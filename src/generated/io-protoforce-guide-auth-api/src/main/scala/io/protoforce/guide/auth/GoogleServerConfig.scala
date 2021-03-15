package io.protoforce.guide.auth

import _root_.izumi.idealingua.model.versioning.IRTSchema.{
  TypeBaseVersion,
  TypeFullVersion
}
import _root_.izumi.idealingua.runtime.{
  IRTMetadata,
  IRTRandomGen,
  IRTTypeId
}
import _root_.scala.List
import _root_.scala.Predef.String
import _root_.scala.util.Random

/**
  * DTO io.protoforce.guide.auth:GoogleServerConfig
  * 
  * Defined at config.pfm @ 13:1
  */
final case class GoogleServerConfig(
  clientId: String,
  redirectUrl: String,
  clientSecret: String
) extends GoogleServerConfig.Defn

object GoogleServerConfig {
  /**
    * DTO io.protoforce.guide.auth:GoogleServerConfig
    * 
    * Defined at config.pfm @ 13:1
    */
  trait Defn {
    def clientId: String
    def redirectUrl: String
    def clientSecret: String
  }
  
  implicit final class Conversions(
    val _value: GoogleServerConfig
  ) extends _root_.izumi.idealingua.runtime.IRTConversions[GoogleServerConfig]
  
  /**
    * conversion:structural-structure-upcast
    */
  implicit object Copy_GoogleServerConfig_to_GoogleClientConfig_StructuralUpcast_Reliable_1629570748 extends _root_.izumi.idealingua.runtime.IRTCast[GoogleServerConfig, GoogleClientConfig] {
    def convert(from: GoogleServerConfig): GoogleClientConfig = new GoogleClientConfig(
      clientId = from.clientId,
      redirectUrl = from.redirectUrl
    )
  }
  
  implicit val GoogleServerConfig_random: IRTRandomGen[GoogleServerConfig] = new IRTRandomGen[GoogleServerConfig]{
    def id: String = "io.protoforce.guide.auth:GoogleServerConfig"
    def makeRandom(_random: Random, _path: List[String]): GoogleServerConfig = new GoogleServerConfig(
      clientId = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
      redirectUrl = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
      clientSecret = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val GoogleServerConfig_meta: IRTMetadata[GoogleServerConfig] = new IRTMetadata[GoogleServerConfig]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:GoogleServerConfig"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("fd9dc0bd222e69ed6e457718ebe4459d4bfd80898aaa65aabd4aceaa0e1cfa10"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("3e2a62f78bc63b5b1041530b04bf0443da78b45dcc03b7a9ae0d640d3e7b6852"))
  }
}