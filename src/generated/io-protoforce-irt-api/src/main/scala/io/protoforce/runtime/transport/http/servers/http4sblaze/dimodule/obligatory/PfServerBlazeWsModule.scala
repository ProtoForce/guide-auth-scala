package io.protoforce.runtime.transport.http.servers.http4sblaze.dimodule.obligatory

import distage.{ModuleDef, Tag}
import io.circe.Json
import io.protoforce.runtime.transport.dispatch.ContextProvider
import io.protoforce.runtime.transport.dispatch.server.ws.{AbstractWsHandler, SessionManager, SessionManagerImpl, SessionStorage}
import io.protoforce.runtime.transport.dispatch.server.{BasicTransportErrorHandler, TransportErrorHandler}
import io.protoforce.runtime.transport.errors.ServerTransportError
import io.protoforce.runtime.transport.http.servers.http4sblaze.model.BlazeWsContext
import io.protoforce.runtime.transport.http.servers.http4sblaze.{BlazeHandler, BlazeHandlerWsImpl}
import zio.{IO, Task}

class PfServerBlazeWsModule[C: Tag, +DomainErrors >: Nothing: Tag, Meta: Tag](
  contextProvider: ContextProvider[
    IO,
    ServerTransportError,
    BlazeWsContext[Task],
    C,
  ]
) extends ModuleDef {

  type F[+E, +A] = IO[E, A]
  type Wire = Json
  type Header = String
  type RC = BlazeWsContext[Task]

  make[BlazeHandler].from[BlazeHandlerWsImpl[C, DomainErrors, Meta]].named("ws")
  make[SessionManager[F, RC, Meta]].aliased[SessionStorage[F, RC, Meta]].from[SessionManagerImpl[F, RC, Meta]]
  make[AbstractWsHandler[C, RC, DomainErrors, Meta, F]]

  make[ContextProvider[F, ServerTransportError, RC, C]]
    .fromValue(contextProvider)

  make[TransportErrorHandler[DomainErrors, RC]]
    .fromValue(BasicTransportErrorHandler.withoutDomain)
}