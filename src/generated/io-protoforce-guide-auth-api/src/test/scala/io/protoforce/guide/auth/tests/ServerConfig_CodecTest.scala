package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.ServerConfig
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class ServerConfig_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:ServerConfig has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[ServerConfig]("io.protoforce.guide.auth", "ServerConfig_CodecTest")
  }
}