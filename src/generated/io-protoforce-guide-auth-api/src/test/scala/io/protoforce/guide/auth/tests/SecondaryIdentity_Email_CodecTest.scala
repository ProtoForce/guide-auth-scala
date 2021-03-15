package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.SecondaryIdentity.Email
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class SecondaryIdentity_Email_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth/SecondaryIdentity:Email has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[Email]("io.protoforce.guide.auth", "SecondaryIdentity_Email_CodecTest")
  }
}