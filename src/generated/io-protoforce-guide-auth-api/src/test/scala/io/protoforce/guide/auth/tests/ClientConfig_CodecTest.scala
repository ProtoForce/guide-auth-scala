package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.ClientConfig
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class ClientConfig_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:ClientConfig has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[ClientConfig]("io.protoforce.guide.auth", "ClientConfig_CodecTest")
  }
}