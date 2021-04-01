package io.protoforce.runtime.transport.http.servers.http4sblaze

import java.nio.charset.StandardCharsets

import io.circe.parser.parse
import io.circe.{Json, Printer}
import izumi.functional.bio.{Async2, F}
import io.protoforce.runtime.transport.dispatch.ContextProvider
import io.protoforce.runtime.transport.dispatch.server.GeneratedServerBase.ServerWireResponse
import io.protoforce.runtime.transport.dispatch.server.http.{HttpBody, HttpEnvelopeSupport, RestlikeResponseConvention}
import io.protoforce.runtime.transport.dispatch.server.{AbstractServerHandler, RPCServerHandlers, TransportErrorHandler, TransportResponse}
import io.protoforce.runtime.transport.errors.ServerTransportError
import io.protoforce.runtime.transport.http.servers.http4sblaze.model.BlazeHttpRequestContext
import org.http4s._
import zio.{IO, Task}

class BlazeHandlerImpl[C, +DomainErrors >: Nothing](
  val dispatchers: RPCServerHandlers[IO, C, Json],
  val serverContextProvider: ContextProvider[
    IO,
    ServerTransportError,
    BlazeHttpRequestContext[Task],
    C,
  ],
  printer: Printer,
  extractor: HttpEnvelopeSupport[IO, BlazeHttpRequestContext[Task]],
  handler: TransportErrorHandler[DomainErrors, Request[Task]],
  convention: RestlikeResponseConvention[IO, String],
  override protected val bioAsync: Async2[IO],
) extends AbstractServerHandler[IO, C, BlazeHttpRequestContext[Task], Json]
  with BlazeHandler {
  import zio.interop.catz._

  override def handle(request: Request[Task]): Task[Response[Task]] = {
    for {
      out <-
        result(request)
          .sandbox
          .mapError {
            cause =>
              cause.failureOrCause.swap.left.map(_.defects)
          }
          .redeemPure[TransportResponse](
            f => TransportResponse.Failure(handler.toRemote(request)(f)),
            v => TransportResponse.Success(v),
          )
      (code, headers, body) = convention.mapResponse(out)
      status <- IO.fromEither(Status.fromInt(code))
      response <- F.sync(body.printWith(printer))
    } yield {
      Response(
        status = status,
        headers = Headers.of(headers.map(h => Header(h._1, h._2)).toSeq: _*),
        body = fs2.Stream.apply[Task, Byte](response.getBytes(StandardCharsets.UTF_8).toSeq: _*),
      )
    }
  }

  private def result(
    exchange: Request[Task]
  ): IO[ServerTransportError, ServerWireResponse[Json]] = {
    for {
      decoded <- body(exchange)
      context = BlazeHttpRequestContext(exchange, decoded)
      input <- extractor.makeInput(context)
      result <- call(context, input.methodId, input.json)
    } yield {
      result
    }
  }

  private def body(
    exchange: Request[Task]
  ): IO[ServerTransportError, HttpBody] = {
    for {
      bytes <-
        if (exchange.method == Method.GET) {
          F.pure(None)
        } else {
          IO.effectAsync[ServerTransportError, Option[Array[Byte]]] {
            f =>
              f(
                exchange
                  .body.compile.toVector
                  .map(bytes => Some(bytes.toArray))
                  .catchAll(e => IO.fail(ServerTransportError.TransportException(e)))
              )
          }
        }
      sbody =
        bytes
          .map(b => new String(b, StandardCharsets.UTF_8))
          .getOrElse(Json.obj().toString())
      decoded <-
        IO.fromEither(parse(sbody))
          .mapError(f => ServerTransportError.JsonCodecError(sbody, f))
    } yield {
      HttpBody(decoded, bytes)
    }
  }

}