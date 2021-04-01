package io.protoforce.runtime.transport.dispatch.server.ws

import io.protoforce.runtime.transport.dispatch.server.WsSessionId

trait SessionStorage[F[+_, +_], C, Meta] {
  def filterSessions(pred: WsSession[F, C, Meta] => Boolean): F[Nothing, Seq[WsSessionBuzzer[F, Meta]]]
}

trait SessionManager[F[+_, +_], C, Meta] extends SessionStorage[F, C, Meta] {
  def register(value: WsSession[F, C, Meta]): F[Nothing, Unit]
  def drop(id: WsSessionId): F[Nothing, Unit]
}