package io.protoforce.demo.auth.app.plugins

import distage.TagKK
import distage.plugins.PluginDef
import io.protoforce.demo.auth.services.{PasswordService, SanitationService, TokensService, UserAuthService}
import izumi.distage.model.definition.ModuleDef
import zio.IO

object ComponentsPlugin extends PluginDef {
  private def makeF[F[+_, +_]: TagKK]: ModuleDef = new ModuleDef {
    make[PasswordService[F]].from[PasswordService.PasswordServiceImpl[F]]
    make[TokensService[F]].from[TokensService.TokensServiceImpl[F]]
    make[SanitationService[F]].from[SanitationService.SanitationServiceImpl[F]]
    make[UserAuthService[F]].from[UserAuthService.UserAuthServiceImpl[F]]
  }

  include(makeF[IO])
}


