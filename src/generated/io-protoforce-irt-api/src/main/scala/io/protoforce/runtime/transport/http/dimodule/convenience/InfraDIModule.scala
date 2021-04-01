package io.protoforce.runtime.transport.http.dimodule.convenience

import distage.{ModuleDef, TagKK}
import io.circe.Printer
import izumi.functional.bio.{Clock2, Entropy2, SyncSafe2}
import izumi.functional.mono.{Clock, Entropy}
import izumi.fundamentals.platform.functional.Identity

class InfraDIModule[F[+_, +_]: TagKK] extends ModuleDef {
  make[Printer].fromValue(Printer.noSpaces)

//  make[Clock2[F]]
//    .from {
//      ss: SyncSafe2[F] =>
//        Clock.fromImpure(Clock.Standard)(ss)
//    }
//  make[Entropy[Identity]]
//    .fromValue(Entropy.Standard)
//  make[Entropy2[F]]
//    .aliased[Entropy[F[Throwable, *]]]
//    .from {
//      ss: SyncSafe2[F] =>
//        Entropy.fromImpure(Entropy.Standard)(ss)
//    }
}