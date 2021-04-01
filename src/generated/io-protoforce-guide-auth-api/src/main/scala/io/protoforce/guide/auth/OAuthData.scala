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
  * 
  *  OAuth Data holds information obtained during OAuth flow
  * 
  * Mixin io.protoforce.guide.auth:OAuthData
  * 
  * Defined at /providers/oauth.pfm @ 4:1
  */
trait OAuthData {
  /**
    * OAuth token
    */
  def accessToken: String
}

object OAuthData {
  /**
    * 
    *  OAuth Data holds information obtained during OAuth flow
    * 
    * Mixin io.protoforce.guide.auth:OAuthData
    * 
    * Defined at /providers/oauth.pfm @ 4:1
    */
  final case class Impl(
    /**
      * OAuth token
      */
    accessToken: String
  ) extends OAuthData
  
  implicit final class Conversions(
    val _value: OAuthData
  ) extends _root_.io.protoforce.runtime.IRTConversions[OAuthData]
  
  /**
    * conversion:interface-clone
    */
  implicit object Copy_OAuthData_to_OAuthData_StructuralSibling_Reliable_1831985658 extends _root_.io.protoforce.runtime.IRTCast[OAuthData, OAuthData.Impl] {
    def convert(from: OAuthData): OAuthData.Impl = new OAuthData.Impl(
      accessToken = from.accessToken
    )
  }
  
  /**
    * conversion:structural-structure-upcast
    */
  implicit object Copy_OAuthData_to_GoogleAuth_StructuralDowncast_Reliable_577073138 extends _root_.io.protoforce.runtime.IRTCast[OAuthData, GoogleAuth] {
    def convert(from: OAuthData): GoogleAuth = new GoogleAuth(
      accessToken = from.accessToken
    )
  }
  
  implicit object Expand_OAuthData_into_Facebook_StructuralDowncast_Reliable_1201240165 extends _root_.io.protoforce.runtime.IRTExtend[OAuthData, SignUp.Facebook] {
    final class Expand(
      val _value: OAuthData
    ) extends _root_.scala.AnyVal {
      def using(timezone: String): SignUp.Facebook = new SignUp.Facebook(
        timezone = timezone,
        accessToken = _value.accessToken
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: OAuthData): Expand = new Expand(
      _value = from
    )
  }
  
  /**
    * conversion:structural-structure-upcast
    */
  implicit object Copy_OAuthData_to_TwitterAuth_StructuralDowncast_Reliable_1922206714 extends _root_.io.protoforce.runtime.IRTCast[OAuthData, TwitterAuth] {
    def convert(from: OAuthData): TwitterAuth = new TwitterAuth(
      accessToken = from.accessToken
    )
  }
  
  implicit object Expand_OAuthData_into_Google_StructuralDowncast_Reliable_301178454 extends _root_.io.protoforce.runtime.IRTExtend[OAuthData, SignUp.Google] {
    final class Expand(
      val _value: OAuthData
    ) extends _root_.scala.AnyVal {
      def using(timezone: String): SignUp.Google = new SignUp.Google(
        timezone = timezone,
        accessToken = _value.accessToken
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: OAuthData): Expand = new Expand(
      _value = from
    )
  }
  
  implicit object Expand_OAuthData_into_Github_StructuralDowncast_Reliable_1175812989 extends _root_.io.protoforce.runtime.IRTExtend[OAuthData, SignUp.Github] {
    final class Expand(
      val _value: OAuthData
    ) extends _root_.scala.AnyVal {
      def using(timezone: String): SignUp.Github = new SignUp.Github(
        timezone = timezone,
        accessToken = _value.accessToken
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: OAuthData): Expand = new Expand(
      _value = from
    )
  }
  
  /**
    * conversion:structural-structure-upcast
    */
  implicit object Copy_OAuthData_to_FacebookAuth_StructuralDowncast_Reliable_96787983 extends _root_.io.protoforce.runtime.IRTCast[OAuthData, FacebookAuth] {
    def convert(from: OAuthData): FacebookAuth = new FacebookAuth(
      accessToken = from.accessToken
    )
  }
  
  /**
    * conversion:structural-structure-upcast
    */
  implicit object Copy_OAuthData_to_GithubAuth_StructuralDowncast_Reliable_1624006738 extends _root_.io.protoforce.runtime.IRTCast[OAuthData, GithubAuth] {
    def convert(from: OAuthData): GithubAuth = new GithubAuth(
      accessToken = from.accessToken
    )
  }
  
  implicit object Expand_OAuthData_into_Twitter_StructuralDowncast_Reliable_1838776839 extends _root_.io.protoforce.runtime.IRTExtend[OAuthData, SignUp.Twitter] {
    final class Expand(
      val _value: OAuthData
    ) extends _root_.scala.AnyVal {
      def using(timezone: String): SignUp.Twitter = new SignUp.Twitter(
        timezone = timezone,
        accessToken = _value.accessToken
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: OAuthData): Expand = new Expand(
      _value = from
    )
  }
  
  implicit val OAuthData_random: IRTRandomGen[OAuthData] = new IRTRandomGen[OAuthData]{
    def id: String = "io.protoforce.guide.auth:OAuthData"
    def makeRandom(_random: Random, _path: List[String]): OAuthData = new OAuthData.Impl(
      accessToken = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val OAuthData_meta: IRTMetadata[OAuthData] = new IRTMetadata[OAuthData]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:OAuthData"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("30a7993ade91f966d9d0856a56111728d28cbd800fa502fc42ab2259c48a4d79"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("942fe7998fbf5a27ac1ce35d7a12120c5ded3ff438004dcf12f4b25a8a7541b4"))
  }
}