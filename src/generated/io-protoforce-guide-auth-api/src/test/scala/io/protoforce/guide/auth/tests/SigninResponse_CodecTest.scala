package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.SigninResponse
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class SigninResponse_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:SigninResponse has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[SigninResponse]("io.protoforce.guide.auth", "SigninResponse_CodecTest")
  }
}