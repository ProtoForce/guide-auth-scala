package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.SMSServerConfig
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class SMSServerConfig_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:SMSServerConfig has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[SMSServerConfig]("io.protoforce.guide.auth", "SMSServerConfig_CodecTest")
  }
}