package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.GoogleAuth
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class GoogleAuth_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:GoogleAuth has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[GoogleAuth]("io.protoforce.guide.auth", "GoogleAuth_CodecTest")
  }
}