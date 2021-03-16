package io.protoforce.demo.auth.app

import distage.plugins.PluginConfig
import io.protoforce.demo.auth.app.plugins.{ApiPlugin, ApplicationPlugin, ComponentsPlugin, ConfigPlugin, HttpServerPlugin, IntegrationsPlugin, ReposPlugin}
import io.protoforce.demo.auth.app.roles.AuthServerRole
import izumi.distage.roles.RoleAppMain
import izumi.fundamentals.platform.cli.model.raw.RawRoleParams
import zio.IO

object AuthDemoApp extends RoleAppMain.LauncherBIO2[IO] {
  override protected def requiredRoles(
      argv: RoleAppMain.ArgV
  ): Vector[RawRoleParams] = {
    Vector(RawRoleParams(AuthServerRole.id))
  }

  override protected def pluginConfig: PluginConfig = PluginConfig.const(
    Seq(
      HttpServerPlugin,
      ApiPlugin,
      IntegrationsPlugin,
      ReposPlugin,
      ComponentsPlugin,
      ConfigPlugin,
      ApplicationPlugin
    )
  )
}
