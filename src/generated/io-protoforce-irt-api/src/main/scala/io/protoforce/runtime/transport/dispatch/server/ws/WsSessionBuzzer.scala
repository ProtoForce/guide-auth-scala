package io.protoforce.runtime.transport.dispatch.server.ws

import java.util.concurrent.ConcurrentHashMap

import izumi.functional.bio.{F, IO2, Ref2}
import io.protoforce.runtime.transport.dispatch.server.{InvokationId, PendingResponse, WsSessionId}

abstract class WsSessionBuzzer[F[+_, +_]: IO2, Meta](_meta: Ref2[F, Meta], _id: WsSessionId) {
  import izumi.fundamentals.platform.language.Quirks.Discarder

  // TODO: we may wish to limit stored dataset size to avoid bad actors from trashing our memory
  private val pending = new ConcurrentHashMap[InvokationId, Option[PendingResponse]]()

  def id: WsSessionId = _id

  def meta: F[Nothing, Meta] = _meta.get

  def send(value: String): F[Throwable, Unit]

  // TODO: we may provide server-initiated disconnection here but it can be always implemented on proto level

  def setResponse(id: InvokationId, pendingResponse: PendingResponse): F[Nothing, Unit] =
    F.sync {
      pending.put(id, Some(pendingResponse))
      ()
    }

  protected[ws] def takePending(id: InvokationId): F[Nothing, Option[PendingResponse]] =
    F.sync {
      pending.getOrDefault(id, None)
    }

  protected[ws] def dropPending(id: InvokationId): F[Nothing, Unit] =
    F.sync {
      pending.remove(id).discard()
    }

  protected[ws] def setPending(id: InvokationId): F[Nothing, Unit] =
    F.sync {
      pending.put(id, None).discard()
    }
}