package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.GoogleServerConfig
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class GoogleServerConfig_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:GoogleServerConfig has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[GoogleServerConfig]("io.protoforce.guide.auth", "GoogleServerConfig_CodecTest")
  }
}