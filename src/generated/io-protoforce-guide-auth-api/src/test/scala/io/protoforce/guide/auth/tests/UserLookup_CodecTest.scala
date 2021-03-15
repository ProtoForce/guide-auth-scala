package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.UserLookup
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class UserLookup_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:UserLookup has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[UserLookup]("io.protoforce.guide.auth", "UserLookup_CodecTest")
  }
}