package io.protoforce.runtime.codecs.circe

import io.circe.{Parser, Printer}
import io.protoforce.runtime.codecs.IRTCodec
import io.protoforce.runtime.codecs.IRTCodec.IRTCodecFailure

trait IRTDomainCodecCirceString { this: IRTDomainCodecCirceJson =>
  protected def parser: Parser = (input: String) => io.circe.parser.parse(input)

  protected def printerBase: Printer = Printer.spaces2SortKeys

  private final def printer: Printer = printerBase.copy(dropNullValues = false)

  implicit def asStringCodec[T: IRTCodecWire]: IRTCodec[T, String] = {
    val codec = implicitly[IRTCodecWire[T]]
    new IRTCodec[T, String] {
      override def encode(justValue: T): String = {
        codec.encode(justValue).printWith(printer)
      }

      override def decode(wireValue: String): Either[List[IRTCodecFailure], T] = {
        for {
          parsed <- parser.parse(wireValue).left.map(f => List(IRTCodecFailure.IRTParserException(wireValue, f)))
          decoded <- codec.decode(parsed)
        } yield {
          decoded
        }
      }
    }
  }

}