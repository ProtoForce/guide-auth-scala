package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.SignupAttributes
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class SignupAttributes_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:SignupAttributes has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[SignupAttributes]("io.protoforce.guide.auth", "SignupAttributes_CodecTest")
  }
}