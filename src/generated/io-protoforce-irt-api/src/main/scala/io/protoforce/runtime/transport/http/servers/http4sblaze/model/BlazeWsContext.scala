package io.protoforce.runtime.transport.http.servers.http4sblaze.model

import org.http4s.Request

case class BlazeWsContext[F[_]](request: Request[F])