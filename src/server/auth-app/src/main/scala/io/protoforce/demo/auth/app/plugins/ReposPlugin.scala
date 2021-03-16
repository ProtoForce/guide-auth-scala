package io.protoforce.demo.auth.app.plugins

import distage.TagKK
import distage.plugins.PluginDef
import io.protoforce.demo.auth.repos.UserRepo
import izumi.distage.model.definition.ModuleDef
import zio.IO

object ReposPlugin extends PluginDef {
  private def makeF[F[+_, +_] : TagKK]: ModuleDef = new ModuleDef {
    make[UserRepo[F]].from[UserRepo.UserRepoDummyImp[F]]
  }

  include(makeF[IO])
}


