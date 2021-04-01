package io.protoforce.runtime.codecs.circe

import java.util.UUID

import io.circe.Json
import io.protoforce.runtime.codecs.IRTCodec.IRTCodecFailure
import io.protoforce.runtime.codecs.{IRTCodec, IRTKeyCodec}
import io.protoforce.runtime.transport.dispatch.RPCResult
import io.protoforce.runtime.{IRTLocalDate, IRTLocalDateTime, IRTLocalTime, IRTOffsetDateTime, IRTTypeId}

import scala.collection.compat.immutable.ArraySeq

trait IRTDomainCodecCirceJson extends IRTDomainCodecCirceAdapters with IRTCodecCirceSyntax {
  override implicit def keycodec_String: IRTKeyCodecWire[String] = fromCirceJsonKey

  override implicit def keycodec_TypeId: IRTKeyCodecWire[IRTTypeId] = fromCirceJsonKey

  override implicit def codec_TypeId: IRTCodecWire[IRTTypeId] = fromCirceJson

  override implicit def keycodec_UUID: IRTKeyCodecWire[UUID] = fromCirceJsonKey

  override implicit def keycodec_Byte: IRTKeyCodecWire[Byte] = fromCirceJsonKey

  override implicit def keycodec_Short: IRTKeyCodecWire[Short] = fromCirceJsonKey

  override implicit def keycodec_Int: IRTKeyCodecWire[Int] = fromCirceJsonKey

  override implicit def keycodec_Long: IRTKeyCodecWire[Long] = fromCirceJsonKey

  override implicit def keycodec_BigInt: IRTKeyCodecWire[BigInt] = fromCirceJsonKey

  override implicit def keycodec_java_Long: IRTKeyCodec[java.lang.Long] = adaptKeyCodec[Long, java.lang.Long](x => x, x => x)

  override implicit def keycodec_java_Byte: IRTKeyCodec[java.lang.Byte] = adaptKeyCodec[Byte, java.lang.Byte](x => x, x => x)

  override implicit def keycodec_java_Short: IRTKeyCodec[java.lang.Short] = adaptKeyCodec[Short, java.lang.Short](x => x, x => x)

  override implicit def keycodec_java_Int: IRTKeyCodec[java.lang.Integer] = adaptKeyCodec[Int, java.lang.Integer](x => x, x => x)

  override implicit def keycodec_java_BigInt: IRTKeyCodec[java.math.BigInteger] = adaptKeyCodec[BigInt, java.math.BigInteger](x => x.bigInteger, x => x)

  override implicit def keycodec_IRTOffsetDateTime: IRTKeyCodecWire[IRTOffsetDateTime] = fromCirceJsonKey

  override implicit def keycodec_IRTLocalDateTime: IRTKeyCodecWire[IRTLocalDateTime] = fromCirceJsonKey

  override implicit def keycodec_IRTLocalDate: IRTKeyCodecWire[IRTLocalDate] = fromCirceJsonKey

  override implicit def keycodec_IRTLocalTime: IRTKeyCodecWire[IRTLocalTime] = fromCirceJsonKey

  override implicit def codec_String: IRTCodecWire[String] = fromCirceJson

  override implicit def codec_Short: IRTCodecWire[Short] = fromCirceJson

  override implicit def codec_Byte: IRTCodecWire[Byte] = fromCirceJson

  override implicit def codec_Int: IRTCodecWire[Int] = fromCirceJson

  override implicit def codec_Long: IRTCodecWire[Long] = fromCirceJson

  override implicit def codec_UUID: IRTCodecWire[UUID] = fromCirceJson

  override implicit def codec_Boolean: IRTCodecWire[Boolean] = fromCirceJson

  override implicit def codec_Double: IRTCodecWire[Double] = fromCirceJson

  override implicit def codec_Char: IRTCodecWire[Char] = fromCirceJson

  override implicit def codec_Float: IRTCodecWire[Float] = fromCirceJson

  override implicit def codec_BigInt: IRTCodecWire[BigInt] = fromCirceJson

  override implicit def codec_BigDecimal: IRTCodecWire[BigDecimal] = fromCirceJson

  override implicit def codec_java_Byte: IRTCodecWire[java.lang.Byte] = fromCirceJson

  override implicit def codec_java_Int: IRTCodecWire[java.lang.Integer] = fromCirceJson

  override implicit def codec_java_Long: IRTCodecWire[java.lang.Long] = fromCirceJson

  override implicit def codec_java_Double: IRTCodecWire[java.lang.Double] = fromCirceJson

  override implicit def codec_java_Boolean: IRTCodecWire[java.lang.Boolean] = fromCirceJson

  override implicit def codec_java_Char: IRTCodecWire[java.lang.Character] = fromCirceJson

  override implicit def codec_java_Float: IRTCodecWire[java.lang.Float] = fromCirceJson

  override implicit def codec_java_Short: IRTCodecWire[java.lang.Short] = fromCirceJson

  override implicit def codec_java_BigInt: IRTCodecWire[java.math.BigInteger] = fromCirceJson

  override implicit def codec_java_BigDecimal: IRTCodecWire[java.math.BigDecimal] = fromCirceJson

  override implicit def codec_IRTOffsetDateTime: IRTCodecWire[IRTOffsetDateTime] = fromCirceJson

  override implicit def codec_IRTLocalDateTime: IRTCodecWire[IRTLocalDateTime] = fromCirceJson

  override implicit def codec_IRTLocalDate: IRTCodecWire[IRTLocalDate] = fromCirceJson

  override implicit def codec_IRTLocalTime: IRTCodecWire[IRTLocalTime] = fromCirceJson

  override implicit def codec_Blob: IRTCodecWire[ArraySeq[Byte]] = fromCirceJson

  override implicit def codec_Unit: IRTCodecWire[Unit] = fromCirceJson

  override implicit def codec_Option[A: IRTCodecWire]: IRTCodecWire[Option[A]] = new CirceCodecOption[A]

  override implicit def codec_Seq[A: IRTCodecWire]: IRTCodecWire[Seq[A]] = new CirceCodecIterable[A, Seq](_.toSeq)

  override implicit def codec_Set[A: IRTCodecWire]: IRTCodecWire[Set[A]] = new CirceCodecIterable[A, Set](_.toSet)

  override implicit def codec_Vector[A: IRTCodecWire]: IRTCodecWire[Vector[A]] = new CirceCodecIterable[A, Vector](_.toVector)

  override implicit def codec_List[A: IRTCodecWire]: IRTCodecWire[List[A]] = new CirceCodecIterable[A, List](_.toList)

  override implicit def codec_Map[K: IRTKeyCodecWire, V: IRTCodecWire]: IRTCodecWire[Map[K, V]] = new CirceCodecMap[K, V]

  override implicit def codec_Either[L: IRTCodecWire, R: IRTCodecWire]: IRTCodecWire[Either[L, R]] = new CirceCodecEither("left", "right")

  override implicit def codec_RPCResult[L: IRTCodecWire, R: IRTCodecWire]: IRTCodecWire[RPCResult[L, R]] = new IRTCodecWire[RPCResult[L, R]] {
    override def encode(justValue: RPCResult[L, R]): Json = {
      import io.circe.literal._
      justValue match {
        case RPCResult.Good(value) => json"""{${RPCResult.right}: ${implicitly[IRTCodec[R, Json]].encode(value)}}"""

        case RPCResult.Bad(value) => json"""{${RPCResult.left}: ${implicitly[IRTCodec[L, Json]].encode(value)}}"""
      }
    }

    override def decode(wireValue: Json): Either[List[IRTCodecFailure], RPCResult[L, R]] = {
      wireValue.asObject match {
        case Some(value) =>
          value.toMap.get(RPCResult.right) match {
            case Some(value) =>
              implicitly[IRTCodec[R, Json]].decode(value).map(v => RPCResult.Good(v))
            case None =>
              value.toMap.get(RPCResult.left) match {
                case Some(value) =>
                  implicitly[IRTCodec[L, Json]].decode(value).map(v => RPCResult.Bad(v))
                case None =>
                  Left(List(IRTCodecFailure.IRTCodecException(new RuntimeException(s"unexpected json: $wireValue"))))
              }
          }
        case None =>
          Left(List(IRTCodecFailure.IRTCodecException(new RuntimeException(s"unexpected json: $wireValue"))))
      }
    }
  }
}