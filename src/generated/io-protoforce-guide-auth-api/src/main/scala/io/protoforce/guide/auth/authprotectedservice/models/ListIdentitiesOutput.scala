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
  *  List known identities
  * 
  * ADT io.protoforce.guide.auth.authprotectedservice.models:ListIdentitiesOutput
  * 
  * Defined at auth.service.pfm @ 136:3
  */
sealed trait ListIdentitiesOutput {
  
}

object ListIdentitiesOutput {
  /**
    * DTO io.protoforce.guide.auth.authprotectedservice.models/ListIdentitiesOutput:ForbiddenError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:ListIdentitiesOutput)
    * 
    * Defined at auth.service.pfm @ 136:63
    */
  final case class ForbiddenErrorRef(
    value: _root_.io.protoforce.guide.auth.ForbiddenError
  ) extends ListIdentitiesOutput.ForbiddenErrorRef.Defn
  
  /**
    * DTO io.protoforce.guide.auth.authprotectedservice.models/ListIdentitiesOutput:InternalError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:ListIdentitiesOutput)
    * 
    * Defined at auth.service.pfm @ 136:47
    */
  final case class InternalErrorRef(
    value: _root_.io.protoforce.guide.auth.InternalError
  ) extends ListIdentitiesOutput.InternalErrorRef.Defn
  
  object ForbiddenErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authprotectedservice.models/ListIdentitiesOutput:ForbiddenError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:ListIdentitiesOutput)
      * 
      * Defined at auth.service.pfm @ 136:63
      */
    sealed trait Defn extends ListIdentitiesOutput {
      def value: _root_.io.protoforce.guide.auth.ForbiddenError
    }
    
    implicit final class Conversions(
      val _value: ListIdentitiesOutput.ForbiddenErrorRef
    ) extends _root_.izumi.idealingua.runtime.IRTConversions[ListIdentitiesOutput.ForbiddenErrorRef]
    
    implicit val ForbiddenError_random: IRTRandomGen[ListIdentitiesOutput.ForbiddenErrorRef] = new IRTRandomGen[ListIdentitiesOutput.ForbiddenErrorRef]{
      def id: String = "io.protoforce.guide.auth.authprotectedservice.models/ListIdentitiesOutput:ForbiddenError"
      def makeRandom(_random: Random, _path: List[String]): ListIdentitiesOutput.ForbiddenErrorRef = new ListIdentitiesOutput.ForbiddenErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.ForbiddenError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val ForbiddenError_meta: IRTMetadata[ListIdentitiesOutput.ForbiddenErrorRef] = new IRTMetadata[ListIdentitiesOutput.ForbiddenErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models/ListIdentitiesOutput:ForbiddenError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("84769a7f9064db24441cc066c60c230aee073bab8ff29162dabf9ea8548facfd"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("d7890645d719a0b63b974e87100037985718b62abd26d0d51111578c5f53aeed"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:ForbiddenError
      */
    def apply(message: String): ListIdentitiesOutput.ForbiddenErrorRef = new ListIdentitiesOutput.ForbiddenErrorRef(new _root_.io.protoforce.guide.auth.ForbiddenError(
      message = message
    ))
  }
  
  object InternalErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authprotectedservice.models/ListIdentitiesOutput:InternalError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:ListIdentitiesOutput)
      * 
      * Defined at auth.service.pfm @ 136:47
      */
    sealed trait Defn extends ListIdentitiesOutput {
      def value: _root_.io.protoforce.guide.auth.InternalError
    }
    
    implicit final class Conversions(
      val _value: ListIdentitiesOutput.InternalErrorRef
    ) extends _root_.izumi.idealingua.runtime.IRTConversions[ListIdentitiesOutput.InternalErrorRef]
    
    implicit val InternalError_random: IRTRandomGen[ListIdentitiesOutput.InternalErrorRef] = new IRTRandomGen[ListIdentitiesOutput.InternalErrorRef]{
      def id: String = "io.protoforce.guide.auth.authprotectedservice.models/ListIdentitiesOutput:InternalError"
      def makeRandom(_random: Random, _path: List[String]): ListIdentitiesOutput.InternalErrorRef = new ListIdentitiesOutput.InternalErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.InternalError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val InternalError_meta: IRTMetadata[ListIdentitiesOutput.InternalErrorRef] = new IRTMetadata[ListIdentitiesOutput.InternalErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models/ListIdentitiesOutput:InternalError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("41098b84caeeded67d391f1700809fb6f3d36f063305ad66e1bad6128936f767"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("31c8496eb0373c5f1d23446af7c90e8b93bcd3f24dee9fd7fa7d07054ac93242"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:InternalError
      */
    def apply(message: String): ListIdentitiesOutput.InternalErrorRef = new ListIdentitiesOutput.InternalErrorRef(new _root_.io.protoforce.guide.auth.InternalError(
      message = message
    ))
  }
  
  implicit val ListIdentitiesOutput_random: IRTRandomGen[ListIdentitiesOutput] = new IRTRandomGen[ListIdentitiesOutput]{
    def id: String = "io.protoforce.guide.auth.authprotectedservice.models:ListIdentitiesOutput"
    def makeRandom(_random: Random, _path: List[String]): ListIdentitiesOutput = {
      val _all = List(
        IRTRandomGen[ListIdentitiesOutput.InternalErrorRef].widen[ListIdentitiesOutput],
        IRTRandomGen[ListIdentitiesOutput.ForbiddenErrorRef].widen[ListIdentitiesOutput]
      )
      IRTRandomGen._safeChoose[ListIdentitiesOutput](_all, _path :+ this.id, _random)
    }
  }
  
  implicit val ListIdentitiesOutput_meta: IRTMetadata[ListIdentitiesOutput] = new IRTMetadata[ListIdentitiesOutput]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models:ListIdentitiesOutput"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("b9a84e60d941475cdb3689457d4a3b20b8a5fb812304872d9338d9e0deefd432"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("5344a2bdcef5cc4c672f9935e0c8ad261930f670aa307de8b533834e59127615"))
  }
}