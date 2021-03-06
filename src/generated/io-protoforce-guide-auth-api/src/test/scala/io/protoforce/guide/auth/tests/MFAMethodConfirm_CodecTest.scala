package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.MFAMethodConfirm
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class MFAMethodConfirm_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:MFAMethodConfirm has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[MFAMethodConfirm]("io.protoforce.guide.auth", "MFAMethodConfirm_CodecTest")
  }
}