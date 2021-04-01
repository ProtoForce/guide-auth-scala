package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.SigninSuccessResponse
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class SigninSuccessResponse_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:SigninSuccessResponse has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[SigninSuccessResponse]("io.protoforce.guide.auth", "SigninSuccessResponse_CodecTest")
  }
}