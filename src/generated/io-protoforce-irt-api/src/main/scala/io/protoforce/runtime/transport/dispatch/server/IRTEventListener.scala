package io.protoforce.runtime.transport.dispatch.server

import izumi.functional.bio._
import izumi.fundamentals.platform.language.unused

trait IRTEventListener[F[_, _]] {
  def message(str: String): Unit

  def onHttpResponse(
    @unused response: String,
    code: Int,
    headers: Map[String, String],
  ): F[Nothing, Unit]

  def onWsSend(value: String, isBuzzer: Boolean): F[Nothing, Unit]

  def onWsBodyReceived(sbody: String): F[Nothing, Unit]

  def onHttpBodyReceived(path: String, sbody: String): F[Nothing, Unit]
}

object IRTEventListener {

  def nullListener[F[+_, +_]: IO2]: IRTEventListener[F] = {
    new IRTEventListener[F] {
      override def message(@unused str: String): Unit = {}
      override def onHttpBodyReceived(
        @unused path: String,
        @unused sbody: String,
      ): F[Nothing, Unit] = F.unit
      override def onWsBodyReceived(@unused sbody: String): F[Nothing, Unit] =
        F.unit
      override def onWsSend(
        @unused value: String,
        @unused isBuzzer: Boolean,
      ): F[Nothing, Unit] = F.unit
      override def onHttpResponse(
        @unused response: String,
        code: Int,
        headers: Map[String, String],
      ): F[Nothing, Unit] = F.unit
    }
//    debugListener[F]
  }

//  def debugListener[F[+_, +_] : IO2]: IRTEventListener[F] = new IRTEventListener[F] {
//
//    override def message(str: String): Unit = {
//      println(str)
//    }
//
//    override def onHttpBodyReceived(path: String, sbody: String): F[Nothing, Unit] = F.sync {
//      println(s"[rpc-http-request]: $path = $sbody")
//    }
//
//    override def onWsBodyReceived(sbody: String): F[Nothing, Unit] = F.sync {
//      println(s"[rpc-ws-request]: $sbody")
//    }
//
//    override def onWsSend(value: String, isBuzzer: Boolean): F[Nothing, Unit] = F.sync {
//      if (isBuzzer) {
//        println(s"[rpc-ws-buzzer-request]: $value")
//      } else {
//        println(s"[rpc-ws-response]: $value")
//      }
//    }
//
//    override def onHttpResponse(response: String, code: Int, headers: Map[String, String]): F[Nothing, Unit] = F.sync {
//      println(s"[rpc-http-response]: $code $headers $response")
//    }
//  }
}