package io.protoforce.demo.auth.services

import izumi.functional.bio.{F, IO2}

trait SanitationService[F[+_, +_]] {
  def sanitizePhone(phone: String): F[Nothing, String]
  def sanitizeEmail(email: String): F[Nothing, String]

}

object SanitationService {
  class SanitationServiceImpl[F[+_, +_]: IO2] extends SanitationService[F] {
    override def sanitizePhone(phone: String): F[Nothing, String] = {
      F.sync(phone.trim.toLowerCase.replaceAll("\\D", ""))
    }

    override def sanitizeEmail(email: String): F[Nothing, String] = {
      F.sync(email.trim.toLowerCase)
    }
  }
}
