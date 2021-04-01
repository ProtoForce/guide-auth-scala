package io.protoforce.runtime.codecs.circe

import io.circe.Json
import io.protoforce.runtime.codecs.IRTCodec
import io.protoforce.runtime.codecs.IRTCodec.IRTCodecFailure

class CirceCodecEither[L: IRTCodecJson, R: IRTCodecJson](left: String, right: String) extends IRTCodec[Either[L, R], Json] {
  private val codecL = implicitly[IRTCodecJson[L]]
  private val codecR = implicitly[IRTCodecJson[R]]

  override def encode(justValue: Either[L, R]): Json = justValue match {
    case Left(value) =>
      Json.obj(left -> codecL.encode(value))

    case Right(value) =>
      Json.obj(right -> codecR.encode(value))
  }

  override def decode(wireValue: Json): Either[List[IRTCodecFailure], Either[L, R]] = {
    wireValue.asObject match {
      case Some(_) =>
        wireValue.hcursor.downField(right).focus match {
          case Some(value) =>
            for {
              decoded <- codecR.decode(value)
            } yield {
              Right(decoded)
            }
          case None =>
            wireValue.hcursor.downField(left).focus match {
              case Some(value) =>
                for {
                  decoded <- codecL.decode(value)
                } yield {
                  Left(decoded)
                }
              case None =>
                Left(List(IRTCodecFailure.IRTCodecIssue(s"`$left` or `$right` expected in `$wireValue`")))
            }
        }

      case None =>
        Left(List(IRTCodecFailure.IRTCodecIssue(s"Object expected but got `$wireValue`")))
    }
  }
}