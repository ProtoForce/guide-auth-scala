package io.protoforce.guide.auth.tests.authprotectedservice.models

import _root_.io.protoforce.guide.auth.authprotectedservice.models.Request2FAInput
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.izumi.idealingua.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class Request2FAInput_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth.authprotectedservice.models:Request2FAInput has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[Request2FAInput]("io.protoforce.guide.auth", "Request2FAInput_CodecTest")
  }
}