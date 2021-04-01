package io.protoforce.guide.auth

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
  *  Server Internal Error: returned when something goes wrong on the backend
  *  as a result of infrastructure problems, or some other unexpected exceptions.
  * 
  * DTO io.protoforce.guide.auth:InternalError
  * 
  * Defined at errors.pfm @ 6:1
  */
class InternalError(
  override val message: String
) extends IRTErrorAuth(message)

object InternalError {
  implicit final class Conversions(
    val _value: InternalError
  ) extends _root_.io.protoforce.runtime.IRTConversions[InternalError]
  
  /**
    * conversion:nominal-sibling-upcast
    */
  implicit object Copy_InternalError_to_NotFoundError_Upcast_Reliable_1868494215 extends _root_.io.protoforce.runtime.IRTCast[InternalError, NotFoundError] {
    def convert(from: InternalError): NotFoundError = new NotFoundError(
      message = from.message
    )
  }
  
  /**
    * conversion:nominal-structure-upcast
    */
  implicit object Copy_InternalError_to_IRTErrorAuth_Upcast_Reliable_319539531 extends _root_.io.protoforce.runtime.IRTCast[InternalError, IRTErrorAuth] {
    def convert(from: InternalError): IRTErrorAuth = new IRTErrorAuth(
      message = from.message
    )
  }
  
  /**
    * conversion:nominal-sibling-upcast
    */
  implicit object Copy_InternalError_to_ForbiddenError_Upcast_Reliable_1468550740 extends _root_.io.protoforce.runtime.IRTCast[InternalError, ForbiddenError] {
    def convert(from: InternalError): ForbiddenError = new ForbiddenError(
      message = from.message
    )
  }
  
  /**
    * conversion:nominal-sibling-upcast
    */
  implicit object Copy_InternalError_to_AlreadyExistsError_Upcast_Reliable_129362345 extends _root_.io.protoforce.runtime.IRTCast[InternalError, AlreadyExistsError] {
    def convert(from: InternalError): AlreadyExistsError = new AlreadyExistsError(
      message = from.message
    )
  }
  
  implicit val InternalError_random: IRTRandomGen[InternalError] = new IRTRandomGen[InternalError]{
    def id: String = "io.protoforce.guide.auth:InternalError"
    def makeRandom(_random: Random, _path: List[String]): InternalError = new InternalError(
      message = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val InternalError_meta: IRTMetadata[InternalError] = new IRTMetadata[InternalError]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:InternalError"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("d69b74030a56a78549ee70fab181283bc3442a93b781842fb79f836fea949277"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("979a5411b050a917fd3b14a4c137033da2b6859fcf6911ecdf3ec431e0ee2795"))
  }
  
  def apply(message: String): InternalError = new InternalError(
    message = message
  )
}