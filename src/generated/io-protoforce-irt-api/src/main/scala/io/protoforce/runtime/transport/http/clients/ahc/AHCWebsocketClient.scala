package io.protoforce.runtime.transport.http.clients.ahc

import java.net.URI
import java.util.concurrent.ConcurrentHashMap

import io.circe.parser.parse
import io.circe.{Json, Printer}
import io.netty.util.concurrent.Future
import izumi.functional.bio.{Async2, Entropy2, F, Primitives2, Temporal2, UnsafeRun2}
import io.protoforce.model.typer.SharedRestSpec.RawRestPath
import io.protoforce.runtime.transport.RuntimeErrorHandler
import io.protoforce.runtime.transport.dispatch.client.{ClientRequestHook, ClientTransport}
import io.protoforce.runtime.transport.dispatch.server.Envelopes.AsyncResponse.{AsyncFailure, AsyncSuccess}
import io.protoforce.runtime.transport.dispatch.server.Envelopes.{AsyncRequest, AsyncResponse}
import io.protoforce.runtime.transport.dispatch.server.GeneratedServerBase.ClientResponse
import io.protoforce.runtime.transport.dispatch.server._
import io.protoforce.runtime.transport.dispatch.{ClientIdRemapper, ContextProvider}
import io.protoforce.runtime.transport.errors.{ClientDispatcherError, ServerTransportError}
import org.asynchttpclient.AsyncHttpClient

case class WsClientTarget(uri: URI)

class AHCWebsocketClient[
  F[
    +_,
    +_,
  ]: Async2: Temporal2: Primitives2: UnsafeRun2,
  WsClientRequestContext,
  BuzzerRequestContext,
  +DomainErrors >: Nothing,
](client: AsyncHttpClient,
  target: WsClientTarget,
  pollingConfig: PollingConfig,
  buzzerDispatchers: RPCClientHandlers[F, BuzzerRequestContext, Json],
  buzzerContextProvider: ContextProvider[
    F,
    ServerTransportError,
    AsyncRequest,
    BuzzerRequestContext,
  ],
  hook: ClientRequestHook[IdentifiedRequestContext[
    WsClientRequestContext
  ], AsyncRequest],
  handler: TransportErrorHandler[DomainErrors, AsyncRequest],
  errHandler: RuntimeErrorHandler[
    ServerTransportError,
    AhcRuntimeErrorHandler.Context,
  ],
  printer: Printer,
  random: Entropy2[F],
  idRemapper: ClientIdRemapper[F],
) extends ClientTransport[F, WsClientRequestContext, Json]
  // with AbstractServerHandler[F, BuzzerRequestContext, AsyncRequest, Json]
  with AHCWSListener {

  import io.circe.syntax._

  private val buzzerHandler =
    new AbstractServerHandler[F, BuzzerRequestContext, AsyncRequest, Json] {
      override protected def bioAsync: Async2[F] = implicitly
      override protected val serverContextProvider: ContextProvider[
        F,
        ServerTransportError,
        AsyncRequest,
        BuzzerRequestContext,
      ] = buzzerContextProvider
      override protected val dispatchers: RPCServerHandlers[F, BuzzerRequestContext, Json] =
        RPCServerHandlers(buzzerDispatchers.handlers)
    }

  private val pending =
    new ConcurrentHashMap[InvokationId, Option[AsyncResponse]]()
  private val session = new AHCWsClientSession(client, target.uri, this)

  def connect(): F[ClientDispatcherError, Unit] = {
    for {
      _ <- F.sync(session.get())
    } yield ()
  }

  override def disconnect(): F[ClientDispatcherError, Unit] = {
    F.async {
      f =>
        session
          .get()
          .sendCloseFrame()
          .addListener(
            (future: Future[Void]) => {
              if (future.isSuccess) {
                f(Right(()))
              } else {
                f(Left(ClientDispatcherError.UnknownException(future.cause())))
              }
            }
          )
        ()
    }
  }

  override def dispatch(
    c: WsClientRequestContext,
    methodId: GeneratedServerBase.MethodId,
    body: Json,
  ): F[ClientDispatcherError, ClientResponse[Json]] = {
    for {
      s <- F.fromOption(
        ClientDispatcherError.UnknownException(
          new RuntimeException(
            s"Failed to create session for $methodId with ${target.uri}"
          )
        )
      )(Option(session.get()))
      id <- random.nextTimeUUID()
      iid = InvokationId(id.toString)
      envelope <- F.fromEither(
        hook.onRequest(
          IdentifiedRequestContext(c, iid, methodId, body),
          c => AsyncRequest(c.methodId, Map.empty, c.body, c.invokationId),
        )
      )
      _ <- F.sync(pending.put(iid, None))
      _ <- F.async[ClientDispatcherError, Unit] {
        f =>
          s.sendTextFrame(envelope.asJson.printWith(printer))
            .addListener(
              (future: Future[Void]) => {
                if (future.isSuccess) {
                  f(Right(()))
                } else {
                  f(Left(ClientDispatcherError.UnknownException(future.cause())))
                }
              }
            )
          ()
      }

      check <- for {
        promise <-
          Primitives2[F]
            .mkPromise[ClientDispatcherError, ClientResponse[Json]]
        check = for {
          status <- F.sync(pending.get(iid))
          _ <- status match {
            case Some(value) =>
              for {
                _ <- value match {
                  case s: AsyncSuccess =>
                    promise.succeed(ClientResponse(s.body))
                  case f: AsyncFailure =>
                    promise.fail(ClientDispatcherError.ServerError(f.error))
                }
              } yield ()

            case None =>
              F.unit
          }
          done <- promise.poll
          out <- done match {
            case Some(value) =>
              value.map(Some(_))
            case None =>
              F.pure(None): F[ClientDispatcherError, Option[
                ClientResponse[Json]
              ]]
          }
        } yield out
      } yield check

      out <- check.repeatUntil(
        ClientDispatcherError.TimeoutException(iid, methodId),
        pollingConfig.sleep,
        pollingConfig.maxAttempts,
      )
    } yield out
  }

  override def onTextMessage(payload: String): Unit = {
    parse(payload) match {
      case Left(_) =>
      // just ignore wrong packets
      case Right(value) =>
        if (value.asObject.exists(_.contains("methodId"))) {
          handleRequest(value)
        } else {
          handleResponse(value)
        }
    }
  }

  private def handleRequest(value: Json): Unit = {
    val work = for {
      conn <- F.sync(session.get())
      data <-
        F.fromEither(value.as[AsyncRequest])
          .leftMap(f => ServerTransportError.EnvelopeFormatError(value.toString(), f)) // all the improper requests will be ignored

      doCall = for {
        methodId <- idRemapper.remapId(
          data.methodId,
          RawRestPath(
            s"buzzer:${data.methodId.service.toString}/${data.methodId.method.name}"
          ),
        )
        out <- buzzerHandler.call(data, methodId, data.body)
      } yield {
        AsyncSuccess(Map.empty, out.value, data.id)
      }

      resp <-
        doCall
          .sandbox
          .leftMap(_.toEither)
          .redeemPure[AsyncResponse](
            f => AsyncFailure(Map.empty, handler.toRemote(data)(f), Some(data.id)),
            s => s,
          )
      _ <- F.sync(conn.sendTextFrame(resp.asJson.printWith(printer)))
    } yield ()

    UnsafeRun2[F].unsafeRunAsync(work)(
      errHandler.handle(AhcRuntimeErrorHandler.Context.WebsocketClientSession())
    )
  }

  private def handleResponse(value: Json): Unit = {
    try {
      val result = for {
        data <-
          value
            .as[AsyncResponse]
            .left
            .map(f => ServerTransportError.EnvelopeFormatError(value.toString(), f))
        maybeId <- data
          .maybeId.toRight(
            ServerTransportError.UnknownRequest(value.toString())
          )
      } yield {
        pending.put(InvokationId(maybeId.id.take(127)), Some(data))
      }
      result match {
        case Right(_) =>
        case Left(err) =>
          errHandler.onDomain(
            AhcRuntimeErrorHandler.Context.WebsocketClientSession(),
            err,
          )
      }
    } catch {
      case t: Throwable =>
        errHandler.onCritical(
          AhcRuntimeErrorHandler.Context.WebsocketClientSession(),
          List(t),
        )
    }
  }

}