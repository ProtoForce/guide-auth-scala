package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.IRTErrorAuth
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class IRTErrorAuth_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:IRTErrorAuth has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[IRTErrorAuth]("io.protoforce.guide.auth", "IRTErrorAuth_CodecTest")
  }
}