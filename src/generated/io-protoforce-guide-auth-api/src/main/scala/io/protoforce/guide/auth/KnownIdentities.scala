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
import _root_.scala.List
import _root_.scala.Predef.{
  Set,
  String
}
import _root_.scala.util.Random

/**
  * 
  *  All known identities of a particular user
  * 
  * DTO io.protoforce.guide.auth:KnownIdentities
  * 
  * Defined at identity.pfm @ 28:1
  */
final case class KnownIdentities(
  /**
    * Confirmed identities
    */
  confirmed: Set[SecondaryIdentity],
  /**
    * Unconfirmed identities
    */
  unconfirmed: Set[SecondaryIdentity]
) extends KnownIdentities.Defn

object KnownIdentities {
  /**
    * 
    *  All known identities of a particular user
    * 
    * DTO io.protoforce.guide.auth:KnownIdentities
    * 
    * Defined at identity.pfm @ 28:1
    */
  trait Defn {
    /**
      * Confirmed identities
      */
    def confirmed: Set[SecondaryIdentity]
    /**
      * Unconfirmed identities
      */
    def unconfirmed: Set[SecondaryIdentity]
  }
  
  implicit final class Conversions(
    val _value: KnownIdentities
  ) extends _root_.io.protoforce.runtime.IRTConversions[KnownIdentities]
  
  implicit val KnownIdentities_random: IRTRandomGen[KnownIdentities] = new IRTRandomGen[KnownIdentities]{
    def id: String = "io.protoforce.guide.auth:KnownIdentities"
    def makeRandom(_random: Random, _path: List[String]): KnownIdentities = new KnownIdentities(
      confirmed = IRTRandomGen[Set[SecondaryIdentity]].makeRandom(_random, _path :+ this.id),
      unconfirmed = IRTRandomGen[Set[SecondaryIdentity]].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val KnownIdentities_meta: IRTMetadata[KnownIdentities] = new IRTMetadata[KnownIdentities]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:KnownIdentities"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("e00dc033b1a5fe47573de4d6f90d826a220761c93198d22d0962cab256ef00e3"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("01e66afa815eb91ea1b6c604217e3617ed82c4a6135a8e0bf1df6ca3f83e9577"))
  }
}