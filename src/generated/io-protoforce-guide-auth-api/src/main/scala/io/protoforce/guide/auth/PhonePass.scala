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
  *  Phone and password
  * 
  * DTO io.protoforce.guide.auth:PhonePass
  * 
  * Defined at /providers/phone.pfm @ 4:1
  */
final case class PhonePass(
  /**
    * Phone number in an international format: +1 XXX XXX XXXX
    */
  number: String,
  /**
    * Password
    */
  pass: String
) extends PhonePass.Defn

object PhonePass {
  /**
    * 
    *  Phone and password
    * 
    * DTO io.protoforce.guide.auth:PhonePass
    * 
    * Defined at /providers/phone.pfm @ 4:1
    */
  trait Defn {
    /**
      * Phone number in an international format: +1 XXX XXX XXXX
      */
    def number: String
    /**
      * Password
      */
    def pass: String
  }
  
  implicit final class Conversions(
    val _value: PhonePass
  ) extends _root_.io.protoforce.runtime.IRTConversions[PhonePass]
  
  implicit object Expand_PhonePass_into_Phone_StructuralDowncast_Reliable_1968942498 extends _root_.io.protoforce.runtime.IRTExtend[PhonePass, SignUp.Phone] {
    final class Expand(
      val _value: PhonePass
    ) extends _root_.scala.AnyVal {
      def using(timezone: String): SignUp.Phone = new SignUp.Phone(
        timezone = timezone,
        number = _value.number,
        pass = _value.pass
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: PhonePass): Expand = new Expand(
      _value = from
    )
  }
  
  implicit val PhonePass_random: IRTRandomGen[PhonePass] = new IRTRandomGen[PhonePass]{
    def id: String = "io.protoforce.guide.auth:PhonePass"
    def makeRandom(_random: Random, _path: List[String]): PhonePass = new PhonePass(
      number = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
      pass = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val PhonePass_meta: IRTMetadata[PhonePass] = new IRTMetadata[PhonePass]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:PhonePass"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("abc45d69e9c3cb5b51266f60ef9d1f9a1e218968a8f969be4cae668505596480"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("ef41c945556df2b8a57f8065748139d23d1db5c145a615933556baacf2e2b201"))
  }
}