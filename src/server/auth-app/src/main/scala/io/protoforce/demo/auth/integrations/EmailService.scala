package io.protoforce.demo.auth.integrations

import io.protoforce.demo.auth.models.EmailConfig
import izumi.functional.bio.IO2
import logstage.LogIO2
import org.asynchttpclient.AsyncHttpClient

trait EmailService[F[+_, +_]] {
  def sendEmail(email: String, message: String): F[Nothing, Unit]
}

object EmailService {
  class EmailServiceDummyImpl[F[+_, +_] : IO2](
                                                client: AsyncHttpClient,
                                                config: EmailConfig,
                                                logger: LogIO2[F],
                                              ) extends EmailService[F] {
    override def sendEmail(email: String, message: String): F[Nothing, Unit] = {
      logger.info(s"Dummy email service: $message => $email")
    }
  }
}