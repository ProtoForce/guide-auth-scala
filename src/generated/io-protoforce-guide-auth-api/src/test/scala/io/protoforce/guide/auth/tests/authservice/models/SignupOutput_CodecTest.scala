package io.protoforce.guide.auth.tests.authservice.models

import _root_.io.protoforce.guide.auth.authservice.models.SignupOutput
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class SignupOutput_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth.authservice.models:SignupOutput has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[SignupOutput]("io.protoforce.guide.auth", "SignupOutput_CodecTest")
  }
}