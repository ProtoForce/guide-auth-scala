package io.protoforce.guide.auth.authprotectedservice.models

import _root_.io.protoforce.guide.auth.MFAMethodConfirm
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
  *  Confirm two factor authentication
  * 
  * DTO io.protoforce.guide.auth.authprotectedservice.models:Confirm2FAInput
  * 
  * Defined at auth.service.pfm @ 115:3
  */
final case class Confirm2FAInput(
  method: MFAMethodConfirm
) extends Confirm2FAInput.Defn

object Confirm2FAInput {
  /**
    * 
    *  Confirm two factor authentication
    * 
    * DTO io.protoforce.guide.auth.authprotectedservice.models:Confirm2FAInput
    * 
    * Defined at auth.service.pfm @ 115:3
    */
  trait Defn {
    def method: MFAMethodConfirm
  }
  
  implicit final class Conversions(
    val _value: Confirm2FAInput
  ) extends _root_.io.protoforce.runtime.IRTConversions[Confirm2FAInput]
  
  implicit val Confirm2FAInput_random: IRTRandomGen[Confirm2FAInput] = new IRTRandomGen[Confirm2FAInput]{
    def id: String = "io.protoforce.guide.auth.authprotectedservice.models:Confirm2FAInput"
    def makeRandom(_random: Random, _path: List[String]): Confirm2FAInput = new Confirm2FAInput(
      method = IRTRandomGen[MFAMethodConfirm].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val Confirm2FAInput_meta: IRTMetadata[Confirm2FAInput] = new IRTMetadata[Confirm2FAInput]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models:Confirm2FAInput"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("1ea11d1af09b4c7d69a0cc0d173f89130454222292399342129a2a36fc89fefe"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("0b8444a30977f39deb8fb0e75268ec1dc694a26156689ad5ff72b924296b01e7"))
  }
}