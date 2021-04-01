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
  *  Change password
  * 
  * DTO io.protoforce.guide.auth.authservice.models:ChangePasswordInput
  * 
  * Defined at auth.service.pfm @ 98:3
  */
final case class ChangePasswordInput(
  changeToken: String,
  password: String
) extends ChangePasswordInput.Defn

object ChangePasswordInput {
  /**
    * 
    *  Change password
    * 
    * DTO io.protoforce.guide.auth.authservice.models:ChangePasswordInput
    * 
    * Defined at auth.service.pfm @ 98:3
    */
  trait Defn {
    def changeToken: String
    def password: String
  }
  
  implicit final class Conversions(
    val _value: ChangePasswordInput
  ) extends _root_.io.protoforce.runtime.IRTConversions[ChangePasswordInput]
  
  implicit val ChangePasswordInput_random: IRTRandomGen[ChangePasswordInput] = new IRTRandomGen[ChangePasswordInput]{
    def id: String = "io.protoforce.guide.auth.authservice.models:ChangePasswordInput"
    def makeRandom(_random: Random, _path: List[String]): ChangePasswordInput = new ChangePasswordInput(
      changeToken = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
      password = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val ChangePasswordInput_meta: IRTMetadata[ChangePasswordInput] = new IRTMetadata[ChangePasswordInput]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authservice.models:ChangePasswordInput"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("b2cb61e8c4d0db98ed52dacb91b01b8be84a8cf34c7468325d85c0fae202f5b2"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("0f10278706066ca69a2415cafbddf6789d8af1d58c3f3be87657c0b87cf4e179"))
  }
}