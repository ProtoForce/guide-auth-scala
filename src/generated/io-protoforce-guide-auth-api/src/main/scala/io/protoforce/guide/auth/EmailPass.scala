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
  *  Email and Password
  * 
  * DTO io.protoforce.guide.auth:EmailPass
  * 
  * Defined at /providers/email.pfm @ 4:1
  */
final case class EmailPass(
  /**
    * User email
    */
  email: String,
  pass: String
) extends EmailPass.Defn

object EmailPass {
  /**
    * 
    *  Email and Password
    * 
    * DTO io.protoforce.guide.auth:EmailPass
    * 
    * Defined at /providers/email.pfm @ 4:1
    */
  trait Defn {
    /**
      * User email
      */
    def email: String
    def pass: String
  }
  
  implicit final class Conversions(
    val _value: EmailPass
  ) extends _root_.izumi.idealingua.runtime.IRTConversions[EmailPass]
  
  implicit object Expand_EmailPass_into_Email_StructuralDowncast_Reliable_1880248267 extends _root_.izumi.idealingua.runtime.IRTExtend[EmailPass, SignUp.Email] {
    final class Expand(
      val _value: EmailPass
    ) extends _root_.scala.AnyVal {
      def using(timezone: String): SignUp.Email = new SignUp.Email(
        timezone = timezone,
        email = _value.email,
        pass = _value.pass
      )
    }
    
    type INSTANTIATOR = Expand
    
    def next(from: EmailPass): Expand = new Expand(
      _value = from
    )
  }
  
  implicit val EmailPass_random: IRTRandomGen[EmailPass] = new IRTRandomGen[EmailPass]{
    def id: String = "io.protoforce.guide.auth:EmailPass"
    def makeRandom(_random: Random, _path: List[String]): EmailPass = new EmailPass(
      email = IRTRandomGen[String].makeRandom(_random, _path :+ this.id),
      pass = IRTRandomGen[String].makeRandom(_random, _path :+ this.id)
    )
  }
  
  implicit val EmailPass_meta: IRTMetadata[EmailPass] = new IRTMetadata[EmailPass]{
    def typeId: IRTTypeId = new IRTTypeId(new String("io.protoforce.guide.auth:EmailPass"))
    def baseVersion: TypeBaseVersion = new TypeBaseVersion(new String("3886239f1b78939c5841bab5d2ff028f7072bae02a0d2c20ee7096007deb4899"))
    def fullVersion: TypeFullVersion = new TypeFullVersion(new String("735fe764e35cfcf9f522349eefe32e46255bc4e65cc6f01203d760e4814de8fb"))
  }
}