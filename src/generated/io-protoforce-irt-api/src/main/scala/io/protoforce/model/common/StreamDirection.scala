package io.protoforce.model.common

sealed trait StreamDirection {}

object StreamDirection {
  final case object ToServer extends StreamDirection
  final case object ToClient extends StreamDirection
}