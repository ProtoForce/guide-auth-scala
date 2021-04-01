package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.SignUp.Twitter
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class SignUp_Twitter_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth/SignUp:Twitter has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[Twitter]("io.protoforce.guide.auth", "SignUp_Twitter_CodecTest")
  }
}