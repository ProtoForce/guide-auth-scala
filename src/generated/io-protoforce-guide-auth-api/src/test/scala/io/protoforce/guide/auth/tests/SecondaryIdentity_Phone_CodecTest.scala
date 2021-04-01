package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.SecondaryIdentity.Phone
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class SecondaryIdentity_Phone_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth/SecondaryIdentity:Phone has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[Phone]("io.protoforce.guide.auth", "SecondaryIdentity_Phone_CodecTest")
  }
}