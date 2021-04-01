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
  * DTO io.protoforce.guide.auth:TwitterServerConfig
  * 
  * Defined at config.pfm @ 22:1
  */
final case class TwitterServerConfig(
  customerId: String,
  customerSecret: String
) extends TwitterServerConfig.Defn

object TwitterServerConfig {
  /**
    * DTO io.protoforce.guide.auth:TwitterServerConfig
    * 
    * Defined at config.pfm @ 22:1
    */
  trait Defn {
    def customerId: String
    def customerSecret: String
  }
  
  implicit final class Conversions(
    val _value: TwitterServerConfig
  ) extends _root_.io.protoforce.runtime.IRTConversions[TwitterServerConfig]
  
  /**
    * conversion:structural-structure-upcast
    */
  implicit object Copy_TwitterServerConfig_to_TwitterClientConfig_StructuralUpcast_Reliable_679107677 extends _root_.io.protoforce.runtime.IRTCast[TwitterServerConfig, TwitterClientConfig] {
    def convert(from: TwitterServerConfig): TwitterClientConfig = new TwitterClientConfig(
      customerId = from.customerId
    )
  }
  
  implicit val TwitterServerConfig_random: IRTRandomGen[TwitterServerConfig] = new IRTRandomGen[TwitterServerConfig]{
    def id: String = "io.protoforce.guide.auth:TwitterServerConfig"
    def makeRandom(_random: Random, _path: List[String]): TwitterServerConfig = new TwitterServerConfig(
      customerId = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
      customerSecret = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val TwitterServerConfig_meta: IRTMetadata[TwitterServerConfig] = new IRTMetadata[TwitterServerConfig]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:TwitterServerConfig"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("787e821e9cae225281f5bd3df2edbe5a28c3788ef75ce7f02f663b2d4fa69792"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("566bdb70fcf7ec0db6b8d62be0465545e688d729268b64839f54415d1873eb74"))
  }
}