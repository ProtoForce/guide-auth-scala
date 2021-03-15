package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.SignUp.Github
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class SignUp_Github_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth/SignUp:Github has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[Github]("io.protoforce.guide.auth", "SignUp_Github_CodecTest")
  }
}