package io.protoforce.demo.auth.app.plugins

import distage._
import distage.plugins._
import izumi.distage.config._
import io.protoforce.demo.auth.integrations._
import zio.IO



object IntegrationsPlugin extends PluginDef with ConfigModuleDef {
  private def makeF[F[+_, +_] : TagKK]: ModuleDef = new ModuleDef {
    make[EmailService[F]].from[EmailService.EmailServiceDummyImpl[F]]
    make[SmsService[F]].from[SmsService.SmsServiceDummyImpl[F]]

    make[FacebookService[F]].from[FacebookService.FacebookServiceImpl[F]]
    make[GithubService[F]].from[GithubService.GithubServiceImpl[F]]
    make[GoogleService[F]].from[GoogleService.GoogleServiceImpl[F]]
    make[TwitterService[F]].from[TwitterService.TwitterServiceImpl[F]]
  }

  include(makeF[IO])
}




