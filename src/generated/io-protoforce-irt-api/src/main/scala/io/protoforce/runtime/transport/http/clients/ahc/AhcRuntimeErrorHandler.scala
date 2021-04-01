package io.protoforce.runtime.transport.http.clients.ahc

import io.protoforce.runtime.transport.RuntimeErrorHandler

object AhcRuntimeErrorHandler {
  class RuntimeErrorHandlerDefaultImpl[-T]() extends RuntimeErrorHandler[T, Context] {
    override def onCritical(context: Context, value: List[Throwable]): Unit = super.onCritical(context, value)

    override def onInfo(context: Context, value: List[Throwable]): Unit = super.onInfo(context, value)

    override def onDomain(context: Context, value: T): Unit = super.onDomain(context, value)
  }

  def ignore: RuntimeErrorHandler[Any, Context] = new RuntimeErrorHandler[Any, Context] {}

  def print: RuntimeErrorHandler[Any, Context] = new RuntimeErrorHandler[Any, Context] {
    override def onCritical(context: Context, value: List[Throwable]): Unit = {
      System.err.println(s"Unhandled error in $context")
      value.foreach(_.printStackTrace())
    }

    override def onInfo(context: Context, value: List[Throwable]): Unit = {
      System.err.println(s"Unhandled issue in $context")
      value.foreach(_.printStackTrace())
    }

    override def onDomain(context: Context, value: Any): Unit = {
      System.err.println(s"Unhandled error in $context: $value")
    }
  }

  sealed trait Context
  object Context {
    case class WebsocketClientSession() extends Context
  }
}