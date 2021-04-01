package io.protoforce.runtime.transport.http.servers.http4sblaze.dimodule.obligatory

import distage.{ModuleDef, Tag}
import io.circe.Json
import io.protoforce.runtime.transport.dispatch.IdRemapper.ServerIdRemapperImpl
import io.protoforce.runtime.transport.dispatch.server.http._
import io.protoforce.runtime.transport.dispatch.server.{TransportErrorHandler, _}
import io.protoforce.runtime.transport.dispatch.{ContextProvider, ServerIdRemapper}
import io.protoforce.runtime.transport.errors.ServerTransportError
import io.protoforce.runtime.transport.http.servers.http4sblaze.model.BlazeHttpRequestContext
import io.protoforce.runtime.transport.http.servers.http4sblaze.{BlazeCORSHandler, BlazeHandler, BlazeHandlerImpl}
import org.http4s.Request
import zio.{IO, Task}

class PfServerBlazeHttpModule[C: Tag, +DomainErrors >: Nothing: Tag](
  contextProvider: ContextProvider[
    IO,
    ServerTransportError,
    BlazeHttpRequestContext[Task],
    C,
  ]
) extends ModuleDef {

  type F[+E, +A] = IO[E, A]
  type Wire = Json
  type Header = String
  type RC = BlazeHttpRequestContext[Task]
  type HC = Request[Task]

  addImplicit[AbstractHeader[Header]]
  addImplicit[AbstractRequestContext[RC]]

  make[BlazeHandler].from[BlazeHandlerImpl[C, DomainErrors]].named("rest")

  make[MethodIdExtractor].fromValue(MethodIdExtractor.TailImpl)
  make[RestlikeResponseConvention[F, Header]]
    .from[RestlikeResponseConventionImpl[F, Header]]
  make[ServerIdRemapper[F]].from[ServerIdRemapperImpl[F]]
  make[HttpEnvelopeSupport[F, RC]].from[HttpEnvelopeSupportRestImpl[F, RC]]
  make[BlazeCORSHandler]
  make[ContextProvider[F, ServerTransportError, RC, C]]
    .fromValue(contextProvider)

  make[TransportErrorHandler[DomainErrors, HC]]
    .fromValue(BasicTransportErrorHandler.withoutDomain)
}