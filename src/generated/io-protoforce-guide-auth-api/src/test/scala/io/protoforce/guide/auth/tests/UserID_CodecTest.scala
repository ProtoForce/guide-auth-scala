package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.UserID
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class UserID_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:UserID has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[UserID]("io.protoforce.guide.auth", "UserID_CodecTest")
  }
}