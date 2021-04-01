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
import _root_.scala.{
  List,
  Long
}
import _root_.scala.Predef.String
import _root_.scala.util.Random

/**
  * DTO io.protoforce.guide.auth:TokensServerConfig
  * 
  * Defined at config.pfm @ 36:1
  */
final case class TokensServerConfig(
  jwtKey: String,
  expiration: Long
) extends TokensServerConfig.Defn

object TokensServerConfig {
  /**
    * DTO io.protoforce.guide.auth:TokensServerConfig
    * 
    * Defined at config.pfm @ 36:1
    */
  trait Defn {
    def jwtKey: String
    def expiration: Long
  }
  
  implicit final class Conversions(
    val _value: TokensServerConfig
  ) extends _root_.io.protoforce.runtime.IRTConversions[TokensServerConfig]
  
  implicit val TokensServerConfig_random: IRTRandomGen[TokensServerConfig] = new IRTRandomGen[TokensServerConfig]{
    def id: String = "io.protoforce.guide.auth:TokensServerConfig"
    def makeRandom(_random: Random, _path: List[String]): TokensServerConfig = new TokensServerConfig(
      jwtKey = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
      expiration = IRTRandomGen[Long].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val TokensServerConfig_meta: IRTMetadata[TokensServerConfig] = new IRTMetadata[TokensServerConfig]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:TokensServerConfig"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("028c399cc0fc48c8f91e89bd9f5c7070e246f389ef3f96b97bbb96a6328e9816"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("e90e156a24d4f6ed590e5dda27c17e4a0fdca361ed14daa08f9bf55f2f3b009e"))
  }
}