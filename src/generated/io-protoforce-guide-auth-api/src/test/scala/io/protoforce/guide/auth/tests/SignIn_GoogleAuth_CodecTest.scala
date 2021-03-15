package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.SignIn.GoogleAuthRef
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class SignIn_GoogleAuth_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth/SignIn:GoogleAuth has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[GoogleAuthRef]("io.protoforce.guide.auth", "SignIn_GoogleAuth_CodecTest")
  }
}