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
  *  Add secondary identity
  * 
  * DTO io.protoforce.guide.auth.authprotectedservice.models:AddIdentityInput
  * 
  * Defined at auth.service.pfm @ 126:3
  */
final case class AddIdentityInput(
  identity: SecondaryIdentity
) extends AddIdentityInput.Defn

object AddIdentityInput {
  /**
    * 
    *  Add secondary identity
    * 
    * DTO io.protoforce.guide.auth.authprotectedservice.models:AddIdentityInput
    * 
    * Defined at auth.service.pfm @ 126:3
    */
  trait Defn {
    def identity: SecondaryIdentity
  }
  
  implicit final class Conversions(
    val _value: AddIdentityInput
  ) extends _root_.izumi.idealingua.runtime.IRTConversions[AddIdentityInput]
  
  implicit val AddIdentityInput_random: IRTRandomGen[AddIdentityInput] = new IRTRandomGen[AddIdentityInput]{
    def id: String = "io.protoforce.guide.auth.authprotectedservice.models:AddIdentityInput"
    def makeRandom(_random: Random, _path: List[String]): AddIdentityInput = new AddIdentityInput(
      identity = IRTRandomGen[SecondaryIdentity].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val AddIdentityInput_meta: IRTMetadata[AddIdentityInput] = new IRTMetadata[AddIdentityInput]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models:AddIdentityInput"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("c6e63f8782827892d3e9cae761fde10f7757658bb63618e654fbd265d305642a"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("fe628018ef62dffd49e46a7ed2d97b4ab6cb9212785f20bbadfc7dbd77c0b305"))
  }
}