package io.protoforce.guide.auth.tests.authservice.models

import _root_.io.protoforce.guide.auth.authservice.models.ResetPasswordInput
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class ResetPasswordInput_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth.authservice.models:ResetPasswordInput has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[ResetPasswordInput]("io.protoforce.guide.auth", "ResetPasswordInput_CodecTest")
  }
}