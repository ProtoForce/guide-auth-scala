package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.MFAMethodPending
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class MFAMethodPending_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:MFAMethodPending has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[MFAMethodPending]("io.protoforce.guide.auth", "MFAMethodPending_CodecTest")
  }
}