package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.EmailServerConfig
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class EmailServerConfig_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:EmailServerConfig has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[EmailServerConfig]("io.protoforce.guide.auth", "EmailServerConfig_CodecTest")
  }
}