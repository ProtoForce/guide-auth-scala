package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.OAuthData
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class OAuthData_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:OAuthData has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[OAuthData]("io.protoforce.guide.auth", "OAuthData_CodecTest")
  }
}