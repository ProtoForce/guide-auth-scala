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
  *  Request two factor authentication
  * 
  * ADT io.protoforce.guide.auth.authprotectedservice.models:Request2FAOutput
  * 
  * Defined at auth.service.pfm @ 110:3
  */
sealed trait Request2FAOutput {
  
}

object Request2FAOutput {
  /**
    * DTO io.protoforce.guide.auth.authprotectedservice.models/Request2FAOutput:ForbiddenError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:Request2FAOutput)
    * 
    * Defined at auth.service.pfm @ 110:84
    */
  final case class ForbiddenErrorRef(
    value: _root_.io.protoforce.guide.auth.ForbiddenError
  ) extends Request2FAOutput.ForbiddenErrorRef.Defn
  
  /**
    * DTO io.protoforce.guide.auth.authprotectedservice.models/Request2FAOutput:InternalError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:Request2FAOutput)
    * 
    * Defined at auth.service.pfm @ 110:68
    */
  final case class InternalErrorRef(
    value: _root_.io.protoforce.guide.auth.InternalError
  ) extends Request2FAOutput.InternalErrorRef.Defn
  
  object ForbiddenErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authprotectedservice.models/Request2FAOutput:ForbiddenError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:Request2FAOutput)
      * 
      * Defined at auth.service.pfm @ 110:84
      */
    sealed trait Defn extends Request2FAOutput {
      def value: _root_.io.protoforce.guide.auth.ForbiddenError
    }
    
    implicit final class Conversions(
      val _value: Request2FAOutput.ForbiddenErrorRef
    ) extends _root_.io.protoforce.runtime.IRTConversions[Request2FAOutput.ForbiddenErrorRef]
    
    implicit val ForbiddenError_random: IRTRandomGen[Request2FAOutput.ForbiddenErrorRef] = new IRTRandomGen[Request2FAOutput.ForbiddenErrorRef]{
      def id: String = "io.protoforce.guide.auth.authprotectedservice.models/Request2FAOutput:ForbiddenError"
      def makeRandom(_random: Random, _path: List[String]): Request2FAOutput.ForbiddenErrorRef = new Request2FAOutput.ForbiddenErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.ForbiddenError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val ForbiddenError_meta: IRTMetadata[Request2FAOutput.ForbiddenErrorRef] = new IRTMetadata[Request2FAOutput.ForbiddenErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models/Request2FAOutput:ForbiddenError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("86b9a62a3af67ab33683ae4307588e308288ac7bdec34a9fe4eca5ac3b539392"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("f83e12f8998c030c90ca2fd33e5dd42287dad16decb123d725bae65353bad978"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:ForbiddenError
      */
    def apply(message: String): Request2FAOutput.ForbiddenErrorRef = new Request2FAOutput.ForbiddenErrorRef(new _root_.io.protoforce.guide.auth.ForbiddenError(
      message = message
    ))
  }
  
  object InternalErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authprotectedservice.models/Request2FAOutput:InternalError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:Request2FAOutput)
      * 
      * Defined at auth.service.pfm @ 110:68
      */
    sealed trait Defn extends Request2FAOutput {
      def value: _root_.io.protoforce.guide.auth.InternalError
    }
    
    implicit final class Conversions(
      val _value: Request2FAOutput.InternalErrorRef
    ) extends _root_.io.protoforce.runtime.IRTConversions[Request2FAOutput.InternalErrorRef]
    
    implicit val InternalError_random: IRTRandomGen[Request2FAOutput.InternalErrorRef] = new IRTRandomGen[Request2FAOutput.InternalErrorRef]{
      def id: String = "io.protoforce.guide.auth.authprotectedservice.models/Request2FAOutput:InternalError"
      def makeRandom(_random: Random, _path: List[String]): Request2FAOutput.InternalErrorRef = new Request2FAOutput.InternalErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.InternalError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val InternalError_meta: IRTMetadata[Request2FAOutput.InternalErrorRef] = new IRTMetadata[Request2FAOutput.InternalErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models/Request2FAOutput:InternalError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("4d53017cc2b18415e9f3d328fb2d93cc8fd7b6ceded01eb5cd1b7c6a4dd20a34"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("f7f17f9b90fdf5887f14c0338203aac643d07c63b8c1f1c9305a3e678c0fd77a"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:InternalError
      */
    def apply(message: String): Request2FAOutput.InternalErrorRef = new Request2FAOutput.InternalErrorRef(new _root_.io.protoforce.guide.auth.InternalError(
      message = message
    ))
  }
  
  implicit val Request2FAOutput_random: IRTRandomGen[Request2FAOutput] = new IRTRandomGen[Request2FAOutput]{
    def id: String = "io.protoforce.guide.auth.authprotectedservice.models:Request2FAOutput"
    def makeRandom(_random: Random, _path: List[String]): Request2FAOutput = {
      val _all = List(
        IRTRandomGen[Request2FAOutput.InternalErrorRef].widen[Request2FAOutput],
        IRTRandomGen[Request2FAOutput.ForbiddenErrorRef].widen[Request2FAOutput]
      )
      IRTRandomGen._safeChoose[Request2FAOutput](_all, _path :+ this.id, _random)
    }
  }
  
  implicit val Request2FAOutput_meta: IRTMetadata[Request2FAOutput] = new IRTMetadata[Request2FAOutput]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models:Request2FAOutput"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("7515048237c9971d7193a8633c24a9ba04f569c7bcffa841a09220980f4c68de"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("b76f3566a2273b414d7a066f821f57c1dab033179ebd90f765cd5dfd057d30b9"))
  }
}