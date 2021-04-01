package io.protoforce.guide.auth.tests.authprotectedservice.models

import _root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.InternalErrorRef
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class AddIdentityOutput_InternalError_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth.authprotectedservice.models/AddIdentityOutput:InternalError has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[InternalErrorRef]("io.protoforce.guide.auth", "AddIdentityOutput_InternalError_CodecTest")
  }
}