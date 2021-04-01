package io.protoforce.model.common

import io.protoforce.model.CachedHashcode

final case class Pkg(_path: Seq[String]) extends CachedHashcode {
  def path: Seq[String] = _path

  def nonEmpty: Boolean = _path.nonEmpty

  def isEmpty: Boolean = _path.isEmpty
}

object Pkg {
  def empty: Pkg = Pkg(Seq.empty)
}