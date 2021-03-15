package io.protoforce.guide.auth.authprotectedservice.models

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
  *  Disable two factor authentication
  * 
  * DTO io.protoforce.guide.auth.authprotectedservice.models:Disable2FAInput
  * 
  * Defined at auth.service.pfm @ 120:3
  */
final case class Disable2FAInput(
  
) extends Disable2FAInput.Defn

object Disable2FAInput {
  /**
    * 
    *  Disable two factor authentication
    * 
    * DTO io.protoforce.guide.auth.authprotectedservice.models:Disable2FAInput
    * 
    * Defined at auth.service.pfm @ 120:3
    */
  trait Defn {
    
  }
  
  implicit final class Conversions(
    val _value: Disable2FAInput
  ) extends _root_.izumi.idealingua.runtime.IRTConversions[Disable2FAInput]
  
  implicit val Disable2FAInput_random: IRTRandomGen[Disable2FAInput] = new IRTRandomGen[Disable2FAInput]{
    def id: String = "io.protoforce.guide.auth.authprotectedservice.models:Disable2FAInput"
    def makeRandom(_random: Random, _path: List[String]): Disable2FAInput = new Disable2FAInput()
  }
  
  implicit val Disable2FAInput_meta: IRTMetadata[Disable2FAInput] = new IRTMetadata[Disable2FAInput]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models:Disable2FAInput"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("b9da698a5e8ef8cce4604e33641e308fbec6866ce3d76b06994a1e0a1052b3b9"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("2e1e31645dbb3a90d1c0b98ce802d0e020e4ca7d97d7ac02e2077c7fa527b5b9"))
  }
}