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
  * 
  *  Facebook Authentication
  * 
  * DTO io.protoforce.guide.auth:FacebookAuth
  * 
  * Defined at /providers/facebook.pfm @ 4:1
  */
final case class FacebookAuth(
  /**
    * OAuth token
    */
  accessToken: String
) extends FacebookAuth.Defn

object FacebookAuth {
  /**
    * 
    *  Facebook Authentication
    * 
    * DTO io.protoforce.guide.auth:FacebookAuth
    * 
    * Defined at /providers/facebook.pfm @ 4:1
    */
  trait Defn {
    /**
      * OAuth token
      */
    def accessToken: String
  }
  
  implicit final class Conversions(
    val _value: FacebookAuth
  ) extends _root_.izumi.idealingua.runtime.IRTConversions[FacebookAuth]
  
  /**
    * conversion:structural-sibling-upcast
    */
  implicit object Copy_FacebookAuth_to_GithubAuth_StructuralUpcast_Reliable_304766903 extends _root_.izumi.idealingua.runtime.IRTCast[FacebookAuth, GithubAuth] {
    def convert(from: FacebookAuth): GithubAuth = new GithubAuth(
      accessToken = from.accessToken
    )
  }
  
  implicit object Expand_FacebookAuth_into_Google_StructuralUpcast_Reliable_2065015201 extends _root_.izumi.idealingua.runtime.IRTExtend[FacebookAuth, SignUp.Google] {
    final class Expand(
      val _value: FacebookAuth
    ) extends _root_.scala.AnyVal {
      def using(timezone: String): SignUp.Google = new SignUp.Google(
        timezone = timezone,
        accessToken = _value.accessToken
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: FacebookAuth): Expand = new Expand(
      _value = from
    )
  }
  
  /**
    * conversion:structural-sibling-upcast
    */
  implicit object Copy_FacebookAuth_to_GoogleAuth_StructuralUpcast_Reliable_1351700503 extends _root_.izumi.idealingua.runtime.IRTCast[FacebookAuth, GoogleAuth] {
    def convert(from: FacebookAuth): GoogleAuth = new GoogleAuth(
      accessToken = from.accessToken
    )
  }
  
  /**
    * conversion:structural-structure-upcast
    */
  implicit object Copy_FacebookAuth_to_OAuthData_StructuralUpcast_Reliable_96787983 extends _root_.izumi.idealingua.runtime.IRTCast[FacebookAuth, OAuthData.Impl] {
    def convert(from: FacebookAuth): OAuthData.Impl = new OAuthData.Impl(
      accessToken = from.accessToken
    )
  }
  
  implicit object Expand_FacebookAuth_into_Github_StructuralUpcast_Reliable_1190380666 extends _root_.izumi.idealingua.runtime.IRTExtend[FacebookAuth, SignUp.Github] {
    final class Expand(
      val _value: FacebookAuth
    ) extends _root_.scala.AnyVal {
      def using(timezone: String): SignUp.Github = new SignUp.Github(
        timezone = timezone,
        accessToken = _value.accessToken
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: FacebookAuth): Expand = new Expand(
      _value = from
    )
  }
  
  implicit object Expand_FacebookAuth_into_Twitter_StructuralUpcast_Reliable_527416816 extends _root_.izumi.idealingua.runtime.IRTExtend[FacebookAuth, SignUp.Twitter] {
    final class Expand(
      val _value: FacebookAuth
    ) extends _root_.scala.AnyVal {
      def using(timezone: String): SignUp.Twitter = new SignUp.Twitter(
        timezone = timezone,
        accessToken = _value.accessToken
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: FacebookAuth): Expand = new Expand(
      _value = from
    )
  }
  
  implicit object Expand_FacebookAuth_into_Facebook_StructuralDowncast_Reliable_727533476 extends _root_.izumi.idealingua.runtime.IRTExtend[FacebookAuth, SignUp.Facebook] {
    final class Expand(
      val _value: FacebookAuth
    ) extends _root_.scala.AnyVal {
      def using(timezone: String): SignUp.Facebook = new SignUp.Facebook(
        timezone = timezone,
        accessToken = _value.accessToken
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: FacebookAuth): Expand = new Expand(
      _value = from
    )
  }
  
  /**
    * conversion:structural-sibling-upcast
    */
  implicit object Copy_FacebookAuth_to_TwitterAuth_StructuralUpcast_Reliable_443986941 extends _root_.izumi.idealingua.runtime.IRTCast[FacebookAuth, TwitterAuth] {
    def convert(from: FacebookAuth): TwitterAuth = new TwitterAuth(
      accessToken = from.accessToken
    )
  }
  
  implicit val FacebookAuth_random: IRTRandomGen[FacebookAuth] = new IRTRandomGen[FacebookAuth]{
    def id: String = "io.protoforce.guide.auth:FacebookAuth"
    def makeRandom(_random: Random, _path: List[String]): FacebookAuth = new FacebookAuth(
      accessToken = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val FacebookAuth_meta: IRTMetadata[FacebookAuth] = new IRTMetadata[FacebookAuth]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:FacebookAuth"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("5d9955de65b858fb97695e10fedd0613181b8d0441c167950c86c609496f21d1"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("e5ccecffc0c314ac88121176ea9d1d4365edb723ba1eb90c83e54b19f63d8a70"))
  }
}