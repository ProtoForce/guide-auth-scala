package io.protoforce.guide.auth.authservice.models

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
  *  Sign in with provided credentials
  * 
  * ADT io.protoforce.guide.auth.authservice.models:SigninOutput
  * 
  * Defined at auth.service.pfm @ 78:3
  */
sealed trait SigninOutput {
  
}

object SigninOutput {
  /**
    * DTO io.protoforce.guide.auth.authservice.models/SigninOutput:InternalError (reference member of ADT io.protoforce.guide.auth.authservice.models:SigninOutput)
    * 
    * Defined at auth.service.pfm @ 78:50
    */
  final case class InternalErrorRef(
    value: _root_.io.protoforce.guide.auth.InternalError
  ) extends SigninOutput.InternalErrorRef.Defn
  
  /**
    * DTO io.protoforce.guide.auth.authservice.models/SigninOutput:NotFoundError (reference member of ADT io.protoforce.guide.auth.authservice.models:SigninOutput)
    * 
    * Defined at auth.service.pfm @ 78:66
    */
  final case class NotFoundErrorRef(
    value: _root_.io.protoforce.guide.auth.NotFoundError
  ) extends SigninOutput.NotFoundErrorRef.Defn
  
  object InternalErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authservice.models/SigninOutput:InternalError (reference member of ADT io.protoforce.guide.auth.authservice.models:SigninOutput)
      * 
      * Defined at auth.service.pfm @ 78:50
      */
    sealed trait Defn extends SigninOutput {
      def value: _root_.io.protoforce.guide.auth.InternalError
    }
    
    implicit final class Conversions(
      val _value: SigninOutput.InternalErrorRef
    ) extends _root_.izumi.idealingua.runtime.IRTConversions[SigninOutput.InternalErrorRef]
    
    implicit val InternalError_random: IRTRandomGen[SigninOutput.InternalErrorRef] = new IRTRandomGen[SigninOutput.InternalErrorRef]{
      def id: String = "io.protoforce.guide.auth.authservice.models/SigninOutput:InternalError"
      def makeRandom(_random: Random, _path: List[String]): SigninOutput.InternalErrorRef = new SigninOutput.InternalErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.InternalError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val InternalError_meta: IRTMetadata[SigninOutput.InternalErrorRef] = new IRTMetadata[SigninOutput.InternalErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authservice.models/SigninOutput:InternalError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("083932c03bb6ec5d7450ffbe632df2309f98a662f3e517b554a45e8090ac9988"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("0a75bb1a9f128e40b9327f7c007d41dbd164cc01bdb3d969789251a86f341ed6"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:InternalError
      */
    def apply(message: String): SigninOutput.InternalErrorRef = new SigninOutput.InternalErrorRef(new _root_.io.protoforce.guide.auth.InternalError(
      message = message
    ))
  }
  
  object NotFoundErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authservice.models/SigninOutput:NotFoundError (reference member of ADT io.protoforce.guide.auth.authservice.models:SigninOutput)
      * 
      * Defined at auth.service.pfm @ 78:66
      */
    sealed trait Defn extends SigninOutput {
      def value: _root_.io.protoforce.guide.auth.NotFoundError
    }
    
    implicit final class Conversions(
      val _value: SigninOutput.NotFoundErrorRef
    ) extends _root_.izumi.idealingua.runtime.IRTConversions[SigninOutput.NotFoundErrorRef]
    
    implicit val NotFoundError_random: IRTRandomGen[SigninOutput.NotFoundErrorRef] = new IRTRandomGen[SigninOutput.NotFoundErrorRef]{
      def id: String = "io.protoforce.guide.auth.authservice.models/SigninOutput:NotFoundError"
      def makeRandom(_random: Random, _path: List[String]): SigninOutput.NotFoundErrorRef = new SigninOutput.NotFoundErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.NotFoundError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val NotFoundError_meta: IRTMetadata[SigninOutput.NotFoundErrorRef] = new IRTMetadata[SigninOutput.NotFoundErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authservice.models/SigninOutput:NotFoundError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("1afae17863465989e877eb40a6e7b827a9e8577634e24b4338f1ec13071e23c4"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("fd9ecd699676e59126fe1622ff55a4304d5b0cb4a7f1ddc5b87a198514904080"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:NotFoundError
      */
    def apply(message: String): SigninOutput.NotFoundErrorRef = new SigninOutput.NotFoundErrorRef(new _root_.io.protoforce.guide.auth.NotFoundError(
      message = message
    ))
  }
  
  implicit val SigninOutput_random: IRTRandomGen[SigninOutput] = new IRTRandomGen[SigninOutput]{
    def id: String = "io.protoforce.guide.auth.authservice.models:SigninOutput"
    def makeRandom(_random: Random, _path: List[String]): SigninOutput = {
      val _all = List(
        IRTRandomGen[SigninOutput.InternalErrorRef].widen[SigninOutput],
        IRTRandomGen[SigninOutput.NotFoundErrorRef].widen[SigninOutput]
      )
      IRTRandomGen._safeChoose[SigninOutput](_all, _path :+ this.id, _random)
    }
  }
  
  implicit val SigninOutput_meta: IRTMetadata[SigninOutput] = new IRTMetadata[SigninOutput]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authservice.models:SigninOutput"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("b0f20c0c069b7641ba05a2b18ae15cac80f9b17c9b89b67b917f91df8c1dbf21"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("06f5aabb329aacdbf2109a9fe4ec7a6882b24621f918e75ee4b956ddc596cebf"))
  }
}