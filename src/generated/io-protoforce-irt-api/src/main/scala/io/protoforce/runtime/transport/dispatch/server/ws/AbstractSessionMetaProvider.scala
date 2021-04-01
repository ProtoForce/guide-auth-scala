package io.protoforce.runtime.transport.dispatch.server.ws

import io.protoforce.runtime.transport.dispatch.server.Envelopes.AsyncRequest

trait AbstractSessionMetaProvider[CTX, Meta] {
  def extractInitial(ctx: CTX): Meta
  def extract(ctx: CTX, previous: Meta, envelopeIn: AsyncRequest, body: Option[String]): Option[Meta]
}