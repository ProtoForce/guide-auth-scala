package io.protoforce.runtime.transport.dispatch.server.ws

trait WsBuzzerTransportFactory[F[+_, +_], Meta, BzrRequestContext] {
  def make(client: WsSessionBuzzer[F, Meta]): WsBuzzerTransport[F, Meta, BzrRequestContext]
}