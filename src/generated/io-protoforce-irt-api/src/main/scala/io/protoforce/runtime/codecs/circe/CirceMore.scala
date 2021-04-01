package io.protoforce.runtime.codecs.circe

import java.nio.charset.StandardCharsets
import java.util.Base64

import io.circe.Decoder.Result
import io.circe._
import io.protoforce.runtime.IRTTypeId

import scala.collection.compat.immutable.ArraySeq

trait CirceMore {
  implicit def keyEncoderTypeId: KeyEncoder[IRTTypeId] = (key: IRTTypeId) => key.value
  implicit def keyDecoderTypeId: KeyDecoder[IRTTypeId] = (key: String) => Some(IRTTypeId(key))

  implicit def encoderTypeId: Encoder[IRTTypeId] = (key: IRTTypeId) => Json.fromString(key.value)
  implicit def decoderTypeId: Decoder[IRTTypeId] = implicitly[Decoder[String]].map(IRTTypeId.apply)

  implicit def keyEncoderBigint: KeyEncoder[BigInt] = (key: BigInt) => key.toString(16)
  implicit def keyDecoderBigint: KeyDecoder[BigInt] = (key: String) =>
    try {
      Some(BigInt.apply(key, 16))
    } catch {
      case _: NumberFormatException =>
        None
    }

  implicit def encoderBlob: Encoder[ArraySeq[Byte]] = (a: ArraySeq[Byte]) => {
    Json.fromString(new String(Base64.getEncoder.encode(a.toArray), StandardCharsets.US_ASCII))
  }

  implicit final val encodeBigInt16: Encoder[BigInt] = (a: BigInt) =>
    if (!a.isValidInt) {
      Json.fromString(a.toString(16))
    } else {
      Json.fromInt(a.toInt)
    }

  implicit final val decodeBigInt16: Decoder[BigInt] = (c: HCursor) => {
    def fail(t: Any): Decoder.Result[Nothing] = {
      Left(DecodingFailure(s"unexpected type in BigInt position: $t", c.history))
    }

    c.value.fold(
        fail(null),
        fail,
        number =>
          number.toBigInt match {
            case Some(v) => Right(v)
            case None => Left(DecodingFailure.apply(s"Failed to decode number into BigInt: $number", c.history))
          },
        string =>
          try {
            Right(BigInt.apply(string, 16))
          } catch {
            case _: NumberFormatException =>
              Left(DecodingFailure.apply(s"Failed to decode string into BigInt: $string", c.history))
          },
        fail,
        fail,
      )
  }

  implicit def decoderBlob: Decoder[ArraySeq[Byte]] = (c: HCursor) => {
    decString(c) {
      s =>
        try {
          Right(ArraySeq.unsafeWrapArray(Base64.getDecoder.decode(s.getBytes(StandardCharsets.US_ASCII))))
        } catch {
          case t: Throwable =>
            Left(DecodingFailure.apply(s"Failed to decode base64: ${t.getMessage}", c.history))
        }
    }
  }

  private def decString[T](c: HCursor)(d: String => Decoder.Result[T]): Result[T] = {
    def fail(t: Any): Decoder.Result[Nothing] = {
      Left(DecodingFailure(s"unexpected type in String position: $t", c.history))
    }

    c.value.fold(
        fail(null),
        fail,
        fail,
        d,
        fail,
        fail,
      )
  }

}