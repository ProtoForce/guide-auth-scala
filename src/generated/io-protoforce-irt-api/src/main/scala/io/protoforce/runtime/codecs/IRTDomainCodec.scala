package io.protoforce.runtime.codecs

import java.util.UUID

import io.protoforce.runtime.transport.dispatch.RPCResult
import io.protoforce.runtime.{IRTLocalDate, IRTLocalDateTime, IRTLocalTime, IRTOffsetDateTime, IRTTypeId}

import scala.collection.compat.immutable.ArraySeq

trait IRTDomainCodec[WIRE] {
  type IRTCodecWire[T] = IRTCodec[T, WIRE]
  type IRTKeyCodecWire[T] = IRTKeyCodec[T]

  implicit def keycodec_TypeId: IRTKeyCodecWire[IRTTypeId]
  implicit def codec_TypeId: IRTCodecWire[IRTTypeId]

  implicit def keycodec_String: IRTKeyCodecWire[String]

  implicit def keycodec_UUID: IRTKeyCodecWire[UUID]
  implicit def keycodec_Byte: IRTKeyCodecWire[Byte]
  implicit def keycodec_Short: IRTKeyCodecWire[Short]
  implicit def keycodec_Int: IRTKeyCodecWire[Int]
  implicit def keycodec_Long: IRTKeyCodecWire[Long]
  implicit def keycodec_BigInt: IRTKeyCodecWire[BigInt]

  implicit def keycodec_java_Long: IRTKeyCodec[java.lang.Long]
  implicit def keycodec_java_Byte: IRTKeyCodec[java.lang.Byte]
  implicit def keycodec_java_Short: IRTKeyCodec[java.lang.Short]
  implicit def keycodec_java_Int: IRTKeyCodec[java.lang.Integer]
  implicit def keycodec_java_BigInt: IRTKeyCodec[java.math.BigInteger]

  implicit def keycodec_IRTOffsetDateTime: IRTKeyCodecWire[IRTOffsetDateTime]
  implicit def keycodec_IRTLocalDateTime: IRTKeyCodecWire[IRTLocalDateTime]
  implicit def keycodec_IRTLocalDate: IRTKeyCodecWire[IRTLocalDate]
  implicit def keycodec_IRTLocalTime: IRTKeyCodecWire[IRTLocalTime]

  implicit def codec_String: IRTCodecWire[String]
  implicit def codec_Unit: IRTCodecWire[Unit]

  implicit def codec_Boolean: IRTCodecWire[Boolean]
  implicit def codec_java_Boolean: IRTCodecWire[java.lang.Boolean]

  implicit def codec_Double: IRTCodecWire[Double]
  implicit def codec_java_Double: IRTCodecWire[java.lang.Double]

  implicit def codec_Char: IRTCodecWire[Char]
  implicit def codec_java_Char: IRTCodecWire[java.lang.Character]

  implicit def codec_Float: IRTCodecWire[Float]
  implicit def codec_java_Float: IRTCodecWire[java.lang.Float]

  implicit def codec_Short: IRTCodecWire[Short]
  implicit def codec_java_Short: IRTCodecWire[java.lang.Short]

  implicit def codec_Byte: IRTCodecWire[Byte]
  implicit def codec_java_Byte: IRTCodecWire[java.lang.Byte]

  implicit def codec_Int: IRTCodecWire[Int]
  implicit def codec_java_Int: IRTCodecWire[java.lang.Integer]

  implicit def codec_Long: IRTCodecWire[Long]
  implicit def codec_java_Long: IRTCodecWire[java.lang.Long]

  implicit def codec_BigInt: IRTCodecWire[BigInt]
  implicit def codec_java_BigInt: IRTCodecWire[java.math.BigInteger]

  implicit def codec_BigDecimal: IRTCodecWire[BigDecimal]
  implicit def codec_java_BigDecimal: IRTCodecWire[java.math.BigDecimal]

  implicit def codec_UUID: IRTCodecWire[UUID]

  implicit def codec_IRTOffsetDateTime: IRTCodecWire[IRTOffsetDateTime]
  implicit def codec_IRTLocalDateTime: IRTCodecWire[IRTLocalDateTime]
  implicit def codec_IRTLocalDate: IRTCodecWire[IRTLocalDate]
  implicit def codec_IRTLocalTime: IRTCodecWire[IRTLocalTime]

  implicit def codec_Blob: IRTCodecWire[ArraySeq[Byte]]

  implicit def codec_Option[A: IRTCodecWire]: IRTCodecWire[Option[A]]

  implicit def codec_Seq[A: IRTCodecWire]: IRTCodecWire[Seq[A]]
  implicit def codec_Set[A: IRTCodecWire]: IRTCodecWire[Set[A]]
  implicit def codec_List[A: IRTCodecWire]: IRTCodecWire[List[A]]
  implicit def codec_Vector[A: IRTCodecWire]: IRTCodecWire[Vector[A]]

  implicit def codec_Map[K: IRTKeyCodecWire, V: IRTCodecWire]: IRTCodecWire[Map[K, V]]
  implicit def codec_Either[L: IRTCodecWire, R: IRTCodecWire]: IRTCodecWire[Either[L, R]]
  implicit def codec_RPCResult[L: IRTCodecWire, R: IRTCodecWire]: IRTCodecWire[RPCResult[L, R]]
}