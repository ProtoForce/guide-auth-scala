package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.TwitterServerConfig
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class TwitterServerConfig_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:TwitterServerConfig has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[TwitterServerConfig]("io.protoforce.guide.auth", "TwitterServerConfig_CodecTest")
  }
}