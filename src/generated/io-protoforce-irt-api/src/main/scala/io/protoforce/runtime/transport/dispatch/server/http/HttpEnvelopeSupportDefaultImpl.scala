package io.protoforce.runtime.transport.dispatch.server.http

import izumi.functional.bio.{F, IO2}
import io.protoforce.model.typer.SharedRestSpec.RawRestPath
import io.protoforce.runtime.transport.dispatch.ServerIdRemapper
import io.protoforce.runtime.transport.dispatch.server.MethodIdExtractor
import io.protoforce.runtime.transport.errors.ServerTransportError

trait AbstractRequestContext[RC] {
  def getRelativePath(rc: RC): RawRestPath
  def body(rc: RC): HttpBody
  def getMethodName(rc: RC): String
  def getQueryParameters(rc: RC): Map[String, List[String]]
  def getQueryString(rc: RC): Option[String]
}

class HttpEnvelopeSupportDefaultImpl[
  F[
    +_,
    +_,
  ]: IO2,
  RC: AbstractRequestContext,
](idExtractor: MethodIdExtractor,
  idRemapper: ServerIdRemapper[F],
) extends HttpEnvelopeSupport[F, RC] {
  private val RC = implicitly[AbstractRequestContext[RC]]

  override def makeInput(context: RC): F[ServerTransportError, MethodInput] = {
    for {
      path <- F.pure(RC.getRelativePath(context))
      id <- F.fromEither(idExtractor.extract(path))
      fullId <- idRemapper.remapId(id, path)
    } yield {
      MethodInput(RC.body(context).json, fullId)
    }
  }
}