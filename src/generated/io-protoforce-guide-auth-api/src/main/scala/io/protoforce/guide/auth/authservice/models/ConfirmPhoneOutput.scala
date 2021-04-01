package io.protoforce.guide.auth.authservice.models

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
  *  Confirm phone number
  * 
  * ADT io.protoforce.guide.auth.authservice.models:ConfirmPhoneOutput
  * 
  * Defined at auth.service.pfm @ 88:3
  */
sealed trait ConfirmPhoneOutput {
  
}

object ConfirmPhoneOutput {
  /**
    * DTO io.protoforce.guide.auth.authservice.models/ConfirmPhoneOutput:NotFoundError (reference member of ADT io.protoforce.guide.auth.authservice.models:ConfirmPhoneOutput)
    * 
    * Defined at auth.service.pfm @ 88:87
    */
  final case class NotFoundErrorRef(
    value: _root_.io.protoforce.guide.auth.NotFoundError
  ) extends ConfirmPhoneOutput.NotFoundErrorRef.Defn
  
  /**
    * DTO io.protoforce.guide.auth.authservice.models/ConfirmPhoneOutput:InternalError (reference member of ADT io.protoforce.guide.auth.authservice.models:ConfirmPhoneOutput)
    * 
    * Defined at auth.service.pfm @ 88:71
    */
  final case class InternalErrorRef(
    value: _root_.io.protoforce.guide.auth.InternalError
  ) extends ConfirmPhoneOutput.InternalErrorRef.Defn
  
  object NotFoundErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authservice.models/ConfirmPhoneOutput:NotFoundError (reference member of ADT io.protoforce.guide.auth.authservice.models:ConfirmPhoneOutput)
      * 
      * Defined at auth.service.pfm @ 88:87
      */
    sealed trait Defn extends ConfirmPhoneOutput {
      def value: _root_.io.protoforce.guide.auth.NotFoundError
    }
    
    implicit final class Conversions(
      val _value: ConfirmPhoneOutput.NotFoundErrorRef
    ) extends _root_.io.protoforce.runtime.IRTConversions[ConfirmPhoneOutput.NotFoundErrorRef]
    
    implicit val NotFoundError_random: IRTRandomGen[ConfirmPhoneOutput.NotFoundErrorRef] = new IRTRandomGen[ConfirmPhoneOutput.NotFoundErrorRef]{
      def id: String = "io.protoforce.guide.auth.authservice.models/ConfirmPhoneOutput:NotFoundError"
      def makeRandom(_random: Random, _path: List[String]): ConfirmPhoneOutput.NotFoundErrorRef = new ConfirmPhoneOutput.NotFoundErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.NotFoundError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val NotFoundError_meta: IRTMetadata[ConfirmPhoneOutput.NotFoundErrorRef] = new IRTMetadata[ConfirmPhoneOutput.NotFoundErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authservice.models/ConfirmPhoneOutput:NotFoundError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("4bbb489bfff2669108bc71f8d3517be1fcfe2d5e93cdf0a099c1159fe281bb3c"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("de98753f01d867ca5097bb3f7c41b45a0aebefdc632df951e551f5b555baff85"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:NotFoundError
      */
    def apply(message: String): ConfirmPhoneOutput.NotFoundErrorRef = new ConfirmPhoneOutput.NotFoundErrorRef(new _root_.io.protoforce.guide.auth.NotFoundError(
      message = message
    ))
  }
  
  object InternalErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authservice.models/ConfirmPhoneOutput:InternalError (reference member of ADT io.protoforce.guide.auth.authservice.models:ConfirmPhoneOutput)
      * 
      * Defined at auth.service.pfm @ 88:71
      */
    sealed trait Defn extends ConfirmPhoneOutput {
      def value: _root_.io.protoforce.guide.auth.InternalError
    }
    
    implicit final class Conversions(
      val _value: ConfirmPhoneOutput.InternalErrorRef
    ) extends _root_.io.protoforce.runtime.IRTConversions[ConfirmPhoneOutput.InternalErrorRef]
    
    implicit val InternalError_random: IRTRandomGen[ConfirmPhoneOutput.InternalErrorRef] = new IRTRandomGen[ConfirmPhoneOutput.InternalErrorRef]{
      def id: String = "io.protoforce.guide.auth.authservice.models/ConfirmPhoneOutput:InternalError"
      def makeRandom(_random: Random, _path: List[String]): ConfirmPhoneOutput.InternalErrorRef = new ConfirmPhoneOutput.InternalErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.InternalError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val InternalError_meta: IRTMetadata[ConfirmPhoneOutput.InternalErrorRef] = new IRTMetadata[ConfirmPhoneOutput.InternalErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authservice.models/ConfirmPhoneOutput:InternalError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("85ab412742cacfc4e66f9550abce3fe074a650779d2a541947a559db5ef0462f"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("90ad1b8a89e31969310ed7838daefecf937cff29e13ca661c83a6e8b3dc11d8e"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:InternalError
      */
    def apply(message: String): ConfirmPhoneOutput.InternalErrorRef = new ConfirmPhoneOutput.InternalErrorRef(new _root_.io.protoforce.guide.auth.InternalError(
      message = message
    ))
  }
  
  implicit val ConfirmPhoneOutput_random: IRTRandomGen[ConfirmPhoneOutput] = new IRTRandomGen[ConfirmPhoneOutput]{
    def id: String = "io.protoforce.guide.auth.authservice.models:ConfirmPhoneOutput"
    def makeRandom(_random: Random, _path: List[String]): ConfirmPhoneOutput = {
      val _all = List(
        IRTRandomGen[ConfirmPhoneOutput.InternalErrorRef].widen[ConfirmPhoneOutput],
        IRTRandomGen[ConfirmPhoneOutput.NotFoundErrorRef].widen[ConfirmPhoneOutput]
      )
      IRTRandomGen._safeChoose[ConfirmPhoneOutput](_all, _path :+ this.id, _random)
    }
  }
  
  implicit val ConfirmPhoneOutput_meta: IRTMetadata[ConfirmPhoneOutput] = new IRTMetadata[ConfirmPhoneOutput]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authservice.models:ConfirmPhoneOutput"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("f08fe6bc11891a87fae5a7d00fb79f2ab16da3b3a3f82bd52c796f439c13b355"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("34472e64fc3e01ea4c4fe71301458aee75a1202edae60071bbf0d4a8bf0a6466"))
  }
}