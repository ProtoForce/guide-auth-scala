package io.protoforce.model.common

import io.protoforce.model.CachedHashcode

final case class Subpkg(path: Seq[String]) extends CachedHashcode {
  def nonEmpty: Boolean = path.nonEmpty
  def isEmpty: Boolean = path.isEmpty

  override def toString: String = path.mkString("::")
}

object Subpkg {
  def empty: Subpkg = Subpkg(Seq.empty)
}