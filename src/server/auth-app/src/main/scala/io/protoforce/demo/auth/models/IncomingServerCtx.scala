package io.protoforce.demo.auth.models

final case class IncomingServerCtx(ip: String, headers: Map[String, Seq[String]])


final case class CustomWsMeta()

