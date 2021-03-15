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
  * DTO io.protoforce.guide.auth:GoogleClientConfig
  * 
  * Defined at config.pfm @ 8:1
  */
final case class GoogleClientConfig(
  clientId: String,
  redirectUrl: String
) extends GoogleClientConfig.Defn

object GoogleClientConfig {
  /**
    * DTO io.protoforce.guide.auth:GoogleClientConfig
    * 
    * Defined at config.pfm @ 8:1
    */
  trait Defn {
    def clientId: String
    def redirectUrl: String
  }
  
  implicit final class Conversions(
    val _value: GoogleClientConfig
  ) extends _root_.izumi.idealingua.runtime.IRTConversions[GoogleClientConfig]
  
  implicit object Expand_GoogleClientConfig_into_GoogleServerConfig_StructuralDowncast_Reliable_1629570748 extends _root_.izumi.idealingua.runtime.IRTExtend[GoogleClientConfig, GoogleServerConfig] {
    final class Expand(
      val _value: GoogleClientConfig
    ) extends _root_.scala.AnyVal {
      def using(clientSecret: String): GoogleServerConfig = new GoogleServerConfig(
        clientSecret = clientSecret,
        clientId = _value.clientId,
        redirectUrl = _value.redirectUrl
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: GoogleClientConfig): Expand = new Expand(
      _value = from
    )
  }
  
  implicit val GoogleClientConfig_random: IRTRandomGen[GoogleClientConfig] = new IRTRandomGen[GoogleClientConfig]{
    def id: String = "io.protoforce.guide.auth:GoogleClientConfig"
    def makeRandom(_random: Random, _path: List[String]): GoogleClientConfig = new GoogleClientConfig(
      clientId = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
      redirectUrl = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val GoogleClientConfig_meta: IRTMetadata[GoogleClientConfig] = new IRTMetadata[GoogleClientConfig]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:GoogleClientConfig"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("2a0e4bebb287281f13f326c3489b2c2809dd1de5636cdee256db7c2f585c4e84"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("cca6a556dcbe313a9c5e9491dec7c76577d1f17b1eaab94e9658e376942463bd"))
  }
}