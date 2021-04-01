package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.SignIn.PhonePassRef
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class SignIn_PhonePass_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth/SignIn:PhonePass has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[PhonePassRef]("io.protoforce.guide.auth", "SignIn_PhonePass_CodecTest")
  }
}