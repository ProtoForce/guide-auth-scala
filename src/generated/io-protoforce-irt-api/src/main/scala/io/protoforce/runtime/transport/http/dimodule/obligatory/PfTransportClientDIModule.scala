package io.protoforce.runtime.transport.http.dimodule.obligatory

import distage.{ModuleDef, Tag, TagKK}
import io.protoforce.model.typer.IRTRestSpec
import io.protoforce.runtime.transport.dispatch.client.ClientRequestHook
import io.protoforce.runtime.transport.dispatch.server.GeneratedServerBase.MethodId
import io.protoforce.runtime.transport.dispatch.server.http.{AbstractHeader, HttpResponseHeaders, RestlikeResponseConvention, RestlikeResponseConventionImpl}
import io.protoforce.runtime.transport.http.clients.ahc.{AHCClientContext, AHCHttpClient, ClientTarget, RestRequestHook}
import org.asynchttpclient.BoundRequestBuilder

class PfTransportClientDIModule[F[+_, +_]: TagKK, CC: Tag, +DomainErrors >: Nothing: Tag](
  target: ClientTarget,
  restSpecs: Option[Map[MethodId, IRTRestSpec]],
) extends ModuleDef {
  addImplicit[AbstractHeader[String]]
  make[AHCHttpClient[F, CC]]
  make[HttpResponseHeaders[String]]
  make[RestlikeResponseConvention[F, String]].from[RestlikeResponseConventionImpl[F, String]]

  make[ClientTarget].fromValue(target)

  make[ClientRequestHook[AHCClientContext[CC], BoundRequestBuilder]].fromValue {
    restSpecs match {
      case Some(value) =>
        new RestRequestHook[F, CC](value)
      case None =>
        ClientRequestHook.forCtx[AHCClientContext[CC]].passthrough[BoundRequestBuilder]
    }
  }
}