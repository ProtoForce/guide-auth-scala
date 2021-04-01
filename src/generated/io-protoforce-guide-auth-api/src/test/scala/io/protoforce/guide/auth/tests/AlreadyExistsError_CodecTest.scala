package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.AlreadyExistsError
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class AlreadyExistsError_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:AlreadyExistsError has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[AlreadyExistsError]("io.protoforce.guide.auth", "AlreadyExistsError_CodecTest")
  }
}