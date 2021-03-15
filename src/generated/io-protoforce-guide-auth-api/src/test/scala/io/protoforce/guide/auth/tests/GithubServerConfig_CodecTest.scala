package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.GithubServerConfig
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class GithubServerConfig_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:GithubServerConfig has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[GithubServerConfig]("io.protoforce.guide.auth", "GithubServerConfig_CodecTest")
  }
}