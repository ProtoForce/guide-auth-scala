package io.protoforce.runtime.transport.errors

case class ClientDispatcherException(error: ClientDispatcherError) extends RuntimeException(error.toString)