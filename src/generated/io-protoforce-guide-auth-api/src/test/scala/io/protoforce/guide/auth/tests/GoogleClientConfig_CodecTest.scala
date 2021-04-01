package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.GoogleClientConfig
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class GoogleClientConfig_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:GoogleClientConfig has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[GoogleClientConfig]("io.protoforce.guide.auth", "GoogleClientConfig_CodecTest")
  }
}