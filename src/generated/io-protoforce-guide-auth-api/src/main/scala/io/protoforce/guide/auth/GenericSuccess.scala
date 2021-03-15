package io.protoforce.guide.auth

import _root_.izumi.idealingua.model.versioning.IRTSchema.{
  TypeBaseVersion,
  TypeFullVersion
}
import _root_.izumi.idealingua.runtime.{
  IRTMetadata,
  IRTRandomGen,
  IRTTypeId
}
import _root_.scala.{
  List,
  Option
}
import _root_.scala.Predef.String
import _root_.scala.util.Random

/**
  * 
  *  Generic success structure, with an optional message which can be used
  *  to display some feedback to the user on the action called
  * 
  * DTO io.protoforce.guide.auth:GenericSuccess
  * 
  * Defined at auth.service.pfm @ 15:1
  */
final case class GenericSuccess(
  message: Option[String]
) extends GenericSuccess.Defn

object GenericSuccess {
  /**
    * 
    *  Generic success structure, with an optional message which can be used
    *  to display some feedback to the user on the action called
    * 
    * DTO io.protoforce.guide.auth:GenericSuccess
    * 
    * Defined at auth.service.pfm @ 15:1
    */
  trait Defn {
    def message: Option[String]
  }
  
  implicit final class Conversions(
    val _value: GenericSuccess
  ) extends _root_.izumi.idealingua.runtime.IRTConversions[GenericSuccess]
  
  implicit val GenericSuccess_random: IRTRandomGen[GenericSuccess] = new IRTRandomGen[GenericSuccess]{
    def id: String = "io.protoforce.guide.auth:GenericSuccess"
    def makeRandom(_random: Random, _path: List[String]): GenericSuccess = new GenericSuccess(
      message = IRTRandomGen[Option[String]].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val GenericSuccess_meta: IRTMetadata[GenericSuccess] = new IRTMetadata[GenericSuccess]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:GenericSuccess"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("a46f8a890568ada13b823a0316899b4f204569085709b912627c253c86471923"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("ccf7aded42177324b3b08bf3df1b86d7a798ccac3b51ebcb5e2b5829c40480b1"))
  }
}