package io.protoforce.runtime.transport.dispatch.server

import io.protoforce.model.typer.SharedRestSpec.RawRestPath
import io.protoforce.runtime.transport.dispatch.server.GeneratedServerBase.{MethodId, MethodName, ServiceName}
import io.protoforce.runtime.transport.errors.ServerTransportError

trait MethodIdExtractor {
  def extract(requestPath: RawRestPath): Either[ServerTransportError, MethodId]
}

object MethodIdExtractor {
  object TailImpl extends MethodIdExtractor {
    def extract(requestPath: RawRestPath): Either[ServerTransportError, MethodId] = {
      val segments = requestPath.normalized.takeRight(2)
      val sn = ServiceName.parse(segments.head)
      Right(MethodId(sn, MethodName(segments.last)))
    }
  }
}