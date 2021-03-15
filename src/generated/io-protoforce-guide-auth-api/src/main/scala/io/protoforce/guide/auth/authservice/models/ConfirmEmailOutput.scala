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
  *  Confirm email
  * 
  * ADT io.protoforce.guide.auth.authservice.models:ConfirmEmailOutput
  * 
  * Defined at auth.service.pfm @ 83:3
  */
sealed trait ConfirmEmailOutput {
  
}

object ConfirmEmailOutput {
  /**
    * DTO io.protoforce.guide.auth.authservice.models/ConfirmEmailOutput:NotFoundError (reference member of ADT io.protoforce.guide.auth.authservice.models:ConfirmEmailOutput)
    * 
    * Defined at auth.service.pfm @ 83:72
    */
  final case class NotFoundErrorRef(
    value: _root_.io.protoforce.guide.auth.NotFoundError
  ) extends ConfirmEmailOutput.NotFoundErrorRef.Defn
  
  /**
    * DTO io.protoforce.guide.auth.authservice.models/ConfirmEmailOutput:InternalError (reference member of ADT io.protoforce.guide.auth.authservice.models:ConfirmEmailOutput)
    * 
    * Defined at auth.service.pfm @ 83:56
    */
  final case class InternalErrorRef(
    value: _root_.io.protoforce.guide.auth.InternalError
  ) extends ConfirmEmailOutput.InternalErrorRef.Defn
  
  object NotFoundErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authservice.models/ConfirmEmailOutput:NotFoundError (reference member of ADT io.protoforce.guide.auth.authservice.models:ConfirmEmailOutput)
      * 
      * Defined at auth.service.pfm @ 83:72
      */
    sealed trait Defn extends ConfirmEmailOutput {
      def value: _root_.io.protoforce.guide.auth.NotFoundError
    }
    
    implicit final class Conversions(
      val _value: ConfirmEmailOutput.NotFoundErrorRef
    ) extends _root_.izumi.idealingua.runtime.IRTConversions[ConfirmEmailOutput.NotFoundErrorRef]
    
    implicit val NotFoundError_random: IRTRandomGen[ConfirmEmailOutput.NotFoundErrorRef] = new IRTRandomGen[ConfirmEmailOutput.NotFoundErrorRef]{
      def id: String = "io.protoforce.guide.auth.authservice.models/ConfirmEmailOutput:NotFoundError"
      def makeRandom(_random: Random, _path: List[String]): ConfirmEmailOutput.NotFoundErrorRef = new ConfirmEmailOutput.NotFoundErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.NotFoundError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val NotFoundError_meta: IRTMetadata[ConfirmEmailOutput.NotFoundErrorRef] = new IRTMetadata[ConfirmEmailOutput.NotFoundErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authservice.models/ConfirmEmailOutput:NotFoundError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("00be35a12cb0a5f508863d36b10daee7f04a76d7cc83b236b9f87f5c13dfd93e"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("f964d761954fdef4561a4147d63cc99d97a5537b72fd5f21294f112c3253d09a"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:NotFoundError
      */
    def apply(message: String): ConfirmEmailOutput.NotFoundErrorRef = new ConfirmEmailOutput.NotFoundErrorRef(new _root_.io.protoforce.guide.auth.NotFoundError(
      message = message
    ))
  }
  
  object InternalErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authservice.models/ConfirmEmailOutput:InternalError (reference member of ADT io.protoforce.guide.auth.authservice.models:ConfirmEmailOutput)
      * 
      * Defined at auth.service.pfm @ 83:56
      */
    sealed trait Defn extends ConfirmEmailOutput {
      def value: _root_.io.protoforce.guide.auth.InternalError
    }
    
    implicit final class Conversions(
      val _value: ConfirmEmailOutput.InternalErrorRef
    ) extends _root_.izumi.idealingua.runtime.IRTConversions[ConfirmEmailOutput.InternalErrorRef]
    
    implicit val InternalError_random: IRTRandomGen[ConfirmEmailOutput.InternalErrorRef] = new IRTRandomGen[ConfirmEmailOutput.InternalErrorRef]{
      def id: String = "io.protoforce.guide.auth.authservice.models/ConfirmEmailOutput:InternalError"
      def makeRandom(_random: Random, _path: List[String]): ConfirmEmailOutput.InternalErrorRef = new ConfirmEmailOutput.InternalErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.InternalError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val InternalError_meta: IRTMetadata[ConfirmEmailOutput.InternalErrorRef] = new IRTMetadata[ConfirmEmailOutput.InternalErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authservice.models/ConfirmEmailOutput:InternalError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("6dd39b885fabceaca82bf70c5b3409d67548074f6f3d15e8ad7f3f942e462614"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("042f06e6758d2b777c39402ab64e47fd8e4213d0a73b167ca3c86c4ee398bc23"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:InternalError
      */
    def apply(message: String): ConfirmEmailOutput.InternalErrorRef = new ConfirmEmailOutput.InternalErrorRef(new _root_.io.protoforce.guide.auth.InternalError(
      message = message
    ))
  }
  
  implicit val ConfirmEmailOutput_random: IRTRandomGen[ConfirmEmailOutput] = new IRTRandomGen[ConfirmEmailOutput]{
    def id: String = "io.protoforce.guide.auth.authservice.models:ConfirmEmailOutput"
    def makeRandom(_random: Random, _path: List[String]): ConfirmEmailOutput = {
      val _all = List(
        IRTRandomGen[ConfirmEmailOutput.InternalErrorRef].widen[ConfirmEmailOutput],
        IRTRandomGen[ConfirmEmailOutput.NotFoundErrorRef].widen[ConfirmEmailOutput]
      )
      IRTRandomGen._safeChoose[ConfirmEmailOutput](_all, _path :+ this.id, _random)
    }
  }
  
  implicit val ConfirmEmailOutput_meta: IRTMetadata[ConfirmEmailOutput] = new IRTMetadata[ConfirmEmailOutput]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authservice.models:ConfirmEmailOutput"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("b6ba2cfa04406454a80905ef35810e424c1a0563969ea4fd4db1f69c45e47c52"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("b63ae277383f2a1cd4d10934e40c01ba76b2ff0c7fe6ed8b06db87d0db74a3bc"))
  }
}