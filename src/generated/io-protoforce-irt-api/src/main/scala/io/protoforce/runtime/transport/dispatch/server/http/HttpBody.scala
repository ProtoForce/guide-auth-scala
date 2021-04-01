package io.protoforce.runtime.transport.dispatch.server.http

import io.circe.Json
import io.protoforce.runtime.transport.dispatch.server.GeneratedServerBase.MethodId

case class MethodInput(json: Json, methodId: MethodId)

case class HttpBody(json: Json, bytes: Option[Array[Byte]])