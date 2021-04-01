package io.protoforce.guide.auth.tests

import _root_.io.protoforce.guide.auth.KnownIdentities
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthCirce
import _root_.io.protoforce.runtime.codecs.IRTCodecTest
import _root_.org.scalatest.wordspec.AnyWordSpec

class KnownIdentities_CodecTest(
  
) extends AnyWordSpec {
  "io.protoforce.guide.auth:KnownIdentities has working codec" in {
    import IRTCodecAuthCirce.DefaultCodec._
    IRTCodecTest.check[KnownIdentities]("io.protoforce.guide.auth", "KnownIdentities_CodecTest")
  }
}