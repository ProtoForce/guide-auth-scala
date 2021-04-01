package io.protoforce.runtime.transport.http.clients.ahc

import java.net.URI
import java.util.function.BiFunction

import io.circe.{Json, Printer}
import izumi.functional.bio.{Async2, F}
import io.protoforce.runtime.codecs.IRTCodec
import io.protoforce.runtime.transport.dispatch.client.{ClientRequestHook, ClientTransport}
import io.protoforce.runtime.transport.dispatch.server.GeneratedServerBase.ClientResponse
import io.protoforce.runtime.transport.dispatch.server.http.RestlikeResponseConvention
import io.protoforce.runtime.transport.dispatch.server.{BaseClientContext, GeneratedServerBase}
import io.protoforce.runtime.transport.errors.ClientDispatcherError
import io.protoforce.runtime.transport.errors.ClientDispatcherError.ClientCodecFailure
import org.asynchttpclient.{AsyncHttpClient, BoundRequestBuilder, Response}

case class ClientTarget(uri: URI)

case class AHCClientContext[RequestContext](
  rc: RequestContext,
  printer: Printer,
  target: ClientTarget,
  client: AsyncHttpClient,
  methodId: GeneratedServerBase.MethodId,
  body: Json,
) extends BaseClientContext[RequestContext]

class AHCHttpClient[F[+_, +_]: Async2, RequestContext](
  client: AsyncHttpClient,
  target: ClientTarget,
  printer: Printer,
  hook: ClientRequestHook[AHCClientContext[
    RequestContext
  ], BoundRequestBuilder],
  convention: RestlikeResponseConvention[F, String],
) extends ClientTransport[F, RequestContext, Json] {

  override def connect(): F[ClientDispatcherError, Unit] = F.unit

  override def disconnect(): F[ClientDispatcherError, Unit] = F.unit

  override def dispatch(
    c: RequestContext,
    methodId: GeneratedServerBase.MethodId,
    body: Json,
  ): F[ClientDispatcherError, ClientResponse[Json]] = {
    import io.circe.parser._
    import izumi.fundamentals.collections.IzCollections._

    import scala.jdk.CollectionConverters._
    for {
      ctx <-
        F.pure(AHCClientContext(c, printer, target, client, methodId, body))
      req <- F.fromEither(hook.onRequest(ctx, c => prepare(c.methodId, c.body)))
      resp <- F.async[ClientDispatcherError, Response] {
        f =>
          val handler = new BiFunction[Response, Throwable, Unit] {
            override def apply(t: Response, u: Throwable): Unit = {
              if (t != null) {
                f(Right(t))
              } else {
                f(Left(ClientDispatcherError.UnknownException(u)))
              }
            }
          }

          req.execute().toCompletableFuture.handle[Unit](handler)
          ()
      }
      body = resp.getResponseBody
      parsed <-
        F.fromEither(parse(body))
          .leftMap(
            e =>
              ClientCodecFailure(
                List(IRTCodec.IRTCodecFailure.IRTParserException(body, e))
              )
          )
      headers =
        resp
          .getHeaders
          .entries()
          .asScala
          .map(e => (e.getKey, e.getValue))
          .toMultimap
      out <- convention.unpackEnvelope(parsed, headers)
    } yield {
      out
    }
  }

  private def prepare(
    methodId: GeneratedServerBase.MethodId,
    body: Json,
  ): BoundRequestBuilder = {
    val t = target.uri
    val url = new URI(
      t.getScheme,
      t.getUserInfo,
      t.getHost,
      t.getPort,
      s"${t.getPath}/${methodId.service.toString}/${methodId.method.name}",
      t.getQuery,
      t.getFragment,
    )
    client
      .preparePost(url.toString)
      .setBody(body.printWith(printer))
  }
}