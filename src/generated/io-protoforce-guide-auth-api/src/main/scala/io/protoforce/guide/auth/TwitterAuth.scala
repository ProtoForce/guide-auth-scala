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
  *  Twitter Authentication
  * 
  * DTO io.protoforce.guide.auth:TwitterAuth
  * 
  * Defined at /providers/twitter.pfm @ 4:1
  */
final case class TwitterAuth(
  /**
    * OAuth token
    */
  accessToken: String
) extends TwitterAuth.Defn

object TwitterAuth {
  /**
    * 
    *  Twitter Authentication
    * 
    * DTO io.protoforce.guide.auth:TwitterAuth
    * 
    * Defined at /providers/twitter.pfm @ 4:1
    */
  trait Defn {
    /**
      * OAuth token
      */
    def accessToken: String
  }
  
  implicit final class Conversions(
    val _value: TwitterAuth
  ) extends _root_.izumi.idealingua.runtime.IRTConversions[TwitterAuth]
  
  /**
    * conversion:structural-sibling-upcast
    */
  implicit object Copy_TwitterAuth_to_FacebookAuth_StructuralUpcast_Reliable_443986941 extends _root_.izumi.idealingua.runtime.IRTCast[TwitterAuth, FacebookAuth] {
    def convert(from: TwitterAuth): FacebookAuth = new FacebookAuth(
      accessToken = from.accessToken
    )
  }
  
  /**
    * conversion:structural-sibling-upcast
    */
  implicit object Copy_TwitterAuth_to_GithubAuth_StructuralUpcast_Reliable_2130185634 extends _root_.izumi.idealingua.runtime.IRTCast[TwitterAuth, GithubAuth] {
    def convert(from: TwitterAuth): GithubAuth = new GithubAuth(
      accessToken = from.accessToken
    )
  }
  
  /**
    * conversion:structural-structure-upcast
    */
  implicit object Copy_TwitterAuth_to_OAuthData_StructuralUpcast_Reliable_1922206714 extends _root_.izumi.idealingua.runtime.IRTCast[TwitterAuth, OAuthData.Impl] {
    def convert(from: TwitterAuth): OAuthData.Impl = new OAuthData.Impl(
      accessToken = from.accessToken
    )
  }
  
  implicit object Expand_TwitterAuth_into_Facebook_StructuralUpcast_Reliable_1742015089 extends _root_.izumi.idealingua.runtime.IRTExtend[TwitterAuth, SignUp.Facebook] {
    final class Expand(
      val _value: TwitterAuth
    ) extends _root_.scala.AnyVal {
      def using(timezone: String): SignUp.Facebook = new SignUp.Facebook(
        timezone = timezone,
        accessToken = _value.accessToken
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: TwitterAuth): Expand = new Expand(
      _value = from
    )
  }
  
  /**
    * conversion:structural-sibling-upcast
    */
  implicit object Copy_TwitterAuth_to_GoogleAuth_StructuralUpcast_Reliable_1117848062 extends _root_.izumi.idealingua.runtime.IRTCast[TwitterAuth, GoogleAuth] {
    def convert(from: TwitterAuth): GoogleAuth = new GoogleAuth(
      accessToken = from.accessToken
    )
  }
  
  implicit object Expand_TwitterAuth_into_Google_StructuralUpcast_Reliable_239596470 extends _root_.izumi.idealingua.runtime.IRTExtend[TwitterAuth, SignUp.Google] {
    final class Expand(
      val _value: TwitterAuth
    ) extends _root_.scala.AnyVal {
      def using(timezone: String): SignUp.Google = new SignUp.Google(
        timezone = timezone,
        accessToken = _value.accessToken
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: TwitterAuth): Expand = new Expand(
      _value = from
    )
  }
  
  implicit object Expand_TwitterAuth_into_Twitter_StructuralDowncast_Reliable_1298001915 extends _root_.izumi.idealingua.runtime.IRTExtend[TwitterAuth, SignUp.Twitter] {
    final class Expand(
      val _value: TwitterAuth
    ) extends _root_.scala.AnyVal {
      def using(timezone: String): SignUp.Twitter = new SignUp.Twitter(
        timezone = timezone,
        accessToken = _value.accessToken
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: TwitterAuth): Expand = new Expand(
      _value = from
    )
  }
  
  implicit object Expand_TwitterAuth_into_Github_StructuralUpcast_Reliable_635038065 extends _root_.izumi.idealingua.runtime.IRTExtend[TwitterAuth, SignUp.Github] {
    final class Expand(
      val _value: TwitterAuth
    ) extends _root_.scala.AnyVal {
      def using(timezone: String): SignUp.Github = new SignUp.Github(
        timezone = timezone,
        accessToken = _value.accessToken
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: TwitterAuth): Expand = new Expand(
      _value = from
    )
  }
  
  implicit val TwitterAuth_random: IRTRandomGen[TwitterAuth] = new IRTRandomGen[TwitterAuth]{
    def id: String = "io.protoforce.guide.auth:TwitterAuth"
    def makeRandom(_random: Random, _path: List[String]): TwitterAuth = new TwitterAuth(
      accessToken = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val TwitterAuth_meta: IRTMetadata[TwitterAuth] = new IRTMetadata[TwitterAuth]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:TwitterAuth"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("a71a76203ad2b2c268f263caf06bc367a9f234cfd77c50cf2af4e4769f38839d"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("def85d3bf32fe5c0e5c59914e91897728603429ce34e7488247c805a04e36239"))
  }
}