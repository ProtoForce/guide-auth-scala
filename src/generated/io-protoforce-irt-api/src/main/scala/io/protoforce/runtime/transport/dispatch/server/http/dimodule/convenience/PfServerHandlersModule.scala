package io.protoforce.runtime.transport.dispatch.server.http.dimodule.convenience

import distage.{ModuleDef, Tag, TagKK}
import io.circe.Json
import io.protoforce.runtime.transport.dispatch.server.RPCServerHandlers
import io.protoforce.runtime.transport.dispatch.server.http.{AbstractHttpResponseHeaders, CORSBase, HttpResponseHeaders}

class PfServerHandlersModule[F[+_, +_]: TagKK, C: Tag](
  handlers: RPCServerHandlers[F, C, Json]
) extends ModuleDef {
  type Wire = Json

  make[CORSBase]
  make[HttpResponseHeaders[String]]
  make[AbstractHttpResponseHeaders[String]].using[HttpResponseHeaders[String]]
  make[RPCServerHandlers[F, C, Wire]].fromValue(handlers)
  make[RPCServerHandlers[F, Nothing, Wire]].fromValue(RPCServerHandlers(handlers.handlers))
}