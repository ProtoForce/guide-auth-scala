package io.protoforce.guide.auth.tests.authprotectedservice.models

import _root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.InternalErrorRef
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class RemoveIdentityOutput_InternalError_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth.authprotectedservice.models/RemoveIdentityOutput:InternalError has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[InternalErrorRef]("io.protoforce.guide.auth", "RemoveIdentityOutput_InternalError_CodecTest")
  }
}