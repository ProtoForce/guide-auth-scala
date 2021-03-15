package io.protoforce.guide.auth.authprotectedservice.models

import _root_.io.protoforce.guide.auth.SecondaryIdentity
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
  *  Remove secondary identity
  * 
  * DTO io.protoforce.guide.auth.authprotectedservice.models:RemoveIdentityInput
  * 
  * Defined at auth.service.pfm @ 131:3
  */
final case class RemoveIdentityInput(
  identity: SecondaryIdentity
) extends RemoveIdentityInput.Defn

object RemoveIdentityInput {
  /**
    * 
    *  Remove secondary identity
    * 
    * DTO io.protoforce.guide.auth.authprotectedservice.models:RemoveIdentityInput
    * 
    * Defined at auth.service.pfm @ 131:3
    */
  trait Defn {
    def identity: SecondaryIdentity
  }
  
  implicit final class Conversions(
    val _value: RemoveIdentityInput
  ) extends _root_.izumi.idealingua.runtime.IRTConversions[RemoveIdentityInput]
  
  implicit val RemoveIdentityInput_random: IRTRandomGen[RemoveIdentityInput] = new IRTRandomGen[RemoveIdentityInput]{
    def id: String = "io.protoforce.guide.auth.authprotectedservice.models:RemoveIdentityInput"
    def makeRandom(_random: Random, _path: List[String]): RemoveIdentityInput = new RemoveIdentityInput(
      identity = IRTRandomGen[SecondaryIdentity].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val RemoveIdentityInput_meta: IRTMetadata[RemoveIdentityInput] = new IRTMetadata[RemoveIdentityInput]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models:RemoveIdentityInput"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("254ce8cdb6477be08251513e3a22cf37cd44633e41988a60197ada73a47da657"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("5474c4b8d8ea632f19064775d773141ebcdc0bcce7f12a14a088b29136ab4962"))
  }
}