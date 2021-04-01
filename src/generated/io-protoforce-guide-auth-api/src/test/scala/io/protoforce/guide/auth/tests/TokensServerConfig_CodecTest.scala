package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.TokensServerConfig
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class TokensServerConfig_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:TokensServerConfig has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[TokensServerConfig]("io.protoforce.guide.auth", "TokensServerConfig_CodecTest")
  }
}