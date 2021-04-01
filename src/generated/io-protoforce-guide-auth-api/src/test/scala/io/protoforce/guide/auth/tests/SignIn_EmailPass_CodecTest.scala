package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.SignIn.EmailPassRef
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class SignIn_EmailPass_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth/SignIn:EmailPass has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[EmailPassRef]("io.protoforce.guide.auth", "SignIn_EmailPass_CodecTest")
  }
}