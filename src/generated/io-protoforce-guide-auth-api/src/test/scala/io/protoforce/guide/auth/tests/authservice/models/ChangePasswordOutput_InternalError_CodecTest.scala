package io.protoforce.guide.auth.tests.authservice.models

import _root_.io.protoforce.guide.auth.authservice.models.ChangePasswordOutput.InternalErrorRef
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class ChangePasswordOutput_InternalError_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth.authservice.models/ChangePasswordOutput:InternalError has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[InternalErrorRef]("io.protoforce.guide.auth", "ChangePasswordOutput_InternalError_CodecTest")
  }
}