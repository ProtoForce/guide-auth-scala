package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.SignUp
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class SignUp_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:SignUp has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[SignUp]("io.protoforce.guide.auth", "SignUp_CodecTest")
  }
}