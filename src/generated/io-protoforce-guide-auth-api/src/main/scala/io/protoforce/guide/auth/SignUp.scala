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
  *  Sign Up options
  * 
  * ADT io.protoforce.guide.auth:SignUp
  * 
  * Defined at auth.signup.pfm @ 10:1
  */
sealed trait SignUp {
  def timezone: String
}

object SignUp {
  /**
    * 
    *  Sign up with Twitter
    * 
    * DTO io.protoforce.guide.auth/SignUp:Twitter (member of ADT io.protoforce.guide.auth:SignUp)
    * 
    * Defined at auth.signup.pfm @ 46:3
    */
  final case class Twitter(
    timezone: String,
    /**
      * OAuth token
      */
    accessToken: String
  ) extends SignUp.Twitter.Defn
  
  /**
    * 
    *  Sign up with a phone number
    * 
    * DTO io.protoforce.guide.auth/SignUp:Phone (member of ADT io.protoforce.guide.auth:SignUp)
    * 
    * Defined at auth.signup.pfm @ 22:3
    */
  final case class Phone(
    timezone: String,
    /**
      * Phone number in an international format: +1 XXX XXX XXXX
      */
    number: String,
    /**
      * Password
      */
    pass: String
  ) extends SignUp.Phone.Defn
  
  /**
    * 
    *  Sign up with an email and a password
    * 
    * DTO io.protoforce.guide.auth/SignUp:Email (member of ADT io.protoforce.guide.auth:SignUp)
    * 
    * Defined at auth.signup.pfm @ 16:3
    */
  final case class Email(
    timezone: String,
    /**
      * User email
      */
    email: String,
    pass: String
  ) extends SignUp.Email.Defn
  
  /**
    * 
    *  Sign up with Facebook
    * 
    * DTO io.protoforce.guide.auth/SignUp:Facebook (member of ADT io.protoforce.guide.auth:SignUp)
    * 
    * Defined at auth.signup.pfm @ 40:3
    */
  final case class Facebook(
    timezone: String,
    /**
      * OAuth token
      */
    accessToken: String
  ) extends SignUp.Facebook.Defn
  
  /**
    * 
    *  Sign up with github
    * 
    * DTO io.protoforce.guide.auth/SignUp:Github (member of ADT io.protoforce.guide.auth:SignUp)
    * 
    * Defined at auth.signup.pfm @ 34:3
    */
  final case class Github(
    timezone: String,
    /**
      * OAuth token
      */
    accessToken: String
  ) extends SignUp.Github.Defn
  
  /**
    * 
    *  Sign up with google
    * 
    * DTO io.protoforce.guide.auth/SignUp:Google (member of ADT io.protoforce.guide.auth:SignUp)
    * 
    * Defined at auth.signup.pfm @ 28:3
    */
  final case class Google(
    timezone: String,
    /**
      * OAuth token
      */
    accessToken: String
  ) extends SignUp.Google.Defn
  
  object Twitter {
    /**
      * 
      *  Sign up with Twitter
      * 
      * DTO io.protoforce.guide.auth/SignUp:Twitter (member of ADT io.protoforce.guide.auth:SignUp)
      * 
      * Defined at auth.signup.pfm @ 46:3
      */
    sealed trait Defn extends SignUp {
      def timezone: String
      /**
        * OAuth token
        */
      def accessToken: String
    }
    
    implicit final class Conversions(
      val _value: SignUp.Twitter
    ) extends _root_.io.protoforce.runtime.IRTConversions[SignUp.Twitter]
    
    implicit object Expand_Twitter_into_Phone_StructuralUpcast_Reliable_597762021 extends _root_.io.protoforce.runtime.IRTExtend[SignUp.Twitter, SignUp.Phone] {
      final class Expand(
        val _value: SignUp.Twitter
      ) extends _root_.scala.AnyVal {
        def using(number: String, pass: String): SignUp.Phone = new SignUp.Phone(
          number = number,
          pass = pass,
          timezone = _value.timezone
        )
      }
      
      type INSTANTIATOR = Expand
      
      def next(from: SignUp.Twitter): Expand = new Expand(
        _value = from
      )
    }
    
    /**
      * conversion:structural-sibling-upcast
      */
    implicit object Copy_Twitter_to_Facebook_StructuralUpcast_Reliable_1825444964 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Twitter, SignUp.Facebook] {
      def convert(from: SignUp.Twitter): SignUp.Facebook = new SignUp.Facebook(
        timezone = from.timezone,
        accessToken = from.accessToken
      )
    }
    
    /**
      * conversion:structural-sibling-upcast
      */
    implicit object Copy_Twitter_to_Github_StructuralUpcast_Reliable_551608190 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Twitter, SignUp.Github] {
      def convert(from: SignUp.Twitter): SignUp.Github = new SignUp.Github(
        timezone = from.timezone,
        accessToken = from.accessToken
      )
    }
    
    implicit object Expand_Twitter_into_Email_StructuralUpcast_Reliable_750679793 extends _root_.io.protoforce.runtime.IRTExtend[SignUp.Twitter, SignUp.Email] {
      final class Expand(
        val _value: SignUp.Twitter
      ) extends _root_.scala.AnyVal {
        def using(email: String, pass: String): SignUp.Email = new SignUp.Email(
          email = email,
          pass = pass,
          timezone = _value.timezone
        )
      }
      
      type INSTANTIATOR = Expand
      
      def next(from: SignUp.Twitter): Expand = new Expand(
        _value = from
      )
    }
    
    /**
      * conversion:structural-sibling-upcast
      */
    implicit object Copy_Twitter_to_Google_StructuralUpcast_Reliable_323026345 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Twitter, SignUp.Google] {
      def convert(from: SignUp.Twitter): SignUp.Google = new SignUp.Google(
        timezone = from.timezone,
        accessToken = from.accessToken
      )
    }
    
    /**
      * conversion:structural-structure-upcast
      */
    implicit object Copy_Twitter_to_OAuthData_StructuralUpcast_Reliable_1838776839 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Twitter, OAuthData.Impl] {
      def convert(from: SignUp.Twitter): OAuthData.Impl = new OAuthData.Impl(
        accessToken = from.accessToken
      )
    }
    
    /**
      * conversion:structural-sibling-upcast
      */
    implicit object Copy_Twitter_to_GithubAuth_StructuralUpcast_Reliable_2046755759 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Twitter, GithubAuth] {
      def convert(from: SignUp.Twitter): GithubAuth = new GithubAuth(
        accessToken = from.accessToken
      )
    }
    
    /**
      * conversion:structural-sibling-upcast
      */
    implicit object Copy_Twitter_to_GoogleAuth_StructuralUpcast_Reliable_1201277937 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Twitter, GoogleAuth] {
      def convert(from: SignUp.Twitter): GoogleAuth = new GoogleAuth(
        accessToken = from.accessToken
      )
    }
    
    /**
      * conversion:structural-structure-upcast
      */
    implicit object Copy_Twitter_to_TwitterAuth_StructuralUpcast_Reliable_1298001915 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Twitter, TwitterAuth] {
      def convert(from: SignUp.Twitter): TwitterAuth = new TwitterAuth(
        accessToken = from.accessToken
      )
    }
    
    /**
      * conversion:structural-sibling-upcast
      */
    implicit object Copy_Twitter_to_FacebookAuth_StructuralUpcast_Reliable_527416816 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Twitter, FacebookAuth] {
      def convert(from: SignUp.Twitter): FacebookAuth = new FacebookAuth(
        accessToken = from.accessToken
      )
    }
    
    /**
      * conversion:structural-structure-upcast
      */
    implicit object Copy_Twitter_to_SignupAttributes_StructuralUpcast_Reliable_414096250 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Twitter, SignupAttributes.Impl] {
      def convert(from: SignUp.Twitter): SignupAttributes.Impl = new SignupAttributes.Impl(
        timezone = from.timezone
      )
    }
    
    implicit val Twitter_random: IRTRandomGen[SignUp.Twitter] = new IRTRandomGen[SignUp.Twitter]{
      def id: String = "io.protoforce.guide.auth/SignUp:Twitter"
      def makeRandom(_random: Random, _path: List[String]): SignUp.Twitter = new SignUp.Twitter(
        timezone = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
        accessToken = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val Twitter_meta: IRTMetadata[SignUp.Twitter] = new IRTMetadata[SignUp.Twitter]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth/SignUp:Twitter"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("0e8e8f10bff5b553fefe1854531f073271ba215fc049660476c2b515758c1132"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("0cf5b7d516d04427f7faee517333ef050841c0741215889cf9dd953f2945db6c"))
    }
  }
  
  object Phone {
    /**
      * 
      *  Sign up with a phone number
      * 
      * DTO io.protoforce.guide.auth/SignUp:Phone (member of ADT io.protoforce.guide.auth:SignUp)
      * 
      * Defined at auth.signup.pfm @ 22:3
      */
    sealed trait Defn extends SignUp {
      def timezone: String
      /**
        * Phone number in an international format: +1 XXX XXX XXXX
        */
      def number: String
      /**
        * Password
        */
      def pass: String
    }
    
    implicit final class Conversions(
      val _value: SignUp.Phone
    ) extends _root_.io.protoforce.runtime.IRTConversions[SignUp.Phone]
    
    implicit object Expand_Phone_into_Twitter_StructuralUpcast_Reliable_597762021 extends _root_.io.protoforce.runtime.IRTExtend[SignUp.Phone, SignUp.Twitter] {
      final class Expand(
        val _value: SignUp.Phone
      ) extends _root_.scala.AnyVal {
        def using(accessToken: String): SignUp.Twitter = new SignUp.Twitter(
          accessToken = accessToken,
          timezone = _value.timezone
        )
      }
      
      type INSTANTIATOR = Expand
      
      def next(from: SignUp.Phone): Expand = new Expand(
        _value = from
      )
    }
    
    implicit object Expand_Phone_into_Email_StructuralUpcast_Reliable_1061654268 extends _root_.io.protoforce.runtime.IRTExtend[SignUp.Phone, SignUp.Email] {
      final class Expand(
        val _value: SignUp.Phone
      ) extends _root_.scala.AnyVal {
        def using(email: String): SignUp.Email = new SignUp.Email(
          email = email,
          timezone = _value.timezone,
          pass = _value.pass
        )
      }
      
      type INSTANTIATOR = Expand
      
      def next(from: SignUp.Phone): Expand = new Expand(
        _value = from
      )
    }
    
    implicit object Expand_Phone_into_Google_StructuralUpcast_Reliable_2135360406 extends _root_.io.protoforce.runtime.IRTExtend[SignUp.Phone, SignUp.Google] {
      final class Expand(
        val _value: SignUp.Phone
      ) extends _root_.scala.AnyVal {
        def using(accessToken: String): SignUp.Google = new SignUp.Google(
          accessToken = accessToken,
          timezone = _value.timezone
        )
      }
      
      type INSTANTIATOR = Expand
      
      def next(from: SignUp.Phone): Expand = new Expand(
        _value = from
      )
    }
    
    implicit object Expand_Phone_into_Facebook_StructuralUpcast_Reliable_657188271 extends _root_.io.protoforce.runtime.IRTExtend[SignUp.Phone, SignUp.Facebook] {
      final class Expand(
        val _value: SignUp.Phone
      ) extends _root_.scala.AnyVal {
        def using(accessToken: String): SignUp.Facebook = new SignUp.Facebook(
          accessToken = accessToken,
          timezone = _value.timezone
        )
      }
      
      type INSTANTIATOR = Expand
      
      def next(from: SignUp.Phone): Expand = new Expand(
        _value = from
      )
    }
    
    /**
      * conversion:structural-structure-upcast
      */
    implicit object Copy_Phone_to_SignupAttributes_StructuralUpcast_Reliable_2068536985 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Phone, SignupAttributes.Impl] {
      def convert(from: SignUp.Phone): SignupAttributes.Impl = new SignupAttributes.Impl(
        timezone = from.timezone
      )
    }
    
    /**
      * conversion:structural-structure-upcast
      */
    implicit object Copy_Phone_to_PhonePass_StructuralUpcast_Reliable_1968942498 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Phone, PhonePass] {
      def convert(from: SignUp.Phone): PhonePass = new PhonePass(
        number = from.number,
        pass = from.pass
      )
    }
    
    implicit object Expand_Phone_into_Github_StructuralUpcast_Reliable_1260725871 extends _root_.io.protoforce.runtime.IRTExtend[SignUp.Phone, SignUp.Github] {
      final class Expand(
        val _value: SignUp.Phone
      ) extends _root_.scala.AnyVal {
        def using(accessToken: String): SignUp.Github = new SignUp.Github(
          accessToken = accessToken,
          timezone = _value.timezone
        )
      }
      
      type INSTANTIATOR = Expand
      
      def next(from: SignUp.Phone): Expand = new Expand(
        _value = from
      )
    }
    
    implicit val Phone_random: IRTRandomGen[SignUp.Phone] = new IRTRandomGen[SignUp.Phone]{
      def id: String = "io.protoforce.guide.auth/SignUp:Phone"
      def makeRandom(_random: Random, _path: List[String]): SignUp.Phone = new SignUp.Phone(
        timezone = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
        number = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
        pass = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val Phone_meta: IRTMetadata[SignUp.Phone] = new IRTMetadata[SignUp.Phone]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth/SignUp:Phone"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("b7623973af5b902cd0a934067e5cff268d5ae00d73a9048f1357822aa19b74a7"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("1b9881161bba42cf3164b235672b932a221021e632e8a0bd70e950a5907ea23f"))
    }
  }
  
  object Email {
    /**
      * 
      *  Sign up with an email and a password
      * 
      * DTO io.protoforce.guide.auth/SignUp:Email (member of ADT io.protoforce.guide.auth:SignUp)
      * 
      * Defined at auth.signup.pfm @ 16:3
      */
    sealed trait Defn extends SignUp {
      def timezone: String
      /**
        * User email
        */
      def email: String
      def pass: String
    }
    
    implicit final class Conversions(
      val _value: SignUp.Email
    ) extends _root_.io.protoforce.runtime.IRTConversions[SignUp.Email]
    
    implicit object Expand_Email_into_Twitter_StructuralUpcast_Reliable_750679793 extends _root_.io.protoforce.runtime.IRTExtend[SignUp.Email, SignUp.Twitter] {
      final class Expand(
        val _value: SignUp.Email
      ) extends _root_.scala.AnyVal {
        def using(accessToken: String): SignUp.Twitter = new SignUp.Twitter(
          accessToken = accessToken,
          timezone = _value.timezone
        )
      }
      
      type INSTANTIATOR = Expand
      
      def next(from: SignUp.Email): Expand = new Expand(
        _value = from
      )
    }
    
    implicit object Expand_Email_into_Phone_StructuralUpcast_Reliable_1061654268 extends _root_.io.protoforce.runtime.IRTExtend[SignUp.Email, SignUp.Phone] {
      final class Expand(
        val _value: SignUp.Email
      ) extends _root_.scala.AnyVal {
        def using(number: String): SignUp.Phone = new SignUp.Phone(
          number = number,
          timezone = _value.timezone,
          pass = _value.pass
        )
      }
      
      type INSTANTIATOR = Expand
      
      def next(from: SignUp.Email): Expand = new Expand(
        _value = from
      )
    }
    
    /**
      * conversion:structural-structure-upcast
      */
    implicit object Copy_Email_to_EmailPass_StructuralUpcast_Reliable_1880248267 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Email, EmailPass] {
      def convert(from: SignUp.Email): EmailPass = new EmailPass(
        email = from.email,
        pass = from.pass
      )
    }
    
    implicit object Expand_Email_into_Google_StructuralUpcast_Reliable_786918592 extends _root_.io.protoforce.runtime.IRTExtend[SignUp.Email, SignUp.Google] {
      final class Expand(
        val _value: SignUp.Email
      ) extends _root_.scala.AnyVal {
        def using(accessToken: String): SignUp.Google = new SignUp.Google(
          accessToken = accessToken,
          timezone = _value.timezone
        )
      }
      
      type INSTANTIATOR = Expand
      
      def next(from: SignUp.Email): Expand = new Expand(
        _value = from
      )
    }
    
    implicit object Expand_Email_into_Github_StructuralUpcast_Reliable_87715943 extends _root_.io.protoforce.runtime.IRTExtend[SignUp.Email, SignUp.Github] {
      final class Expand(
        val _value: SignUp.Email
      ) extends _root_.scala.AnyVal {
        def using(accessToken: String): SignUp.Github = new SignUp.Github(
          accessToken = accessToken,
          timezone = _value.timezone
        )
      }
      
      type INSTANTIATOR = Expand
      
      def next(from: SignUp.Email): Expand = new Expand(
        _value = from
      )
    }
    
    implicit object Expand_Email_into_Facebook_StructuralUpcast_Reliable_2005630085 extends _root_.io.protoforce.runtime.IRTExtend[SignUp.Email, SignUp.Facebook] {
      final class Expand(
        val _value: SignUp.Email
      ) extends _root_.scala.AnyVal {
        def using(accessToken: String): SignUp.Facebook = new SignUp.Facebook(
          accessToken = accessToken,
          timezone = _value.timezone
        )
      }
      
      type INSTANTIATOR = Expand
      
      def next(from: SignUp.Email): Expand = new Expand(
        _value = from
      )
    }
    
    /**
      * conversion:structural-structure-upcast
      */
    implicit object Copy_Email_to_SignupAttributes_StructuralUpcast_Reliable_877988497 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Email, SignupAttributes.Impl] {
      def convert(from: SignUp.Email): SignupAttributes.Impl = new SignupAttributes.Impl(
        timezone = from.timezone
      )
    }
    
    implicit val Email_random: IRTRandomGen[SignUp.Email] = new IRTRandomGen[SignUp.Email]{
      def id: String = "io.protoforce.guide.auth/SignUp:Email"
      def makeRandom(_random: Random, _path: List[String]): SignUp.Email = new SignUp.Email(
        timezone = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
        email = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
        pass = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val Email_meta: IRTMetadata[SignUp.Email] = new IRTMetadata[SignUp.Email]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth/SignUp:Email"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("d418d8b43d841cfd8cb13bbaa3e295c88e3e29a74eb864408616afaebbd87d7b"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("9f5172692b4db2eef965d434f5ed5ab38c1e7b429e72982bcc00a8d3c0dbe280"))
    }
  }
  
  object Facebook {
    /**
      * 
      *  Sign up with Facebook
      * 
      * DTO io.protoforce.guide.auth/SignUp:Facebook (member of ADT io.protoforce.guide.auth:SignUp)
      * 
      * Defined at auth.signup.pfm @ 40:3
      */
    sealed trait Defn extends SignUp {
      def timezone: String
      /**
        * OAuth token
        */
      def accessToken: String
    }
    
    implicit final class Conversions(
      val _value: SignUp.Facebook
    ) extends _root_.io.protoforce.runtime.IRTConversions[SignUp.Facebook]
    
    /**
      * conversion:structural-sibling-upcast
      */
    implicit object Copy_Facebook_to_GithubAuth_StructuralUpcast_Reliable_993261245 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Facebook, GithubAuth] {
      def convert(from: SignUp.Facebook): GithubAuth = new GithubAuth(
        accessToken = from.accessToken
      )
    }
    
    /**
      * conversion:structural-sibling-upcast
      */
    implicit object Copy_Facebook_to_Twitter_StructuralUpcast_Reliable_1825444964 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Facebook, SignUp.Twitter] {
      def convert(from: SignUp.Facebook): SignUp.Twitter = new SignUp.Twitter(
        timezone = from.timezone,
        accessToken = from.accessToken
      )
    }
    
    /**
      * conversion:structural-sibling-upcast
      */
    implicit object Copy_Facebook_to_TwitterAuth_StructuralUpcast_Reliable_1742015089 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Facebook, TwitterAuth] {
      def convert(from: SignUp.Facebook): TwitterAuth = new TwitterAuth(
        accessToken = from.accessToken
      )
    }
    
    /**
      * conversion:structural-sibling-upcast
      */
    implicit object Copy_Facebook_to_Google_StructuralUpcast_Reliable_931923947 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Facebook, SignUp.Google] {
      def convert(from: SignUp.Facebook): SignUp.Google = new SignUp.Google(
        timezone = from.timezone,
        accessToken = from.accessToken
      )
    }
    
    /**
      * conversion:structural-sibling-upcast
      */
    implicit object Copy_Facebook_to_Github_StructuralUpcast_Reliable_1806558482 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Facebook, SignUp.Github] {
      def convert(from: SignUp.Facebook): SignUp.Github = new SignUp.Github(
        timezone = from.timezone,
        accessToken = from.accessToken
      )
    }
    
    /**
      * conversion:structural-structure-upcast
      */
    implicit object Copy_Facebook_to_SignupAttributes_StructuralUpcast_Reliable_840854042 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Facebook, SignupAttributes.Impl] {
      def convert(from: SignUp.Facebook): SignupAttributes.Impl = new SignupAttributes.Impl(
        timezone = from.timezone
      )
    }
    
    /**
      * conversion:structural-sibling-upcast
      */
    implicit object Copy_Facebook_to_GoogleAuth_StructuralUpcast_Reliable_53672355 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Facebook, GoogleAuth] {
      def convert(from: SignUp.Facebook): GoogleAuth = new GoogleAuth(
        accessToken = from.accessToken
      )
    }
    
    /**
      * conversion:structural-sibling-upcast
      */
    implicit object Copy_Facebook_to_FacebookAuth_StructuralUpcast_Reliable_727533476 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Facebook, FacebookAuth] {
      def convert(from: SignUp.Facebook): FacebookAuth = new FacebookAuth(
        accessToken = from.accessToken
      )
    }
    
    implicit object Expand_Facebook_into_Phone_StructuralUpcast_Reliable_657188271 extends _root_.io.protoforce.runtime.IRTExtend[SignUp.Facebook, SignUp.Phone] {
      final class Expand(
        val _value: SignUp.Facebook
      ) extends _root_.scala.AnyVal {
        def using(number: String, pass: String): SignUp.Phone = new SignUp.Phone(
          number = number,
          pass = pass,
          timezone = _value.timezone
        )
      }
      
      type INSTANTIATOR = Expand
      
      def next(from: SignUp.Facebook): Expand = new Expand(
        _value = from
      )
    }
    
    implicit object Expand_Facebook_into_Email_StructuralUpcast_Reliable_2005630085 extends _root_.io.protoforce.runtime.IRTExtend[SignUp.Facebook, SignUp.Email] {
      final class Expand(
        val _value: SignUp.Facebook
      ) extends _root_.scala.AnyVal {
        def using(email: String, pass: String): SignUp.Email = new SignUp.Email(
          email = email,
          pass = pass,
          timezone = _value.timezone
        )
      }
      
      type INSTANTIATOR = Expand
      
      def next(from: SignUp.Facebook): Expand = new Expand(
        _value = from
      )
    }
    
    /**
      * conversion:structural-structure-upcast
      */
    implicit object Copy_Facebook_to_OAuthData_StructuralUpcast_Reliable_1201240165 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Facebook, OAuthData.Impl] {
      def convert(from: SignUp.Facebook): OAuthData.Impl = new OAuthData.Impl(
        accessToken = from.accessToken
      )
    }
    
    implicit val Facebook_random: IRTRandomGen[SignUp.Facebook] = new IRTRandomGen[SignUp.Facebook]{
      def id: String = "io.protoforce.guide.auth/SignUp:Facebook"
      def makeRandom(_random: Random, _path: List[String]): SignUp.Facebook = new SignUp.Facebook(
        timezone = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
        accessToken = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val Facebook_meta: IRTMetadata[SignUp.Facebook] = new IRTMetadata[SignUp.Facebook]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth/SignUp:Facebook"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("4b0e876a5a62cbbf812a9c6435290bcb3dad6cdf62539055fdc322cf18be75ce"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("092e7e1102f936d247623fec2a3c20240c22fab96c41c32f68110c18c93af6e2"))
    }
  }
  
  object Github {
    /**
      * 
      *  Sign up with github
      * 
      * DTO io.protoforce.guide.auth/SignUp:Github (member of ADT io.protoforce.guide.auth:SignUp)
      * 
      * Defined at auth.signup.pfm @ 34:3
      */
    sealed trait Defn extends SignUp {
      def timezone: String
      /**
        * OAuth token
        */
      def accessToken: String
    }
    
    implicit final class Conversions(
      val _value: SignUp.Github
    ) extends _root_.io.protoforce.runtime.IRTConversions[SignUp.Github]
    
    /**
      * conversion:structural-structure-upcast
      */
    implicit object Copy_Github_to_OAuthData_StructuralUpcast_Reliable_1175812989 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Github, OAuthData.Impl] {
      def convert(from: SignUp.Github): OAuthData.Impl = new OAuthData.Impl(
        accessToken = from.accessToken
      )
    }
    
    /**
      * conversion:structural-sibling-upcast
      */
    implicit object Copy_Github_to_TwitterAuth_StructuralUpcast_Reliable_635038065 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Github, TwitterAuth] {
      def convert(from: SignUp.Github): TwitterAuth = new TwitterAuth(
        accessToken = from.accessToken
      )
    }
    
    /**
      * conversion:structural-sibling-upcast
      */
    implicit object Copy_Github_to_Facebook_StructuralUpcast_Reliable_1806558482 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Github, SignUp.Facebook] {
      def convert(from: SignUp.Github): SignUp.Facebook = new SignUp.Facebook(
        timezone = from.timezone,
        accessToken = from.accessToken
      )
    }
    
    implicit object Expand_Github_into_Phone_StructuralUpcast_Reliable_1260725871 extends _root_.io.protoforce.runtime.IRTExtend[SignUp.Github, SignUp.Phone] {
      final class Expand(
        val _value: SignUp.Github
      ) extends _root_.scala.AnyVal {
        def using(number: String, pass: String): SignUp.Phone = new SignUp.Phone(
          number = number,
          pass = pass,
          timezone = _value.timezone
        )
      }
      
      type INSTANTIATOR = Expand
      
      def next(from: SignUp.Github): Expand = new Expand(
        _value = from
      )
    }
    
    /**
      * conversion:structural-structure-upcast
      */
    implicit object Copy_Github_to_SignupAttributes_StructuralUpcast_Reliable_1077060100 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Github, SignupAttributes.Impl] {
      def convert(from: SignUp.Github): SignupAttributes.Impl = new SignupAttributes.Impl(
        timezone = from.timezone
      )
    }
    
    /**
      * conversion:structural-sibling-upcast
      */
    implicit object Copy_Github_to_GoogleAuth_StructuralUpcast_Reliable_1864241787 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Github, GoogleAuth] {
      def convert(from: SignUp.Github): GoogleAuth = new GoogleAuth(
        accessToken = from.accessToken
      )
    }
    
    /**
      * conversion:structural-sibling-upcast
      */
    implicit object Copy_Github_to_Google_StructuralUpcast_Reliable_985990195 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Github, SignUp.Google] {
      def convert(from: SignUp.Github): SignUp.Google = new SignUp.Google(
        timezone = from.timezone,
        accessToken = from.accessToken
      )
    }
    
    implicit object Expand_Github_into_Email_StructuralUpcast_Reliable_87715943 extends _root_.io.protoforce.runtime.IRTExtend[SignUp.Github, SignUp.Email] {
      final class Expand(
        val _value: SignUp.Github
      ) extends _root_.scala.AnyVal {
        def using(email: String, pass: String): SignUp.Email = new SignUp.Email(
          email = email,
          pass = pass,
          timezone = _value.timezone
        )
      }
      
      type INSTANTIATOR = Expand
      
      def next(from: SignUp.Github): Expand = new Expand(
        _value = from
      )
    }
    
    /**
      * conversion:structural-sibling-upcast
      */
    implicit object Copy_Github_to_FacebookAuth_StructuralUpcast_Reliable_1190380666 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Github, FacebookAuth] {
      def convert(from: SignUp.Github): FacebookAuth = new FacebookAuth(
        accessToken = from.accessToken
      )
    }
    
    /**
      * conversion:structural-sibling-upcast
      */
    implicit object Copy_Github_to_Twitter_StructuralUpcast_Reliable_551608190 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Github, SignUp.Twitter] {
      def convert(from: SignUp.Github): SignUp.Twitter = new SignUp.Twitter(
        timezone = from.timezone,
        accessToken = from.accessToken
      )
    }
    
    /**
      * conversion:structural-structure-upcast
      */
    implicit object Copy_Github_to_GithubAuth_StructuralUpcast_Reliable_1383791909 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Github, GithubAuth] {
      def convert(from: SignUp.Github): GithubAuth = new GithubAuth(
        accessToken = from.accessToken
      )
    }
    
    implicit val Github_random: IRTRandomGen[SignUp.Github] = new IRTRandomGen[SignUp.Github]{
      def id: String = "io.protoforce.guide.auth/SignUp:Github"
      def makeRandom(_random: Random, _path: List[String]): SignUp.Github = new SignUp.Github(
        timezone = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
        accessToken = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val Github_meta: IRTMetadata[SignUp.Github] = new IRTMetadata[SignUp.Github]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth/SignUp:Github"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("97d0b49a7795e0bf5a5dc11a994c38d23731945978b5fad8f5451930f5c8228b"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("b1766268e02c84ff5d1aa338f338b551e81fa048232e1775ddf8a0a71b758ef3"))
    }
  }
  
  object Google {
    /**
      * 
      *  Sign up with google
      * 
      * DTO io.protoforce.guide.auth/SignUp:Google (member of ADT io.protoforce.guide.auth:SignUp)
      * 
      * Defined at auth.signup.pfm @ 28:3
      */
    sealed trait Defn extends SignUp {
      def timezone: String
      /**
        * OAuth token
        */
      def accessToken: String
    }
    
    implicit final class Conversions(
      val _value: SignUp.Google
    ) extends _root_.io.protoforce.runtime.IRTConversions[SignUp.Google]
    
    /**
      * conversion:structural-structure-upcast
      */
    implicit object Copy_Google_to_SignupAttributes_StructuralUpcast_Reliable_1951694635 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Google, SignupAttributes.Impl] {
      def convert(from: SignUp.Google): SignupAttributes.Impl = new SignupAttributes.Impl(
        timezone = from.timezone
      )
    }
    
    /**
      * conversion:structural-sibling-upcast
      */
    implicit object Copy_Google_to_GithubAuth_StructuralUpcast_Reliable_509157374 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Google, GithubAuth] {
      def convert(from: SignUp.Google): GithubAuth = new GithubAuth(
        accessToken = from.accessToken
      )
    }
    
    /**
      * conversion:structural-sibling-upcast
      */
    implicit object Copy_Google_to_Facebook_StructuralUpcast_Reliable_931923947 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Google, SignUp.Facebook] {
      def convert(from: SignUp.Google): SignUp.Facebook = new SignUp.Facebook(
        timezone = from.timezone,
        accessToken = from.accessToken
      )
    }
    
    /**
      * conversion:structural-sibling-upcast
      */
    implicit object Copy_Google_to_FacebookAuth_StructuralUpcast_Reliable_2065015201 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Google, FacebookAuth] {
      def convert(from: SignUp.Google): FacebookAuth = new FacebookAuth(
        accessToken = from.accessToken
      )
    }
    
    implicit object Expand_Google_into_Phone_StructuralUpcast_Reliable_2135360406 extends _root_.io.protoforce.runtime.IRTExtend[SignUp.Google, SignUp.Phone] {
      final class Expand(
        val _value: SignUp.Google
      ) extends _root_.scala.AnyVal {
        def using(number: String, pass: String): SignUp.Phone = new SignUp.Phone(
          number = number,
          pass = pass,
          timezone = _value.timezone
        )
      }
      
      type INSTANTIATOR = Expand
      
      def next(from: SignUp.Google): Expand = new Expand(
        _value = from
      )
    }
    
    /**
      * conversion:structural-sibling-upcast
      */
    implicit object Copy_Google_to_Github_StructuralUpcast_Reliable_985990195 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Google, SignUp.Github] {
      def convert(from: SignUp.Google): SignUp.Github = new SignUp.Github(
        timezone = from.timezone,
        accessToken = from.accessToken
      )
    }
    
    /**
      * conversion:structural-sibling-upcast
      */
    implicit object Copy_Google_to_TwitterAuth_StructuralUpcast_Reliable_239596470 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Google, TwitterAuth] {
      def convert(from: SignUp.Google): TwitterAuth = new TwitterAuth(
        accessToken = from.accessToken
      )
    }
    
    /**
      * conversion:structural-structure-upcast
      */
    implicit object Copy_Google_to_GoogleAuth_StructuralUpcast_Reliable_1556090974 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Google, GoogleAuth] {
      def convert(from: SignUp.Google): GoogleAuth = new GoogleAuth(
        accessToken = from.accessToken
      )
    }
    
    implicit object Expand_Google_into_Email_StructuralUpcast_Reliable_786918592 extends _root_.io.protoforce.runtime.IRTExtend[SignUp.Google, SignUp.Email] {
      final class Expand(
        val _value: SignUp.Google
      ) extends _root_.scala.AnyVal {
        def using(email: String, pass: String): SignUp.Email = new SignUp.Email(
          email = email,
          pass = pass,
          timezone = _value.timezone
        )
      }
      
      type INSTANTIATOR = Expand
      
      def next(from: SignUp.Google): Expand = new Expand(
        _value = from
      )
    }
    
    /**
      * conversion:structural-structure-upcast
      */
    implicit object Copy_Google_to_OAuthData_StructuralUpcast_Reliable_301178454 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Google, OAuthData.Impl] {
      def convert(from: SignUp.Google): OAuthData.Impl = new OAuthData.Impl(
        accessToken = from.accessToken
      )
    }
    
    /**
      * conversion:structural-sibling-upcast
      */
    implicit object Copy_Google_to_Twitter_StructuralUpcast_Reliable_323026345 extends _root_.io.protoforce.runtime.IRTCast[SignUp.Google, SignUp.Twitter] {
      def convert(from: SignUp.Google): SignUp.Twitter = new SignUp.Twitter(
        timezone = from.timezone,
        accessToken = from.accessToken
      )
    }
    
    implicit val Google_random: IRTRandomGen[SignUp.Google] = new IRTRandomGen[SignUp.Google]{
      def id: String = "io.protoforce.guide.auth/SignUp:Google"
      def makeRandom(_random: Random, _path: List[String]): SignUp.Google = new SignUp.Google(
        timezone = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
        accessToken = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val Google_meta: IRTMetadata[SignUp.Google] = new IRTMetadata[SignUp.Google]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth/SignUp:Google"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("962c319d2f678f22b83e84463f990b72721a6cb353dad628d901e320a8744999"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("229fc83f681444fcd06f111a6df8b3e1693191d5223b5c88153cfda53bbdceda"))
    }
  }
  
  implicit val SignUp_random: IRTRandomGen[SignUp] = new IRTRandomGen[SignUp]{
    def id: String = "io.protoforce.guide.auth:SignUp"
    def makeRandom(_random: Random, _path: List[String]): SignUp = {
      val _all = List(
        IRTRandomGen[SignUp.Email].widen[SignUp],
        IRTRandomGen[SignUp.Phone].widen[SignUp],
        IRTRandomGen[SignUp.Google].widen[SignUp],
        IRTRandomGen[SignUp.Github].widen[SignUp],
        IRTRandomGen[SignUp.Facebook].widen[SignUp],
        IRTRandomGen[SignUp.Twitter].widen[SignUp]
      )
      IRTRandomGen._safeChoose[SignUp](_all, _path :+ this.id, _random)
    }
  }
  
  implicit val SignUp_meta: IRTMetadata[SignUp] = new IRTMetadata[SignUp]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:SignUp"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("e9f41cc872e4a947186bd7f8dd4fa68f0c1932909114449830a4dd62ae3bafc6"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("e1a37dad31e3af75abd42de3bc58ddcc71b2bbd1ca3ceb3ec30c64bea3f4d586"))
  }
}