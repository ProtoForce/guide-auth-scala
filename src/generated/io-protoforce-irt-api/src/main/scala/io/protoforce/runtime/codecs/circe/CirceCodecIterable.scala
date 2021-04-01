package io.protoforce.runtime.codecs.circe

import io.circe.Json
import io.protoforce.runtime.codecs.IRTCodec.IRTCodecFailure

class CirceCodecIterable[A: IRTCodecJson, F[_] <: Iterable[_]](toF: Iterable[A] => F[A]) extends IRTCodecJson[F[A]] {
  private val codec = implicitly[IRTCodecJson[A]]

  override def encode(justValue: F[A]): Json = {
    Json.fromValues(justValue.asInstanceOf[Iterable[A]].map(codec.encode))
  }

  import izumi.functional.IzEither._

  override def decode(wireValue: Json): Either[List[IRTCodecFailure], F[A]] = {
    for {
      arr <- wireValue.asArray.toRight(List(IRTCodecFailure.IRTCodecIssue(s"Iterable expected but got `$wireValue`")))
      x <- arr.map(v => codec.decode(v)).biAggregate
    } yield {
      toF(x)
    }
  }
}