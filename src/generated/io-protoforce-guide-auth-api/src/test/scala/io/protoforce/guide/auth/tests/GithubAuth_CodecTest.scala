package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.GithubAuth
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class GithubAuth_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:GithubAuth has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[GithubAuth]("io.protoforce.guide.auth", "GithubAuth_CodecTest")
  }
}