package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.SignUp.Facebook
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class SignUp_Facebook_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth/SignUp:Facebook has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[Facebook]("io.protoforce.guide.auth", "SignUp_Facebook_CodecTest")
  }
}