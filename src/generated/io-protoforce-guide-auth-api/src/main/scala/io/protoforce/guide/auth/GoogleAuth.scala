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
  *  Google Authentication
  * 
  * DTO io.protoforce.guide.auth:GoogleAuth
  * 
  * Defined at /providers/google.pfm @ 4:1
  */
final case class GoogleAuth(
  /**
    * OAuth token
    */
  accessToken: String
) extends GoogleAuth.Defn

object GoogleAuth {
  /**
    * 
    *  Google Authentication
    * 
    * DTO io.protoforce.guide.auth:GoogleAuth
    * 
    * Defined at /providers/google.pfm @ 4:1
    */
  trait Defn {
    /**
      * OAuth token
      */
    def accessToken: String
  }
  
  implicit final class Conversions(
    val _value: GoogleAuth
  ) extends _root_.io.protoforce.runtime.IRTConversions[GoogleAuth]
  
  /**
    * conversion:structural-sibling-upcast
    */
  implicit object Copy_GoogleAuth_to_GithubAuth_StructuralUpcast_Reliable_369094218 extends _root_.io.protoforce.runtime.IRTCast[GoogleAuth, GithubAuth] {
    def convert(from: GoogleAuth): GithubAuth = new GithubAuth(
      accessToken = from.accessToken
    )
  }
  
  /**
    * conversion:structural-structure-upcast
    */
  implicit object Copy_GoogleAuth_to_OAuthData_StructuralUpcast_Reliable_577073138 extends _root_.io.protoforce.runtime.IRTCast[GoogleAuth, OAuthData.Impl] {
    def convert(from: GoogleAuth): OAuthData.Impl = new OAuthData.Impl(
      accessToken = from.accessToken
    )
  }
  
  /**
    * conversion:structural-sibling-upcast
    */
  implicit object Copy_GoogleAuth_to_FacebookAuth_StructuralUpcast_Reliable_1351700503 extends _root_.io.protoforce.runtime.IRTCast[GoogleAuth, FacebookAuth] {
    def convert(from: GoogleAuth): FacebookAuth = new FacebookAuth(
      accessToken = from.accessToken
    )
  }
  
  implicit object Expand_GoogleAuth_into_Twitter_StructuralUpcast_Reliable_1201277937 extends _root_.io.protoforce.runtime.IRTExtend[GoogleAuth, SignUp.Twitter] {
    final class Expand(
      val _value: GoogleAuth
    ) extends _root_.scala.AnyVal {
      def using(timezone: String): SignUp.Twitter = new SignUp.Twitter(
        timezone = timezone,
        accessToken = _value.accessToken
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: GoogleAuth): Expand = new Expand(
      _value = from
    )
  }
  
  implicit object Expand_GoogleAuth_into_Google_StructuralDowncast_Reliable_1556090974 extends _root_.io.protoforce.runtime.IRTExtend[GoogleAuth, SignUp.Google] {
    final class Expand(
      val _value: GoogleAuth
    ) extends _root_.scala.AnyVal {
      def using(timezone: String): SignUp.Google = new SignUp.Google(
        timezone = timezone,
        accessToken = _value.accessToken
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: GoogleAuth): Expand = new Expand(
      _value = from
    )
  }
  
  /**
    * conversion:structural-sibling-upcast
    */
  implicit object Copy_GoogleAuth_to_TwitterAuth_StructuralUpcast_Reliable_1117848062 extends _root_.io.protoforce.runtime.IRTCast[GoogleAuth, TwitterAuth] {
    def convert(from: GoogleAuth): TwitterAuth = new TwitterAuth(
      accessToken = from.accessToken
    )
  }
  
  implicit object Expand_GoogleAuth_into_Github_StructuralUpcast_Reliable_1864241787 extends _root_.io.protoforce.runtime.IRTExtend[GoogleAuth, SignUp.Github] {
    final class Expand(
      val _value: GoogleAuth
    ) extends _root_.scala.AnyVal {
      def using(timezone: String): SignUp.Github = new SignUp.Github(
        timezone = timezone,
        accessToken = _value.accessToken
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: GoogleAuth): Expand = new Expand(
      _value = from
    )
  }
  
  implicit object Expand_GoogleAuth_into_Facebook_StructuralUpcast_Reliable_53672355 extends _root_.io.protoforce.runtime.IRTExtend[GoogleAuth, SignUp.Facebook] {
    final class Expand(
      val _value: GoogleAuth
    ) extends _root_.scala.AnyVal {
      def using(timezone: String): SignUp.Facebook = new SignUp.Facebook(
        timezone = timezone,
        accessToken = _value.accessToken
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: GoogleAuth): Expand = new Expand(
      _value = from
    )
  }
  
  implicit val GoogleAuth_random: IRTRandomGen[GoogleAuth] = new IRTRandomGen[GoogleAuth]{
    def id: String = "io.protoforce.guide.auth:GoogleAuth"
    def makeRandom(_random: Random, _path: List[String]): GoogleAuth = new GoogleAuth(
      accessToken = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val GoogleAuth_meta: IRTMetadata[GoogleAuth] = new IRTMetadata[GoogleAuth]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:GoogleAuth"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("697dbe9bf5b153dc5b8d71dd4603f87a7ea85340d2c8024e1cd06aecabb23cda"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("a97aefedbb20a68c145fb562a3e1e009c1b123bd4033666e9ccfe98215787894"))
  }
}