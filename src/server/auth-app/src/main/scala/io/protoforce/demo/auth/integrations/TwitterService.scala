package io.protoforce.demo.auth.integrations

import io.circe.parser.parse
import io.protoforce.demo.auth.integrations.TwitterService.VerifiedTwitter
import io.protoforce.demo.auth.models.TwitterConfig
import izumi.functional.bio.{Async2, F, IO2}
import org.asynchttpclient.AsyncHttpClient

trait TwitterService[F[+_, +_]] {
  def verifyTwitter(accessToken: String) : F[Nothing, VerifiedTwitter]
}

object TwitterService {
  case class VerifiedTwitter(email: String)

  case class EmailsResponse(email: String)
  object EmailsResponse {
    implicit val codec = io.circe.derivation.deriveCodec[EmailsResponse]
  }

  class TwitterServiceImpl[F[+_, +_] : IO2 : Async2](
      client: AsyncHttpClient,
      config: TwitterConfig,
                                           ) extends TwitterService[F] {
    override def verifyTwitter(accessToken: String): F[Nothing, VerifiedTwitter] = {
      for {
        emails <- F
          .fromFutureJava(
            client
              .prepareGet(s"https://api.twitter.com/1.1/account/verify_credentials.json?include_email=true")
              .setHeader("Authorization", s"Bearer ${accessToken}")
              .execute()
              .toCompletableFuture
          )
          .orTerminate
        emailData <- F
          .fromEither(
            parse(emails.getResponseBody)
              .flatMap(_.as[EmailsResponse])
          )
          .orTerminate
      } yield {
        VerifiedTwitter(emailData.email)
      }
    }
  }
}