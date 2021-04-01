package io.protoforce.guide.auth.tests.authprotectedservice.models

import _root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.AlreadyExistsErrorRef
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class AddIdentityOutput_AlreadyExistsError_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth.authprotectedservice.models/AddIdentityOutput:AlreadyExistsError has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[AlreadyExistsErrorRef]("io.protoforce.guide.auth", "AddIdentityOutput_AlreadyExistsError_CodecTest")
  }
}