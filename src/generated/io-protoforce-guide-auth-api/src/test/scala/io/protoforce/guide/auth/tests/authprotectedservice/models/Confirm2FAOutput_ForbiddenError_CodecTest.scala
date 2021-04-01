package io.protoforce.guide.auth.tests.authprotectedservice.models

import _root_.io.protoforce.guide.auth.authprotectedservice.models.Confirm2FAOutput.ForbiddenErrorRef
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class Confirm2FAOutput_ForbiddenError_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth.authprotectedservice.models/Confirm2FAOutput:ForbiddenError has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[ForbiddenErrorRef]("io.protoforce.guide.auth", "Confirm2FAOutput_ForbiddenError_CodecTest")
  }
}