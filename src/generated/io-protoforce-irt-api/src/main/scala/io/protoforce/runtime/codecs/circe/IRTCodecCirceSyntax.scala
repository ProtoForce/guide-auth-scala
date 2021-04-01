package io.protoforce.runtime.codecs.circe

import java.net.{URLDecoder, URLEncoder}

import io.circe._
import izumi.fundamentals.platform.language.Quirks
import io.protoforce.runtime.codecs.IRTCodec.IRTCodecFailure
import io.protoforce.runtime.codecs.IRTKeyCodec

trait IRTCodecCirceSyntax extends CirceTime with CirceMore {

  private def arrayOrString(json: Json): Option[Either[List[Json], String]] =
    json.asArray.map(_.toList).map(Left(_)).orElse(json.asString.map(Right(_)))

  def _stubEncoder[T](t: T): Json = {
    Quirks.discard(t)
    Json.fromString("TODO-NO-DECODER")
  }

  def _stubDecoder[T](json: Json): Either[List[IRTCodecFailure], T] = {
    Quirks.discard(json)
    Right(null.asInstanceOf[T])
  }

  @inline final def _decCircePolyNested(json: Json): Either[List[IRTCodecFailure], (String, Json)] = {
    val cursor = json.hcursor

    def fail: List[IRTCodecFailure] = List(
      IRTCodecFailure.IRTCodecIssue(s"""No type name found in JSON, expected JSON of form { "type_name": { ...fields } }, got: $json""")
    )

    for {
      fname <- cursor.keys.flatMap(_.headOption).toRight(fail)
      nested <- cursor.downField(fname).success.toRight(fail)
    } yield {
      (fname, nested.value)
    }
  }

  @inline final def _decCircePolyFlat(json: Json, memberId: String): Either[List[IRTCodecFailure], (String, Json)] = {
    val cursor = json.hcursor

    def fail: List[IRTCodecFailure] = List(
      IRTCodecFailure.IRTCodecIssue(s"""No type name found in JSON, expected JSON of form { "$memberId": "type_name", ... }, got: $json""")
    )

    for {
      fname <- cursor.downField(memberId).success.toRight(fail)
      out <- fname.value.asArray match {
        case Some(value) =>
          val stripped: Json = value.tail.toList match {
            case single :: Nil =>
              single
            case o => Json.fromValues(o)
          }

          for {
            fixed <- cursor.value.asObject match {
              case Some(value) =>
                Right(value.add(memberId, stripped))
              case None =>
                Left(fail)
            }
            out <- value.head.asString.toRight(fail).map(name => (name, Json.fromJsonObject(fixed)))
          } yield {
            out
          }

        case None =>
          fname.value.asString.toRight(fail).map(name => (name, cursor.value))
      }
    } yield {
      out
    }
  }

  @inline final def _encCircePolyNestedJson(value: Json, memberId: String): Json = {
    Json.obj((memberId, value))
  }

  @inline final def _encCircePolyFlatJson(value: Json, typeField: String, memberId: String): Json = {

    def scalar: Json = Json.obj(typeField -> Json.fromString(memberId), "value" -> value)

    val out = value.fold(
      scalar,
      _ => scalar,
      _ => scalar,
      _ => scalar,
      _ => scalar,
      v =>
        v(typeField) match {
          case Some(value) =>
            val ext = value.asArray match {
              case Some(value) =>
                Json.fromValues(Json.fromString(memberId) +: value)
              case None =>
                Json.fromValues(Seq(Json.fromString(memberId), value))
            }
            Json.fromJsonObject(v.add(typeField, ext))
          case None =>
            Json.fromJsonObject(v.add(typeField, Json.fromString(memberId)))
        },
    )
    //println(s"_encCircePolyFlatJson($value, $typeField, $memberId) ; ${value.getClass}; ==> $out")
    out
  }

  @inline final def _dec_scalar_poly[T: IRTCodecJson](json: Json): Either[List[IRTCodecFailure], T] = {
    for {
      a <- Right(
        json.hcursor.downField("value").success.getOrElse(Json.Null.hcursor)
      ) //.toRight(List(IRTCodecFailure.IRTCodecIssue(s"`value` field expected in json corresponding to a scalar: ${json}")))
      b <- implicitly[IRTCodecJson[T]].decode(a.value)
    } yield {
      b
    }
  }

  @inline final def _dec_type[T: IRTCodecJson](json: Json): Either[List[IRTCodecFailure], T] = {
    implicitly[IRTCodecJson[T]].decode(json)
  }

  @inline final def _dec_field[T: IRTCodecJson](json: Json, field: String): Either[List[IRTCodecFailure], T] = {
    val cursor = json.hcursor
    val fval = cursor.downField(field).success.map(_.value).getOrElse(Json.Null)
    implicitly[IRTCodecJson[T]].decode(fval)
  }

  @inline final def _enc_object_fields(t: (String, Json, Boolean)*): Json = {
    val fields = t.flatMap {
      case (name, value, nullIgnorable) =>
        if (nullIgnorable && value.isNull) {
          Seq.empty
        } else {
          Seq((name, value))
        }
    }
    Json.fromJsonObject(JsonObject.fromIterable(fields))
  }

  // identifiers
  @inline final def _enc_identifier[T: IRTKeyCodec](t: T): Json = {
    Json.fromString(implicitly[IRTKeyCodec[T]].encode(t))
  }

  @inline final def _dec_identifier[T: IRTKeyCodec](t: Json): Either[List[IRTCodecFailure], T] = {
    t.asString match {
      case Some(value) =>
        implicitly[IRTKeyCodec[T]].decode(value)
      case None =>
        Left(List(IRTCodecFailure.IRTCodecIssue(s"Cannot decode identifier into key, json string expected but got: `$t`")))
    }
  }

  @inline final def _enc_circe_identifier_StringToJson(id: String, values: List[(String, String)]): Json = {
    Json.fromString(_enc_circe_identifier_StringToString(id, values))
  }

  @inline final def _enc_circe_identifier_StringToString(id: String, values: List[(String, String)]): String = {
    val pairs = values.map {
      case (k, v) =>
        val sk = escape(k)
        val sv = escape(v)
        s"$sk=$sv"
    }

    //pairs.mkString(s"$id{", ";", "}")
    pairs.mkString(s"$id#", ";", "")
  }

  @inline final def _decCirceIdtUnpack(id: String, value: String, fields: List[String]): Either[List[IRTCodecFailure], Map[String, String]] = {
    def fail(message: String) = Left(List(IRTCodecFailure.IRTCodecIssue(s"Codec failure while decoding type `$id` from `$value`: $message")))

    val indexData = value.indexOf("#")
    if (indexData > 0) {
      val name = value.substring(0, indexData)
      if (name == id) {
        val parts = value.substring(indexData + 1, value.length).split(';').map {
          p =>
            (p, p.indexOf("="))
        }

        val (good, bad) = parts.partition(_._2 > 0)

        if (bad.isEmpty) {
          val asMap = good.map {
            case (p, idx) =>
              val (k, v) = p.splitAt(idx)
              k -> unescape(v.substring(1))
          }.toMap

          val missing = fields.toSet.diff(asMap.keySet)
          if (missing.isEmpty) {
            Right(asMap)
          } else {
            fail(s"missing keys=$missing")
          }
        } else {
          fail(s"unexpected id format, missing value, ${bad.mkString(", ")}")
        }
      } else {
        fail(s"unexpected type id `$name`")
      }
    } else {
      fail(s"unexpected id format, missing `{}`")
    }

    //    val indexBegin = value.indexOf('{')
    //    val indexEnd = value.lastIndexOf('}')
    //    if (indexBegin > 0 && indexEnd > indexBegin) {
    //      val name = value.substring(0, indexBegin)
    //      if (name == id) {
    //        val parts = value.substring(indexBegin + 1, indexEnd).split(';').map {
    //          p =>
    //            (p, p.indexOf("="))
    //        }
    //
    //        val (good, bad) = parts.partition(_._2 > 0)
    //
    //        if (bad.isEmpty) {
    //          val asMap = good
    //            .map {
    //              case (p, idx) =>
    //                val (k, v) = p.splitAt(idx)
    //                k -> unescape(v.substring(1))
    //            }
    //            .toMap
    //
    //          val missing = fields.toSet.diff(asMap.keySet)
    //          if (missing.isEmpty) {
    //            Right(asMap)
    //          } else {
    //            fail(s"missing keys=$missing")
    //          }
    //        } else {
    //          fail(s"unexpected id format, missing value, ${bad.mkString(", ")}")
    //        }
    //      } else {
    //        fail(s"unexpected type id `$name`")
    //      }
    //    } else {
    //      fail(s"unexpected id format, missing `{}`")
    //    }
  }

  @inline final def _decCirceCursor[T: IRTKeyCodec](ctx: String, fieldname: String, fields: Map[String, String]): Either[List[IRTCodecFailure], T] = {
    for {
      fieldv <- fields.get(fieldname).toRight(List(IRTCodecFailure.IRTCodecIssue(s"Cannot decode identifier field $fieldname, raw value: $ctx")))
      dec <- implicitly[IRTKeyCodec[T]].decode(fieldv)
    } yield {
      dec
    }
  }

  @inline final def escape(s: String): String = URLEncoder.encode(s, "UTF-8")

  @inline final def unescape(s: String): String = URLDecoder.decode(s, "UTF-8")

  // enums
  @inline final def _dec_circe_enum_fromJsonVal[T, V: IRTCodecJson](s: Json, mapping: Map[V, T]): Either[List[IRTCodecFailure], T] = {
    for {
      v <- implicitly[IRTCodecJson[V]].decode(s)
      r <- mapping.get(v).toRight(List(IRTCodecFailure.IRTCodecIssue(s"Unexpected enum value: $v, expected=${mapping.keySet.mkString("{", ",", "}")}")))
    } yield {
      r
    }
  }

  @inline final def _dec_circe_enum_fromStrVal[T, V: IRTKeyCodec](s: String, mapping: Map[V, T]): Either[List[IRTCodecFailure], T] = {
    for {
      v <- implicitly[IRTKeyCodec[V]].decode(s)
      r <- mapping.get(v).toRight(List(IRTCodecFailure.IRTCodecIssue(s"Unexpected enum value: $v, expected=${mapping.keySet.mkString("{", ",", "}")}")))
    } yield {
      r
    }
  }

  @inline final def _dec_circe_enum_fromJsonStr[T](s: Json, mapping: Map[String, T]): Either[List[IRTCodecFailure], T] = {
    s.asString match {
      case Some(value) =>
        _dec_circe_enum_fromStr(value, mapping)
      case None =>
        Left(List(IRTCodecFailure.IRTCodecIssue(s"String expected, got `$s`")))
    }
  }

  @inline final def _dec_circe_enum_fromStr[T](s: String, mapping: Map[String, T]): Either[List[IRTCodecFailure], T] = {
    mapping.get(s).toRight {
      List(IRTCodecFailure.IRTCodecIssue(s"Unexpected enum element name: `$s`, expected=${mapping.keySet.mkString("{", ",", "}")}"))
    }
  }
}