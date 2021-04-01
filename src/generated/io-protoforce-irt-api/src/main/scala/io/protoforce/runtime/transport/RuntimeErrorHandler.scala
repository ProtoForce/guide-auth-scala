package io.protoforce.runtime.transport

import izumi.functional.bio.Exit
import izumi.fundamentals.platform.language.Quirks._

trait RuntimeErrorHandler[-T, Context] {
  def onCritical(context: Context, value: List[Throwable]): Unit = {
    (context, value).discard()
  }
  def onInfo(context: Context, value: List[Throwable]): Unit = {
    (context, value).discard()
  }
  def onDomain(context: Context, value: T): Unit = {
    (context, value).discard()
  }

  final def handle(context: Context)(f: Exit[T, _]): Unit = {
    f match {
      case Exit.Success(_) =>
      case failure: Exit.Failure[T] =>
        failure.toEither match {
          case Left(value) =>
            onCritical(context, value)
          case Right(value) =>
            onDomain(context, value)
        }
    }
  }
}