package io.protoforce.demo.auth.app.plugins

import distage.plugins.PluginDef
import io.protoforce.demo.auth.models._
import izumi.distage.config.ConfigModuleDef

object ConfigPlugin extends PluginDef with ConfigModuleDef {
  makeConfig[HttpConfig]("http.listen")

  makeConfig[AppConfig]("demo")
  make[GithubConfig].from { c: AppConfig => c.github }
  make[GoogleConfig].from { c: AppConfig => c.google }
  make[TwitterConfig].from { c: AppConfig => c.twitter }
  make[TokensConfig].from { c: AppConfig => c.tokens }
  make[EmailConfig].from { c: AppConfig => c.email }
  make[FacebookConfig].from { c: AppConfig => c.facebook }
  make[SmsConfig].from { c: AppConfig => c.sms }

}
