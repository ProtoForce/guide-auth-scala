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
  * DTO io.protoforce.guide.auth:GithubServerConfig
  * 
  * Defined at config.pfm @ 31:1
  */
final case class GithubServerConfig(
  clientId: String,
  clientSecret: String
) extends GithubServerConfig.Defn

object GithubServerConfig {
  /**
    * DTO io.protoforce.guide.auth:GithubServerConfig
    * 
    * Defined at config.pfm @ 31:1
    */
  trait Defn {
    def clientId: String
    def clientSecret: String
  }
  
  implicit final class Conversions(
    val _value: GithubServerConfig
  ) extends _root_.io.protoforce.runtime.IRTConversions[GithubServerConfig]
  
  /**
    * conversion:structural-structure-upcast
    */
  implicit object Copy_GithubServerConfig_to_GithubClientConfig_StructuralUpcast_Reliable_1582467299 extends _root_.io.protoforce.runtime.IRTCast[GithubServerConfig, GithubClientConfig] {
    def convert(from: GithubServerConfig): GithubClientConfig = new GithubClientConfig(
      clientId = from.clientId
    )
  }
  
  implicit val GithubServerConfig_random: IRTRandomGen[GithubServerConfig] = new IRTRandomGen[GithubServerConfig]{
    def id: String = "io.protoforce.guide.auth:GithubServerConfig"
    def makeRandom(_random: Random, _path: List[String]): GithubServerConfig = new GithubServerConfig(
      clientId = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
      clientSecret = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val GithubServerConfig_meta: IRTMetadata[GithubServerConfig] = new IRTMetadata[GithubServerConfig]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:GithubServerConfig"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("62160ff8c9cb87d3d3ee951f17e4b02638278f87e3a86bf1631270a2a2b452d3"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("c53eac15e0bf6c111e59b74ec5e55ae625459dbd5dda15d0720671f8821a1aeb"))
  }
}