package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.GenericSuccess
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class GenericSuccess_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:GenericSuccess has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[GenericSuccess]("io.protoforce.guide.auth", "GenericSuccess_CodecTest")
  }
}