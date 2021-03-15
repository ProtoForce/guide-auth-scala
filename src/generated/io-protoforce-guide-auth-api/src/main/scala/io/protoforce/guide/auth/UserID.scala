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
import _root_.java.util.UUID
import _root_.scala.List
import _root_.scala.Predef.String
import _root_.scala.util.Random

/**
  * 
  *  User identifier
  * 
  * Identifier io.protoforce.guide.auth:UserID
  * 
  * Defined at user.pfm @ 5:1
  */
final case class UserID(
  id: UUID
)

object UserID {
  implicit val UserID_random: IRTRandomGen[UserID] = new IRTRandomGen[UserID]{
    def id: String = "io.protoforce.guide.auth:UserID"
    def makeRandom(_random: Random, _path: List[String]): UserID = new UserID(
      id = IRTRandomGen[UUID].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val UserID_meta: IRTMetadata[UserID] = new IRTMetadata[UserID]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:UserID"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("05827c40b8db98cb5aa88245ebb6579aa1b5da220e5b4031d2c0008b7ae36eaa"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("55a495b3150ba2399dea21ae32d11757ad3da859fa3dfd96c87094430a720478"))
  }
}