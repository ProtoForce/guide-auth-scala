package io.protoforce.runtime.transport.dispatch.server.ws

import java.util.concurrent.ConcurrentHashMap

import izumi.functional.bio.{F, IO2}
import izumi.fundamentals.platform.language.Quirks._
import io.protoforce.runtime.transport.dispatch.server.WsSessionId

import scala.jdk.CollectionConverters._

final class SessionManagerImpl[F[+_, +_]: IO2, C, Meta] extends SessionManager[F, C, Meta] {
  private val sessions = new ConcurrentHashMap[WsSessionId, WsSession[F, C, Meta]]

  def register(value: WsSession[F, C, Meta]): F[Nothing, Unit] = F.sync {
    sessions.put(value.id, value).discard()
  }

  def drop(id: WsSessionId): F[Nothing, Unit] = F.sync {
    sessions.remove(id).discard()
  }

  def filterSessions(pred: WsSession[F, C, Meta] => Boolean): F[Nothing, Seq[WsSessionBuzzer[F, Meta]]] = F.sync {
    sessions
      .asScala
      .values
      .filter(s => pred(s))
      .map(s => s.buzzer)
      .toSeq
  }
}