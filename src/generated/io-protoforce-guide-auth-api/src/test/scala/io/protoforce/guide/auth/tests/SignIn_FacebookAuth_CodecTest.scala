package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.SignIn.FacebookAuthRef
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class SignIn_FacebookAuth_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth/SignIn:FacebookAuth has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[FacebookAuthRef]("io.protoforce.guide.auth", "SignIn_FacebookAuth_CodecTest")
  }
}