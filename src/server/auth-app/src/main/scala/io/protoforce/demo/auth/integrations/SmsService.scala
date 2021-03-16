package io.protoforce.demo.auth.integrations

import io.protoforce.demo.auth.models.SmsConfig
import izumi.functional.bio.IO2
import logstage.LogIO2
import org.asynchttpclient.AsyncHttpClient

trait SmsService[F[+_, +_]] {
  def sendSMS(phone: String, message: String): F[Nothing, Unit]

}

object SmsService {
  class SmsServiceDummyImpl[F[+_, +_] : IO2](
                                              client: AsyncHttpClient,
                                              config: SmsConfig,
                                              logger: LogIO2[F],
                                            ) extends SmsService[F] {
    override def sendSMS(phone: String, message: String): F[Nothing, Unit] = {
      logger.info(s"Dummy sms service: $message => $phone")

    }
  }
}