package io.protoforce.runtime.transport.dispatch.client

import izumi.functional.bio.Error2
import izumi.functional.bio.F
import io.protoforce.runtime.codecs.IRTCodec
import io.protoforce.runtime.transport.dispatch.server.GeneratedServerBase.ClientResponse
import io.protoforce.runtime.transport.errors.ClientDispatcherError
import io.protoforce.runtime.transport.errors.ClientDispatcherError.ClientCodecFailure

abstract class GeneratedClientBase[F[+_, +_]: Error2, C, WValue] {
  def _transport: ClientTransport[F, C, WValue]

  protected final def _doDecode[V: IRTCodec[*, WValue]](
    r: ClientResponse[WValue]
  ): F[ClientDispatcherError, V] = {
    val codecRes = implicitly[IRTCodec[V, WValue]]

    F.fromEither(codecRes.decode(r.value).left.map(f => ClientCodecFailure(f)))
  }
}