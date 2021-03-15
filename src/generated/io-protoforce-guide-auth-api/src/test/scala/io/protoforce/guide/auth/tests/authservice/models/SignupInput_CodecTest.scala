package io.protoforce.guide.auth.tests.authservice.models

import _root_.io.protoforce.guide.auth.authservice.models.SignupInput
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class SignupInput_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth.authservice.models:SignupInput has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[SignupInput]("io.protoforce.guide.auth", "SignupInput_CodecTest")
  }
}