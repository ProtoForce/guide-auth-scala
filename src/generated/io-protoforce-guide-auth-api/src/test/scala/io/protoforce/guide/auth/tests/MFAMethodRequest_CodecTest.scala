package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.MFAMethodRequest
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class MFAMethodRequest_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:MFAMethodRequest has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[MFAMethodRequest]("io.protoforce.guide.auth", "MFAMethodRequest_CodecTest")
  }
}