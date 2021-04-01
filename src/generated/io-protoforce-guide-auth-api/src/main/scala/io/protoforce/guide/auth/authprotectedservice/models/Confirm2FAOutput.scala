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
  *  Confirm two factor authentication
  * 
  * ADT io.protoforce.guide.auth.authprotectedservice.models:Confirm2FAOutput
  * 
  * Defined at auth.service.pfm @ 115:3
  */
sealed trait Confirm2FAOutput {
  
}

object Confirm2FAOutput {
  /**
    * DTO io.protoforce.guide.auth.authprotectedservice.models/Confirm2FAOutput:ForbiddenError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:Confirm2FAOutput)
    * 
    * Defined at auth.service.pfm @ 115:82
    */
  final case class ForbiddenErrorRef(
    value: _root_.io.protoforce.guide.auth.ForbiddenError
  ) extends Confirm2FAOutput.ForbiddenErrorRef.Defn
  
  /**
    * DTO io.protoforce.guide.auth.authprotectedservice.models/Confirm2FAOutput:InternalError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:Confirm2FAOutput)
    * 
    * Defined at auth.service.pfm @ 115:66
    */
  final case class InternalErrorRef(
    value: _root_.io.protoforce.guide.auth.InternalError
  ) extends Confirm2FAOutput.InternalErrorRef.Defn
  
  object ForbiddenErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authprotectedservice.models/Confirm2FAOutput:ForbiddenError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:Confirm2FAOutput)
      * 
      * Defined at auth.service.pfm @ 115:82
      */
    sealed trait Defn extends Confirm2FAOutput {
      def value: _root_.io.protoforce.guide.auth.ForbiddenError
    }
    
    implicit final class Conversions(
      val _value: Confirm2FAOutput.ForbiddenErrorRef
    ) extends _root_.io.protoforce.runtime.IRTConversions[Confirm2FAOutput.ForbiddenErrorRef]
    
    implicit val ForbiddenError_random: IRTRandomGen[Confirm2FAOutput.ForbiddenErrorRef] = new IRTRandomGen[Confirm2FAOutput.ForbiddenErrorRef]{
      def id: String = "io.protoforce.guide.auth.authprotectedservice.models/Confirm2FAOutput:ForbiddenError"
      def makeRandom(_random: Random, _path: List[String]): Confirm2FAOutput.ForbiddenErrorRef = new Confirm2FAOutput.ForbiddenErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.ForbiddenError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val ForbiddenError_meta: IRTMetadata[Confirm2FAOutput.ForbiddenErrorRef] = new IRTMetadata[Confirm2FAOutput.ForbiddenErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models/Confirm2FAOutput:ForbiddenError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("b0f3d97e9a4b4cdb2da7e2b0e63e130d4b887815b80e51fb531484bf9cbfbf40"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("6356a6e4b316d78d82ea91e4f3411bb20ccdd76b681d99e77039c1dcb3beb8d2"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:ForbiddenError
      */
    def apply(message: String): Confirm2FAOutput.ForbiddenErrorRef = new Confirm2FAOutput.ForbiddenErrorRef(new _root_.io.protoforce.guide.auth.ForbiddenError(
      message = message
    ))
  }
  
  object InternalErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authprotectedservice.models/Confirm2FAOutput:InternalError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:Confirm2FAOutput)
      * 
      * Defined at auth.service.pfm @ 115:66
      */
    sealed trait Defn extends Confirm2FAOutput {
      def value: _root_.io.protoforce.guide.auth.InternalError
    }
    
    implicit final class Conversions(
      val _value: Confirm2FAOutput.InternalErrorRef
    ) extends _root_.io.protoforce.runtime.IRTConversions[Confirm2FAOutput.InternalErrorRef]
    
    implicit val InternalError_random: IRTRandomGen[Confirm2FAOutput.InternalErrorRef] = new IRTRandomGen[Confirm2FAOutput.InternalErrorRef]{
      def id: String = "io.protoforce.guide.auth.authprotectedservice.models/Confirm2FAOutput:InternalError"
      def makeRandom(_random: Random, _path: List[String]): Confirm2FAOutput.InternalErrorRef = new Confirm2FAOutput.InternalErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.InternalError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val InternalError_meta: IRTMetadata[Confirm2FAOutput.InternalErrorRef] = new IRTMetadata[Confirm2FAOutput.InternalErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models/Confirm2FAOutput:InternalError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("46c58132998db3f8f38fb0e1051b7a201b32ebfb86ebd4c248f34bae18edb729"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("51989568766cbeb72cd3cab39d511c7ba09868e798c93956058dcbeee6fe1052"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:InternalError
      */
    def apply(message: String): Confirm2FAOutput.InternalErrorRef = new Confirm2FAOutput.InternalErrorRef(new _root_.io.protoforce.guide.auth.InternalError(
      message = message
    ))
  }
  
  implicit val Confirm2FAOutput_random: IRTRandomGen[Confirm2FAOutput] = new IRTRandomGen[Confirm2FAOutput]{
    def id: String = "io.protoforce.guide.auth.authprotectedservice.models:Confirm2FAOutput"
    def makeRandom(_random: Random, _path: List[String]): Confirm2FAOutput = {
      val _all = List(
        IRTRandomGen[Confirm2FAOutput.InternalErrorRef].widen[Confirm2FAOutput],
        IRTRandomGen[Confirm2FAOutput.ForbiddenErrorRef].widen[Confirm2FAOutput]
      )
      IRTRandomGen._safeChoose[Confirm2FAOutput](_all, _path :+ this.id, _random)
    }
  }
  
  implicit val Confirm2FAOutput_meta: IRTMetadata[Confirm2FAOutput] = new IRTMetadata[Confirm2FAOutput]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models:Confirm2FAOutput"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("1056065c06f06e2021a097aae00b65a834827a7f581ce9b513bb27e88c47efc1"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("bd2778441bac1c721931deb4ab3af9e00e4d614b6b0e417cf9adffee6e39ac54"))
  }
}