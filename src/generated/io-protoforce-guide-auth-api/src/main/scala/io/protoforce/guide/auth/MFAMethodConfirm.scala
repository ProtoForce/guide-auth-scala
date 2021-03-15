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
  *  MFA setup: confirming previously requested MFA method
  * 
  * ADT io.protoforce.guide.auth:MFAMethodConfirm
  * 
  * Defined at auth.mfa.pfm @ 38:1
  */
sealed trait MFAMethodConfirm {
  
}

object MFAMethodConfirm {
  /**
    * 
    *  App based authentication confirmation
    * 
    * DTO io.protoforce.guide.auth/MFAMethodConfirm:App (member of ADT io.protoforce.guide.auth:MFAMethodConfirm)
    * 
    * Defined at auth.mfa.pfm @ 42:3
    */
  final case class App(
    /**
      * One code sample generated using the previously provided secret
      */
    code: String,
    /**
      * Token previously provided in the MFAMethodPending structure
      */
    token: String
  ) extends MFAMethodConfirm.App.Defn
  
  object App {
    /**
      * 
      *  App based authentication confirmation
      * 
      * DTO io.protoforce.guide.auth/MFAMethodConfirm:App (member of ADT io.protoforce.guide.auth:MFAMethodConfirm)
      * 
      * Defined at auth.mfa.pfm @ 42:3
      */
    sealed trait Defn extends MFAMethodConfirm {
      /**
        * One code sample generated using the previously provided secret
        */
      def code: String
      /**
        * Token previously provided in the MFAMethodPending structure
        */
      def token: String
    }
    
    implicit final class Conversions(
      val _value: MFAMethodConfirm.App
    ) extends _root_.izumi.idealingua.runtime.IRTConversions[MFAMethodConfirm.App]
    
    implicit val App_random: IRTRandomGen[MFAMethodConfirm.App] = new IRTRandomGen[MFAMethodConfirm.App]{
      def id: String = "io.protoforce.guide.auth/MFAMethodConfirm:App"
      def makeRandom(_random: Random, _path: List[String]): MFAMethodConfirm.App = new MFAMethodConfirm.App(
        code = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
        token = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val App_meta: IRTMetadata[MFAMethodConfirm.App] = new IRTMetadata[MFAMethodConfirm.App]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth/MFAMethodConfirm:App"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("82639fc8acfa6c76480a9a4900a4007b06458b4f6e460873f542e33817dfd98b"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("9035cb852d573b5e75f8a77a1ed456f8c1af6d7f3be8d7491c39d20ea66cab63"))
    }
  }
  
  implicit val MFAMethodConfirm_random: IRTRandomGen[MFAMethodConfirm] = new IRTRandomGen[MFAMethodConfirm]{
    def id: String = "io.protoforce.guide.auth:MFAMethodConfirm"
    def makeRandom(_random: Random, _path: List[String]): MFAMethodConfirm = {
      val _all = List(
        IRTRandomGen[MFAMethodConfirm.App].widen[MFAMethodConfirm]
      )
      IRTRandomGen._safeChoose[MFAMethodConfirm](_all, _path :+ this.id, _random)
    }
  }
  
  implicit val MFAMethodConfirm_meta: IRTMetadata[MFAMethodConfirm] = new IRTMetadata[MFAMethodConfirm]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:MFAMethodConfirm"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("cd9d25222533beb36d7046c38f295b7f3e5879dcef2f1b27f4fa9d4ce46940d6"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("4fcad2d871f34f55f2bcfc9a9cbe4ab286a56c671a3d94e9ec650e96fa7e1821"))
  }
}