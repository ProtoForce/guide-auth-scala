package io.protoforce.runtime.codecs.circe

import io.circe.Json
import io.protoforce.runtime.codecs.IRTCodec.IRTCodecFailure

class CirceCodecOption[A: IRTCodecJson] extends IRTCodecJson[Option[A]] {
  private val codec = implicitly[IRTCodecJson[A]]

  override def encode(justValue: Option[A]): Json = {
    justValue match {
      case Some(value) =>
        codec.encode(value)
      case None =>
        Json.Null
    }
  }

  override def decode(wireValue: Json): Either[List[IRTCodecFailure], Option[A]] = {
    wireValue.asNull match {
      case Some(_) =>
        Right(None)
      case None =>
        codec.decode(wireValue).map(v => Some(v))
    }
  }
}