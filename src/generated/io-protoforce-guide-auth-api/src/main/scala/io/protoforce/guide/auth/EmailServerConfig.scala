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
  * DTO io.protoforce.guide.auth:EmailServerConfig
  * 
  * Defined at config.pfm @ 41:1
  */
final case class EmailServerConfig(
  apiKey: String,
  confirmEndpoint: String,
  resetPassEndpoint: String
) extends EmailServerConfig.Defn

object EmailServerConfig {
  /**
    * DTO io.protoforce.guide.auth:EmailServerConfig
    * 
    * Defined at config.pfm @ 41:1
    */
  trait Defn {
    def apiKey: String
    def confirmEndpoint: String
    def resetPassEndpoint: String
  }
  
  implicit final class Conversions(
    val _value: EmailServerConfig
  ) extends _root_.io.protoforce.runtime.IRTConversions[EmailServerConfig]
  
  implicit val EmailServerConfig_random: IRTRandomGen[EmailServerConfig] = new IRTRandomGen[EmailServerConfig]{
    def id: String = "io.protoforce.guide.auth:EmailServerConfig"
    def makeRandom(_random: Random, _path: List[String]): EmailServerConfig = new EmailServerConfig(
      apiKey = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
      confirmEndpoint = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
      resetPassEndpoint = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val EmailServerConfig_meta: IRTMetadata[EmailServerConfig] = new IRTMetadata[EmailServerConfig]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:EmailServerConfig"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("95f0eb581ab2ef9a702608576cb8f4fe907aa62a1179c8f5c50abea79c5f8f7d"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("e3c9b75d25b97788b91c9e1d2ece56e68d83e2cbe6b5c1a3a331eecdbba3603f"))
  }
}