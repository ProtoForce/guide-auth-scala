package io.protoforce.demo.auth.models

import scala.concurrent.duration.FiniteDuration

case class EmailConfig(resetPassEndpoint: String)
case class SmsConfig(apiKey: String)
case class GithubConfig(clientId: String, clientSecret: String)
case class TwitterConfig(customerId: String, customerSecret: String)
case class GoogleConfig(
    clientId: String,
    clientSecret: String,
    redirectUrl: String
)
case class FacebookConfig(appId: String)
case class TokensConfig(jwtKey: String, expiration: FiniteDuration)
case class AppConfig(
    email: EmailConfig,
    sms: SmsConfig,
    google: GoogleConfig,
    github: GithubConfig,
    twitter: TwitterConfig,
    facebook: FacebookConfig,
    tokens: TokensConfig
)
