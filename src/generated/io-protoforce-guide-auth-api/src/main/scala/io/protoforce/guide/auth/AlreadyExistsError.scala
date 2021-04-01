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
  *  Already Exists Error: an entity already exists
  * 
  * DTO io.protoforce.guide.auth:AlreadyExistsError
  * 
  * Defined at errors.pfm @ 22:1
  */
class AlreadyExistsError(
  override val message: String
) extends IRTErrorAuth(message)

object AlreadyExistsError {
  implicit final class Conversions(
    val _value: AlreadyExistsError
  ) extends _root_.io.protoforce.runtime.IRTConversions[AlreadyExistsError]
  
  /**
    * conversion:nominal-sibling-upcast
    */
  implicit object Copy_AlreadyExistsError_to_NotFoundError_Upcast_Reliable_1645732128 extends _root_.io.protoforce.runtime.IRTCast[AlreadyExistsError, NotFoundError] {
    def convert(from: AlreadyExistsError): NotFoundError = new NotFoundError(
      message = from.message
    )
  }
  
  /**
    * conversion:nominal-sibling-upcast
    */
  implicit object Copy_AlreadyExistsError_to_InternalError_Upcast_Reliable_129362345 extends _root_.io.protoforce.runtime.IRTCast[AlreadyExistsError, InternalError] {
    def convert(from: AlreadyExistsError): InternalError = new InternalError(
      message = from.message
    )
  }
  
  /**
    * conversion:nominal-sibling-upcast
    */
  implicit object Copy_AlreadyExistsError_to_ForbiddenError_Upcast_Reliable_1245788653 extends _root_.io.protoforce.runtime.IRTCast[AlreadyExistsError, ForbiddenError] {
    def convert(from: AlreadyExistsError): ForbiddenError = new ForbiddenError(
      message = from.message
    )
  }
  
  /**
    * conversion:nominal-structure-upcast
    */
  implicit object Copy_AlreadyExistsError_to_IRTErrorAuth_Upcast_Reliable_542301618 extends _root_.io.protoforce.runtime.IRTCast[AlreadyExistsError, IRTErrorAuth] {
    def convert(from: AlreadyExistsError): IRTErrorAuth = new IRTErrorAuth(
      message = from.message
    )
  }
  
  implicit val AlreadyExistsError_random: IRTRandomGen[AlreadyExistsError] = new IRTRandomGen[AlreadyExistsError]{
    def id: String = "io.protoforce.guide.auth:AlreadyExistsError"
    def makeRandom(_random: Random, _path: List[String]): AlreadyExistsError = new AlreadyExistsError(
      message = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val AlreadyExistsError_meta: IRTMetadata[AlreadyExistsError] = new IRTMetadata[AlreadyExistsError]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:AlreadyExistsError"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("c851dbe174820b657cf275ec24a815dbc0d363e55cedb5304de8166030601689"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("217e44add93bf4cbfce49d42476e61a4cebf1e7629330b412347f47544625775"))
  }
  
  def apply(message: String): AlreadyExistsError = new AlreadyExistsError(
    message = message
  )
}