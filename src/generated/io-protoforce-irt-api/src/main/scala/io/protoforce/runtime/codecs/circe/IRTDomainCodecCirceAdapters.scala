package io.protoforce.runtime.codecs.circe

import io.circe._
import io.protoforce.runtime.codecs.IRTCodec.IRTCodecFailure
import io.protoforce.runtime.codecs.{IRTDomainCodec, IRTKeyCodec}

trait IRTDomainCodecCirceAdapters extends IRTDomainCodec[Json] {
  protected def fromCirceJson[T: Encoder: Decoder]: IRTCodecWire[T] = new IRTCodecWire[T] {
    override def encode(justValue: T): Json = {
      implicitly[Encoder[T]].apply(justValue)
    }

    override def decode(wireValue: Json): Either[List[IRTCodecFailure], T] = {
      implicitly[Decoder[T]].decodeJson(wireValue).left.map(f => List(IRTCodecFailure.IRTCodecException(f)))
    }
  }

  protected def fromCirceJsonKey[T: KeyEncoder: KeyDecoder]: IRTKeyCodecWire[T] = new IRTKeyCodecWire[T] {
    override def encode(justValue: T): String = {
      implicitly[KeyEncoder[T]].apply(justValue)
    }

    override def decode(wireValue: String): Either[List[IRTCodecFailure], T] = {
      implicitly[KeyDecoder[T]].apply(wireValue).toRight(List(IRTCodecFailure.IRTCodecIssue(s"Cannot decode key from `$wireValue`")))
    }
  }

  protected def adaptKeyCodec[T: IRTKeyCodec, T1](co: T => T1, contra: T1 => T): IRTKeyCodec[T1] = new IRTKeyCodec[T1] {
    private val base = implicitly[IRTKeyCodec[T]]
    override def encode(justValue: T1): String = base.encode(contra(justValue))
    override def decode(wireValue: String): Either[List[IRTCodecFailure], T1] = base.decode(wireValue).map(co)
  }
}