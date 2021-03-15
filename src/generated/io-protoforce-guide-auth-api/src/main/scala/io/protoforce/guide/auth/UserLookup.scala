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
  *  User lookup options
  * 
  * ADT io.protoforce.guide.auth:UserLookup
  * 
  * Defined at auth.service.pfm @ 50:1
  */
sealed trait UserLookup {
  
}

object UserLookup {
  /**
    * 
    *  Find using Email
    * 
    * DTO io.protoforce.guide.auth/UserLookup:Email (member of ADT io.protoforce.guide.auth:UserLookup)
    * 
    * Defined at auth.service.pfm @ 58:3
    */
  final case class Email(
    email: String
  ) extends UserLookup.Email.Defn
  
  /**
    * 
    *  Find using UserID
    * 
    * DTO io.protoforce.guide.auth/UserLookup:UserID (reference member of ADT io.protoforce.guide.auth:UserLookup)
    * 
    * Defined at auth.service.pfm @ 54:3
    */
  final case class UserIDRef(
    /**
      * Find using UserID
      */
    value: _root_.io.protoforce.guide.auth.UserID
  ) extends UserLookup.UserIDRef.Defn
  
  /**
    * 
    *  Find using Phone
    * 
    * DTO io.protoforce.guide.auth/UserLookup:Phone (member of ADT io.protoforce.guide.auth:UserLookup)
    * 
    * Defined at auth.service.pfm @ 62:3
    */
  final case class Phone(
    phone: String
  ) extends UserLookup.Phone.Defn
  
  object Email {
    /**
      * 
      *  Find using Email
      * 
      * DTO io.protoforce.guide.auth/UserLookup:Email (member of ADT io.protoforce.guide.auth:UserLookup)
      * 
      * Defined at auth.service.pfm @ 58:3
      */
    sealed trait Defn extends UserLookup {
      def email: String
    }
    
    implicit final class Conversions(
      val _value: UserLookup.Email
    ) extends _root_.izumi.idealingua.runtime.IRTConversions[UserLookup.Email]
    
    implicit val Email_random: IRTRandomGen[UserLookup.Email] = new IRTRandomGen[UserLookup.Email]{
      def id: String = "io.protoforce.guide.auth/UserLookup:Email"
      def makeRandom(_random: Random, _path: List[String]): UserLookup.Email = new UserLookup.Email(
        email = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val Email_meta: IRTMetadata[UserLookup.Email] = new IRTMetadata[UserLookup.Email]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth/UserLookup:Email"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("9cfdc12d68347faf0752b353f6a420db0509d3ff969b364111eb12b6eedbac50"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("bf71ddf00a96aa796d72ebdb060b5adc1a7766e18a5c82f275296bed90a6f2ed"))
    }
  }
  
  object UserIDRef {
    /**
      * 
      *  Find using UserID
      * 
      * DTO io.protoforce.guide.auth/UserLookup:UserID (reference member of ADT io.protoforce.guide.auth:UserLookup)
      * 
      * Defined at auth.service.pfm @ 54:3
      */
    sealed trait Defn extends UserLookup {
      /**
        * Find using UserID
        */
      def value: _root_.io.protoforce.guide.auth.UserID
    }
    
    implicit final class Conversions(
      val _value: UserLookup.UserIDRef
    ) extends _root_.izumi.idealingua.runtime.IRTConversions[UserLookup.UserIDRef]
    
    implicit val UserID_random: IRTRandomGen[UserLookup.UserIDRef] = new IRTRandomGen[UserLookup.UserIDRef]{
      def id: String = "io.protoforce.guide.auth/UserLookup:UserID"
      def makeRandom(_random: Random, _path: List[String]): UserLookup.UserIDRef = new UserLookup.UserIDRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.UserID].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val UserID_meta: IRTMetadata[UserLookup.UserIDRef] = new IRTMetadata[UserLookup.UserIDRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth/UserLookup:UserID"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("da22f952420981869840e6449fdf390d5a2589cce909a47b849c90ccb5025232"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("fad0e1fa7835ecf949a66489183ade416ab171bf9d9191b1143c0219703cc01d"))
    }
  }
  
  object Phone {
    /**
      * 
      *  Find using Phone
      * 
      * DTO io.protoforce.guide.auth/UserLookup:Phone (member of ADT io.protoforce.guide.auth:UserLookup)
      * 
      * Defined at auth.service.pfm @ 62:3
      */
    sealed trait Defn extends UserLookup {
      def phone: String
    }
    
    implicit final class Conversions(
      val _value: UserLookup.Phone
    ) extends _root_.izumi.idealingua.runtime.IRTConversions[UserLookup.Phone]
    
    implicit val Phone_random: IRTRandomGen[UserLookup.Phone] = new IRTRandomGen[UserLookup.Phone]{
      def id: String = "io.protoforce.guide.auth/UserLookup:Phone"
      def makeRandom(_random: Random, _path: List[String]): UserLookup.Phone = new UserLookup.Phone(
        phone = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val Phone_meta: IRTMetadata[UserLookup.Phone] = new IRTMetadata[UserLookup.Phone]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth/UserLookup:Phone"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("ea467b6ad928860d9a2decb32031cd7a8a814b09ec72c90ab5a5c8037c0e1eab"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("c925f35b6914d22b5fff0365bd8e60dfef6bb8df78e06d8f83986f26f80ed03d"))
    }
  }
  
  implicit val UserLookup_random: IRTRandomGen[UserLookup] = new IRTRandomGen[UserLookup]{
    def id: String = "io.protoforce.guide.auth:UserLookup"
    def makeRandom(_random: Random, _path: List[String]): UserLookup = {
      val _all = List(
        IRTRandomGen[UserLookup.UserIDRef].widen[UserLookup],
        IRTRandomGen[UserLookup.Email].widen[UserLookup],
        IRTRandomGen[UserLookup.Phone].widen[UserLookup]
      )
      IRTRandomGen._safeChoose[UserLookup](_all, _path :+ this.id, _random)
    }
  }
  
  implicit val UserLookup_meta: IRTMetadata[UserLookup] = new IRTMetadata[UserLookup]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:UserLookup"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("3e27f1d833f7277af67a194b51eb5373d3cc5808d77a3b51cff10b74260f9ff9"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("017ffb1bb8bbafa5a57c641832dc82fef2be18196b6e5ea0cfa2b97dbd98f92e"))
  }
}