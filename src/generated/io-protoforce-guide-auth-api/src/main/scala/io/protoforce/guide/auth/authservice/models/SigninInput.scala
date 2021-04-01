package io.protoforce.guide.auth.authservice.models

import _root_.io.protoforce.guide.auth.SignIn
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
  *  Sign in with provided credentials
  * 
  * DTO io.protoforce.guide.auth.authservice.models:SigninInput
  * 
  * Defined at auth.service.pfm @ 78:3
  */
final case class SigninInput(
  `with`: SignIn
) extends SigninInput.Defn

object SigninInput {
  /**
    * 
    *  Sign in with provided credentials
    * 
    * DTO io.protoforce.guide.auth.authservice.models:SigninInput
    * 
    * Defined at auth.service.pfm @ 78:3
    */
  trait Defn {
    def `with`: SignIn
  }
  
  implicit final class Conversions(
    val _value: SigninInput
  ) extends _root_.io.protoforce.runtime.IRTConversions[SigninInput]
  
  implicit val SigninInput_random: IRTRandomGen[SigninInput] = new IRTRandomGen[SigninInput]{
    def id: String = "io.protoforce.guide.auth.authservice.models:SigninInput"
    def makeRandom(_random: Random, _path: List[String]): SigninInput = new SigninInput(
      `with` = IRTRandomGen[SignIn].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val SigninInput_meta: IRTMetadata[SigninInput] = new IRTMetadata[SigninInput]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth.authservice.models:SigninInput"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("8ec6eb9f2d6a3462ed654a83a95ce4dfbe6966fad2af45ac48723964b525619d"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("94257a1023fc1d439a80a14ad6709ae8ac702cfa55c19384b627824cc17cccef"))
  }
}