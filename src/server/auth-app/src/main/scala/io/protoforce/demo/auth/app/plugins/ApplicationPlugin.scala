package io.protoforce.demo.auth.app.plugins

import distage.TagKK
import distage.plugins.PluginDef
import io.protoforce.demo.auth.app.roles.AuthServerRole
import izumi.distage.model.definition.ModuleDef
import izumi.distage.roles.model.definition.RoleModuleDef
import izumi.functional.bio.IO2
import zio.IO

object ApplicationPlugin extends PluginDef with RoleModuleDef {
  private def makeF[F[+_, +_]: IO2: TagKK]: ModuleDef = new ModuleDef {
    makeRole[AuthServerRole[F]]
  }
  include(makeF[IO])
}
