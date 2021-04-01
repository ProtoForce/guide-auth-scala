package io.protoforce.runtime.transport.errors

import io.protoforce.runtime.codecs.IRTCodec.IRTCodecFailure
import io.protoforce.runtime.transport.dispatch.server.Envelopes.RemoteError
import io.protoforce.runtime.transport.dispatch.server.GeneratedServerBase.MethodId
import io.protoforce.runtime.transport.dispatch.server.InvokationId

sealed trait ClientDispatcherError

object ClientDispatcherError {
  case class ServerError(err: RemoteError) extends ClientDispatcherError
  case class WrongRpcEnvelope(missingHeader: Option[String], wrongHeader: Option[String]) extends ClientDispatcherError

  sealed trait LocalError extends ClientDispatcherError
  case class TimeoutException(id: InvokationId, methodId: MethodId) extends LocalError
  case class OperationUnsupported() extends LocalError
  case class ClientCodecFailure(failures: List[IRTCodecFailure]) extends LocalError
  case class UnknownException(t: Throwable) extends LocalError
  case class RestMappingError(e: List[MappingError]) extends LocalError

}