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
  *  Sign in method response
  * 
  * ADT io.protoforce.guide.auth:SigninResponse
  * 
  * Defined at auth.service.pfm @ 23:1
  */
sealed trait SigninResponse {
  
}

object SigninResponse {
  /**
    * 
    *  Successful authentication with details
    * 
    * DTO io.protoforce.guide.auth/SigninResponse:SigninSuccessResponse (reference member of ADT io.protoforce.guide.auth:SigninResponse)
    * 
    * Defined at auth.service.pfm @ 27:3
    */
  final case class SigninSuccessResponseRef(
    /**
      * Successful authentication with details
      */
    value: _root_.io.protoforce.guide.auth.SigninSuccessResponse
  ) extends SigninResponse.SigninSuccessResponseRef.Defn
  
  /**
    * 
    *  Further authentication is required for a user
    * 
    * DTO io.protoforce.guide.auth/SigninResponse:Confirm2FA (member of ADT io.protoforce.guide.auth:SigninResponse)
    * 
    * Defined at auth.service.pfm @ 31:3
    */
  final case class Confirm2FA(
    /**
      * Message to display to a user. Examples:
      *    "We've sent you an SMS to number +1XXXXXXX123"
      *    "Please use "
      */
    message: String,
    /**
      * Token is used to hold information about the authentication
      *    attempt
      */
    token: String
  ) extends SigninResponse.Confirm2FA.Defn
  
  object SigninSuccessResponseRef {
    /**
      * 
      *  Successful authentication with details
      * 
      * DTO io.protoforce.guide.auth/SigninResponse:SigninSuccessResponse (reference member of ADT io.protoforce.guide.auth:SigninResponse)
      * 
      * Defined at auth.service.pfm @ 27:3
      */
    sealed trait Defn extends SigninResponse {
      /**
        * Successful authentication with details
        */
      def value: _root_.io.protoforce.guide.auth.SigninSuccessResponse
    }
    
    implicit final class Conversions(
      val _value: SigninResponse.SigninSuccessResponseRef
    ) extends _root_.izumi.idealingua.runtime.IRTConversions[SigninResponse.SigninSuccessResponseRef]
    
    implicit val SigninSuccessResponse_random: IRTRandomGen[SigninResponse.SigninSuccessResponseRef] = new IRTRandomGen[SigninResponse.SigninSuccessResponseRef]{
      def id: String = "io.protoforce.guide.auth/SigninResponse:SigninSuccessResponse"
      def makeRandom(_random: Random, _path: List[String]): SigninResponse.SigninSuccessResponseRef = new SigninResponse.SigninSuccessResponseRef(
        value = IRTRandomGen[_root_.io.protoforce.guide.auth.SigninSuccessResponse].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val SigninSuccessResponse_meta: IRTMetadata[SigninResponse.SigninSuccessResponseRef] = new IRTMetadata[SigninResponse.SigninSuccessResponseRef]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth/SigninResponse:SigninSuccessResponse"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("c552dcbe53b7c0881bcbbaee29fbc987b7349eacb3407a72daa7f79775abeb6d"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("709485becdd458465af49cf9e0f7e9c8451ab4867a1b8064db9d3d2defbb044f"))
    }
    
    /**
      * Convenience helper replicating constructor of io.protoforce.guide.auth:SigninSuccessResponse
      */
    def apply(user: User, accessToken: String): SigninResponse.SigninSuccessResponseRef = new SigninResponse.SigninSuccessResponseRef(new _root_.io.protoforce.guide.auth.SigninSuccessResponse(
      user = user,
      accessToken = accessToken
    ))
  }
  
  object Confirm2FA {
    /**
      * 
      *  Further authentication is required for a user
      * 
      * DTO io.protoforce.guide.auth/SigninResponse:Confirm2FA (member of ADT io.protoforce.guide.auth:SigninResponse)
      * 
      * Defined at auth.service.pfm @ 31:3
      */
    sealed trait Defn extends SigninResponse {
      /**
        * Message to display to a user. Examples:
        *    "We've sent you an SMS to number +1XXXXXXX123"
        *    "Please use "
        */
      def message: String
      /**
        * Token is used to hold information about the authentication
        *    attempt
        */
      def token: String
    }
    
    implicit final class Conversions(
      val _value: SigninResponse.Confirm2FA
    ) extends _root_.izumi.idealingua.runtime.IRTConversions[SigninResponse.Confirm2FA]
    
    implicit val Confirm2FA_random: IRTRandomGen[SigninResponse.Confirm2FA] = new IRTRandomGen[SigninResponse.Confirm2FA]{
      def id: String = "io.protoforce.guide.auth/SigninResponse:Confirm2FA"
      def makeRandom(_random: Random, _path: List[String]): SigninResponse.Confirm2FA = new SigninResponse.Confirm2FA(
        message = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
        token = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
      )
    }
    
    implicit val Confirm2FA_meta: IRTMetadata[SigninResponse.Confirm2FA] = new IRTMetadata[SigninResponse.Confirm2FA]{
      def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth/SigninResponse:Confirm2FA"))
      def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("79f8f66940b99b437006ffc4966390d84d79012d52e6484c11afe5166add7488"))
      def fullVersion: TypeFullVersion = new TypeFullVersion(new String("30433d795b4e8e86fc5ffa4341c1c38a2357b3363beb5f2d92626591b94d4113"))
    }
  }
  
  implicit val SigninResponse_random: IRTRandomGen[SigninResponse] = new IRTRandomGen[SigninResponse]{
    def id: String = "io.protoforce.guide.auth:SigninResponse"
    def makeRandom(_random: Random, _path: List[String]): SigninResponse = {
      val _all = List(
        IRTRandomGen[SigninResponse.SigninSuccessResponseRef].widen[SigninResponse],
        IRTRandomGen[SigninResponse.Confirm2FA].widen[SigninResponse]
      )
      IRTRandomGen._safeChoose[SigninResponse](_all, _path :+ this.id, _random)
    }
  }
  
  implicit val SigninResponse_meta: IRTMetadata[SigninResponse] = new IRTMetadata[SigninResponse]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:SigninResponse"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("fe0054911927571fed8b89dd01591342f550ffda8c65472cba38a538d84447bd"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("e6dd7d9df05c6b74ef4fc791e83fe26fee128103b22451d43fed07f407354709"))
  }
}