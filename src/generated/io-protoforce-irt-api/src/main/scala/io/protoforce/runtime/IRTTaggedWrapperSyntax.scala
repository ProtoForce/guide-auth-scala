package io.protoforce.runtime

trait IRTTaggedWrapperSyntax[T] {
  def apply(t: T): IRT[T] = t.asInstanceOf[IRT[T]]
}