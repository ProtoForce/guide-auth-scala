package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.SignUp.Email
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class SignUp_Email_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth/SignUp:Email has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[Email]("io.protoforce.guide.auth", "SignUp_Email_CodecTest")
  }
}