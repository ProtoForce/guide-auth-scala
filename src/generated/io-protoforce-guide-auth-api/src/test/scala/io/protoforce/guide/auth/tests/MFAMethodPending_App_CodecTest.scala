package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.MFAMethodPending.App
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class MFAMethodPending_App_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth/MFAMethodPending:App has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[App]("io.protoforce.guide.auth", "MFAMethodPending_App_CodecTest")
  }
}