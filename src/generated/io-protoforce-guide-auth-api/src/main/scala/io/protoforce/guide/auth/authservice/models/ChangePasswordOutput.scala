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
  *  Change password
  * 
  * ADT io.protoforce.guide.auth.authservice.models:ChangePasswordOutput
  * 
  * Defined at auth.service.pfm @ 98:3
  */
sealed trait ChangePasswordOutput {
  
}

object ChangePasswordOutput {
  /**
    * DTO io.protoforce.guide.auth.authservice.models/ChangePasswordOutput:NotFoundError (reference member of ADT io.protoforce.guide.auth.authservice.models:ChangePasswordOutput)
    * 
    * Defined at auth.service.pfm @ 98:99
    */
  final case class NotFoundErrorRef(
    value: _root_.io.protoforce.guide.auth.NotFoundError
  ) extends ChangePasswordOutput.NotFoundErrorRef.Defn
  
  /**
    * DTO io.protoforce.guide.auth.authservice.models/ChangePasswordOutput:InternalError (reference member of ADT io.protoforce.guide.auth.authservice.models:ChangePasswordOutput)
    * 
    * Defined at auth.service.pfm @ 98:83
    */
  final case class InternalErrorRef(
    value: _root_.io.protoforce.guide.auth.InternalError
  ) extends ChangePasswordOutput.InternalErrorRef.Defn
  
  object NotFoundErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authservice.models/ChangePasswordOutput:NotFoundError (reference member of ADT io.protoforce.guide.auth.authservice.models:ChangePasswordOutput)
      * 
      * Defined at auth.service.pfm @ 98:99
      */
    sealed trait Defn extends ChangePasswordOutput {
      def value: _root_.io.protoforce.guide.auth.NotFoundError
    }
    
    implicit final class Conversions(
      val _value: ChangePasswordOutput.NotFoundErrorRef
    ) extends _root_.io.protoforce.runtime.IRTConversions[ChangePasswordOutput.NotFoundErrorRef]
    
    implicit val NotFoundError_random: IRTRandomGen[ChangePasswordOutput.NotFoundErrorRef] = new IRTRandomGen[ChangePasswordOutput.NotFoundErrorRef]{
      def id: String = "io.protoforce.guide.auth.authservice.models/ChangePasswordOutput:NotFoundError"
      def makeRandom(_random: Random, _path: List[String]): ChangePasswordOutput.NotFoundErrorRef = new ChangePasswordOutput.NotFoundErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.NotFoundError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val NotFoundError_meta: IRTMetadata[ChangePasswordOutput.NotFoundErrorRef] = new IRTMetadata[ChangePasswordOutput.NotFoundErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authservice.models/ChangePasswordOutput:NotFoundError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("9a887ce243d7f6128b6d54efd2d3194acecbb7efc9fc6621f036cc66c90db678"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("89ecdbd540341d1820feecfc91b0983789e5cc3e9339e463fe9867b54689e685"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:NotFoundError
      */
    def apply(message: String): ChangePasswordOutput.NotFoundErrorRef = new ChangePasswordOutput.NotFoundErrorRef(new _root_.io.protoforce.guide.auth.NotFoundError(
      message = message
    ))
  }
  
  object InternalErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authservice.models/ChangePasswordOutput:InternalError (reference member of ADT io.protoforce.guide.auth.authservice.models:ChangePasswordOutput)
      * 
      * Defined at auth.service.pfm @ 98:83
      */
    sealed trait Defn extends ChangePasswordOutput {
      def value: _root_.io.protoforce.guide.auth.InternalError
    }
    
    implicit final class Conversions(
      val _value: ChangePasswordOutput.InternalErrorRef
    ) extends _root_.io.protoforce.runtime.IRTConversions[ChangePasswordOutput.InternalErrorRef]
    
    implicit val InternalError_random: IRTRandomGen[ChangePasswordOutput.InternalErrorRef] = new IRTRandomGen[ChangePasswordOutput.InternalErrorRef]{
      def id: String = "io.protoforce.guide.auth.authservice.models/ChangePasswordOutput:InternalError"
      def makeRandom(_random: Random, _path: List[String]): ChangePasswordOutput.InternalErrorRef = new ChangePasswordOutput.InternalErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.InternalError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val InternalError_meta: IRTMetadata[ChangePasswordOutput.InternalErrorRef] = new IRTMetadata[ChangePasswordOutput.InternalErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authservice.models/ChangePasswordOutput:InternalError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("804b820868126c4d6796fccac2db8d759bf0cc557fcd24442d1273cca59e7a24"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("c283203153a5ba32c535a7fa1fbea88ba8c4cb9beb987ef398e9a355a62a21d9"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:InternalError
      */
    def apply(message: String): ChangePasswordOutput.InternalErrorRef = new ChangePasswordOutput.InternalErrorRef(new _root_.io.protoforce.guide.auth.InternalError(
      message = message
    ))
  }
  
  implicit val ChangePasswordOutput_random: IRTRandomGen[ChangePasswordOutput] = new IRTRandomGen[ChangePasswordOutput]{
    def id: String = "io.protoforce.guide.auth.authservice.models:ChangePasswordOutput"
    def makeRandom(_random: Random, _path: List[String]): ChangePasswordOutput = {
      val _all = List(
        IRTRandomGen[ChangePasswordOutput.InternalErrorRef].widen[ChangePasswordOutput],
        IRTRandomGen[ChangePasswordOutput.NotFoundErrorRef].widen[ChangePasswordOutput]
      )
      IRTRandomGen._safeChoose[ChangePasswordOutput](_all, _path :+ this.id, _random)
    }
  }
  
  implicit val ChangePasswordOutput_meta: IRTMetadata[ChangePasswordOutput] = new IRTMetadata[ChangePasswordOutput]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authservice.models:ChangePasswordOutput"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("81ea420ee9437d502c596615282de59dabce4bf6f09e81ced12bc4aaef62a870"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("856c0083be401876d2c03109faea1914f286166101446e088db745d0a9ce9cd1"))
  }
}