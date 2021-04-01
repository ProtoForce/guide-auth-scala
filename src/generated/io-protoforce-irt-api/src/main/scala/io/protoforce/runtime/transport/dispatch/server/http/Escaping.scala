package io.protoforce.runtime.transport.dispatch.server.http

import java.net.{URLDecoder, URLEncoder}

object Escaping {
  @inline final def escape(s: String): String = URLEncoder.encode(s, "UTF-8")

  @inline final def unescape(s: String): String = URLDecoder.decode(s, "UTF-8")
}