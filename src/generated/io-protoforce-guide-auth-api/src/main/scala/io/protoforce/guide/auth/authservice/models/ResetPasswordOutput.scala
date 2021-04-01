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
  *  Reset password
  * 
  * ADT io.protoforce.guide.auth.authservice.models:ResetPasswordOutput
  * 
  * Defined at auth.service.pfm @ 93:3
  */
sealed trait ResetPasswordOutput {
  
}

object ResetPasswordOutput {
  /**
    * DTO io.protoforce.guide.auth.authservice.models/ResetPasswordOutput:InternalError (reference member of ADT io.protoforce.guide.auth.authservice.models:ResetPasswordOutput)
    * 
    * Defined at auth.service.pfm @ 93:63
    */
  final case class InternalErrorRef(
    value: _root_.io.protoforce.guide.auth.InternalError
  ) extends ResetPasswordOutput.InternalErrorRef.Defn
  
  /**
    * DTO io.protoforce.guide.auth.authservice.models/ResetPasswordOutput:NotFoundError (reference member of ADT io.protoforce.guide.auth.authservice.models:ResetPasswordOutput)
    * 
    * Defined at auth.service.pfm @ 93:79
    */
  final case class NotFoundErrorRef(
    value: _root_.io.protoforce.guide.auth.NotFoundError
  ) extends ResetPasswordOutput.NotFoundErrorRef.Defn
  
  object InternalErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authservice.models/ResetPasswordOutput:InternalError (reference member of ADT io.protoforce.guide.auth.authservice.models:ResetPasswordOutput)
      * 
      * Defined at auth.service.pfm @ 93:63
      */
    sealed trait Defn extends ResetPasswordOutput {
      def value: _root_.io.protoforce.guide.auth.InternalError
    }
    
    implicit final class Conversions(
      val _value: ResetPasswordOutput.InternalErrorRef
    ) extends _root_.io.protoforce.runtime.IRTConversions[ResetPasswordOutput.InternalErrorRef]
    
    implicit val InternalError_random: IRTRandomGen[ResetPasswordOutput.InternalErrorRef] = new IRTRandomGen[ResetPasswordOutput.InternalErrorRef]{
      def id: String = "io.protoforce.guide.auth.authservice.models/ResetPasswordOutput:InternalError"
      def makeRandom(_random: Random, _path: List[String]): ResetPasswordOutput.InternalErrorRef = new ResetPasswordOutput.InternalErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.InternalError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val InternalError_meta: IRTMetadata[ResetPasswordOutput.InternalErrorRef] = new IRTMetadata[ResetPasswordOutput.InternalErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authservice.models/ResetPasswordOutput:InternalError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("2c2273efc9924d41db169c9356a5cab9d3f0b7a2c2b872eecaf04a688a32c2d5"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("3431e06ce723ea1c7dfd8658f3f1998f0d305d7f93d958f2d24162d90919dd84"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:InternalError
      */
    def apply(message: String): ResetPasswordOutput.InternalErrorRef = new ResetPasswordOutput.InternalErrorRef(new _root_.io.protoforce.guide.auth.InternalError(
      message = message
    ))
  }
  
  object NotFoundErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authservice.models/ResetPasswordOutput:NotFoundError (reference member of ADT io.protoforce.guide.auth.authservice.models:ResetPasswordOutput)
      * 
      * Defined at auth.service.pfm @ 93:79
      */
    sealed trait Defn extends ResetPasswordOutput {
      def value: _root_.io.protoforce.guide.auth.NotFoundError
    }
    
    implicit final class Conversions(
      val _value: ResetPasswordOutput.NotFoundErrorRef
    ) extends _root_.io.protoforce.runtime.IRTConversions[ResetPasswordOutput.NotFoundErrorRef]
    
    implicit val NotFoundError_random: IRTRandomGen[ResetPasswordOutput.NotFoundErrorRef] = new IRTRandomGen[ResetPasswordOutput.NotFoundErrorRef]{
      def id: String = "io.protoforce.guide.auth.authservice.models/ResetPasswordOutput:NotFoundError"
      def makeRandom(_random: Random, _path: List[String]): ResetPasswordOutput.NotFoundErrorRef = new ResetPasswordOutput.NotFoundErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.NotFoundError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val NotFoundError_meta: IRTMetadata[ResetPasswordOutput.NotFoundErrorRef] = new IRTMetadata[ResetPasswordOutput.NotFoundErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authservice.models/ResetPasswordOutput:NotFoundError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("d666eb60e8c788cf66b2ed88762b299d8b4a0a52c5652344c3a58573e7a3b3d9"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("2443089704101c44401c92e9b9fcb7948edd996822245877b1c32a0bafb92c22"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:NotFoundError
      */
    def apply(message: String): ResetPasswordOutput.NotFoundErrorRef = new ResetPasswordOutput.NotFoundErrorRef(new _root_.io.protoforce.guide.auth.NotFoundError(
      message = message
    ))
  }
  
  implicit val ResetPasswordOutput_random: IRTRandomGen[ResetPasswordOutput] = new IRTRandomGen[ResetPasswordOutput]{
    def id: String = "io.protoforce.guide.auth.authservice.models:ResetPasswordOutput"
    def makeRandom(_random: Random, _path: List[String]): ResetPasswordOutput = {
      val _all = List(
        IRTRandomGen[ResetPasswordOutput.InternalErrorRef].widen[ResetPasswordOutput],
        IRTRandomGen[ResetPasswordOutput.NotFoundErrorRef].widen[ResetPasswordOutput]
      )
      IRTRandomGen._safeChoose[ResetPasswordOutput](_all, _path :+ this.id, _random)
    }
  }
  
  implicit val ResetPasswordOutput_meta: IRTMetadata[ResetPasswordOutput] = new IRTMetadata[ResetPasswordOutput]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authservice.models:ResetPasswordOutput"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("5a3c5f094598c4fea4c5a21181f2b76bbba694e8da650f5f267de8e0608d9891"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("7c4b4ec55d73f6419fc5d8b8c7c0abca1db3d29b272ac12d3e16cc882b7a6835"))
  }
}