package io.protoforce.guide.auth.authprotectedservice.models

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
  *  Disable two factor authentication
  * 
  * ADT io.protoforce.guide.auth.authprotectedservice.models:Disable2FAOutput
  * 
  * Defined at auth.service.pfm @ 120:3
  */
sealed trait Disable2FAOutput {
  
}

object Disable2FAOutput {
  /**
    * DTO io.protoforce.guide.auth.authprotectedservice.models/Disable2FAOutput:InternalError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:Disable2FAOutput)
    * 
    * Defined at auth.service.pfm @ 120:42
    */
  final case class InternalErrorRef(
    value: _root_.io.protoforce.guide.auth.InternalError
  ) extends Disable2FAOutput.InternalErrorRef.Defn
  
  /**
    * DTO io.protoforce.guide.auth.authprotectedservice.models/Disable2FAOutput:ForbiddenError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:Disable2FAOutput)
    * 
    * Defined at auth.service.pfm @ 120:58
    */
  final case class ForbiddenErrorRef(
    value: _root_.io.protoforce.guide.auth.ForbiddenError
  ) extends Disable2FAOutput.ForbiddenErrorRef.Defn
  
  object InternalErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authprotectedservice.models/Disable2FAOutput:InternalError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:Disable2FAOutput)
      * 
      * Defined at auth.service.pfm @ 120:42
      */
    sealed trait Defn extends Disable2FAOutput {
      def value: _root_.io.protoforce.guide.auth.InternalError
    }
    
    implicit final class Conversions(
      val _value: Disable2FAOutput.InternalErrorRef
    ) extends _root_.io.protoforce.runtime.IRTConversions[Disable2FAOutput.InternalErrorRef]
    
    implicit val InternalError_random: IRTRandomGen[Disable2FAOutput.InternalErrorRef] = new IRTRandomGen[Disable2FAOutput.InternalErrorRef]{
      def id: String = "io.protoforce.guide.auth.authprotectedservice.models/Disable2FAOutput:InternalError"
      def makeRandom(_random: Random, _path: List[String]): Disable2FAOutput.InternalErrorRef = new Disable2FAOutput.InternalErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.InternalError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val InternalError_meta: IRTMetadata[Disable2FAOutput.InternalErrorRef] = new IRTMetadata[Disable2FAOutput.InternalErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models/Disable2FAOutput:InternalError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("fafd79443928503bc81dd9b77fd8d975bf8fce995492202782310786d7f6a52d"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("119783d17a8887ed5ad3cc260ac738b8b966e295a3ca5ba844401ab5e41f20bc"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:InternalError
      */
    def apply(message: String): Disable2FAOutput.InternalErrorRef = new Disable2FAOutput.InternalErrorRef(new _root_.io.protoforce.guide.auth.InternalError(
      message = message
    ))
  }
  
  object ForbiddenErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authprotectedservice.models/Disable2FAOutput:ForbiddenError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:Disable2FAOutput)
      * 
      * Defined at auth.service.pfm @ 120:58
      */
    sealed trait Defn extends Disable2FAOutput {
      def value: _root_.io.protoforce.guide.auth.ForbiddenError
    }
    
    implicit final class Conversions(
      val _value: Disable2FAOutput.ForbiddenErrorRef
    ) extends _root_.io.protoforce.runtime.IRTConversions[Disable2FAOutput.ForbiddenErrorRef]
    
    implicit val ForbiddenError_random: IRTRandomGen[Disable2FAOutput.ForbiddenErrorRef] = new IRTRandomGen[Disable2FAOutput.ForbiddenErrorRef]{
      def id: String = "io.protoforce.guide.auth.authprotectedservice.models/Disable2FAOutput:ForbiddenError"
      def makeRandom(_random: Random, _path: List[String]): Disable2FAOutput.ForbiddenErrorRef = new Disable2FAOutput.ForbiddenErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.ForbiddenError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val ForbiddenError_meta: IRTMetadata[Disable2FAOutput.ForbiddenErrorRef] = new IRTMetadata[Disable2FAOutput.ForbiddenErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models/Disable2FAOutput:ForbiddenError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("f4d94a421fb1167d7cc1225c99c800e2fce54aacc291020a89e93beafbbaf0a6"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("52e7d7a7c6a3b0ea6299a7dd80f1bd415caef452ba1037543903fd876385a64b"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:ForbiddenError
      */
    def apply(message: String): Disable2FAOutput.ForbiddenErrorRef = new Disable2FAOutput.ForbiddenErrorRef(new _root_.io.protoforce.guide.auth.ForbiddenError(
      message = message
    ))
  }
  
  implicit val Disable2FAOutput_random: IRTRandomGen[Disable2FAOutput] = new IRTRandomGen[Disable2FAOutput]{
    def id: String = "io.protoforce.guide.auth.authprotectedservice.models:Disable2FAOutput"
    def makeRandom(_random: Random, _path: List[String]): Disable2FAOutput = {
      val _all = List(
        IRTRandomGen[Disable2FAOutput.InternalErrorRef].widen[Disable2FAOutput],
        IRTRandomGen[Disable2FAOutput.ForbiddenErrorRef].widen[Disable2FAOutput]
      )
      IRTRandomGen._safeChoose[Disable2FAOutput](_all, _path :+ this.id, _random)
    }
  }
  
  implicit val Disable2FAOutput_meta: IRTMetadata[Disable2FAOutput] = new IRTMetadata[Disable2FAOutput]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models:Disable2FAOutput"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("0ca22340f54984662552a3ab6dc0821afaddd6ce3027abc2acfe9a82d4b37576"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("6d0a9e1ba28fa9b151f316e3638d1c16a0f65280800a9343fbf7486db6e5cbcc"))
  }
}