package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.EmailPass
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class EmailPass_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:EmailPass has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[EmailPass]("io.protoforce.guide.auth", "EmailPass_CodecTest")
  }
}