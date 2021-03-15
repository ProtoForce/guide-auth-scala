package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.FacebookAuth
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class FacebookAuth_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:FacebookAuth has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[FacebookAuth]("io.protoforce.guide.auth", "FacebookAuth_CodecTest")
  }
}