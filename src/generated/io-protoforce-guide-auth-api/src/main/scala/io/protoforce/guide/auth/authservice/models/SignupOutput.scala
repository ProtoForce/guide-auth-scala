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
  *  Sign up for a service with provided credentials
  * 
  * ADT io.protoforce.guide.auth.authservice.models:SignupOutput
  * 
  * Defined at auth.service.pfm @ 73:3
  */
sealed trait SignupOutput {
  
}

object SignupOutput {
  /**
    * DTO io.protoforce.guide.auth.authservice.models/SignupOutput:InternalError (reference member of ADT io.protoforce.guide.auth.authservice.models:SignupOutput)
    * 
    * Defined at auth.service.pfm @ 73:57
    */
  final case class InternalErrorRef(
    value: _root_.io.protoforce.guide.auth.InternalError
  ) extends SignupOutput.InternalErrorRef.Defn
  
  /**
    * DTO io.protoforce.guide.auth.authservice.models/SignupOutput:AlreadyExistsError (reference member of ADT io.protoforce.guide.auth.authservice.models:SignupOutput)
    * 
    * Defined at auth.service.pfm @ 73:73
    */
  final case class AlreadyExistsErrorRef(
    value: _root_.io.protoforce.guide.auth.AlreadyExistsError
  ) extends SignupOutput.AlreadyExistsErrorRef.Defn
  
  object InternalErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authservice.models/SignupOutput:InternalError (reference member of ADT io.protoforce.guide.auth.authservice.models:SignupOutput)
      * 
      * Defined at auth.service.pfm @ 73:57
      */
    sealed trait Defn extends SignupOutput {
      def value: _root_.io.protoforce.guide.auth.InternalError
    }
    
    implicit final class Conversions(
      val _value: SignupOutput.InternalErrorRef
    ) extends _root_.io.protoforce.runtime.IRTConversions[SignupOutput.InternalErrorRef]
    
    implicit val InternalError_random: IRTRandomGen[SignupOutput.InternalErrorRef] = new IRTRandomGen[SignupOutput.InternalErrorRef]{
      def id: String = "io.protoforce.guide.auth.authservice.models/SignupOutput:InternalError"
      def makeRandom(_random: Random, _path: List[String]): SignupOutput.InternalErrorRef = new SignupOutput.InternalErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.InternalError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val InternalError_meta: IRTMetadata[SignupOutput.InternalErrorRef] = new IRTMetadata[SignupOutput.InternalErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authservice.models/SignupOutput:InternalError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("374da2c5d9c587f32f6f358e32be6cb4b55aece23509c79f9ec743c367b9664f"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("6351c81d6c269d3fdebafd395ec391cf935384affd2e1bc9cd10634568048129"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:InternalError
      */
    def apply(message: String): SignupOutput.InternalErrorRef = new SignupOutput.InternalErrorRef(new _root_.io.protoforce.guide.auth.InternalError(
      message = message
    ))
  }
  
  object AlreadyExistsErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authservice.models/SignupOutput:AlreadyExistsError (reference member of ADT io.protoforce.guide.auth.authservice.models:SignupOutput)
      * 
      * Defined at auth.service.pfm @ 73:73
      */
    sealed trait Defn extends SignupOutput {
      def value: _root_.io.protoforce.guide.auth.AlreadyExistsError
    }
    
    implicit final class Conversions(
      val _value: SignupOutput.AlreadyExistsErrorRef
    ) extends _root_.io.protoforce.runtime.IRTConversions[SignupOutput.AlreadyExistsErrorRef]
    
    implicit val AlreadyExistsError_random: IRTRandomGen[SignupOutput.AlreadyExistsErrorRef] = new IRTRandomGen[SignupOutput.AlreadyExistsErrorRef]{
      def id: String = "io.protoforce.guide.auth.authservice.models/SignupOutput:AlreadyExistsError"
      def makeRandom(_random: Random, _path: List[String]): SignupOutput.AlreadyExistsErrorRef = new SignupOutput.AlreadyExistsErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.AlreadyExistsError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val AlreadyExistsError_meta: IRTMetadata[SignupOutput.AlreadyExistsErrorRef] = new IRTMetadata[SignupOutput.AlreadyExistsErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authservice.models/SignupOutput:AlreadyExistsError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("a04eb6051aceb96b0f61f5b53452062e23eb5b555f02b98721343b1925a502f3"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("3390c52d98c9d5f4505769a74aeb86e0c10336baaa6cbcfea2d5aa0f507a44fe"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:AlreadyExistsError
      */
    def apply(message: String): SignupOutput.AlreadyExistsErrorRef = new SignupOutput.AlreadyExistsErrorRef(new _root_.io.protoforce.guide.auth.AlreadyExistsError(
      message = message
    ))
  }
  
  implicit val SignupOutput_random: IRTRandomGen[SignupOutput] = new IRTRandomGen[SignupOutput]{
    def id: String = "io.protoforce.guide.auth.authservice.models:SignupOutput"
    def makeRandom(_random: Random, _path: List[String]): SignupOutput = {
      val _all = List(
        IRTRandomGen[SignupOutput.InternalErrorRef].widen[SignupOutput],
        IRTRandomGen[SignupOutput.AlreadyExistsErrorRef].widen[SignupOutput]
      )
      IRTRandomGen._safeChoose[SignupOutput](_all, _path :+ this.id, _random)
    }
  }
  
  implicit val SignupOutput_meta: IRTMetadata[SignupOutput] = new IRTMetadata[SignupOutput]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authservice.models:SignupOutput"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("2f12eb519909e6e7e00157db2ef0bb105d16c2facc6a3ab42e675cf1758ee799"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("3ba147c7177fbb4d46ac8f534b2b7033fa049020b11ed92f1ec6e3258be2604b"))
  }
}