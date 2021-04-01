package io.protoforce.runtime.transport.dispatch.server

import io.protoforce.runtime.transport.dispatch.server.Envelopes.RemoteError
import io.protoforce.runtime.transport.errors.ServerTransportError

trait TransportErrorHandler[-DomainError, -Ctx] {
  def toRemote(ctx: Ctx)(err: Either[List[Throwable], ServerTransportError]): RemoteError

  protected def transformDomain(ctx: Ctx, domain: DomainError): RemoteError
}