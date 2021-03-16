package io.protoforce.demo.auth.integrations

import io.circe.parser.parse
import io.protoforce.demo.auth.integrations.FacebookService.VerifiedFacebook
import io.protoforce.demo.auth.models.FacebookConfig
import izumi.functional.bio.{Async2, F, IO2}
import org.asynchttpclient.AsyncHttpClient

trait FacebookService[F[+_, +_]] {
  def verifyFacebook(accessToken: String) : F[Nothing, VerifiedFacebook]

}

object FacebookService {
  case class VerifiedFacebook(email: String)

  case class EmailsResponse(id: String, email: String)
  object EmailsResponse {
    implicit val codec = io.circe.derivation.deriveCodec[EmailsResponse]
  }

  class FacebookServiceImpl[F[+_, +_] : IO2 : Async2](
                                              client: AsyncHttpClient,
                                              config: FacebookConfig,
                                            ) extends FacebookService[F] {
    override def verifyFacebook(accessToken: String): F[Nothing, VerifiedFacebook] = {
      for {
        emails <- F
          .fromFutureJava(
            client
              .prepareGet(s"https://graph.facebook.com/me?fields=email&access_token=${accessToken}")
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
        VerifiedFacebook(emailData.email)
      }
    }
  }
}