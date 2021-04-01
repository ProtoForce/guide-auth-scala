package io.protoforce.runtime.transport.http.dimodule.convenience

import distage.{ModuleDef, Tag, TagKK}
import io.protoforce.runtime.transport.dispatch.client.ClientRequestHook
import io.protoforce.runtime.transport.dispatch.server.Envelopes.AsyncRequest
import io.protoforce.runtime.transport.dispatch.server.IdentifiedRequestContext
import io.protoforce.runtime.transport.dispatch.server.ws.WsBuzzerTransport

class SharedWsBuzzerModule[F[+_, +_]: TagKK, C: Tag, WsMeta: Tag]() extends ModuleDef {

  make[ClientRequestHook[IdentifiedRequestContext[C], AsyncRequest]].fromValue(ClientRequestHook.forCtx[IdentifiedRequestContext[C]].passthrough[AsyncRequest])
  make[WsBuzzerTransport[F, WsMeta, C]]

}