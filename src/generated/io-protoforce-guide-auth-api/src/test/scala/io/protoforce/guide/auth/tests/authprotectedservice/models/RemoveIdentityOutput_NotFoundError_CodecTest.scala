package io.protoforce.guide.auth.tests.authprotectedservice.models

import _root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.NotFoundErrorRef
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class RemoveIdentityOutput_NotFoundError_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth.authprotectedservice.models/RemoveIdentityOutput:NotFoundError has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[NotFoundErrorRef]("io.protoforce.guide.auth", "RemoveIdentityOutput_NotFoundError_CodecTest")
  }
}