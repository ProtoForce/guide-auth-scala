package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.SigninResponse.SigninSuccessResponseRef
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class SigninResponse_SigninSuccessResponse_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth/SigninResponse:SigninSuccessResponse has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[SigninSuccessResponseRef]("io.protoforce.guide.auth", "SigninResponse_SigninSuccessResponse_CodecTest")
  }
}