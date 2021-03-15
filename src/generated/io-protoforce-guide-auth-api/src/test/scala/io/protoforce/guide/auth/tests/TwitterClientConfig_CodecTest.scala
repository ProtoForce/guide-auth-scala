package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.TwitterClientConfig
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class TwitterClientConfig_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:TwitterClientConfig has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[TwitterClientConfig]("io.protoforce.guide.auth", "TwitterClientConfig_CodecTest")
  }
}