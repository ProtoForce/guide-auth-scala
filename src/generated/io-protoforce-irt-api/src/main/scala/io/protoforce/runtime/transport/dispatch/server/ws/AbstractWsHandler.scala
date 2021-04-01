package io.protoforce.runtime.transport.dispatch.server.ws

import java.time.LocalDateTime

import io.circe.{Json, Printer}
import izumi.functional.bio.{Async2, Clock2, F}
import io.protoforce.model.typer.SharedRestSpec.RawRestPath
import io.protoforce.runtime.transport.dispatch.server.Envelopes.AsyncResponse.{AsyncFailure, AsyncSuccess}
import io.protoforce.runtime.transport.dispatch.server.Envelopes.{AsyncRequest, AsyncResponse}
import io.protoforce.runtime.transport.dispatch.server.ws.AbstractWsHandler.Out
import io.protoforce.runtime.transport.dispatch.server._
import io.protoforce.runtime.transport.dispatch.{ContextProvider, ServerIdRemapper}
import io.protoforce.runtime.transport.errors.ServerTransportError

sealed trait ServerWsResult[Meta]
object ServerWsResult {
  case class SerializedServerResponse[Meta](message: String, nextState: Option[Meta]) extends ServerWsResult[Meta]
  case class BuzzerResponse[Meta](id: InvokationId, p: PendingResponse) extends ServerWsResult[Meta]
}

case class WsSession[F[+_, +_], C, Meta](id: WsSessionId, context: C, meta: Meta, buzzer: WsSessionBuzzer[F, Meta])

class AbstractWsHandler[
  C,
  SC,
  +DomainErrors >: Nothing,
  Meta,
  F[
    +_,
    +_,
  ]: Async2,
](printer: Printer,
  clock: Clock2[F],
  handler: TransportErrorHandler[DomainErrors, SC],
  sessionMetaProvider: AbstractSessionMetaProvider[SC, Meta],
  idRemapper: ServerIdRemapper[F],
  override val dispatchers: RPCServerHandlers[F, C, Json],
  override val serverContextProvider: ContextProvider[F, ServerTransportError, SC, C],
) extends AbstractServerHandler[F, C, SC, Json] {
  import io.circe._
  import io.circe.parser.parse
  import io.circe.syntax._

  override protected def bioAsync: Async2[F] = implicitly[Async2[F]]

  def result(message: String, state: Meta, ctx: SC): F[ServerTransportError.Predefined, ServerWsResult[Meta]] = {
    for {
      sbody <- F.pure(message)
      //_ <- undertowEventListener.onWsBodyReceived(sbody)
      decoded <-
        F.fromEither(parse(sbody))
          .leftMap(f => ServerTransportError.JsonCodecError(sbody, f))
      out <-
        if (decoded.asObject.exists(_.toMap.contains("methodId"))) { // incoming request
          val maybeId = decoded
            .asObject.flatMap(
              _.toMap.get("id").flatMap(_.asString).map(id => InvokationId(id))
            )
          for {
            out <-
              dispatchRequest(ctx, sbody, decoded, state)
                .sandbox
                .leftMap(_.toEither)
                .redeemPure[Out[Meta]](
                  f =>
                    Out(
                      AsyncFailure(
                        Map.empty,
                        handler.toRemote(ctx)(f),
                        maybeId,
                      ),
                      Option.empty[Meta],
                    ),
                  s => s,
                )
            json = out.response.asJson
            serialized = json.printWith(printer)
          } yield {
            ServerWsResult.SerializedServerResponse(serialized, out.state)
          }
        } else {
          for {
            envelope <-
              F.fromEither(decoded.as[AsyncResponse])
                .leftMap(f => ServerTransportError.EnvelopeFormatError(sbody, f))
            id <- F.fromOption(ServerTransportError.UnknownRequest(sbody))(
              envelope.maybeId
            )
            now <- now()
          } yield {
            ServerWsResult.BuzzerResponse[Meta](id, PendingResponse(envelope, now))
          }
        }
    } yield {
      out
    }
  }

  private def dispatchRequest(
    channel: SC,
    sbody: String,
    decoded: Json,
    currentState: Meta,
  ): F[ServerTransportError, Out[Meta]] = {
    for {
      envelope <-
        F.fromEither(decoded.as[AsyncRequest])
          .leftMap(f => ServerTransportError.EnvelopeFormatError(sbody, f))
      nextState <- F.sync(sessionMetaProvider.extract(channel, currentState, envelope, Some(sbody)))
      methodId <- idRemapper.remapId(
        envelope.methodId,
        RawRestPath(
          s"ws:${envelope.methodId.service.toString}/${envelope.methodId.method.name}"
        ),
      )
      result <- call(
        channel, //WsServerInRequestContext(ctx, envelope, sbody),
        methodId,
        envelope.body,
      )
    } yield {
      Out(AsyncSuccess(Map.empty, result.value, envelope.id), nextState)
    }
  }

  private def now(): F[Nothing, LocalDateTime] = {
    clock.now().map(_.toLocalDateTime)
  }

}

object AbstractWsHandler {
  private case class Out[State](response: AsyncResponse, state: Option[State])
}