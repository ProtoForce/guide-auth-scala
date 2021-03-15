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
  * DTO io.protoforce.guide.auth:GithubClientConfig
  * 
  * Defined at config.pfm @ 27:1
  */
final case class GithubClientConfig(
  clientId: String
) extends GithubClientConfig.Defn

object GithubClientConfig {
  /**
    * DTO io.protoforce.guide.auth:GithubClientConfig
    * 
    * Defined at config.pfm @ 27:1
    */
  trait Defn {
    def clientId: String
  }
  
  implicit final class Conversions(
    val _value: GithubClientConfig
  ) extends _root_.izumi.idealingua.runtime.IRTConversions[GithubClientConfig]
  
  implicit object Expand_GithubClientConfig_into_GithubServerConfig_StructuralDowncast_Reliable_1582467299 extends _root_.izumi.idealingua.runtime.IRTExtend[GithubClientConfig, GithubServerConfig] {
    final class Expand(
      val _value: GithubClientConfig
    ) extends _root_.scala.AnyVal {
      def using(clientSecret: String): GithubServerConfig = new GithubServerConfig(
        clientSecret = clientSecret,
        clientId = _value.clientId
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: GithubClientConfig): Expand = new Expand(
      _value = from
    )
  }
  
  implicit val GithubClientConfig_random: IRTRandomGen[GithubClientConfig] = new IRTRandomGen[GithubClientConfig]{
    def id: String = "io.protoforce.guide.auth:GithubClientConfig"
    def makeRandom(_random: Random, _path: List[String]): GithubClientConfig = new GithubClientConfig(
      clientId = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val GithubClientConfig_meta: IRTMetadata[GithubClientConfig] = new IRTMetadata[GithubClientConfig]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:GithubClientConfig"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("e58c0f6624d99a559f77bc7ce287632ab196cb618ba59dbc521a0a261e785a7a"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("76a9ad12bef21371137cf8fdf75bb104d5e4a984e7b97cee831a63511ffb2b93"))
  }
}