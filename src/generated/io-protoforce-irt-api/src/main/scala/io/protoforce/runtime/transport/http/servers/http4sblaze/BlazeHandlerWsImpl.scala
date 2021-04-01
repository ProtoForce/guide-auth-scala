package io.protoforce.runtime.transport.http.servers.http4sblaze

import fs2.concurrent.Queue
import io.circe.literal._
import io.circe.{Json, Printer}
import izumi.functional.bio.{Async2, Exit, Ref2}
import izumi.functional.mono.Entropy
import io.protoforce.runtime.transport.dispatch.ContextProvider
import io.protoforce.runtime.transport.dispatch.server.ws._
import io.protoforce.runtime.transport.dispatch.server.{AbstractServerHandler, RPCServerHandlers, WsSessionId}
import io.protoforce.runtime.transport.errors.ServerTransportError
import io.protoforce.runtime.transport.http.servers.http4sblaze.model.{BlazeHttpRequestContext, BlazeWsContext}
import org.http4s.server.websocket.WebSocketBuilder
import org.http4s.websocket.WebSocketFrame
import org.http4s.websocket.WebSocketFrame._
import org.http4s.{Headers, Request, Response, Status}
import zio.{IO, Task}

import scala.concurrent.duration._

class BlazeHandlerWsImpl[C, +DomainErrors >: Nothing, Meta](
  val dispatchers: RPCServerHandlers[IO, C, Json],
  val serverContextProvider: ContextProvider[
    IO,
    ServerTransportError,
    BlazeHttpRequestContext[Task],
    C,
  ],
  printer: Printer,
  entropy: Entropy[Task],
  dispatcher: AbstractWsHandler[C, BlazeWsContext[Task], DomainErrors, Meta, IO],
  sessionManager: SessionManager[IO, BlazeWsContext[Task], Meta],
  sessionMetaProvider: AbstractSessionMetaProvider[BlazeWsContext[Task], Meta],
  override protected val bioAsync: Async2[IO],
) extends AbstractServerHandler[IO, C, BlazeHttpRequestContext[Task], Json]
  with BlazeHandler {
  import zio.interop.catz._
  import zio.interop.catz.implicits._

  override def handle(request: Request[Task]): Task[Response[Task]] = {
    val pingTimeout: FiniteDuration = 25.seconds
    val pingStream: fs2.Stream[Task, WebSocketFrame] =
      fs2.Stream.awakeEvery[Task](pingTimeout) >> fs2.Stream(Ping())

    val context = model.BlazeWsContext(request)

    for {
      inQueue <- Queue.unbounded[Task, WebSocketFrame]
      outQueue <- Queue.unbounded[Task, WebSocketFrame]
      initialContext <- Task(sessionMetaProvider.extractInitial(context))
      uid <- entropy.nextTimeUUID()
      id = WsSessionId(uid)
      ref <- zio.Ref.make(initialContext)
      buzzer = new WsSessionBuzzer[IO, Meta](Ref2.fromZIO(ref), id) {
        override def send(value: String): IO[Throwable, Unit] = {
          outQueue.enqueue1(WebSocketFrame.Text(value))
        }
      }
      session = WsSession(id, context, initialContext, buzzer)
      responsesStream = inQueue.dequeue.through {
        stream =>
          stream
            .evalMapAccumulate(initialContext) {
              case (s, frame) =>
                handleWsMessage(session, s)(frame).map {
                  case Some((ns, value)) =>
                    (ns, Some(value))
                  case None =>
                    (s, None)
                }
            }
            .evalTap {
              case (state, _) =>
                ref.set(state)
            }
            .collect {
              case (_, Some(v)) =>
                WebSocketFrame.Text(v)
            }
      }
      _ <- sessionManager.register(session)
      resp <- WebSocketBuilder[Task](
        headers = Headers.empty,
        onNonWebSocketRequest = Task(Response[Task](Status.NotImplemented).withEntity("This is a WebSocket route.")),
        onHandshakeFailure = Task(Response[Task](Status.BadRequest).withEntity("WebSocket handshake failed.")),
        onClose = Task.unit,
        filterPingPongs = false,
      ).build(
        send = responsesStream.merge(outQueue.dequeue).merge(pingStream),
        receive = inQueue.enqueue,
      )
    } yield {
      resp
    }
  }

  protected def handleWsMessage(session: WsSession[IO, BlazeWsContext[Task], Meta], state: Meta): WebSocketFrame => Task[Option[(Meta, String)]] = {
    case Text(msg, _) =>
      dispatcher
        .result(msg, state, session.context)
        .sandboxExit
        .flatMap {
          case Exit.Success(value) =>
            value match {
              case ServerWsResult.SerializedServerResponse(message, nextState) =>
                Task.succeed(Some((nextState.getOrElse(state), message)))
              case ServerWsResult.BuzzerResponse(id, p) =>
                session.buzzer.setResponse(id, p) *> Task.succeed(None)
            }
          case failure: Exit.Failure[_] =>
            Task.succeed(Some((state, printer.print(json"""{"status": "failure", "dump": ${failure.toString}}"""))))
        }

    case Close(_) =>
      Task(None)

    case _: Binary =>
      Task(None)

    case _: Pong =>
      Task(None)

    case _ =>
      Task(None)
  }
}