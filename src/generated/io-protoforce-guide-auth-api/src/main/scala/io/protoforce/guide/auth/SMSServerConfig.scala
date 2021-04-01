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
  * DTO io.protoforce.guide.auth:SMSServerConfig
  * 
  * Defined at config.pfm @ 47:1
  */
final case class SMSServerConfig(
  apiKey: String
) extends SMSServerConfig.Defn

object SMSServerConfig {
  /**
    * DTO io.protoforce.guide.auth:SMSServerConfig
    * 
    * Defined at config.pfm @ 47:1
    */
  trait Defn {
    def apiKey: String
  }
  
  implicit final class Conversions(
    val _value: SMSServerConfig
  ) extends _root_.io.protoforce.runtime.IRTConversions[SMSServerConfig]
  
  implicit val SMSServerConfig_random: IRTRandomGen[SMSServerConfig] = new IRTRandomGen[SMSServerConfig]{
    def id: String = "io.protoforce.guide.auth:SMSServerConfig"
    def makeRandom(_random: Random, _path: List[String]): SMSServerConfig = new SMSServerConfig(
      apiKey = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val SMSServerConfig_meta: IRTMetadata[SMSServerConfig] = new IRTMetadata[SMSServerConfig]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:SMSServerConfig"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("78716af59bee932e3c4d329b41acc6a678ad259272f4b4c14b8b7dcd2475feba"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("680012cc5daf2f998e69950e59cc07644e4e88a1e82e9ec3ea3b06828483abfa"))
  }
}