package io.protoforce.runtime.transport.dispatch.server

import io.circe.Json
import io.protoforce.runtime.transport.dispatch.server.Envelopes.RemoteError
import io.protoforce.runtime.transport.dispatch.server.GeneratedServerBase.ServerWireResponse

sealed trait TransportResponse

object TransportResponse {
  case class Success(data: ServerWireResponse[Json]) extends TransportResponse
  case class Failure(error: RemoteError) extends TransportResponse
}