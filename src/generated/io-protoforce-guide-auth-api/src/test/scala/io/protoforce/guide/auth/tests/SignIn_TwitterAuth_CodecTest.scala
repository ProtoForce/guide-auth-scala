package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.SignIn.TwitterAuthRef
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class SignIn_TwitterAuth_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth/SignIn:TwitterAuth has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[TwitterAuthRef]("io.protoforce.guide.auth", "SignIn_TwitterAuth_CodecTest")
  }
}