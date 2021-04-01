package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.User
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class User_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:User has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[User]("io.protoforce.guide.auth", "User_CodecTest")
  }
}