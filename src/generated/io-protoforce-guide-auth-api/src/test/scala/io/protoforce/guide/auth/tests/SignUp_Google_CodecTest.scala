package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.SignUp.Google
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class SignUp_Google_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth/SignUp:Google has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[Google]("io.protoforce.guide.auth", "SignUp_Google_CodecTest")
  }
}