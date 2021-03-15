package io.protoforce.guide.auth.tests.authprotectedservice.models

import _root_.io.protoforce.guide.auth.authprotectedservice.models.ListIdentitiesOutput.ForbiddenErrorRef
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class ListIdentitiesOutput_ForbiddenError_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth.authprotectedservice.models/ListIdentitiesOutput:ForbiddenError has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[ForbiddenErrorRef]("io.protoforce.guide.auth", "ListIdentitiesOutput_ForbiddenError_CodecTest")
  }
}