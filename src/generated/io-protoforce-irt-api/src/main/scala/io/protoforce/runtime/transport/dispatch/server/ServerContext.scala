package io.protoforce.runtime.transport.dispatch.server

import io.protoforce.runtime.transport.dispatch.server.GeneratedServerBase.{ServerWireRequest, ServerWireResponse}

trait ServerContext[+F[_, _], -C, WValue] {
  protected[this] type _Req = ServerWireRequest[C, WValue]
  protected[this] type _Res = ServerWireResponse[WValue]
}