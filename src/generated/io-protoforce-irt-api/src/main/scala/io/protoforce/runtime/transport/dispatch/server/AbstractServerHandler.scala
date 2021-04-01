package io.protoforce.runtime.transport.dispatch.server

import izumi.functional.bio.{Async2, F, Temporal2}
import io.protoforce.runtime.transport.dispatch.ContextProvider
import io.protoforce.runtime.transport.dispatch.server.GeneratedServerBase.{MethodId, ServerWireRequest, ServerWireResponse}
import io.protoforce.runtime.transport.errors.ServerTransportError

import scala.annotation.nowarn

@nowarn("msg=Unused import")
trait AbstractServerHandler[
  F[
    +_,
    +_,
  ],
  TransportContext,
  ServerTransportContext,
  WireBody,
] {
  protected implicit def bioAsync: Async2[F]
  import scala.collection.compat._

  protected def dispatchers: RPCServerHandlers[F, TransportContext, WireBody]
  protected def serverContextProvider: ContextProvider[
    F,
    ServerTransportError,
    ServerTransportContext,
    TransportContext,
  ]

  private lazy val methods = dispatchers
    .handlers
    .groupBy(_._id)
    .view
    .mapValues {
      d =>
        if (d.size > 1) {
          throw new RuntimeException(s"Duplicated services: $d")
        }
        d.head
    }
    .toMap

  def call(
    context: ServerTransportContext,
    id: MethodId,
    decoded: WireBody,
  ): F[ServerTransportError, ServerWireResponse[WireBody]] = {
    for {
      svcm <- F.fromOption(ServerTransportError.MissingService(id))(
        methods.get(id.service)
      )
      ctx <- serverContextProvider.decode(context)
      out <-
        svcm
          .dispatch(id, ServerWireRequest(ctx, decoded))
          .leftMap(f => ServerTransportError.DispatcherError(f): ServerTransportError)
    } yield out
  }
}