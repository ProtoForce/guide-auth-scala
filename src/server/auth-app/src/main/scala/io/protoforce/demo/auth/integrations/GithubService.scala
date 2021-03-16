package io.protoforce.demo.auth.integrations

import io.circe.Printer
import io.circe.literal._
import io.circe.parser._
import io.protoforce.demo.auth.integrations.GithubService.VerifiedGithub
import io.protoforce.demo.auth.models.GithubConfig
import izumi.functional.bio.{Async2, F, IO2}
import org.asynchttpclient.AsyncHttpClient

trait GithubService[F[+_, +_]] {
  def verifyGithub(accessToken: String): F[Nothing, VerifiedGithub]

}

object GithubService {
  case class VerifiedGithub(email: String)

  case class TokenDataResponse(access_token: String)
  object TokenDataResponse {
    implicit val codec = io.circe.derivation.deriveCodec[TokenDataResponse]
  }

  case class EmailsResponse(email: String, primary: Boolean, verified: Boolean)
  object EmailsResponse {
    implicit val codec = io.circe.derivation.deriveCodec[EmailsResponse]
  }

  class GithubServiceImpl[F[+_, +_]: IO2: Async2](
      client: AsyncHttpClient,
      config: GithubConfig,
      printer: Printer
  ) extends GithubService[F] {
    override def verifyGithub(accessToken: String): F[Nothing, VerifiedGithub] =
      for {
        req <- F.pure(
          printer.print(
            json"""{"client_id": ${config.clientId}, "client_secret": ${config.clientSecret}, "code": $accessToken} """
          )
        )
        tokenDataResponse <- F
          .fromFutureJava(
            client
              .preparePost("https://github.com/login/oauth/access_token")
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
              .prepareGet(s"https://api.github.com/user/emails?access_token=${tokenData.access_token}")
              .execute()
              .toCompletableFuture
          )
          .orTerminate
        emailData <- F
          .fromEither(
            parse(emails.getResponseBody)
              .flatMap(_.as[List[EmailsResponse]])
          )
          .orTerminate
        verifiedEmails = emailData.filter(_.verified)
        email <- F.fromOption(new RuntimeException("No valid email found"))(verifiedEmails.find(_.primary).orElse(verifiedEmails.headOption)).orTerminate
      } yield {
        VerifiedGithub(email.email)
      }
  }
}
