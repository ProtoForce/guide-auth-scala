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
  *  Secondary identities
  * 
  * ADT io.protoforce.guide.auth:SecondaryIdentity
  * 
  * Defined at identity.pfm @ 4:1
  */
sealed trait SecondaryIdentity {
  
}

object SecondaryIdentity {
  /**
    * 
    *  Phone secondary identity
    * 
    * DTO io.protoforce.guide.auth/SecondaryIdentity:Phone (member of ADT io.protoforce.guide.auth:SecondaryIdentity)
    * 
    * Defined at identity.pfm @ 8:3
    */
  final case class Phone(
    /**
      * Phone number in international format
      */
    phone: String
  ) extends SecondaryIdentity.Phone.Defn
  
  /**
    * 
    *  Email secondary identity
    * 
    * DTO io.protoforce.guide.auth/SecondaryIdentity:Email (member of ADT io.protoforce.guide.auth:SecondaryIdentity)
    * 
    * Defined at identity.pfm @ 17:3
    */
  final case class Email(
    /**
      * Email
      */
    email: String
  ) extends SecondaryIdentity.Email.Defn
  
  object Phone {
    /**
      * 
      *  Phone secondary identity
      * 
      * DTO io.protoforce.guide.auth/SecondaryIdentity:Phone (member of ADT io.protoforce.guide.auth:SecondaryIdentity)
      * 
      * Defined at identity.pfm @ 8:3
      */
    sealed trait Defn extends SecondaryIdentity {
      /**
        * Phone number in international format
        */
      def phone: String
    }
    
    implicit final class Conversions(
      val _value: SecondaryIdentity.Phone
    ) extends _root_.izumi.idealingua.runtime.IRTConversions[SecondaryIdentity.Phone]
    
    implicit val Phone_random: IRTRandomGen[SecondaryIdentity.Phone] = new IRTRandomGen[SecondaryIdentity.Phone]{
      def id: String = "io.protoforce.guide.auth/SecondaryIdentity:Phone"
      def makeRandom(_random: Random, _path: List[String]): SecondaryIdentity.Phone = new SecondaryIdentity.Phone(
        phone = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val Phone_meta: IRTMetadata[SecondaryIdentity.Phone] = new IRTMetadata[SecondaryIdentity.Phone]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth/SecondaryIdentity:Phone"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("2d5368c96223fd581ac5024281b268c391bd25d7a13bc8e22d9a5f9d6d92fab0"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("0b7668f58f4b5016f7e1d7bc2436a2626fd69183ac04fd5e0c7d6644f02b971f"))
    }
  }
  
  object Email {
    /**
      * 
      *  Email secondary identity
      * 
      * DTO io.protoforce.guide.auth/SecondaryIdentity:Email (member of ADT io.protoforce.guide.auth:SecondaryIdentity)
      * 
      * Defined at identity.pfm @ 17:3
      */
    sealed trait Defn extends SecondaryIdentity {
      /**
        * Email
        */
      def email: String
    }
    
    implicit final class Conversions(
      val _value: SecondaryIdentity.Email
    ) extends _root_.izumi.idealingua.runtime.IRTConversions[SecondaryIdentity.Email]
    
    implicit val Email_random: IRTRandomGen[SecondaryIdentity.Email] = new IRTRandomGen[SecondaryIdentity.Email]{
      def id: String = "io.protoforce.guide.auth/SecondaryIdentity:Email"
      def makeRandom(_random: Random, _path: List[String]): SecondaryIdentity.Email = new SecondaryIdentity.Email(
        email = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val Email_meta: IRTMetadata[SecondaryIdentity.Email] = new IRTMetadata[SecondaryIdentity.Email]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth/SecondaryIdentity:Email"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("3abeb0fb7a47737a91a464fe1f2936ed091b40b4597ea7e37aca84285c53d9c3"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("3cb992898ea4686d3ceb45bb2740f1b97ef82ede6b04b98be431e68cfeb5b0bf"))
    }
  }
  
  implicit val SecondaryIdentity_random: IRTRandomGen[SecondaryIdentity] = new IRTRandomGen[SecondaryIdentity]{
    def id: String = "io.protoforce.guide.auth:SecondaryIdentity"
    def makeRandom(_random: Random, _path: List[String]): SecondaryIdentity = {
      val _all = List(
        IRTRandomGen[SecondaryIdentity.Phone].widen[SecondaryIdentity],
        IRTRandomGen[SecondaryIdentity.Email].widen[SecondaryIdentity]
      )
      IRTRandomGen._safeChoose[SecondaryIdentity](_all, _path :+ this.id, _random)
    }
  }
  
  implicit val SecondaryIdentity_meta: IRTMetadata[SecondaryIdentity] = new IRTMetadata[SecondaryIdentity]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:SecondaryIdentity"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("ec4e6d0ad9cd8dc69846ae13f9ef63c76c65d59354d1d62e3a446edf49c31ee9"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("b07a238d8922b6a14d45896a97c671f33e0fce289b9d49865870200f08f5bb55"))
  }
}