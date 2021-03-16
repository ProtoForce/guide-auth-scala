package io.protoforce.demo.auth.services

import izumi.functional.bio.{Entropy2, F, IO2}

import java.math.BigInteger
import java.nio.charset.StandardCharsets

trait PasswordService[F[+_, +_]] {
  def nextPhonecode(): F[Nothing, String]

  def hash(value: String, salt: String): F[Nothing, String]
}

object PasswordService {
  class PasswordServiceImpl[F[+_, +_]: IO2: Entropy2]
      extends PasswordService[F] {
    override def hash(value: String, salt: String): F[Nothing, String] =
      F.sync {
        import java.security.MessageDigest
        val digest = MessageDigest
          .getInstance("SHA-256")
          .digest(s"$value:$salt".getBytes(StandardCharsets.UTF_8))
        val hash = String.format(
          "%032x",
          new BigInteger(1, digest)
        )
        hash.reverse.padTo(64, "0").reverse.mkString
      }

    override def nextPhonecode(): F[Nothing, String] =
      for {
        rnd <- Entropy2[F].nextInt(1000000)
      } yield {
        rnd.toString.padTo(6, "0").mkString
      }
  }
}
