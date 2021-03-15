package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.GithubClientConfig
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class GithubClientConfig_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:GithubClientConfig has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[GithubClientConfig]("io.protoforce.guide.auth", "GithubClientConfig_CodecTest")
  }
}