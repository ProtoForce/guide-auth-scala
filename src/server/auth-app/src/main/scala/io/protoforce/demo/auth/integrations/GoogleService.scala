package io.protoforce.demo.auth.integrations

import io.circe.Printer
import io.circe.literal._
import io.circe.parser._
import io.protoforce.demo.auth.integrations.GoogleService.VerifiedGoogle
import io.protoforce.demo.auth.models.GoogleConfig
import izumi.functional.bio.{Async2, F, IO2}
import org.asynchttpclient.AsyncHttpClient

trait GoogleService[F[+_, +_]] {
  def verifyGoogle(accessToken: String): F[Nothing, VerifiedGoogle]

}

object GoogleService {
  case class VerifiedGoogle(email: String)

  case class TokenDataResponse(
      access_token: String,
      expires_in: Long,
      token_type: String,
      refresh_token: String
  )
  object TokenDataResponse {
    implicit val codec = io.circe.derivation.deriveCodec[TokenDataResponse]
  }

  case class EmailsResponse(
      id: String,
      email: String,
      given_name: String,
      family_name: String
  )
  object EmailsResponse {
    implicit val codec = io.circe.derivation.deriveCodec[EmailsResponse]
  }

  class GoogleServiceImpl[F[+_, +_]: IO2: Async2](
      client: AsyncHttpClient,
      config: GoogleConfig,
      printer: Printer
  ) extends GoogleService[F] {
    override def verifyGoogle(
        accessToken: String
    ): F[Nothing, VerifiedGoogle] = {
      for {
        req <- F.pure(
          printer.print(
            json"""{
                     "client_id": ${config.clientId},
                     "client_secret": ${config.clientSecret},
                     "redirect_uri": ${config.redirectUrl},
                     "grant_type": "authorization_code",
                     "code": $accessToken
                    } """
          )
        )
        tokenDataResponse <- F
          .fromFutureJava(
            client
              .preparePost("https://oauth2.googleapis.com/token")
              .setBody(req)
              .execute()
              .toCompletableFuture
          )
          .orTerminate
        tokenData <- F
          .fromEither(
            parse(tokenDataResponse.getResponseBody)
              .flatMap(_.as[TokenDataResponse])
          )
          .orTerminate
        emails <- F
          .fromFutureJava(
            client
              .prepareGet(
                "https://www.googleapis.com/oauth2/v2/userinfo"
              )
              .setHeader("Authorization", s"Bearer ${tokenData.access_token}")
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
        VerifiedGoogle(emailData.email)
      }

    }
  }
}
