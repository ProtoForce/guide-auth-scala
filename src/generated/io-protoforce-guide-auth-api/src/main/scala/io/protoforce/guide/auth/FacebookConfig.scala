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
  * DTO io.protoforce.guide.auth:FacebookConfig
  * 
  * Defined at config.pfm @ 4:1
  */
final case class FacebookConfig(
  appId: String
) extends FacebookConfig.Defn

object FacebookConfig {
  /**
    * DTO io.protoforce.guide.auth:FacebookConfig
    * 
    * Defined at config.pfm @ 4:1
    */
  trait Defn {
    def appId: String
  }
  
  implicit final class Conversions(
    val _value: FacebookConfig
  ) extends _root_.izumi.idealingua.runtime.IRTConversions[FacebookConfig]
  
  implicit val FacebookConfig_random: IRTRandomGen[FacebookConfig] = new IRTRandomGen[FacebookConfig]{
    def id: String = "io.protoforce.guide.auth:FacebookConfig"
    def makeRandom(_random: Random, _path: List[String]): FacebookConfig = new FacebookConfig(
      appId = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val FacebookConfig_meta: IRTMetadata[FacebookConfig] = new IRTMetadata[FacebookConfig]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:FacebookConfig"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("db3fa14887ca935a596c2762a581bc9e159f14d3ea89d80d970a540d1aadde02"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("44482ef5479c5ab607bfff512dd95296972a1d4ca88c5d1dfdf929260c71b587"))
  }
}