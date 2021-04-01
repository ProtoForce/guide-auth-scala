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
import _root_.scala.Predef.String
import _root_.scala.util.Random

/**
  * 
  *  User info
  * 
  * Mixin io.protoforce.guide.auth:UserInfo
  * 
  * Defined at user.pfm @ 12:1
  */
trait UserInfo {
  def name: String
}

object UserInfo {
  /**
    * 
    *  User info
    * 
    * Mixin io.protoforce.guide.auth:UserInfo
    * 
    * Defined at user.pfm @ 12:1
    */
  final case class Impl(
    name: String
  ) extends UserInfo
  
  implicit final class Conversions(
    val _value: UserInfo
  ) extends _root_.io.protoforce.runtime.IRTConversions[UserInfo]
  
  /**
    * conversion:interface-clone
    */
  implicit object Copy_UserInfo_to_UserInfo_StructuralSibling_Reliable_1857904184 extends _root_.io.protoforce.runtime.IRTCast[UserInfo, UserInfo.Impl] {
    def convert(from: UserInfo): UserInfo.Impl = new UserInfo.Impl(
      name = from.name
    )
  }
  
  implicit object Expand_UserInfo_into_User_StructuralDowncast_Reliable_179059848 extends _root_.io.protoforce.runtime.IRTExtend[UserInfo, User] {
    final class Expand(
      val _value: UserInfo
    ) extends _root_.scala.AnyVal {
      def using(id: UserID, verified: _root_.scala.Boolean): User = new User(
        id = id,
        verified = verified,
        name = _value.name
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: UserInfo): Expand = new Expand(
      _value = from
    )
  }
  
  implicit val UserInfo_random: IRTRandomGen[UserInfo] = new IRTRandomGen[UserInfo]{
    def id: String = "io.protoforce.guide.auth:UserInfo"
    def makeRandom(_random: Random, _path: List[String]): UserInfo = new UserInfo.Impl(
      name = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val UserInfo_meta: IRTMetadata[UserInfo] = new IRTMetadata[UserInfo]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:UserInfo"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("725b95d8143b2f16d3d69621301fe2a6b9cc5222f5fc97d08abf896f05795672"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("47f9641e73a2ede2f0fd52e6399ae23d9e1d088739e11335fced3de21e236853"))
  }
}