package io.protoforce.runtime

trait Tag[T]

object Tag {
  implicit class TaggedSyntax[T](t: IRT[T]) {
    def untag(): T = t.asInstanceOf[T]
  }
}