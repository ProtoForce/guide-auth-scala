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
  *  MFA setup: request to enable MFA via provided method
  * 
  * ADT io.protoforce.guide.auth:MFAMethodRequest
  * 
  * Defined at auth.mfa.pfm @ 5:1
  */
sealed trait MFAMethodRequest {
  
}

object MFAMethodRequest {
  /**
    * 
    *  Request an app based MFA
    * 
    * DTO io.protoforce.guide.auth/MFAMethodRequest:App (member of ADT io.protoforce.guide.auth:MFAMethodRequest)
    * 
    * Defined at auth.mfa.pfm @ 9:3
    */
  final case class App(
    
  ) extends MFAMethodRequest.App.Defn
  
  object App {
    /**
      * 
      *  Request an app based MFA
      * 
      * DTO io.protoforce.guide.auth/MFAMethodRequest:App (member of ADT io.protoforce.guide.auth:MFAMethodRequest)
      * 
      * Defined at auth.mfa.pfm @ 9:3
      */
    sealed trait Defn extends MFAMethodRequest {
      
    }
    
    implicit final class Conversions(
      val _value: MFAMethodRequest.App
    ) extends _root_.io.protoforce.runtime.IRTConversions[MFAMethodRequest.App]
    
    implicit val App_random: IRTRandomGen[MFAMethodRequest.App] = new IRTRandomGen[MFAMethodRequest.App]{
      def id: String = "io.protoforce.guide.auth/MFAMethodRequest:App"
      def makeRandom(_random: Random, _path: List[String]): MFAMethodRequest.App = new MFAMethodRequest.App()
    }
    
    implicit val App_meta: IRTMetadata[MFAMethodRequest.App] = new IRTMetadata[MFAMethodRequest.App]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth/MFAMethodRequest:App"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("a7f6d90844ab5e7f6708d336151ed74bfa7cf8d60e1bd2ac3c100696362dd0ea"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("b14c824638399cec2d6c073d0e8f2791e75d48d61bab1a2dd20452b69bdf973c"))
    }
  }
  
  implicit val MFAMethodRequest_random: IRTRandomGen[MFAMethodRequest] = new IRTRandomGen[MFAMethodRequest]{
    def id: String = "io.protoforce.guide.auth:MFAMethodRequest"
    def makeRandom(_random: Random, _path: List[String]): MFAMethodRequest = {
      val _all = List(
        IRTRandomGen[MFAMethodRequest.App].widen[MFAMethodRequest]
      )
      IRTRandomGen._safeChoose[MFAMethodRequest](_all, _path :+ this.id, _random)
    }
  }
  
  implicit val MFAMethodRequest_meta: IRTMetadata[MFAMethodRequest] = new IRTMetadata[MFAMethodRequest]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:MFAMethodRequest"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("dd4bcc4846196cddf71878b905a532e0497f8f1dac41bce7904e96210c45e496"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("5d54c979adc69b27b3d3c2bc034f367660106c0943f212e626ec9407af957227"))
  }
}