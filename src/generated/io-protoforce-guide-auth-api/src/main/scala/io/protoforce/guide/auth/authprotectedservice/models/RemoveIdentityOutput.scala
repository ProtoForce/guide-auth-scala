package io.protoforce.guide.auth.authprotectedservice.models

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
  *  Remove secondary identity
  * 
  * ADT io.protoforce.guide.auth.authprotectedservice.models:RemoveIdentityOutput
  * 
  * Defined at auth.service.pfm @ 131:3
  */
sealed trait RemoveIdentityOutput {
  
}

object RemoveIdentityOutput {
  /**
    * DTO io.protoforce.guide.auth.authprotectedservice.models/RemoveIdentityOutput:InternalError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:RemoveIdentityOutput)
    * 
    * Defined at auth.service.pfm @ 131:73
    */
  final case class InternalErrorRef(
    value: _root_.io.protoforce.guide.auth.InternalError
  ) extends RemoveIdentityOutput.InternalErrorRef.Defn
  
  /**
    * DTO io.protoforce.guide.auth.authprotectedservice.models/RemoveIdentityOutput:NotFoundError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:RemoveIdentityOutput)
    * 
    * Defined at auth.service.pfm @ 131:106
    */
  final case class NotFoundErrorRef(
    value: _root_.io.protoforce.guide.auth.NotFoundError
  ) extends RemoveIdentityOutput.NotFoundErrorRef.Defn
  
  /**
    * DTO io.protoforce.guide.auth.authprotectedservice.models/RemoveIdentityOutput:ForbiddenError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:RemoveIdentityOutput)
    * 
    * Defined at auth.service.pfm @ 131:89
    */
  final case class ForbiddenErrorRef(
    value: _root_.io.protoforce.guide.auth.ForbiddenError
  ) extends RemoveIdentityOutput.ForbiddenErrorRef.Defn
  
  object InternalErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authprotectedservice.models/RemoveIdentityOutput:InternalError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:RemoveIdentityOutput)
      * 
      * Defined at auth.service.pfm @ 131:73
      */
    sealed trait Defn extends RemoveIdentityOutput {
      def value: _root_.io.protoforce.guide.auth.InternalError
    }
    
    implicit final class Conversions(
      val _value: RemoveIdentityOutput.InternalErrorRef
    ) extends _root_.izumi.idealingua.runtime.IRTConversions[RemoveIdentityOutput.InternalErrorRef]
    
    implicit val InternalError_random: IRTRandomGen[RemoveIdentityOutput.InternalErrorRef] = new IRTRandomGen[RemoveIdentityOutput.InternalErrorRef]{
      def id: String = "io.protoforce.guide.auth.authprotectedservice.models/RemoveIdentityOutput:InternalError"
      def makeRandom(_random: Random, _path: List[String]): RemoveIdentityOutput.InternalErrorRef = new RemoveIdentityOutput.InternalErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.InternalError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val InternalError_meta: IRTMetadata[RemoveIdentityOutput.InternalErrorRef] = new IRTMetadata[RemoveIdentityOutput.InternalErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models/RemoveIdentityOutput:InternalError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("d498d78579c5395258cc7af9bca2cc0ce8788f34bd3c2225c287b0fb2d233df3"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("a23aa40591af278ff812cfc97349a6dd1533a0a1007b7391f072933fbe1d5922"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:InternalError
      */
    def apply(message: String): RemoveIdentityOutput.InternalErrorRef = new RemoveIdentityOutput.InternalErrorRef(new _root_.io.protoforce.guide.auth.InternalError(
      message = message
    ))
  }
  
  object NotFoundErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authprotectedservice.models/RemoveIdentityOutput:NotFoundError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:RemoveIdentityOutput)
      * 
      * Defined at auth.service.pfm @ 131:106
      */
    sealed trait Defn extends RemoveIdentityOutput {
      def value: _root_.io.protoforce.guide.auth.NotFoundError
    }
    
    implicit final class Conversions(
      val _value: RemoveIdentityOutput.NotFoundErrorRef
    ) extends _root_.izumi.idealingua.runtime.IRTConversions[RemoveIdentityOutput.NotFoundErrorRef]
    
    implicit val NotFoundError_random: IRTRandomGen[RemoveIdentityOutput.NotFoundErrorRef] = new IRTRandomGen[RemoveIdentityOutput.NotFoundErrorRef]{
      def id: String = "io.protoforce.guide.auth.authprotectedservice.models/RemoveIdentityOutput:NotFoundError"
      def makeRandom(_random: Random, _path: List[String]): RemoveIdentityOutput.NotFoundErrorRef = new RemoveIdentityOutput.NotFoundErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.NotFoundError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val NotFoundError_meta: IRTMetadata[RemoveIdentityOutput.NotFoundErrorRef] = new IRTMetadata[RemoveIdentityOutput.NotFoundErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models/RemoveIdentityOutput:NotFoundError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("cbcf7f1bf38aa714693284ce9fb7156a3d5e8ea3b722c14b49bd7958f5e7a96a"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("d625b642ef9d6fbf6d366577efc7cdf22e7ecbae72369d7b16ba2c0087cb356c"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:NotFoundError
      */
    def apply(message: String): RemoveIdentityOutput.NotFoundErrorRef = new RemoveIdentityOutput.NotFoundErrorRef(new _root_.io.protoforce.guide.auth.NotFoundError(
      message = message
    ))
  }
  
  object ForbiddenErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authprotectedservice.models/RemoveIdentityOutput:ForbiddenError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:RemoveIdentityOutput)
      * 
      * Defined at auth.service.pfm @ 131:89
      */
    sealed trait Defn extends RemoveIdentityOutput {
      def value: _root_.io.protoforce.guide.auth.ForbiddenError
    }
    
    implicit final class Conversions(
      val _value: RemoveIdentityOutput.ForbiddenErrorRef
    ) extends _root_.izumi.idealingua.runtime.IRTConversions[RemoveIdentityOutput.ForbiddenErrorRef]
    
    implicit val ForbiddenError_random: IRTRandomGen[RemoveIdentityOutput.ForbiddenErrorRef] = new IRTRandomGen[RemoveIdentityOutput.ForbiddenErrorRef]{
      def id: String = "io.protoforce.guide.auth.authprotectedservice.models/RemoveIdentityOutput:ForbiddenError"
      def makeRandom(_random: Random, _path: List[String]): RemoveIdentityOutput.ForbiddenErrorRef = new RemoveIdentityOutput.ForbiddenErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.ForbiddenError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val ForbiddenError_meta: IRTMetadata[RemoveIdentityOutput.ForbiddenErrorRef] = new IRTMetadata[RemoveIdentityOutput.ForbiddenErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models/RemoveIdentityOutput:ForbiddenError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("8757f73b1f13e1b2a9ea53a322d0df9b0092fc2617b04226749b0fa5baf84335"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("598da348b2ae95d3e7726ba7d2321e4507dfa35b6d1bcbc7541bc1fa163cd2cf"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:ForbiddenError
      */
    def apply(message: String): RemoveIdentityOutput.ForbiddenErrorRef = new RemoveIdentityOutput.ForbiddenErrorRef(new _root_.io.protoforce.guide.auth.ForbiddenError(
      message = message
    ))
  }
  
  implicit val RemoveIdentityOutput_random: IRTRandomGen[RemoveIdentityOutput] = new IRTRandomGen[RemoveIdentityOutput]{
    def id: String = "io.protoforce.guide.auth.authprotectedservice.models:RemoveIdentityOutput"
    def makeRandom(_random: Random, _path: List[String]): RemoveIdentityOutput = {
      val _all = List(
        IRTRandomGen[RemoveIdentityOutput.InternalErrorRef].widen[RemoveIdentityOutput],
        IRTRandomGen[RemoveIdentityOutput.ForbiddenErrorRef].widen[RemoveIdentityOutput],
        IRTRandomGen[RemoveIdentityOutput.NotFoundErrorRef].widen[RemoveIdentityOutput]
      )
      IRTRandomGen._safeChoose[RemoveIdentityOutput](_all, _path :+ this.id, _random)
    }
  }
  
  implicit val RemoveIdentityOutput_meta: IRTMetadata[RemoveIdentityOutput] = new IRTMetadata[RemoveIdentityOutput]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models:RemoveIdentityOutput"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("34999d4b176eb07e76d69d21a7966a6c19dfd89705f03a70ebcb66116591817a"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("871f6974ec2dcddb82551610a0f66ec18452eb1ac135e11742061245a4417cac"))
  }
}