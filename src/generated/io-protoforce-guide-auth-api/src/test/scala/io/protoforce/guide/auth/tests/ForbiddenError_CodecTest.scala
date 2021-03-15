package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.ForbiddenError
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class ForbiddenError_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:ForbiddenError has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[ForbiddenError]("io.protoforce.guide.auth", "ForbiddenError_CodecTest")
  }
}