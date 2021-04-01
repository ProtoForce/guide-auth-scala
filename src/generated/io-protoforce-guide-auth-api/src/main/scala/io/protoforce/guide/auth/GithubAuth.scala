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
  *  Github Authentication
  * 
  * DTO io.protoforce.guide.auth:GithubAuth
  * 
  * Defined at /providers/github.pfm @ 4:1
  */
final case class GithubAuth(
  /**
    * OAuth token
    */
  accessToken: String
) extends GithubAuth.Defn

object GithubAuth {
  /**
    * 
    *  Github Authentication
    * 
    * DTO io.protoforce.guide.auth:GithubAuth
    * 
    * Defined at /providers/github.pfm @ 4:1
    */
  trait Defn {
    /**
      * OAuth token
      */
    def accessToken: String
  }
  
  implicit final class Conversions(
    val _value: GithubAuth
  ) extends _root_.io.protoforce.runtime.IRTConversions[GithubAuth]
  
  /**
    * conversion:structural-sibling-upcast
    */
  implicit object Copy_GithubAuth_to_FacebookAuth_StructuralUpcast_Reliable_304766903 extends _root_.io.protoforce.runtime.IRTCast[GithubAuth, FacebookAuth] {
    def convert(from: GithubAuth): FacebookAuth = new FacebookAuth(
      accessToken = from.accessToken
    )
  }
  
  /**
    * conversion:structural-sibling-upcast
    */
  implicit object Copy_GithubAuth_to_GoogleAuth_StructuralUpcast_Reliable_369094218 extends _root_.io.protoforce.runtime.IRTCast[GithubAuth, GoogleAuth] {
    def convert(from: GithubAuth): GoogleAuth = new GoogleAuth(
      accessToken = from.accessToken
    )
  }
  
  implicit object Expand_GithubAuth_into_Github_StructuralUpcast_Reliable_1383791909 extends _root_.io.protoforce.runtime.IRTExtend[GithubAuth, SignUp.Github] {
    final class Expand(
      val _value: GithubAuth
    ) extends _root_.scala.AnyVal {
      def using(timezone: String): SignUp.Github = new SignUp.Github(
        timezone = timezone,
        accessToken = _value.accessToken
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: GithubAuth): Expand = new Expand(
      _value = from
    )
  }
  
  /**
    * conversion:structural-sibling-upcast
    */
  implicit object Copy_GithubAuth_to_TwitterAuth_StructuralUpcast_Reliable_2130185634 extends _root_.io.protoforce.runtime.IRTCast[GithubAuth, TwitterAuth] {
    def convert(from: GithubAuth): TwitterAuth = new TwitterAuth(
      accessToken = from.accessToken
    )
  }
  
  implicit object Expand_GithubAuth_into_Google_StructuralUpcast_Reliable_509157374 extends _root_.io.protoforce.runtime.IRTExtend[GithubAuth, SignUp.Google] {
    final class Expand(
      val _value: GithubAuth
    ) extends _root_.scala.AnyVal {
      def using(timezone: String): SignUp.Google = new SignUp.Google(
        timezone = timezone,
        accessToken = _value.accessToken
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: GithubAuth): Expand = new Expand(
      _value = from
    )
  }
  
  implicit object Expand_GithubAuth_into_Facebook_StructuralUpcast_Reliable_993261245 extends _root_.io.protoforce.runtime.IRTExtend[GithubAuth, SignUp.Facebook] {
    final class Expand(
      val _value: GithubAuth
    ) extends _root_.scala.AnyVal {
      def using(timezone: String): SignUp.Facebook = new SignUp.Facebook(
        timezone = timezone,
        accessToken = _value.accessToken
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: GithubAuth): Expand = new Expand(
      _value = from
    )
  }
  
  implicit object Expand_GithubAuth_into_Twitter_StructuralUpcast_Reliable_2046755759 extends _root_.io.protoforce.runtime.IRTExtend[GithubAuth, SignUp.Twitter] {
    final class Expand(
      val _value: GithubAuth
    ) extends _root_.scala.AnyVal {
      def using(timezone: String): SignUp.Twitter = new SignUp.Twitter(
        timezone = timezone,
        accessToken = _value.accessToken
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: GithubAuth): Expand = new Expand(
      _value = from
    )
  }
  
  /**
    * conversion:structural-structure-upcast
    */
  implicit object Copy_GithubAuth_to_OAuthData_StructuralUpcast_Reliable_1624006738 extends _root_.io.protoforce.runtime.IRTCast[GithubAuth, OAuthData.Impl] {
    def convert(from: GithubAuth): OAuthData.Impl = new OAuthData.Impl(
      accessToken = from.accessToken
    )
  }
  
  implicit val GithubAuth_random: IRTRandomGen[GithubAuth] = new IRTRandomGen[GithubAuth]{
    def id: String = "io.protoforce.guide.auth:GithubAuth"
    def makeRandom(_random: Random, _path: List[String]): GithubAuth = new GithubAuth(
      accessToken = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val GithubAuth_meta: IRTMetadata[GithubAuth] = new IRTMetadata[GithubAuth]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:GithubAuth"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("b121049396653f42ef911ac5dd9f7b0af3b88cfac2d156e5d07eba5093f58ca3"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("4dde612d7eed1f97c50f63e40dc25c6c22752f84dd0fff4e7dc0522f3f9280ea"))
  }
}