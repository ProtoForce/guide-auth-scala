package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.SignIn.TwoFactor
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class SignIn_TwoFactor_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth/SignIn:TwoFactor has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[TwoFactor]("io.protoforce.guide.auth", "SignIn_TwoFactor_CodecTest")
  }
}