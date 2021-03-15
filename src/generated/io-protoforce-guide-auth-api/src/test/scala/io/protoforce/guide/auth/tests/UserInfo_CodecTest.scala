package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.UserInfo
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class UserInfo_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:UserInfo has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[UserInfo]("io.protoforce.guide.auth", "UserInfo_CodecTest")
  }
}