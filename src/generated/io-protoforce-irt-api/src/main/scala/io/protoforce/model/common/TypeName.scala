package io.protoforce.model.common

final case class TypeName(name: String) extends AnyVal {
  override def toString: String = name
}