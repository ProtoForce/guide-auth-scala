package io.protoforce.runtime.transport.http.servers.http4sblaze.dimodule.obligatory

import distage.{ModuleDef, Tag, TagKK}
import io.protoforce.runtime.transport.dispatch.client.ClientRequestHook
import io.protoforce.runtime.transport.dispatch.server.Envelopes.AsyncRequest
import io.protoforce.runtime.transport.dispatch.server.IdentifiedRequestContext

class PfServerBlazeBuzzerModule[F[+_, +_]: TagKK, C: Tag, WsMeta: Tag]() extends ModuleDef {

  make[ClientRequestHook[IdentifiedRequestContext[C], AsyncRequest]].fromValue(ClientRequestHook.forCtx[IdentifiedRequestContext[C]].passthrough[AsyncRequest])

}