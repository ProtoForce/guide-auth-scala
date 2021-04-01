package io.protoforce.runtime.transport.dispatch.client

import io.protoforce.runtime.transport.dispatch.server.GeneratedServerBase.{ClientResponse, MethodId}
import io.protoforce.runtime.transport.errors.ClientDispatcherError

trait ClientTransportDispatcher[F[_, _], C, WValue] {
  def dispatch(c: C, methodId: MethodId, body: WValue): F[ClientDispatcherError, ClientResponse[WValue]]
}

trait ClientTransport[F[_, _], C, WValue] extends ClientTransportDispatcher[F, C, WValue] {
  def connect(): F[ClientDispatcherError, Unit]
  def disconnect(): F[ClientDispatcherError, Unit]
}