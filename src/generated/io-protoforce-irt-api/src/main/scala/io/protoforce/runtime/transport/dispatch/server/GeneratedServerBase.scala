package io.protoforce.runtime.transport.dispatch.server

import io.circe.Json
import izumi.functional.bio.{Error2, F}
import izumi.fundamentals.platform.language.Quirks._
import io.protoforce.model.typer.IRTRestSpec
import io.protoforce.runtime.codecs.IRTCodec
import io.protoforce.runtime.transport.dispatch.server.GeneratedServerBase._
import io.protoforce.runtime.transport.errors.ServerDispatcherError
import io.protoforce.runtime.transport.errors.ServerDispatcherError.{MethodHandlerMissing, ServerCodecFailure}

trait GeneratedServerBase[+F[_, _], -C, WValue] extends ServerContext[F, C, WValue] {
  def _id: ServiceName
  def _methods: Map[MethodId, _Req => F[ServerDispatcherError, _Res]]
  def _specs: Map[MethodId, IRTRestSpec]
  def dispatch(
    methodId: MethodId,
    r: _Req,
  ): F[ServerDispatcherError, ServerWireResponse[WValue]]
}

abstract class GeneratedServerBaseImpl[F[+_, +_]: Error2, C, WValue] extends GeneratedServerBase[F, C, WValue] {
  override final def dispatch(
    methodId: MethodId,
    r: _Req,
  ): F[ServerDispatcherError, ServerWireResponse[WValue]] = {
    _methods.get(methodId) match {
      case Some(value) =>
        value(r)
      case None =>
        F.fail(MethodHandlerMissing(methodId, _methods.keySet))
    }
  }

  protected final def doDecode[V: IRTCodec[*, WValue]](
    r: _Req
  ): F[ServerDispatcherError, V] = {
    val codec = implicitly[IRTCodec[V, WValue]]
    F.fromEither(codec.decode(r.value).left.map(f => ServerCodecFailure(f)))
  }

  protected final def doEncode[
    ResBody: IRTCodec[*, WValue],
    ReqBody: IRTCodec[
      *,
      WValue,
    ],
  ](r: _Req,
    reqBody: ReqBody,
    resBody: ResBody,
    kind: ResponseKind,
  ): F[ServerDispatcherError, ServerWireResponse[WValue]] = {
    (r, reqBody).discard()

    val codec = implicitly[IRTCodec[ResBody, WValue]]
    for {
      out <- F.pure(codec.encode(resBody))
    } yield {
      ServerWireResponse(out, kind)
    }
  }
}

object GeneratedServerBase {

  case class ClientResponse[+WValue](value: WValue)

  case class ServerWireRequest[+WCtxIn, +WValue](c: WCtxIn, value: WValue)

  sealed trait ResponseKind
  object ResponseKind {
    object Scalar extends ResponseKind
    object RpcSuccess extends ResponseKind
    object RpcFailure extends ResponseKind
  }
  case class ServerWireResponse[+WValue](value: WValue, kind: ResponseKind)

  case class MethodName(name: String) extends AnyVal

  case class ServiceName(prefix: Option[String], id: String) {
    override def toString: String =
      prefix match {
        case Some(value) =>
          s"$value:$id"
        case None =>
          id
      }
  }
  object ServiceName {
    def parse(s: String): ServiceName = {
      s.split(':').toList match {
        case head :: Nil =>
          ServiceName(None, head)
        case prefix :: id :: Nil =>
          ServiceName(Some(prefix), id)
        case _ =>
          ServiceName(None, s)
      }
    }
  }
  case class MethodId(service: ServiceName, method: MethodName)

}

trait BaseClientContext[RequestContext] {
  def methodId: GeneratedServerBase.MethodId
  def body: Json
  def rc: RequestContext
}

case class IdentifiedRequestContext[RequestContext](
  rc: RequestContext,
  invokationId: InvokationId,
  methodId: GeneratedServerBase.MethodId,
  body: Json,
) extends BaseClientContext[RequestContext]