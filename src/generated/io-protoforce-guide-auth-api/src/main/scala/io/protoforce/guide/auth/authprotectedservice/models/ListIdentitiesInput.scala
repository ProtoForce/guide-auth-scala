package io.protoforce.guide.auth.authprotectedservice.models

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
  *  List known identities
  * 
  * DTO io.protoforce.guide.auth.authprotectedservice.models:ListIdentitiesInput
  * 
  * Defined at auth.service.pfm @ 136:3
  */
final case class ListIdentitiesInput(
  
) extends ListIdentitiesInput.Defn

object ListIdentitiesInput {
  /**
    * 
    *  List known identities
    * 
    * DTO io.protoforce.guide.auth.authprotectedservice.models:ListIdentitiesInput
    * 
    * Defined at auth.service.pfm @ 136:3
    */
  trait Defn {
    
  }
  
  implicit final class Conversions(
    val _value: ListIdentitiesInput
  ) extends _root_.io.protoforce.runtime.IRTConversions[ListIdentitiesInput]
  
  implicit val ListIdentitiesInput_random: IRTRandomGen[ListIdentitiesInput] = new IRTRandomGen[ListIdentitiesInput]{
    def id: String = "io.protoforce.guide.auth.authprotectedservice.models:ListIdentitiesInput"
    def makeRandom(_random: Random, _path: List[String]): ListIdentitiesInput = new ListIdentitiesInput()
  }
  
  implicit val ListIdentitiesInput_meta: IRTMetadata[ListIdentitiesInput] = new IRTMetadata[ListIdentitiesInput]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authprotectedservice.models:ListIdentitiesInput"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("2d380419d747d6122a1695b294cb1ef7406209e4476f0b28f94f562fa4ab72b0"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("0b3990167ea9f8f37dc0770b5fd11990b24c1670aff7893fd757c62fd0335ef6"))
  }
}