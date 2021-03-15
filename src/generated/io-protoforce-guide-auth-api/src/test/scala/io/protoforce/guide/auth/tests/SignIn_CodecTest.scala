package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.SignIn
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class SignIn_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:SignIn has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[SignIn]("io.protoforce.guide.auth", "SignIn_CodecTest")
  }
}