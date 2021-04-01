package io.protoforce.runtime.transport.http.dimodule.convenience

import distage.{ModuleDef, TagKK}
import izumi.functional.bio.IO2
import io.protoforce.runtime.transport.dispatch.server.IRTEventListener

class SharedHttpModule[F[+_, +_]: TagKK] extends ModuleDef {
  make[IRTEventListener[F]].from {
    implicit bio: IO2[F] =>
      IRTEventListener.nullListener[F]
  }
}