package io.protoforce.runtime.transport.http.dimodule.convenience

import distage.{ModuleDef, Tag, TagKK}
import io.circe.Json
import io.protoforce.runtime.transport.RuntimeErrorHandler
import io.protoforce.runtime.transport.dispatch.server.RPCClientHandlers
import io.protoforce.runtime.transport.errors.ServerTransportError
import io.protoforce.runtime.transport.http.clients.ahc.AhcRuntimeErrorHandler

class PfClientHandlersModule[F[+_, +_]: TagKK, C: Tag](
  handlers: RPCClientHandlers[F, C, Json],
  h2: RuntimeErrorHandler[ServerTransportError, AhcRuntimeErrorHandler.Context],
) extends SharedHttpModule[F]
  with ModuleDef {
  type Wire = Json

  make[RPCClientHandlers[F, C, Wire]].fromValue(handlers)
  make[RPCClientHandlers[F, Nothing, Wire]].fromValue(RPCClientHandlers(handlers.handlers))
  make[RuntimeErrorHandler[ServerTransportError, AhcRuntimeErrorHandler.Context]].fromValue(h2)
  make[RuntimeErrorHandler[Nothing, AhcRuntimeErrorHandler.Context]].fromValue(h2)

}