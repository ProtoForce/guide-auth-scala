package io.protoforce.guide.auth

import _root_.io.protoforce.model.versioning.IRTSchema.{
  TypeBaseVersion,
  TypeFullVersion
}
import _root_.io.protoforce.runtime.{
  IRTMetadata,
  IRTRandomGen,
  IRTTypeId
}
import _root_.scala.{
  Boolean,
  List
}
import _root_.scala.Predef.String
import _root_.scala.util.Random

/**
  * 
  *  Complete user data
  * 
  * DTO io.protoforce.guide.auth:User
  * 
  * Defined at user.pfm @ 19:1
  */
final case class User(
  name: String,
  id: UserID,
  /**
    * Verified user is the one who signed up with a provider which validated
    *    their emails, or when a user manually validates their email, phone, etc.
    *    If a user has many secondary identities, this boolean denotes when they
    *    have at least one secondary identity verified.
    */
  verified: Boolean
) extends User.Defn

object User {
  /**
    * 
    *  Complete user data
    * 
    * DTO io.protoforce.guide.auth:User
    * 
    * Defined at user.pfm @ 19:1
    */
  trait Defn {
    def name: String
    def id: UserID
    /**
      * Verified user is the one who signed up with a provider which validated
      *    their emails, or when a user manually validates their email, phone, etc.
      *    If a user has many secondary identities, this boolean denotes when they
      *    have at least one secondary identity verified.
      */
    def verified: Boolean
  }
  
  implicit final class Conversions(
    val _value: User
  ) extends _root_.io.protoforce.runtime.IRTConversions[User]
  
  /**
    * conversion:structural-structure-upcast
    */
  implicit object Copy_User_to_UserInfo_StructuralUpcast_Reliable_179059848 extends _root_.io.protoforce.runtime.IRTCast[User, UserInfo.Impl] {
    def convert(from: User): UserInfo.Impl = new UserInfo.Impl(
      name = from.name
    )
  }
  
  implicit val User_random: IRTRandomGen[User] = new IRTRandomGen[User]{
    def id: String = "io.protoforce.guide.auth:User"
    def makeRandom(_random: Random, _path: List[String]): User = new User(
      name = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
      id = IRTRandomGen[UserID].makeRandom(_random, _path :+ this.id),
      verified = IRTRandomGen[Boolean].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val User_meta: IRTMetadata[User] = new IRTMetadata[User]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:User"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("a832a6a27b3bdae3ce7fc267c711154e31f958c7b18051356e12752853033ad1"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("cb2ccbdbe05985cfb928781cc7926d7f8aeac7b448c73118238b574734bc82bf"))
  }
}