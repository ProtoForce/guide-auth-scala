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
  *  MFA setup: pending MFA confirmation by a user
  * 
  * ADT io.protoforce.guide.auth:MFAMethodPending
  * 
  * Defined at auth.mfa.pfm @ 16:1
  */
sealed trait MFAMethodPending {
  
}

object MFAMethodPending {
  /**
    * 
    *  App based
    * 
    * DTO io.protoforce.guide.auth/MFAMethodPending:App (member of ADT io.protoforce.guide.auth:MFAMethodPending)
    * 
    * Defined at auth.mfa.pfm @ 20:3
    */
  final case class App(
    /**
      * Secret to be stored on the client only, this is the only
      *    time it will be avaialble.
      */
    secret: String,
    /**
      * Token to be preserved and passed into the confirmation of the
      *    MFA setup.
      */
    token: String
  ) extends MFAMethodPending.App.Defn
  
  object App {
    /**
      * 
      *  App based
      * 
      * DTO io.protoforce.guide.auth/MFAMethodPending:App (member of ADT io.protoforce.guide.auth:MFAMethodPending)
      * 
      * Defined at auth.mfa.pfm @ 20:3
      */
    sealed trait Defn extends MFAMethodPending {
      /**
        * Secret to be stored on the client only, this is the only
        *    time it will be avaialble.
        */
      def secret: String
      /**
        * Token to be preserved and passed into the confirmation of the
        *    MFA setup.
        */
      def token: String
    }
    
    implicit final class Conversions(
      val _value: MFAMethodPending.App
    ) extends _root_.io.protoforce.runtime.IRTConversions[MFAMethodPending.App]
    
    implicit val App_random: IRTRandomGen[MFAMethodPending.App] = new IRTRandomGen[MFAMethodPending.App]{
      def id: String = "io.protoforce.guide.auth/MFAMethodPending:App"
      def makeRandom(_random: Random, _path: List[String]): MFAMethodPending.App = new MFAMethodPending.App(
        secret = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
        token = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val App_meta: IRTMetadata[MFAMethodPending.App] = new IRTMetadata[MFAMethodPending.App]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth/MFAMethodPending:App"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("8249c9b88b212218c834c25616b67512782d0685ae8d65bf7829db2e77cfc384"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("d0784768159764417915edeb1e0cf31cda169b21c491e8e75729e1cb53f0de6f"))
    }
  }
  
  implicit val MFAMethodPending_random: IRTRandomGen[MFAMethodPending] = new IRTRandomGen[MFAMethodPending]{
    def id: String = "io.protoforce.guide.auth:MFAMethodPending"
    def makeRandom(_random: Random, _path: List[String]): MFAMethodPending = {
      val _all = List(
        IRTRandomGen[MFAMethodPending.App].widen[MFAMethodPending]
      )
      IRTRandomGen._safeChoose[MFAMethodPending](_all, _path :+ this.id, _random)
    }
  }
  
  implicit val MFAMethodPending_meta: IRTMetadata[MFAMethodPending] = new IRTMetadata[MFAMethodPending]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:MFAMethodPending"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("dc82caa7fd620e4825f7d21508d418bc86a208d186672a36f2c5e81233b24754"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("be96b818a6b9029db752497c2fd5f20e546f0f9ac0a3d158d887b37151ed31c5"))
  }
}