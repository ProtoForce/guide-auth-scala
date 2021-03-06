package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.UserLookup.Phone
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class UserLookup_Phone_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth/UserLookup:Phone has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[Phone]("io.protoforce.guide.auth", "UserLookup_Phone_CodecTest")
  }
}