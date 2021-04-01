package io.protoforce.runtime.transport.http.dimodule.obligatory

import distage.{ModuleDef, Tag, TagKK}
import io.circe.Json
import io.protoforce.runtime.transport.dispatch.IdRemapper.ClientIdRemapperImpl
import io.protoforce.runtime.transport.dispatch.client.ClientRequestHook
import io.protoforce.runtime.transport.dispatch.server._
import io.protoforce.runtime.transport.dispatch.{ClientIdRemapper, ContextProvider}
import io.protoforce.runtime.transport.errors.ServerTransportError
import io.protoforce.runtime.transport.http.clients.ahc.{AHCWebsocketClient, WsClientTarget}

class PfTransportWsClientDIModule[F[+_, +_]: TagKK, WRC: Tag, WCC: Tag, +DomainErrors >: Nothing: Tag](
  target: WsClientTarget,
  contextProvider: ContextProvider[F, ServerTransportError, Envelopes.AsyncRequest, WCC],
  clientRequestHook: ClientRequestHook[IdentifiedRequestContext[WRC], Envelopes.AsyncRequest],
  pollingConfig: Option[PollingConfig] = None,
) extends ModuleDef {
  type Wire = Json
  make[PollingConfig].fromValue(pollingConfig.getOrElse(PollingConfig.default))
  make[TransportErrorHandler[DomainErrors, Envelopes.AsyncRequest]].fromValue(BasicTransportErrorHandler.withoutDomain)

  make[AHCWebsocketClient[F, WRC, WCC, DomainErrors]]
  make[ClientRequestHook[IdentifiedRequestContext[WRC], Envelopes.AsyncRequest]].fromValue(clientRequestHook)
  make[ContextProvider[F, ServerTransportError, Envelopes.AsyncRequest, WCC]].fromValue(contextProvider)

  make[ClientIdRemapper[F]].from[ClientIdRemapperImpl[F]]
  make[WsClientTarget].fromValue(target)
}