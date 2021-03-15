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
import _root_.scala.List
import _root_.scala.Predef.String
import _root_.scala.util.Random

/**
  * 
  *  Class represents a successful sign in of a user, which is a result
  *  of sign up or sign in.
  * 
  * DTO io.protoforce.guide.auth:SigninSuccessResponse
  * 
  * Defined at auth.service.pfm @ 6:1
  */
final case class SigninSuccessResponse(
  user: User,
  accessToken: String
) extends SigninSuccessResponse.Defn

object SigninSuccessResponse {
  /**
    * 
    *  Class represents a successful sign in of a user, which is a result
    *  of sign up or sign in.
    * 
    * DTO io.protoforce.guide.auth:SigninSuccessResponse
    * 
    * Defined at auth.service.pfm @ 6:1
    */
  trait Defn {
    def user: User
    def accessToken: String
  }
  
  implicit final class Conversions(
    val _value: SigninSuccessResponse
  ) extends _root_.izumi.idealingua.runtime.IRTConversions[SigninSuccessResponse]
  
  implicit val SigninSuccessResponse_random: IRTRandomGen[SigninSuccessResponse] = new IRTRandomGen[SigninSuccessResponse]{
    def id: String = "io.protoforce.guide.auth:SigninSuccessResponse"
    def makeRandom(_random: Random, _path: List[String]): SigninSuccessResponse = new SigninSuccessResponse(
      user = IRTRandomGen[User].makeRandom(_random, _path :+ this.id),
      accessToken = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val SigninSuccessResponse_meta: IRTMetadata[SigninSuccessResponse] = new IRTMetadata[SigninSuccessResponse]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:SigninSuccessResponse"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("26c1dbc092c91865186326d16bebfe825c08e7a2d81d99b9915aba1ad948ba4b"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("cd428e376118afff63a278a0a7bc508f3136edee17ddeababe1b952959da45a9"))
  }
}