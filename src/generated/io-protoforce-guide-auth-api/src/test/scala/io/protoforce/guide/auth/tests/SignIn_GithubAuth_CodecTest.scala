package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.SignIn.GithubAuthRef
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class SignIn_GithubAuth_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth/SignIn:GithubAuth has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[GithubAuthRef]("io.protoforce.guide.auth", "SignIn_GithubAuth_CodecTest")
  }
}