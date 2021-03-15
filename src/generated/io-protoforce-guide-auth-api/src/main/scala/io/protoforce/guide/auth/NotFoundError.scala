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
  *  Not Found Error: returned when an entity requested is not found
  * 
  * DTO io.protoforce.guide.auth:NotFoundError
  * 
  * Defined at errors.pfm @ 14:1
  */
class NotFoundError(
  override val message: String
) extends IRTErrorAuth(message)

object NotFoundError {
  implicit final class Conversions(
    val _value: NotFoundError
  ) extends _root_.izumi.idealingua.runtime.IRTConversions[NotFoundError]
  
  /**
    * conversion:nominal-sibling-upcast
    */
  implicit object Copy_NotFoundError_to_InternalError_Upcast_Reliable_1868494215 extends _root_.izumi.idealingua.runtime.IRTCast[NotFoundError, InternalError] {
    def convert(from: NotFoundError): InternalError = new InternalError(
      message = from.message
    )
  }
  
  /**
    * conversion:nominal-sibling-upcast
    */
  implicit object Copy_NotFoundError_to_ForbiddenError_Upcast_Reliable_1051322083 extends _root_.izumi.idealingua.runtime.IRTCast[NotFoundError, ForbiddenError] {
    def convert(from: NotFoundError): ForbiddenError = new ForbiddenError(
      message = from.message
    )
  }
  
  /**
    * conversion:nominal-sibling-upcast
    */
  implicit object Copy_NotFoundError_to_AlreadyExistsError_Upcast_Reliable_1645732128 extends _root_.izumi.idealingua.runtime.IRTCast[NotFoundError, AlreadyExistsError] {
    def convert(from: NotFoundError): AlreadyExistsError = new AlreadyExistsError(
      message = from.message
    )
  }
  
  /**
    * conversion:nominal-structure-upcast
    */
  implicit object Copy_NotFoundError_to_IRTErrorAuth_Upcast_Reliable_1455554942 extends _root_.izumi.idealingua.runtime.IRTCast[NotFoundError, IRTErrorAuth] {
    def convert(from: NotFoundError): IRTErrorAuth = new IRTErrorAuth(
      message = from.message
    )
  }
  
  implicit val NotFoundError_random: IRTRandomGen[NotFoundError] = new IRTRandomGen[NotFoundError]{
    def id: String = "io.protoforce.guide.auth:NotFoundError"
    def makeRandom(_random: Random, _path: List[String]): NotFoundError = new NotFoundError(
      message = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val NotFoundError_meta: IRTMetadata[NotFoundError] = new IRTMetadata[NotFoundError]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:NotFoundError"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("905e3821a51942d2177d09d9672dfb851ba74e804d546f17760b358f03bb7ed8"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("bf83540db4e8ef317c998841740020a0fde324c4ef564f4394656fb05be3f70c"))
  }
  
  def apply(message: String): NotFoundError = new NotFoundError(
    message = message
  )
}