package io.protoforce.runtime.transport.dispatch.server.http

class CORSBase(
  headers: AbstractHttpResponseHeaders[String]
) {
  def corsBase: Map[String, String] = cors
  def corsMore: Map[String, String] = corsMoreH

  private val allRpcHeaders = headers.allHeaders.mkString(", ")

  private val corsMoreH = Map(
    "Access-Control-Allow-Origin" -> "*",
    "Access-Control-Max-Age" -> "86400",
  )
  private val pfHeaders: Seq[Any] = Seq(
    "Origin",
    "X-Requested-With",
    "X-HTTP-Method-Override",
    "Content-Type",
    "Accept",
    "Authorization",
    "X-Forwarded-For",
  )

  private val allPfHeaders = pfHeaders.mkString(", ")

  private val cors = Map(
    "Access-Control-Allow-Methods" -> Seq(
      "GET",
      "POST",
      "PUT",
      "DELETE",
      "PATCH",
      "OPTIONS",
    ).mkString(", "),
    "Access-Control-Allow-Headers" -> allPfHeaders,
    "Access-Control-Expose-Headers" -> allRpcHeaders,
  )
}