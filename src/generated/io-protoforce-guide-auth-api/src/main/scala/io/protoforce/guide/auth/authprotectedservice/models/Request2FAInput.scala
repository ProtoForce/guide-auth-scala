package io.protoforce.guide.auth.authprotectedservice.models

import _root_.io.protoforce.guide.auth.MFAMethodRequest
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
  *  Request two factor authentication
  * 
  * DTO io.protoforce.guide.auth.authprotectedservice.models:Request2FAInput
  * 
  * Defined at auth.service.pfm @ 110:3
  */
final case class Request2FAInput(
  method: MFAMethodRequest
) extends Request2FAInput.Defn

object Request2FAInput {
  /**
    * 
    *  Request two factor authentication
    * 
    * DTO io.protoforce.guide.auth.authprotectedservice.models:Request2FAInput
    * 
    * Defined at auth.service.pfm @ 110:3
    */
  trait Defn {
    def method: MFAMethodRequest
  }
  
  implicit final class Conversions(
    val _value: Request2FAInput
  ) extends _root_.izumi.idealingua.runtime.IRTConversions[Request2FAInput]
  
  implicit val Request2FAInput_random: IRTRandomGen[Request2FAInput] = new IRTRandomGen[Request2FAInput]{
    def id: String = "io.protoforce.guide.auth.authprotectedservice.models:Request2FAInput"
    def makeRandom(_random: Random, _path: List[String]): Request2FAInput = new Request2FAInput(
      method = IRTRandomGen[MFAMethodRequest].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val Request2FAInput_meta: IRTMetadata[Request2FAInput] = new IRTMetadata[Request2FAInput]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models:Request2FAInput"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("8cd69f0e0a9215c4060ca883b40f13035b83163c8dfeed3a7b8c788767b13263"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("95746a49f7c2943e7316a79a9e50c430c0ffbc5626c96319218eceb319476fe6"))
  }
}