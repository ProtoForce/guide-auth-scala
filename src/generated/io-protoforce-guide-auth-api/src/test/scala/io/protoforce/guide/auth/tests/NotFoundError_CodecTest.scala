package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.NotFoundError
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class NotFoundError_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:NotFoundError has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[NotFoundError]("io.protoforce.guide.auth", "NotFoundError_CodecTest")
  }
}