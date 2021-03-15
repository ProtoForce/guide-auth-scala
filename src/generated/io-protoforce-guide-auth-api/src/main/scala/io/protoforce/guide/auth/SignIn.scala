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
  *  Sign In options
  * 
  * ADT io.protoforce.guide.auth:SignIn
  * 
  * Defined at auth.signin.pfm @ 5:1
  */
sealed trait SignIn {
  
}

object SignIn {
  /**
    * 
    *  Sign in with twitter
    * 
    * DTO io.protoforce.guide.auth/SignIn:TwitterAuth (reference member of ADT io.protoforce.guide.auth:SignIn)
    * 
    * Defined at auth.signin.pfm @ 29:3
    */
  final case class TwitterAuthRef(
    /**
      * Sign in with twitter
      */
    value: _root_.io.protoforce.guide.auth.TwitterAuth
  ) extends SignIn.TwitterAuthRef.Defn
  
  /**
    * 
    *  Sign in with facebook
    * 
    * DTO io.protoforce.guide.auth/SignIn:FacebookAuth (reference member of ADT io.protoforce.guide.auth:SignIn)
    * 
    * Defined at auth.signin.pfm @ 25:3
    */
  final case class FacebookAuthRef(
    /**
      * Sign in with facebook
      */
    value: _root_.io.protoforce.guide.auth.FacebookAuth
  ) extends SignIn.FacebookAuthRef.Defn
  
  /**
    * 
    *  Sign in with github
    * 
    * DTO io.protoforce.guide.auth/SignIn:GithubAuth (reference member of ADT io.protoforce.guide.auth:SignIn)
    * 
    * Defined at auth.signin.pfm @ 21:3
    */
  final case class GithubAuthRef(
    /**
      * Sign in with github
      */
    value: _root_.io.protoforce.guide.auth.GithubAuth
  ) extends SignIn.GithubAuthRef.Defn
  
  /**
    * 
    *  Sign in with a phone number
    * 
    * DTO io.protoforce.guide.auth/SignIn:PhonePass (reference member of ADT io.protoforce.guide.auth:SignIn)
    * 
    * Defined at auth.signin.pfm @ 13:3
    */
  final case class PhonePassRef(
    /**
      * Sign in with a phone number
      */
    value: _root_.io.protoforce.guide.auth.PhonePass
  ) extends SignIn.PhonePassRef.Defn
  
  /**
    * 
    *  Sign in following two factor auth request
    * 
    * DTO io.protoforce.guide.auth/SignIn:TwoFactor (member of ADT io.protoforce.guide.auth:SignIn)
    * 
    * Defined at auth.signin.pfm @ 33:3
    */
  final case class TwoFactor(
    /**
      * Token which was provided in the SigninResponse.Confirm2FA model
      */
    token: String,
    /**
      * Code from a secondary authentication method
      */
    code: String
  ) extends SignIn.TwoFactor.Defn
  
  /**
    * 
    *  Sign in with google
    * 
    * DTO io.protoforce.guide.auth/SignIn:GoogleAuth (reference member of ADT io.protoforce.guide.auth:SignIn)
    * 
    * Defined at auth.signin.pfm @ 17:3
    */
  final case class GoogleAuthRef(
    /**
      * Sign in with google
      */
    value: _root_.io.protoforce.guide.auth.GoogleAuth
  ) extends SignIn.GoogleAuthRef.Defn
  
  /**
    * 
    *  Sign in with an email and as password
    * 
    * DTO io.protoforce.guide.auth/SignIn:EmailPass (reference member of ADT io.protoforce.guide.auth:SignIn)
    * 
    * Defined at auth.signin.pfm @ 9:3
    */
  final case class EmailPassRef(
    /**
      * Sign in with an email and as password
      */
    value: _root_.io.protoforce.guide.auth.EmailPass
  ) extends SignIn.EmailPassRef.Defn
  
  object TwitterAuthRef {
    /**
      * 
      *  Sign in with twitter
      * 
      * DTO io.protoforce.guide.auth/SignIn:TwitterAuth (reference member of ADT io.protoforce.guide.auth:SignIn)
      * 
      * Defined at auth.signin.pfm @ 29:3
      */
    sealed trait Defn extends SignIn {
      /**
        * Sign in with twitter
        */
      def value: _root_.io.protoforce.guide.auth.TwitterAuth
    }
    
    implicit final class Conversions(
      val _value: SignIn.TwitterAuthRef
    ) extends _root_.izumi.idealingua.runtime.IRTConversions[SignIn.TwitterAuthRef]
    
    implicit val TwitterAuth_random: IRTRandomGen[SignIn.TwitterAuthRef] = new IRTRandomGen[SignIn.TwitterAuthRef]{
      def id: String = "io.protoforce.guide.auth/SignIn:TwitterAuth"
      def makeRandom(_random: Random, _path: List[String]): SignIn.TwitterAuthRef = new SignIn.TwitterAuthRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.TwitterAuth].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val TwitterAuth_meta: IRTMetadata[SignIn.TwitterAuthRef] = new IRTMetadata[SignIn.TwitterAuthRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth/SignIn:TwitterAuth"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("15bf809dc84ef10833d0d1562f3d1f400ea658d80efcdabb05c0420f7ff4c1f0"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("9b0aba8b681bd50c482d7bfa9ad7726056a72cc0d63cd8f5f8541855075d5a21"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:TwitterAuth
      */
    def apply(accessToken: String): SignIn.TwitterAuthRef = new SignIn.TwitterAuthRef(new _root_.io.protoforce.guide.auth.TwitterAuth(
      accessToken = accessToken
    ))
  }
  
  object FacebookAuthRef {
    /**
      * 
      *  Sign in with facebook
      * 
      * DTO io.protoforce.guide.auth/SignIn:FacebookAuth (reference member of ADT io.protoforce.guide.auth:SignIn)
      * 
      * Defined at auth.signin.pfm @ 25:3
      */
    sealed trait Defn extends SignIn {
      /**
        * Sign in with facebook
        */
      def value: _root_.io.protoforce.guide.auth.FacebookAuth
    }
    
    implicit final class Conversions(
      val _value: SignIn.FacebookAuthRef
    ) extends _root_.izumi.idealingua.runtime.IRTConversions[SignIn.FacebookAuthRef]
    
    implicit val FacebookAuth_random: IRTRandomGen[SignIn.FacebookAuthRef] = new IRTRandomGen[SignIn.FacebookAuthRef]{
      def id: String = "io.protoforce.guide.auth/SignIn:FacebookAuth"
      def makeRandom(_random: Random, _path: List[String]): SignIn.FacebookAuthRef = new SignIn.FacebookAuthRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.FacebookAuth].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val FacebookAuth_meta: IRTMetadata[SignIn.FacebookAuthRef] = new IRTMetadata[SignIn.FacebookAuthRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth/SignIn:FacebookAuth"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("f5f9b94d37b9d8d97957e97dda57ff58a6eb2441ac7bd09b89ff2aaace08ddad"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("54ca95f82734583d2896be89ec685f91c723516f4bb01c7763a93e43283204eb"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:FacebookAuth
      */
    def apply(accessToken: String): SignIn.FacebookAuthRef = new SignIn.FacebookAuthRef(new _root_.io.protoforce.guide.auth.FacebookAuth(
      accessToken = accessToken
    ))
  }
  
  object GithubAuthRef {
    /**
      * 
      *  Sign in with github
      * 
      * DTO io.protoforce.guide.auth/SignIn:GithubAuth (reference member of ADT io.protoforce.guide.auth:SignIn)
      * 
      * Defined at auth.signin.pfm @ 21:3
      */
    sealed trait Defn extends SignIn {
      /**
        * Sign in with github
        */
      def value: _root_.io.protoforce.guide.auth.GithubAuth
    }
    
    implicit final class Conversions(
      val _value: SignIn.GithubAuthRef
    ) extends _root_.izumi.idealingua.runtime.IRTConversions[SignIn.GithubAuthRef]
    
    implicit val GithubAuth_random: IRTRandomGen[SignIn.GithubAuthRef] = new IRTRandomGen[SignIn.GithubAuthRef]{
      def id: String = "io.protoforce.guide.auth/SignIn:GithubAuth"
      def makeRandom(_random: Random, _path: List[String]): SignIn.GithubAuthRef = new SignIn.GithubAuthRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.GithubAuth].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val GithubAuth_meta: IRTMetadata[SignIn.GithubAuthRef] = new IRTMetadata[SignIn.GithubAuthRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth/SignIn:GithubAuth"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("99fb60069daf0aaae3d970443704098d1939ad69863e2d0010763e270c798589"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("569f199af6dbff8033115a23ac6924fe9575cf9399f8e9bf2a20230795d9346e"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:GithubAuth
      */
    def apply(accessToken: String): SignIn.GithubAuthRef = new SignIn.GithubAuthRef(new _root_.io.protoforce.guide.auth.GithubAuth(
      accessToken = accessToken
    ))
  }
  
  object PhonePassRef {
    /**
      * 
      *  Sign in with a phone number
      * 
      * DTO io.protoforce.guide.auth/SignIn:PhonePass (reference member of ADT io.protoforce.guide.auth:SignIn)
      * 
      * Defined at auth.signin.pfm @ 13:3
      */
    sealed trait Defn extends SignIn {
      /**
        * Sign in with a phone number
        */
      def value: _root_.io.protoforce.guide.auth.PhonePass
    }
    
    implicit final class Conversions(
      val _value: SignIn.PhonePassRef
    ) extends _root_.izumi.idealingua.runtime.IRTConversions[SignIn.PhonePassRef]
    
    implicit val PhonePass_random: IRTRandomGen[SignIn.PhonePassRef] = new IRTRandomGen[SignIn.PhonePassRef]{
      def id: String = "io.protoforce.guide.auth/SignIn:PhonePass"
      def makeRandom(_random: Random, _path: List[String]): SignIn.PhonePassRef = new SignIn.PhonePassRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.PhonePass].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val PhonePass_meta: IRTMetadata[SignIn.PhonePassRef] = new IRTMetadata[SignIn.PhonePassRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth/SignIn:PhonePass"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("106196803323b151c538de736e44bb482f83eef668c68ef213ef95db367a5bd4"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("82a4def1fab2193342a34e606af42c5b0bb406aad98d5b61f5831f4afe535aba"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:PhonePass
      */
    def apply(number: String, pass: String): SignIn.PhonePassRef = new SignIn.PhonePassRef(new _root_.io.protoforce.guide.auth.PhonePass(
      number = number,
      pass = pass
    ))
  }
  
  object TwoFactor {
    /**
      * 
      *  Sign in following two factor auth request
      * 
      * DTO io.protoforce.guide.auth/SignIn:TwoFactor (member of ADT io.protoforce.guide.auth:SignIn)
      * 
      * Defined at auth.signin.pfm @ 33:3
      */
    sealed trait Defn extends SignIn {
      /**
        * Token which was provided in the SigninResponse.Confirm2FA model
        */
      def token: String
      /**
        * Code from a secondary authentication method
        */
      def code: String
    }
    
    implicit final class Conversions(
      val _value: SignIn.TwoFactor
    ) extends _root_.izumi.idealingua.runtime.IRTConversions[SignIn.TwoFactor]
    
    implicit val TwoFactor_random: IRTRandomGen[SignIn.TwoFactor] = new IRTRandomGen[SignIn.TwoFactor]{
      def id: String = "io.protoforce.guide.auth/SignIn:TwoFactor"
      def makeRandom(_random: Random, _path: List[String]): SignIn.TwoFactor = new SignIn.TwoFactor(
        token = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
        code = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val TwoFactor_meta: IRTMetadata[SignIn.TwoFactor] = new IRTMetadata[SignIn.TwoFactor]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth/SignIn:TwoFactor"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("400ae04e7367358e38f141f5d51c26d3c651f3e0f489f9816eae3706ae49c9d9"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("9f9194a9c20b68fdb6d6e056a10463b81721d7dd221188d237694a8746835156"))
    }
  }
  
  object GoogleAuthRef {
    /**
      * 
      *  Sign in with google
      * 
      * DTO io.protoforce.guide.auth/SignIn:GoogleAuth (reference member of ADT io.protoforce.guide.auth:SignIn)
      * 
      * Defined at auth.signin.pfm @ 17:3
      */
    sealed trait Defn extends SignIn {
      /**
        * Sign in with google
        */
      def value: _root_.io.protoforce.guide.auth.GoogleAuth
    }
    
    implicit final class Conversions(
      val _value: SignIn.GoogleAuthRef
    ) extends _root_.izumi.idealingua.runtime.IRTConversions[SignIn.GoogleAuthRef]
    
    implicit val GoogleAuth_random: IRTRandomGen[SignIn.GoogleAuthRef] = new IRTRandomGen[SignIn.GoogleAuthRef]{
      def id: String = "io.protoforce.guide.auth/SignIn:GoogleAuth"
      def makeRandom(_random: Random, _path: List[String]): SignIn.GoogleAuthRef = new SignIn.GoogleAuthRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.GoogleAuth].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val GoogleAuth_meta: IRTMetadata[SignIn.GoogleAuthRef] = new IRTMetadata[SignIn.GoogleAuthRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth/SignIn:GoogleAuth"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("6dee9be4f10712ddf82cd16b54f9edc6e43e7c1a8ba1fc993a36e249085b7c47"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("c136e9b2135c05ef79d6b8223282d6df6e57ce720764fc2693aca12ab056c386"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:GoogleAuth
      */
    def apply(accessToken: String): SignIn.GoogleAuthRef = new SignIn.GoogleAuthRef(new _root_.io.protoforce.guide.auth.GoogleAuth(
      accessToken = accessToken
    ))
  }
  
  object EmailPassRef {
    /**
      * 
      *  Sign in with an email and as password
      * 
      * DTO io.protoforce.guide.auth/SignIn:EmailPass (reference member of ADT io.protoforce.guide.auth:SignIn)
      * 
      * Defined at auth.signin.pfm @ 9:3
      */
    sealed trait Defn extends SignIn {
      /**
        * Sign in with an email and as password
        */
      def value: _root_.io.protoforce.guide.auth.EmailPass
    }
    
    implicit final class Conversions(
      val _value: SignIn.EmailPassRef
    ) extends _root_.izumi.idealingua.runtime.IRTConversions[SignIn.EmailPassRef]
    
    implicit val EmailPass_random: IRTRandomGen[SignIn.EmailPassRef] = new IRTRandomGen[SignIn.EmailPassRef]{
      def id: String = "io.protoforce.guide.auth/SignIn:EmailPass"
      def makeRandom(_random: Random, _path: List[String]): SignIn.EmailPassRef = new SignIn.EmailPassRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.EmailPass].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val EmailPass_meta: IRTMetadata[SignIn.EmailPassRef] = new IRTMetadata[SignIn.EmailPassRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth/SignIn:EmailPass"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("c0e27a711f862e567d0d5ee0e6d70d1091a2500f19db91a7ad93abdd7504e517"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("5c02e73a5cb3b2f41c6361757631fc5dbc4cf74daa02b2e90b40d16e06ef0713"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:EmailPass
      */
    def apply(email: String, pass: String): SignIn.EmailPassRef = new SignIn.EmailPassRef(new _root_.io.protoforce.guide.auth.EmailPass(
      email = email,
      pass = pass
    ))
  }
  
  implicit val SignIn_random: IRTRandomGen[SignIn] = new IRTRandomGen[SignIn]{
    def id: String = "io.protoforce.guide.auth:SignIn"
    def makeRandom(_random: Random, _path: List[String]): SignIn = {
      val _all = List(
        IRTRandomGen[SignIn.EmailPassRef].widen[SignIn],
        IRTRandomGen[SignIn.PhonePassRef].widen[SignIn],
        IRTRandomGen[SignIn.GoogleAuthRef].widen[SignIn],
        IRTRandomGen[SignIn.GithubAuthRef].widen[SignIn],
        IRTRandomGen[SignIn.FacebookAuthRef].widen[SignIn],
        IRTRandomGen[SignIn.TwitterAuthRef].widen[SignIn],
        IRTRandomGen[SignIn.TwoFactor].widen[SignIn]
      )
      IRTRandomGen._safeChoose[SignIn](_all, _path :+ this.id, _random)
    }
  }
  
  implicit val SignIn_meta: IRTMetadata[SignIn] = new IRTMetadata[SignIn]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:SignIn"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("789696d67e0dbfa1cbd511468505fd60346ebc9ac8ce1a699d81725d3db32502"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("8ff7e95ced2dfb4ca827476a8094f5ee2f1e4bca0f58d19eedecc32cdb1729c6"))
  }
}