package io.protoforce.guide.auth

import _root_.izumi.idealingua.model.versioning.IRTSchema.{
  TypeBaseVersion,
  TypeFullVersion
}
import _root_.izumi.idealingua.runtime.{
  IRTException,
  IRTMetadata,
  IRTRandomGen,
  IRTTypeId
}
import _root_.scala.List
import _root_.scala.Predef.String
import _root_.scala.util.Random

/**
  * DTO io.protoforce.guide.auth:IRTErrorAuth
  */
class IRTErrorAuth(
  override val message: String
) extends IRTException(message)

object IRTErrorAuth {
  implicit final class Conversions(
    val _value: IRTErrorAuth
  ) extends _root_.izumi.idealingua.runtime.IRTConversions[IRTErrorAuth]
  
  /**
    * conversion:nominal-structure-downcast
    */
  implicit object Copy_IRTErrorAuth_to_NotFoundError_Downcast_Reliable_1455554942 extends _root_.izumi.idealingua.runtime.IRTCast[IRTErrorAuth, NotFoundError] {
    def convert(from: IRTErrorAuth): NotFoundError = new NotFoundError(
      message = from.message
    )
  }
  
  /**
    * conversion:nominal-structure-downcast
    */
  implicit object Copy_IRTErrorAuth_to_InternalError_Downcast_Reliable_319539531 extends _root_.izumi.idealingua.runtime.IRTCast[IRTErrorAuth, InternalError] {
    def convert(from: IRTErrorAuth): InternalError = new InternalError(
      message = from.message
    )
  }
  
  /**
    * conversion:nominal-structure-downcast
    */
  implicit object Copy_IRTErrorAuth_to_AlreadyExistsError_Downcast_Reliable_542301618 extends _root_.izumi.idealingua.runtime.IRTCast[IRTErrorAuth, AlreadyExistsError] {
    def convert(from: IRTErrorAuth): AlreadyExistsError = new AlreadyExistsError(
      message = from.message
    )
  }
  
  /**
    * conversion:nominal-structure-downcast
    */
  implicit object Copy_IRTErrorAuth_to_ForbiddenError_Downcast_Reliable_1055611467 extends _root_.izumi.idealingua.runtime.IRTCast[IRTErrorAuth, ForbiddenError] {
    def convert(from: IRTErrorAuth): ForbiddenError = new ForbiddenError(
      message = from.message
    )
  }
  
  implicit val IRTErrorAuth_random: IRTRandomGen[IRTErrorAuth] = new IRTRandomGen[IRTErrorAuth]{
    def id: String = "io.protoforce.guide.auth:IRTErrorAuth"
    def makeRandom(_random: Random, _path: List[String]): IRTErrorAuth = new IRTErrorAuth(
      message = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val IRTErrorAuth_meta: IRTMetadata[IRTErrorAuth] = new IRTMetadata[IRTErrorAuth]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:IRTErrorAuth"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("52c920b4064a75f0b7201fe128e55762a235887cb92dac541bb7de0d00cd652e"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("558a1f824d8d25569c23ac31aabf31ea2bd593479a95876433095e7b47d524df"))
  }
  
  def apply(message: String): IRTErrorAuth = new IRTErrorAuth(
    message = message
  )
}