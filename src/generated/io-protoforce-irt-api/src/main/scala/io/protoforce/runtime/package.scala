package io.protoforce

import java.time.{LocalDate, LocalDateTime, LocalTime, OffsetDateTime}

package object runtime {
  type IRT[T] = T with Tag[T]

  type IRTOffsetDateTime = IRT[OffsetDateTime]
  object IRTOffsetDateTime extends IRTTaggedWrapperSyntax[OffsetDateTime]

  type IRTLocalDateTime = IRT[LocalDateTime]
  object IRTLocalDateTime extends IRTTaggedWrapperSyntax[LocalDateTime]

  type IRTLocalTime = IRT[LocalTime]
  object IRTLocalTime extends IRTTaggedWrapperSyntax[LocalTime]

  type IRTLocalDate = IRT[LocalDate]
  object IRTLocalDate extends IRTTaggedWrapperSyntax[LocalDate]
}