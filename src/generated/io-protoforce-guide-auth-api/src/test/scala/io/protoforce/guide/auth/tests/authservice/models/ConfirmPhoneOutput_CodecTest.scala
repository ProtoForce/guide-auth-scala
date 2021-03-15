package io.protoforce.guide.auth.tests.authservice.models

import _root_.io.protoforce.guide.auth.authservice.models.ConfirmPhoneOutput
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class ConfirmPhoneOutput_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth.authservice.models:ConfirmPhoneOutput has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[ConfirmPhoneOutput]("io.protoforce.guide.auth", "ConfirmPhoneOutput_CodecTest")
  }
}