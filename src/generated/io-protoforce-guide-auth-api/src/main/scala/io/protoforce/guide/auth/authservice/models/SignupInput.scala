package io.protoforce.guide.auth.authservice.models

import _root_.io.protoforce.guide.auth.SignUp
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
  *  Sign up for a service with provided credentials
  * 
  * DTO io.protoforce.guide.auth.authservice.models:SignupInput
  * 
  * Defined at auth.service.pfm @ 73:3
  */
final case class SignupInput(
  `with`: SignUp
) extends SignupInput.Defn

object SignupInput {
  /**
    * 
    *  Sign up for a service with provided credentials
    * 
    * DTO io.protoforce.guide.auth.authservice.models:SignupInput
    * 
    * Defined at auth.service.pfm @ 73:3
    */
  trait Defn {
    def `with`: SignUp
  }
  
  implicit final class Conversions(
    val _value: SignupInput
  ) extends _root_.io.protoforce.runtime.IRTConversions[SignupInput]
  
  implicit val SignupInput_random: IRTRandomGen[SignupInput] = new IRTRandomGen[SignupInput]{
    def id: String = "io.protoforce.guide.auth.authservice.models:SignupInput"
    def makeRandom(_random: Random, _path: List[String]): SignupInput = new SignupInput(
      `with` = IRTRandomGen[SignUp].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val SignupInput_meta: IRTMetadata[SignupInput] = new IRTMetadata[SignupInput]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authservice.models:SignupInput"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("699ee0ee1ad60eb50125b68ecc7421469e5e03f687fb3d7c78f6656e0e1f7a38"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("14f5ccf740b4ba305ab54ecc04110d7093a4791ada593701f49c93ed05c9eb3d"))
  }
}