package io.protoforce.guide.auth.tests.authservice.models

import _root_.io.protoforce.guide.auth.authservice.models.ConfirmEmailOutput.NotFoundErrorRef
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class ConfirmEmailOutput_NotFoundError_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth.authservice.models/ConfirmEmailOutput:NotFoundError has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[NotFoundErrorRef]("io.protoforce.guide.auth", "ConfirmEmailOutput_NotFoundError_CodecTest")
  }
}