package io.protoforce.runtime.codecs

import io.protoforce.runtime.codecs.IRTCodec.IRTCodecFailure

trait IRTCodec[T, W] {
  def encode(justValue: T): W

  def decode(wireValue: W): Either[List[IRTCodecFailure], T]
}

trait IRTKeyCodec[T] {
  def encode(justValue: T): String

  def decode(wireValue: String): Either[List[IRTCodecFailure], T]
}

object IRTCodec {

  sealed trait IRTCodecFailure

  object IRTCodecFailure {
    final case class IRTCodecIssue(message: String) extends IRTCodecFailure
    final case class IRTParserException(unparseable: String, throwable: Throwable) extends IRTCodecFailure
    final case class IRTCodecException(throwable: Throwable) extends IRTCodecFailure
  }

}