package io.protoforce.guide.auth

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
  *  Forbidden Error: whenever a user is not authorized to use a method
  * 
  * DTO io.protoforce.guide.auth:ForbiddenError
  * 
  * Defined at errors.pfm @ 30:1
  */
class ForbiddenError(
  override val message: String
) extends IRTErrorAuth(message)

object ForbiddenError {
  implicit final class Conversions(
    val _value: ForbiddenError
  ) extends _root_.izumi.idealingua.runtime.IRTConversions[ForbiddenError]
  
  /**
    * conversion:nominal-sibling-upcast
    */
  implicit object Copy_ForbiddenError_to_AlreadyExistsError_Upcast_Reliable_1245788653 extends _root_.izumi.idealingua.runtime.IRTCast[ForbiddenError, AlreadyExistsError] {
    def convert(from: ForbiddenError): AlreadyExistsError = new AlreadyExistsError(
      message = from.message
    )
  }
  
  /**
    * conversion:nominal-sibling-upcast
    */
  implicit object Copy_ForbiddenError_to_NotFoundError_Upcast_Reliable_1051322083 extends _root_.izumi.idealingua.runtime.IRTCast[ForbiddenError, NotFoundError] {
    def convert(from: ForbiddenError): NotFoundError = new NotFoundError(
      message = from.message
    )
  }
  
  /**
    * conversion:nominal-sibling-upcast
    */
  implicit object Copy_ForbiddenError_to_InternalError_Upcast_Reliable_1468550740 extends _root_.izumi.idealingua.runtime.IRTCast[ForbiddenError, InternalError] {
    def convert(from: ForbiddenError): InternalError = new InternalError(
      message = from.message
    )
  }
  
  /**
    * conversion:nominal-structure-upcast
    */
  implicit object Copy_ForbiddenError_to_IRTErrorAuth_Upcast_Reliable_1055611467 extends _root_.izumi.idealingua.runtime.IRTCast[ForbiddenError, IRTErrorAuth] {
    def convert(from: ForbiddenError): IRTErrorAuth = new IRTErrorAuth(
      message = from.message
    )
  }
  
  implicit val ForbiddenError_random: IRTRandomGen[ForbiddenError] = new IRTRandomGen[ForbiddenError]{
    def id: String = "io.protoforce.guide.auth:ForbiddenError"
    def makeRandom(_random: Random, _path: List[String]): ForbiddenError = new ForbiddenError(
      message = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val ForbiddenError_meta: IRTMetadata[ForbiddenError] = new IRTMetadata[ForbiddenError]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:ForbiddenError"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("3e6debb8c022c02b75c1659f1626272241aa8c6d31439977ad500f4bb71b32e2"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("83bd3eae92a4da96283356ffc9ee29182e80deb966e0dda7408cd607183c5b09"))
  }
  
  def apply(message: String): ForbiddenError = new ForbiddenError(
    message = message
  )
}