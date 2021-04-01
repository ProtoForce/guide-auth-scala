package io.protoforce.runtime.transport.dispatch.server.http

trait AbstractHeader[H] {
  def create(s: String): H
  def asString(h: H): String
}

object AbstractHeader {

  implicit object StringHeader extends AbstractHeader[String] {
    override def create(s: String): String = s

    override def asString(h: String): String = h
  }

}