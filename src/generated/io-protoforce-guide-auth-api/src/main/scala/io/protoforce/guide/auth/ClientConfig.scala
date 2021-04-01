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
  *  Client side configuration. Should be used by clients to connect to a service
  *  and other providers using the defined IDs and endpoints
  * 
  * DTO io.protoforce.guide.auth:ClientConfig
  * 
  * Defined at config.pfm @ 55:1
  */
final case class ClientConfig(
  /**
    * Services endpoint
    */
  endpoint: String,
  facebook: FacebookConfig,
  google: GoogleClientConfig,
  twitter: TwitterClientConfig,
  github: GithubClientConfig
) extends ClientConfig.Defn

object ClientConfig {
  /**
    * 
    *  Client side configuration. Should be used by clients to connect to a service
    *  and other providers using the defined IDs and endpoints
    * 
    * DTO io.protoforce.guide.auth:ClientConfig
    * 
    * Defined at config.pfm @ 55:1
    */
  trait Defn {
    /**
      * Services endpoint
      */
    def endpoint: String
    def facebook: FacebookConfig
    def google: GoogleClientConfig
    def twitter: TwitterClientConfig
    def github: GithubClientConfig
  }
  
  implicit final class Conversions(
    val _value: ClientConfig
  ) extends _root_.io.protoforce.runtime.IRTConversions[ClientConfig]
  
  implicit val ClientConfig_random: IRTRandomGen[ClientConfig] = new IRTRandomGen[ClientConfig]{
    def id: String = "io.protoforce.guide.auth:ClientConfig"
    def makeRandom(_random: Random, _path: List[String]): ClientConfig = new ClientConfig(
      endpoint = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
      facebook = IRTRandomGen[FacebookConfig].makeRandom(_random, _path :+ this.id),
      google = IRTRandomGen[GoogleClientConfig].makeRandom(_random, _path :+ this.id),
      twitter = IRTRandomGen[TwitterClientConfig].makeRandom(_random, _path :+ this.id),
      github = IRTRandomGen[GithubClientConfig].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val ClientConfig_meta: IRTMetadata[ClientConfig] = new IRTMetadata[ClientConfig]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:ClientConfig"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("4a0cf67da2813b1cdd9c79b7c2109324be764045fa6c6e8d5c97da6576fb7878"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("8a72067149a8e16ef7d9b60dc199fa0daf777a216c3465a784ce79ac3259d764"))
  }
}