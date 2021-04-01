package io.protoforce.runtime.transport.dispatch

import io.circe.Json
import izumi.functional.bio._
import izumi.fundamentals.collections.IzCollections._
import io.protoforce.model.typer.SharedRestSpec.RawRestPath
import io.protoforce.runtime.transport.dispatch.server.{GeneratedServerBase, RPCClientHandlers, RPCServerHandlers}
import io.protoforce.runtime.transport.dispatch.server.GeneratedServerBase.{MethodId, ServiceName}
import io.protoforce.runtime.transport.errors.ServerTransportError
import io.protoforce.runtime.transport.errors.ServerTransportError.MethodIdError

import scala.annotation.nowarn

trait ServerIdRemapper[F[_, _]] {
  def remapId(
    id: MethodId,
    context: RawRestPath,
  ): F[ServerTransportError, MethodId]
}
trait ClientIdRemapper[F[_, _]] {
  def remapId(
    id: MethodId,
    context: RawRestPath,
  ): F[ServerTransportError, MethodId]
}

@nowarn("msg=Unused import")
object IdRemapper {
  import scala.collection.compat._

  class IdRemapperImpl[F[+_, +_]: IO2](
    dispatchers: Seq[GeneratedServerBase[F, Nothing, Json]]
  ) extends ServerIdRemapper[F]
    with ClientIdRemapper[F] {
    private val bindings: Map[MethodId, MethodId] = dispatchers
      .flatMap(_._methods.keys)
      .flatMap {
        id =>
          val fqnId = Seq((id, id))
          val shortId = id.service match {
            case ServiceName(None, _) =>
              Seq.empty
            case ServiceName(Some(_), name) =>
              Seq((MethodId(ServiceName(None, name), id.method), id))
          }
          shortId ++ fqnId
      }
      .toMultimap
      .view
      .filterNot(_._2.size > 1)
      .map {
        case (k, v) =>
          (k, v.head)
      }
      .toMap

    def remapId(
      id: MethodId,
      context: RawRestPath,
    ): F[ServerTransportError, MethodId] = {
      val maybeBinding = bindings.get(id)
      F.fromOption(MethodIdError(s"path=$context, available=${bindings.size}")) {
        maybeBinding
      }
    }
  }

  class ClientIdRemapperImpl[F[+_, +_]: IO2](
    dispatchers: RPCClientHandlers[F, Nothing, Json]
  ) extends IdRemapperImpl[F](dispatchers.handlers)

  class ServerIdRemapperImpl[F[+_, +_]: IO2](
    dispatchers: RPCServerHandlers[F, Nothing, Json]
  ) extends IdRemapperImpl[F](dispatchers.handlers)

}