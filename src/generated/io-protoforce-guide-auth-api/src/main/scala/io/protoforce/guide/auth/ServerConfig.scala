package io.protoforce.guide.auth

import _root_.io.protoforce.model.versioning.IRTSchema.{
  TypeBaseVersion,
  TypeFullVersion
}
import _root_.io.protoforce.runtime.{
  IRTMetadata,
  IRTRandomGen,
  IRTTypeId
}
import _root_.scala.List
import _root_.scala.Predef.String
import _root_.scala.util.Random

/**
  * 
  *  Server side configuration
  * 
  * DTO io.protoforce.guide.auth:ServerConfig
  * 
  * Defined at config.pfm @ 89:1
  */
final case class ServerConfig(
  tokens: TokensServerConfig,
  email: EmailServerConfig,
  sms: SMSServerConfig,
  facebook: FacebookConfig,
  google: GoogleServerConfig,
  twitter: TwitterServerConfig,
  github: GithubServerConfig
) extends ServerConfig.Defn

object ServerConfig {
  /**
    * 
    *  Server side configuration
    * 
    * DTO io.protoforce.guide.auth:ServerConfig
    * 
    * Defined at config.pfm @ 89:1
    */
  trait Defn {
    def tokens: TokensServerConfig
    def email: EmailServerConfig
    def sms: SMSServerConfig
    def facebook: FacebookConfig
    def google: GoogleServerConfig
    def twitter: TwitterServerConfig
    def github: GithubServerConfig
  }
  
  implicit final class Conversions(
    val _value: ServerConfig
  ) extends _root_.io.protoforce.runtime.IRTConversions[ServerConfig]
  
  implicit val ServerConfig_random: IRTRandomGen[ServerConfig] = new IRTRandomGen[ServerConfig]{
    def id: String = "io.protoforce.guide.auth:ServerConfig"
    def makeRandom(_random: Random, _path: List[String]): ServerConfig = new ServerConfig(
      tokens = IRTRandomGen[TokensServerConfig].makeRandom(_random, _path :+ this.id),
      email = IRTRandomGen[EmailServerConfig].makeRandom(_random, _path :+ this.id),
      sms = IRTRandomGen[SMSServerConfig].makeRandom(_random, _path :+ this.id),
      facebook = IRTRandomGen[FacebookConfig].makeRandom(_random, _path :+ this.id),
      google = IRTRandomGen[GoogleServerConfig].makeRandom(_random, _path :+ this.id),
      twitter = IRTRandomGen[TwitterServerConfig].makeRandom(_random, _path :+ this.id),
      github = IRTRandomGen[GithubServerConfig].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val ServerConfig_meta: IRTMetadata[ServerConfig] = new IRTMetadata[ServerConfig]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:ServerConfig"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("62b809c036cc6559e4265aca0a9a74b84f5c84a99a96ef3536f8338980a5b5fe"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("60327e5dbf4e090e0b2cb781397824c39dcc2de4d09fdd8ae1c2c2db03889f13"))
  }
}