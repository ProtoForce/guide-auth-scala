package io.protoforce.guide.auth.authservice.models

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
  *  Confirm phone number
  * 
  * DTO io.protoforce.guide.auth.authservice.models:ConfirmPhoneInput
  * 
  * Defined at auth.service.pfm @ 88:3
  */
final case class ConfirmPhoneInput(
  code: String,
  phone: String
) extends ConfirmPhoneInput.Defn

object ConfirmPhoneInput {
  /**
    * 
    *  Confirm phone number
    * 
    * DTO io.protoforce.guide.auth.authservice.models:ConfirmPhoneInput
    * 
    * Defined at auth.service.pfm @ 88:3
    */
  trait Defn {
    def code: String
    def phone: String
  }
  
  implicit final class Conversions(
    val _value: ConfirmPhoneInput
  ) extends _root_.io.protoforce.runtime.IRTConversions[ConfirmPhoneInput]
  
  implicit val ConfirmPhoneInput_random: IRTRandomGen[ConfirmPhoneInput] = new IRTRandomGen[ConfirmPhoneInput]{
    def id: String = "io.protoforce.guide.auth.authservice.models:ConfirmPhoneInput"
    def makeRandom(_random: Random, _path: List[String]): ConfirmPhoneInput = new ConfirmPhoneInput(
      code = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
      phone = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val ConfirmPhoneInput_meta: IRTMetadata[ConfirmPhoneInput] = new IRTMetadata[ConfirmPhoneInput]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authservice.models:ConfirmPhoneInput"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("74a49e4b7d54fe369002e240f48af9c329e652fb728a2ba34a9b0e9f69ced17d"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("d79f5190f039de409234f2090c9e633d1e63e32d1c46f789a80ff10700cd69e1"))
  }
}