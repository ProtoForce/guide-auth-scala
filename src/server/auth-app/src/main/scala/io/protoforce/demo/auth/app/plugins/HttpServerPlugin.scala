package io.protoforce.demo.auth.app.plugins

import distage.plugins.PluginDef
import distage.{Id, Lifecycle, TagKK}
import io.circe.Json
import io.protoforce.demo.auth.models.{CustomWsMeta, HttpConfig, IncomingServerCtx}
import izumi.distage.config.ConfigModuleDef
import izumi.distage.model.definition.ModuleDef
import izumi.functional.bio.IO2
import io.protoforce.runtime.transport.dispatch.ContextProvider
import io.protoforce.runtime.transport.dispatch.server.http.{AbstractHttpResponseHeaders, CORSBase, HttpResponseHeaders}
import io.protoforce.runtime.transport.dispatch.server.ws.AbstractSessionMetaProvider
import io.protoforce.runtime.transport.dispatch.server.{Envelopes, GeneratedServerBase, IRTEventListener, RPCServerHandlers}
import io.protoforce.runtime.transport.http.dimodule.convenience.{InfraDIModule, PfAHCClientModule}
import io.protoforce.runtime.transport.http.servers.http4sblaze.dimodule.obligatory.{PfServerBlazeHttpModule, PfServerBlazeWsModule}
import io.protoforce.runtime.transport.http.servers.http4sblaze.model.{BlazeHttpRequestContext, BlazeWsContext}
import io.protoforce.runtime.transport.http.servers.http4sblaze.{BlazeCORSHandler, BlazeHandler}
import izumi.logstage.api.IzLogger
import org.http4s.HttpRoutes
import org.http4s.server.Server
import zio.{IO, Task}

import scala.concurrent.ExecutionContext


object HttpServerPlugin extends PluginDef with ConfigModuleDef {
  include(makeHandlersF[IO])
  include(makeApiBindings[IO])
  include(makeProtoforceRuntimeF[IO])

  private def makeHandlersF[F[+_, +_] : IO2 : TagKK]: ModuleDef = new ModuleDef {
    val httpContextExtractor: ContextProvider[IO, Nothing, BlazeHttpRequestContext[Task], IncomingServerCtx] =
      ContextProvider
        .forF[IO]
        .pure((w: BlazeHttpRequestContext[Task]) => IncomingServerCtx(w.exchange.remoteAddr.getOrElse(""), w.headers))

    val websocketContextExtractor: ContextProvider[IO, Nothing, BlazeWsContext[Task], IncomingServerCtx] =
      ContextProvider
        .forF[IO]
        .pure((_: BlazeWsContext[Task]) => IncomingServerCtx("", Map.empty))

    // websocket sesstion state
    make[AbstractSessionMetaProvider[BlazeWsContext[Task], CustomWsMeta]].fromValue(
      new AbstractSessionMetaProvider[BlazeWsContext[Task], CustomWsMeta] {
        override def extractInitial(ctx: BlazeWsContext[Task]): CustomWsMeta = {
          CustomWsMeta()
        }

        override def extract(ctx: BlazeWsContext[Task], previous: CustomWsMeta, envelopeIn: Envelopes.AsyncRequest, body: Option[String]): Option[CustomWsMeta] = {
          Some(previous)
        }
      }
    )
    include(new PfServerBlazeHttpModule[IncomingServerCtx, Nothing](httpContextExtractor))
    include(new PfServerBlazeWsModule[IncomingServerCtx, Nothing, CustomWsMeta](websocketContextExtractor))

    make[IRTEventListener[F]].from {
      (bio: IO2[F], logger: IzLogger) =>
        new IRTEventListener[F] {
          override def message(str: String): Unit = {
            logger.info(s"transport message: $str")
          }

          override def onHttpResponse(response: String, code: Int, headers: Map[String, String]): F[Nothing, Unit] = {
            bio.sync(logger.info(s"http response: $code, $headers, $response"))
          }

          override def onWsSend(value: String, isBuzzer: Boolean): F[Nothing, Unit] = {
            bio.sync(logger.info(s"ws send: $value"))
          }

          override def onWsBodyReceived(sbody: String): F[Nothing, Unit] = {
            bio.sync(logger.info(s"ws body: $sbody"))
          }

          override def onHttpBodyReceived(path: String, sbody: String): F[Nothing, Unit] = {
            bio.sync(logger.info(s"http body: $path, $sbody"))
          }
        }
    }
  }

  private def makeApiBindings[F[+_, +_] : IO2 : TagKK]: ModuleDef = new ModuleDef {
    // here we expose our API implementations to Protoforce runtime
    make[RPCServerHandlers[F, IncomingServerCtx, Json]]
      .from { handlers: Set[GeneratedServerBase[F, IncomingServerCtx, Json]] => RPCServerHandlers(handlers.toSeq) }
      .aliased[RPCServerHandlers[F, Nothing, Json]]
  }

  private def makeProtoforceRuntimeF[F[+_, +_] : IO2 : TagKK]: ModuleDef = new ModuleDef {
    // shared Protoforce runtime
    include(new InfraDIModule[F]())
    // Protoforce HTTP client
    include(new PfAHCClientModule())

    // CORS support helpers
    make[CORSBase]

    // Protoforce RPC convention
    make[HttpResponseHeaders[String]].aliased[AbstractHttpResponseHeaders[String]]

    // http4s server initialization
    make[Server].fromResource {
      (h: BlazeHandler@Id("rest"), w: BlazeHandler@Id("ws"), cors: BlazeCORSHandler, runtime: zio.Runtime[Any], config: HttpConfig) =>
        import org.http4s.implicits._
        import org.http4s.server.Router
        import org.http4s.server.blaze._
        import zio.interop.catz._
        import zio.interop.catz.implicits._

        val serviceRest = HttpRoutes.of[Task](h.handlePartial)
        val serviceWs = HttpRoutes.of[Task](w.handlePartial)
        val app = Router(
          "api/v1" -> cors.withCors(serviceRest),
          "prod/api/v1" -> cors.withCors(serviceRest),
          "dev/api/v1" -> cors.withCors(serviceRest),
          "api/ws/v1" -> cors.withCors(serviceWs),
          "prod/api/ws/v1" -> cors.withCors(serviceWs),
          "dev/api/ws/v1" -> cors.withCors(serviceWs),
        ).orNotFound
        implicit val rt = runtime
        val b = BlazeServerBuilder[Task](ExecutionContext.global)
          .bindHttp(config.port, config.host)
          .withWebSockets(true)
          .withHttpApp(app)

        Lifecycle.fromCats(b.resource)
    }
  }
}
