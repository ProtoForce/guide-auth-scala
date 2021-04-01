package io.protoforce.runtime.codecs.circe

import java.time.format.DateTimeFormatter
import java.time.{DateTimeException, LocalDate, LocalDateTime, LocalTime, OffsetDateTime}

import io.protoforce.runtime.{IRTLocalDate, IRTLocalDateTime, IRTLocalTime, IRTOffsetDateTime}
import io.circe.{Decoder, Encoder, HCursor, Json, KeyDecoder, KeyEncoder}

trait CirceTime {
  // IRTOffsetDateTime
  implicit val CirceEncoderZonedDateTime: Encoder[IRTOffsetDateTime] = {
    encodeZonedDateTime(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
      .contramap {
        a: IRTOffsetDateTime => a.untag()
      }
  }
  implicit val KeyCirceEncoderZonedDateTime: KeyEncoder[IRTOffsetDateTime] = {
    encodeZonedDateTimeKey(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
      .contramap {
        a: IRTOffsetDateTime => a.untag()
      }
  }
  implicit val CirceDecoderZonedDateTime: Decoder[IRTOffsetDateTime] = {
    c: HCursor =>
      Decoder.decodeOffsetDateTime.apply(c).map(IRTOffsetDateTime.apply)
  }
  implicit val KeyCirceDecoderZonedDateTime: KeyDecoder[IRTOffsetDateTime] = (key: String) => {
    try {
      Some(IRTOffsetDateTime(OffsetDateTime.parse(key, DateTimeFormatter.ISO_OFFSET_DATE_TIME)))
    } catch {
      case _: DateTimeException =>
        None
    }
  }

  // IRTLocalDateTime
  implicit val CirceEncoderLocalDateTime: Encoder[IRTLocalDateTime] = {
    encodeLocalDateTime(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
      .contramap {
        a: IRTLocalDateTime => a.untag()
      }
  }
  implicit val KeyCirceEncoderLocalDateTime: KeyEncoder[IRTLocalDateTime] = {
    encodeLocalDateTimeKey(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
      .contramap {
        a: IRTLocalDateTime => a.untag()
      }
  }
  implicit val CirceDecoderLocalDateTime: Decoder[IRTLocalDateTime] = {
    c: HCursor =>
      Decoder.decodeLocalDateTime.apply(c).map(IRTLocalDateTime.apply)
  }
  implicit val KeyCirceDecoderLocalDateTime: KeyDecoder[IRTLocalDateTime] = (key: String) => {
    try {
      Some(IRTLocalDateTime(LocalDateTime.parse(key, DateTimeFormatter.ISO_LOCAL_DATE_TIME)))
    } catch {
      case _: DateTimeException =>
        None
    }
  }

  // IRTLocalDate
  implicit val CirceEncoderLocalDate: Encoder[IRTLocalDate] = {
    implicitly[Encoder[LocalDate]]
      .contramap {
        a: IRTLocalDate => a.untag()
      }
  }
  implicit val KeyCirceEncoderLocalDate: KeyEncoder[IRTLocalDate] = {
    (key: IRTLocalDate) => DateTimeFormatter.ISO_LOCAL_DATE.format(key.untag())
  }
  implicit val CirceDecoderLocalDate: Decoder[IRTLocalDate] = {
    c: HCursor =>
      Decoder.decodeLocalDate.apply(c).map(IRTLocalDate.apply)
  }
  implicit val KeyCirceDecoderLocalDate: KeyDecoder[IRTLocalDate] = (key: String) => {
    try {
      Some(IRTLocalDate(LocalDate.parse(key, DateTimeFormatter.ISO_LOCAL_DATE)))
    } catch {
      case _: DateTimeException =>
        None
    }
  }

  // IRTLocalTime
  implicit val CirceEncoderLocalTime: Encoder[IRTLocalTime] = {
    implicitly[Encoder[LocalTime]]
      .contramap {
        a: IRTLocalTime => a.untag()
      }
  }
  implicit val KeyCirceEncoderLocalTime: KeyEncoder[IRTLocalTime] = {
    (key: IRTLocalTime) => DateTimeFormatter.ISO_LOCAL_TIME.format(key.untag())
  }
  implicit val CirceDecoderLocalTime: Decoder[IRTLocalTime] = {
    c: HCursor =>
      Decoder.decodeLocalTime.apply(c).map(IRTLocalTime.apply)
  }
  implicit val KeyCirceDecoderLocalTime: KeyDecoder[IRTLocalTime] = (key: String) => {
    try {
      Some(IRTLocalTime(LocalTime.parse(key, DateTimeFormatter.ISO_LOCAL_TIME)))
    } catch {
      case _: DateTimeException =>
        None
    }
  }

  // helpers
  private[this] final def encodeZonedDateTime(formatter: DateTimeFormatter): Encoder[OffsetDateTime] =
    Encoder.instance(time => Json.fromString(time.format(formatter)))

  private[this] final def encodeLocalDateTime(formatter: DateTimeFormatter): Encoder[LocalDateTime] =
    Encoder.instance(time => Json.fromString(time.format(formatter)))

  private[this] final def encodeZonedDateTimeKey(formatter: DateTimeFormatter): KeyEncoder[OffsetDateTime] =
    KeyEncoder.instance(time => time.format(formatter))

  private[this] final def encodeLocalDateTimeKey(formatter: DateTimeFormatter): KeyEncoder[LocalDateTime] =
    KeyEncoder.instance(time => time.format(formatter))

}