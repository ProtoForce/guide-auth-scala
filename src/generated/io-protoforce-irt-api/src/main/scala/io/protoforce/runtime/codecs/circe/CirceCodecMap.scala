package io.protoforce.runtime.codecs.circe

import io.circe.Json
import io.protoforce.runtime.codecs.IRTCodec.IRTCodecFailure
import io.protoforce.runtime.codecs.IRTKeyCodec

class CirceCodecMap[K: IRTKeyCodec, V: IRTCodecJson]() extends IRTCodecJson[Map[K, V]] {
  private val codecK = implicitly[IRTKeyCodec[K]]
  private val codecV = implicitly[IRTCodecJson[V]]

  override def encode(justValue: Map[K, V]): Json = {
    val pairs = justValue.map {
      case (k, v) =>
        val ek = codecK.encode(k)
        val ev = codecV.encode(v)
        (ek, ev)
    }
    Json.fromFields(pairs)
  }

  import izumi.functional.IzEither._

  override def decode(wireValue: Json): Either[List[IRTCodecFailure], Map[K, V]] = {
    for {
      arr <- wireValue.asObject.toRight(List(IRTCodecFailure.IRTCodecIssue(s"Object expected but got `$wireValue`")))
      x <- arr
        .toList
        .map {
          case (k, v) =>
            for {
              dv <- codecV.decode(v)
              kv <- codecK.decode(k)
            } yield {
              (kv, dv)
            }
        }
        .biAggregate
    } yield {
      x.toMap
    }
  }
}