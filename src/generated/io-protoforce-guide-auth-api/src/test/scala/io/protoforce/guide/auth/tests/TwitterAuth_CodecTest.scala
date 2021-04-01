package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.TwitterAuth
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class TwitterAuth_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:TwitterAuth has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[TwitterAuth]("io.protoforce.guide.auth", "TwitterAuth_CodecTest")
  }
}