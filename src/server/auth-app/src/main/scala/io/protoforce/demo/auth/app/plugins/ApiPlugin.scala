package io.protoforce.demo.auth.app.plugins

import distage.TagKK
import distage.plugins.PluginDef
import io.circe.Json
import io.protoforce.demo.auth.api.{AuthProtectedServiceImpl, AuthServiceImpl, Codecs}
import io.protoforce.demo.auth.models.IncomingServerCtx
import io.protoforce.guide.auth.authprotectedservice.{AuthProtectedService, AuthProtectedServiceServerDispatcher}
import io.protoforce.guide.auth.authservice.{AuthService, AuthServiceServerDispatcher}
import io.protoforce.guide.auth.codecs.IRTCodecAuthAbstract
import izumi.distage.model.definition.ModuleDef
import io.protoforce.runtime.transport.dispatch.server.GeneratedServerBase
import zio.IO

object ApiPlugin extends PluginDef {
//  private type TagK1K1[K[_[+_, +_]]] = HKTag[ {type Arg[F[+_, +_]] = K[F]}]
//
//  private class Aux[F[+_, +_] : TagKK, Impl[_[+_, +_]] : TagK1K1](implicit @unused ctor: ClassConstructor[Impl[F]]) {
//    def from[Codec[_] <: IRTDomainCodec[_] : TagK](impl: (Impl[F], Codec[Json], Error2[F]) => GeneratedServerBase[F, IncomingServerCtx, Json]): Unit = {
//      make[Impl[F]]
//      many[GeneratedServerBase[F, IncomingServerCtx, Json]]
//        .add {
//          (svc: Impl[F], codec: Codec[Json], bme: Error2[F]) =>
//            impl(svc, codec, bme)
//        }
//      ()
//    }
//  }
//
//  private def makeService[F[+_, +_] : TagKK, Impl[_[+_, +_]] : TagK1K1](implicit ctor: ClassConstructor[Impl[F]]): Aux[F, Impl] = {
//    new Aux[F, Impl]
//  }
//
//  private def makeF[F[+_, +_] : TagKK]: ModuleDef = new ModuleDef {
//    makeService[F, AuthServiceImpl]
//      .from[IRTCodecAuthAbstract]((i, c, b) => new AuthServiceServerDispatcher(i, c)(b))
//
//    makeService[F, AuthProtectedServiceImpl]
//      .from[IRTCodecAuthAbstract]((i, c, b) => new AuthProtectedServiceServerDispatcher(i, c)(b))
//  }

  private def makeF[F[+_, +_] : TagKK]: ModuleDef = new ModuleDef {
    make[AuthService[IncomingServerCtx, F]].from[AuthServiceImpl[F]]
    make[AuthProtectedService[IncomingServerCtx, F]].from[AuthProtectedServiceImpl[F]]

    many[GeneratedServerBase[F, IncomingServerCtx, Json]]
      .add[AuthServiceServerDispatcher[F, IncomingServerCtx, Json]]
      .add[AuthProtectedServiceServerDispatcher[F, IncomingServerCtx, Json]]

  }

  include(makeF[IO])

  make[Codecs]
    .fromValue(Codecs)
    .aliased[IRTCodecAuthAbstract[Json]]
}
