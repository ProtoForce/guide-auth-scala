package io.protoforce.runtime.transport.dispatch.server.http

trait AbstractHttpResponseHeaders[Header] {
  def allHeaders: Seq[Header]
}

class HttpResponseHeaders[Header: AbstractHeader] extends AbstractHttpResponseHeaders[Header] {
  private val Header = implicitly[AbstractHeader[Header]]
  final val baseHeaders = Map(Header.create("Content-Type") -> "application/json")

  final val XResponseType: Header = Header.create("X-Response-Type")
  final val XResponseTypeSuccess = "Success"
  final val XResponseTypeFailure = "Failure"

  final val XSuccess: Header = Header.create(s"X-$XResponseTypeSuccess")
  final val XSuccessLeft = "Left"
  final val XSuccessRight = "Right"
  final val XSuccessScalar = "Scalar"

  final val XFailure: Header = Header.create(s"X-$XResponseTypeFailure")
  final val XFailureBadInput = "Bad-Input"
  final val XFailureServer = "Server-Failure"

  final val allHeaders: Seq[Header] = Seq(XResponseType, XSuccess, XFailure)
}