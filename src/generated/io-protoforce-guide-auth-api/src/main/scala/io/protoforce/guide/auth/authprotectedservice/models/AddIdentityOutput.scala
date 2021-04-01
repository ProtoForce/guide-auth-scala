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
  *  Add secondary identity
  * 
  * ADT io.protoforce.guide.auth.authprotectedservice.models:AddIdentityOutput
  * 
  * Defined at auth.service.pfm @ 126:3
  */
sealed trait AddIdentityOutput {
  
}

object AddIdentityOutput {
  /**
    * DTO io.protoforce.guide.auth.authprotectedservice.models/AddIdentityOutput:InternalError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:AddIdentityOutput)
    * 
    * Defined at auth.service.pfm @ 126:70
    */
  final case class InternalErrorRef(
    value: _root_.io.protoforce.guide.auth.InternalError
  ) extends AddIdentityOutput.InternalErrorRef.Defn
  
  /**
    * DTO io.protoforce.guide.auth.authprotectedservice.models/AddIdentityOutput:ForbiddenError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:AddIdentityOutput)
    * 
    * Defined at auth.service.pfm @ 126:86
    */
  final case class ForbiddenErrorRef(
    value: _root_.io.protoforce.guide.auth.ForbiddenError
  ) extends AddIdentityOutput.ForbiddenErrorRef.Defn
  
  /**
    * DTO io.protoforce.guide.auth.authprotectedservice.models/AddIdentityOutput:AlreadyExistsError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:AddIdentityOutput)
    * 
    * Defined at auth.service.pfm @ 126:103
    */
  final case class AlreadyExistsErrorRef(
    value: _root_.io.protoforce.guide.auth.AlreadyExistsError
  ) extends AddIdentityOutput.AlreadyExistsErrorRef.Defn
  
  object InternalErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authprotectedservice.models/AddIdentityOutput:InternalError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:AddIdentityOutput)
      * 
      * Defined at auth.service.pfm @ 126:70
      */
    sealed trait Defn extends AddIdentityOutput {
      def value: _root_.io.protoforce.guide.auth.InternalError
    }
    
    implicit final class Conversions(
      val _value: AddIdentityOutput.InternalErrorRef
    ) extends _root_.io.protoforce.runtime.IRTConversions[AddIdentityOutput.InternalErrorRef]
    
    implicit val InternalError_random: IRTRandomGen[AddIdentityOutput.InternalErrorRef] = new IRTRandomGen[AddIdentityOutput.InternalErrorRef]{
      def id: String = "io.protoforce.guide.auth.authprotectedservice.models/AddIdentityOutput:InternalError"
      def makeRandom(_random: Random, _path: List[String]): AddIdentityOutput.InternalErrorRef = new AddIdentityOutput.InternalErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.InternalError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val InternalError_meta: IRTMetadata[AddIdentityOutput.InternalErrorRef] = new IRTMetadata[AddIdentityOutput.InternalErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models/AddIdentityOutput:InternalError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("4872cd802bc67529ef1e19562059bb844fa2b12b9ebe146daf735e9fc9da19e1"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("e0fd70e98bf789c880d76adc64689ea270353d1a0750f89af05e25f7ed96cd63"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:InternalError
      */
    def apply(message: String): AddIdentityOutput.InternalErrorRef = new AddIdentityOutput.InternalErrorRef(new _root_.io.protoforce.guide.auth.InternalError(
      message = message
    ))
  }
  
  object ForbiddenErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authprotectedservice.models/AddIdentityOutput:ForbiddenError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:AddIdentityOutput)
      * 
      * Defined at auth.service.pfm @ 126:86
      */
    sealed trait Defn extends AddIdentityOutput {
      def value: _root_.io.protoforce.guide.auth.ForbiddenError
    }
    
    implicit final class Conversions(
      val _value: AddIdentityOutput.ForbiddenErrorRef
    ) extends _root_.io.protoforce.runtime.IRTConversions[AddIdentityOutput.ForbiddenErrorRef]
    
    implicit val ForbiddenError_random: IRTRandomGen[AddIdentityOutput.ForbiddenErrorRef] = new IRTRandomGen[AddIdentityOutput.ForbiddenErrorRef]{
      def id: String = "io.protoforce.guide.auth.authprotectedservice.models/AddIdentityOutput:ForbiddenError"
      def makeRandom(_random: Random, _path: List[String]): AddIdentityOutput.ForbiddenErrorRef = new AddIdentityOutput.ForbiddenErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.ForbiddenError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val ForbiddenError_meta: IRTMetadata[AddIdentityOutput.ForbiddenErrorRef] = new IRTMetadata[AddIdentityOutput.ForbiddenErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models/AddIdentityOutput:ForbiddenError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("00fd3b94feecef03614bb948bbb94b1e948c3c8a1fabb0b1005ada1d713d1ace"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("82041be6d38deb4478597ed2b2d5e4c7c401409a9195966479a5d13aa3737cf0"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:ForbiddenError
      */
    def apply(message: String): AddIdentityOutput.ForbiddenErrorRef = new AddIdentityOutput.ForbiddenErrorRef(new _root_.io.protoforce.guide.auth.ForbiddenError(
      message = message
    ))
  }
  
  object AlreadyExistsErrorRef {
    /**
      * DTO io.protoforce.guide.auth.authprotectedservice.models/AddIdentityOutput:AlreadyExistsError (reference member of ADT io.protoforce.guide.auth.authprotectedservice.models:AddIdentityOutput)
      * 
      * Defined at auth.service.pfm @ 126:103
      */
    sealed trait Defn extends AddIdentityOutput {
      def value: _root_.io.protoforce.guide.auth.AlreadyExistsError
    }
    
    implicit final class Conversions(
      val _value: AddIdentityOutput.AlreadyExistsErrorRef
    ) extends _root_.io.protoforce.runtime.IRTConversions[AddIdentityOutput.AlreadyExistsErrorRef]
    
    implicit val AlreadyExistsError_random: IRTRandomGen[AddIdentityOutput.AlreadyExistsErrorRef] = new IRTRandomGen[AddIdentityOutput.AlreadyExistsErrorRef]{
      def id: String = "io.protoforce.guide.auth.authprotectedservice.models/AddIdentityOutput:AlreadyExistsError"
      def makeRandom(_random: Random, _path: List[String]): AddIdentityOutput.AlreadyExistsErrorRef = new AddIdentityOutput.AlreadyExistsErrorRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.AlreadyExistsError].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val AlreadyExistsError_meta: IRTMetadata[AddIdentityOutput.AlreadyExistsErrorRef] = new IRTMetadata[AddIdentityOutput.AlreadyExistsErrorRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models/AddIdentityOutput:AlreadyExistsError"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("d8e51d24519e89a7aded7c7362216328e05e047eb91c3bc47c52feadbef87861"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("746601f62183166db1a12899aac6463ee5933dc0124cc6d40091a4fd67c3b47c"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:AlreadyExistsError
      */
    def apply(message: String): AddIdentityOutput.AlreadyExistsErrorRef = new AddIdentityOutput.AlreadyExistsErrorRef(new _root_.io.protoforce.guide.auth.AlreadyExistsError(
      message = message
    ))
  }
  
  implicit val AddIdentityOutput_random: IRTRandomGen[AddIdentityOutput] = new IRTRandomGen[AddIdentityOutput]{
    def id: String = "io.protoforce.guide.auth.authprotectedservice.models:AddIdentityOutput"
    def makeRandom(_random: Random, _path: List[String]): AddIdentityOutput = {
      val _all = List(
        IRTRandomGen[AddIdentityOutput.InternalErrorRef].widen[AddIdentityOutput],
        IRTRandomGen[AddIdentityOutput.ForbiddenErrorRef].widen[AddIdentityOutput],
        IRTRandomGen[AddIdentityOutput.AlreadyExistsErrorRef].widen[AddIdentityOutput]
      )
      IRTRandomGen._safeChoose[AddIdentityOutput](_all, _path :+ this.id, _random)
    }
  }
  
  implicit val AddIdentityOutput_meta: IRTMetadata[AddIdentityOutput] = new IRTMetadata[AddIdentityOutput]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models:AddIdentityOutput"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("b3d9b92737cdd41b98d7cf1a6adb610a50465b461473add7d6761530a682ba1d"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("faa1b28d5f0b9c192e39744d217b1540af8f6c34b07c71766bd82c1f3a7d9431"))
  }
}