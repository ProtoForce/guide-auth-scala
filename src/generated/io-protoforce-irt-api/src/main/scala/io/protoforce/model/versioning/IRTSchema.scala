package io.protoforce.model.versioning

object IRTSchema {
  case class TypeBaseVersion(version: String) extends AnyVal

  case class TypeFullVersion(version: String) extends AnyVal
}