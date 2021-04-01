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
  * Mixin io.protoforce.guide.auth:SignupAttributes
  * 
  * Defined at auth.signup.pfm @ 2:1
  */
trait SignupAttributes {
  def timezone: String
}

object SignupAttributes {
  /**
    * Mixin io.protoforce.guide.auth:SignupAttributes
    * 
    * Defined at auth.signup.pfm @ 2:1
    */
  final case class Impl(
    timezone: String
  ) extends SignupAttributes
  
  implicit final class Conversions(
    val _value: SignupAttributes
  ) extends _root_.io.protoforce.runtime.IRTConversions[SignupAttributes]
  
  /**
    * conversion:interface-clone
    */
  implicit object Copy_SignupAttributes_to_SignupAttributes_StructuralSibling_Reliable_2042764540 extends _root_.io.protoforce.runtime.IRTCast[SignupAttributes, SignupAttributes.Impl] {
    def convert(from: SignupAttributes): SignupAttributes.Impl = new SignupAttributes.Impl(
      timezone = from.timezone
    )
  }
  
  implicit object Expand_SignupAttributes_into_Twitter_StructuralDowncast_Reliable_414096250 extends _root_.io.protoforce.runtime.IRTExtend[SignupAttributes, SignUp.Twitter] {
    final class Expand(
      val _value: SignupAttributes
    ) extends _root_.scala.AnyVal {
      def using(accessToken: String): SignUp.Twitter = new SignUp.Twitter(
        accessToken = accessToken,
        timezone = _value.timezone
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: SignupAttributes): Expand = new Expand(
      _value = from
    )
  }
  
  implicit object Expand_SignupAttributes_into_Phone_StructuralDowncast_Reliable_2068536985 extends _root_.io.protoforce.runtime.IRTExtend[SignupAttributes, SignUp.Phone] {
    final class Expand(
      val _value: SignupAttributes
    ) extends _root_.scala.AnyVal {
      def using(number: String, pass: String): SignUp.Phone = new SignUp.Phone(
        number = number,
        pass = pass,
        timezone = _value.timezone
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: SignupAttributes): Expand = new Expand(
      _value = from
    )
  }
  
  implicit object Expand_SignupAttributes_into_Email_StructuralDowncast_Reliable_877988497 extends _root_.io.protoforce.runtime.IRTExtend[SignupAttributes, SignUp.Email] {
    final class Expand(
      val _value: SignupAttributes
    ) extends _root_.scala.AnyVal {
      def using(email: String, pass: String): SignUp.Email = new SignUp.Email(
        email = email,
        pass = pass,
        timezone = _value.timezone
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: SignupAttributes): Expand = new Expand(
      _value = from
    )
  }
  
  implicit object Expand_SignupAttributes_into_Facebook_StructuralDowncast_Reliable_840854042 extends _root_.io.protoforce.runtime.IRTExtend[SignupAttributes, SignUp.Facebook] {
    final class Expand(
      val _value: SignupAttributes
    ) extends _root_.scala.AnyVal {
      def using(accessToken: String): SignUp.Facebook = new SignUp.Facebook(
        accessToken = accessToken,
        timezone = _value.timezone
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: SignupAttributes): Expand = new Expand(
      _value = from
    )
  }
  
  implicit object Expand_SignupAttributes_into_Github_StructuralDowncast_Reliable_1077060100 extends _root_.io.protoforce.runtime.IRTExtend[SignupAttributes, SignUp.Github] {
    final class Expand(
      val _value: SignupAttributes
    ) extends _root_.scala.AnyVal {
      def using(accessToken: String): SignUp.Github = new SignUp.Github(
        accessToken = accessToken,
        timezone = _value.timezone
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: SignupAttributes): Expand = new Expand(
      _value = from
    )
  }
  
  implicit object Expand_SignupAttributes_into_Google_StructuralDowncast_Reliable_1951694635 extends _root_.io.protoforce.runtime.IRTExtend[SignupAttributes, SignUp.Google] {
    final class Expand(
      val _value: SignupAttributes
    ) extends _root_.scala.AnyVal {
      def using(accessToken: String): SignUp.Google = new SignUp.Google(
        accessToken = accessToken,
        timezone = _value.timezone
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: SignupAttributes): Expand = new Expand(
      _value = from
    )
  }
  
  implicit val SignupAttributes_random: IRTRandomGen[SignupAttributes] = new IRTRandomGen[SignupAttributes]{
    def id: String = "io.protoforce.guide.auth:SignupAttributes"
    def makeRandom(_random: Random, _path: List[String]): SignupAttributes = new SignupAttributes.Impl(
      timezone = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val SignupAttributes_meta: IRTMetadata[SignupAttributes] = new IRTMetadata[SignupAttributes]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:SignupAttributes"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("85f8635c66cfa2d43664971946a4cf44bd60e8d94bff76bc439c84c257d3cc8a"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("c46eefab5b4b63f993db5d242d22d77b5ca61dd03b41c3f3eafe7222db5bccda"))
  }
}