package io.protoforce.runtime.transport.dispatch.server.http

import io.protoforce.runtime.transport.errors.ServerTransportError

trait HttpEnvelopeSupport[+F[_, _], RC] {
  def makeInput(context: RC): F[ServerTransportError, MethodInput]
}