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
  * DTO io.protoforce.guide.auth:TwitterClientConfig
  * 
  * Defined at config.pfm @ 18:1
  */
final case class TwitterClientConfig(
  customerId: String
) extends TwitterClientConfig.Defn

object TwitterClientConfig {
  /**
    * DTO io.protoforce.guide.auth:TwitterClientConfig
    * 
    * Defined at config.pfm @ 18:1
    */
  trait Defn {
    def customerId: String
  }
  
  implicit final class Conversions(
    val _value: TwitterClientConfig
  ) extends _root_.izumi.idealingua.runtime.IRTConversions[TwitterClientConfig]
  
  implicit object Expand_TwitterClientConfig_into_TwitterServerConfig_StructuralDowncast_Reliable_679107677 extends _root_.izumi.idealingua.runtime.IRTExtend[TwitterClientConfig, TwitterServerConfig] {
    final class Expand(
      val _value: TwitterClientConfig
    ) extends _root_.scala.AnyVal {
      def using(customerSecret: String): TwitterServerConfig = new TwitterServerConfig(
        customerSecret = customerSecret,
        customerId = _value.customerId
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: TwitterClientConfig): Expand = new Expand(
      _value = from
    )
  }
  
  implicit val TwitterClientConfig_random: IRTRandomGen[TwitterClientConfig] = new IRTRandomGen[TwitterClientConfig]{
    def id: String = "io.protoforce.guide.auth:TwitterClientConfig"
    def makeRandom(_random: Random, _path: List[String]): TwitterClientConfig = new TwitterClientConfig(
      customerId = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val TwitterClientConfig_meta: IRTMetadata[TwitterClientConfig] = new IRTMetadata[TwitterClientConfig]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:TwitterClientConfig"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("c09b201e8fec37c612831107762fe6f13a21976d24c162b3443738d5e917e9b4"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("51e131140bbf8cbd6a2bbfa805178a5e781507aa816a4af4a3f149365b4bf72d"))
  }
}