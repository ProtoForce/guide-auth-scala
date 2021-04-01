package io.protoforce.runtime.transport.errors

import io.protoforce.runtime.transport.dispatch.server.GeneratedServerBase.MethodId
import io.protoforce.runtime.codecs.IRTCodec.IRTCodecFailure

sealed trait ServerDispatcherError

object ServerDispatcherError {
  case class MethodHandlerMissing(methodId: MethodId, available: Set[MethodId]) extends ServerDispatcherError
  case class ServerCodecFailure(failures: List[IRTCodecFailure]) extends ServerDispatcherError
}