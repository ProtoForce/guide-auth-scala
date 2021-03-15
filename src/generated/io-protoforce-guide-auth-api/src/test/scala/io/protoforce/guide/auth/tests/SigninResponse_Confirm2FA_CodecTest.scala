package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.SigninResponse.Confirm2FA
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class SigninResponse_Confirm2FA_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth/SigninResponse:Confirm2FA has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[Confirm2FA]("io.protoforce.guide.auth", "SigninResponse_Confirm2FA_CodecTest")
  }
}