package io.protoforce.guide.auth.authservice.models

import _root_.io.protoforce.guide.auth.UserLookup
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
  *  Reset password
  * 
  * DTO io.protoforce.guide.auth.authservice.models:ResetPasswordInput
  * 
  * Defined at auth.service.pfm @ 93:3
  */
final case class ResetPasswordInput(
  lookup: UserLookup
) extends ResetPasswordInput.Defn

object ResetPasswordInput {
  /**
    * 
    *  Reset password
    * 
    * DTO io.protoforce.guide.auth.authservice.models:ResetPasswordInput
    * 
    * Defined at auth.service.pfm @ 93:3
    */
  trait Defn {
    def lookup: UserLookup
  }
  
  implicit final class Conversions(
    val _value: ResetPasswordInput
  ) extends _root_.izumi.idealingua.runtime.IRTConversions[ResetPasswordInput]
  
  implicit val ResetPasswordInput_random: IRTRandomGen[ResetPasswordInput] = new IRTRandomGen[ResetPasswordInput]{
    def id: String = "io.protoforce.guide.auth.authservice.models:ResetPasswordInput"
    def makeRandom(_random: Random, _path: List[String]): ResetPasswordInput = new ResetPasswordInput(
      lookup = IRTRandomGen[UserLookup].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val ResetPasswordInput_meta: IRTMetadata[ResetPasswordInput] = new IRTMetadata[ResetPasswordInput]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authservice.models:ResetPasswordInput"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("d6de2a289f3325a35895860fd77f4430e291b5e71f5e30fb48b67647c6c7b2b7"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("e197e5a656a5df3b57089848b31cb179ec567dbd1d9a982f7a427c28b32703bd"))
  }
}