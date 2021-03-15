package io.protoforce.guide.auth.authservice.models

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
  *  Confirm email
  * 
  * DTO io.protoforce.guide.auth.authservice.models:ConfirmEmailInput
  * 
  * Defined at auth.service.pfm @ 83:3
  */
final case class ConfirmEmailInput(
  code: String
) extends ConfirmEmailInput.Defn

object ConfirmEmailInput {
  /**
    * 
    *  Confirm email
    * 
    * DTO io.protoforce.guide.auth.authservice.models:ConfirmEmailInput
    * 
    * Defined at auth.service.pfm @ 83:3
    */
  trait Defn {
    def code: String
  }
  
  implicit final class Conversions(
    val _value: ConfirmEmailInput
  ) extends _root_.izumi.idealingua.runtime.IRTConversions[ConfirmEmailInput]
  
  implicit val ConfirmEmailInput_random: IRTRandomGen[ConfirmEmailInput] = new IRTRandomGen[ConfirmEmailInput]{
    def id: String = "io.protoforce.guide.auth.authservice.models:ConfirmEmailInput"
    def makeRandom(_random: Random, _path: List[String]): ConfirmEmailInput = new ConfirmEmailInput(
      code = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val ConfirmEmailInput_meta: IRTMetadata[ConfirmEmailInput] = new IRTMetadata[ConfirmEmailInput]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authservice.models:ConfirmEmailInput"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("9de7d27a44bcc373b995412b7af783def020dccdaf198980641f21629420d0db"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("36ebc75c59e2e6386b271e829e5c224eff47fffcce871fc6651f528c3344e615"))
  }
}