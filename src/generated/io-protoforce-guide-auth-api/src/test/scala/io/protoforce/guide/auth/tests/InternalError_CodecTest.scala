package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.InternalError
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class InternalError_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:InternalError has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[InternalError]("io.protoforce.guide.auth", "InternalError_CodecTest")
  }
}