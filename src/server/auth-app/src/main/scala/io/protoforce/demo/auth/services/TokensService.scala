package io.protoforce.demo.auth.services

import dev.samstevens.totp.secret.DefaultSecretGenerator
import io.circe._
import io.circe.syntax._
import io.protoforce.demo.auth.models.TokensConfig
import io.protoforce.guide.auth.UserID
import izumi.functional.bio.{Clock2, F, IO2}
import pdi.jwt.{JwtAlgorithm, JwtCirce, JwtClaim}

trait TokensService[F[+_, +_]] {
  // Primary JWT tokens confirming user identity
  def issueAuthToken(id: UserID): F[Nothing, String]
  def parseAuthToken(token: String): F[Throwable, UserID]

  // Password reset JWT tokens
  def issuePassResetToken(id: UserID): F[Nothing, String]
  def parsePassResetToken(token: String): F[Throwable, UserID]

  // Email confirmation JWT tokens
  def issueEmailConfirmationToken(email: String): F[Nothing, String]
  def parseEmailConfirmationToken(token: String): F[Throwable, String]

  // 2FA challenge JWT tokens
  def issueRestrictedTokenForUnfinished2FA(
      id: UserID
  ): F[Nothing, String]
  def parseRestrictedTokenForUnfinished2FA(token: String): F[Throwable, UserID]

  // 2FA activation JWT tokens
  def parseSignedMfaAuthSecret(token: String): F[Throwable, String]
  def issueSignedMfaAuthSecret(secret: String): F[Nothing, String]

  // TOTP helpers
  def issueMfaAppAuthSecret(): F[Nothing, String]
  def checkMfaCode(secret: String, value: String): F[Nothing, Boolean]
}

object TokensService {
  implicit val codecUserId = io.circe.derivation.deriveCodec[UserID]
  case class TokenContentOut(userID: UserID)
  object TokenContentOut {
    implicit val codec = io.circe.derivation.deriveEncoder[TokenContentOut]
  }
  case class TokenContentAud(aud: String)
  object TokenContentAud {
    implicit val codec = io.circe.derivation.deriveDecoder[TokenContentAud]
  }

  class TokensServiceImpl[F[+_, +_]: IO2](
      config: TokensConfig,
      clock2: Clock2[F],
      printer: Printer
  ) extends TokensService[F] {
    private val algo = JwtAlgorithm.HS256

    private def exp(aud: String): F[Nothing, JwtClaim] = {
      for {
        now <- clock2.nowOffset()
      } yield {
        JwtClaim(
          expiration = Some(
            now
              .plusSeconds(config.expiration.toSeconds)
              .toInstant
              .getEpochSecond
          ),
          issuedAt = Some(now.toInstant.getEpochSecond),
          audience = Some(Set(aud))
        )

      }
    }
    private def makeToken(id: UserID, aud: String): F[Nothing, String] = {
      makeJsonToken(TokenContentOut(id), aud)
    }

    private def makeJsonToken[T: Encoder](
        id: T,
        aud: String
    ): F[Nothing, String] = {
      for {
        claim <- exp(aud)
        content = printer.print(id.asJson)
        fullClaim = claim.withContent(content)
      } yield {
        JwtCirce.encode(fullClaim, config.jwtKey, algo)

      }
    }

    private def parseToken(token: String, aud: String): F[Throwable, UserID] = {

      parseJsonToken[UserID](token, aud)
    }

    private def parseJsonToken[T: Decoder](
        token: String,
        aud: String
    ): F[Throwable, T] = {
      for {
        json <- F.fromTry(JwtCirce.decodeJson(token, config.jwtKey, Seq(algo)))
        content <- F.fromEither(json.as[T])
        tokenAud <- F.fromEither(json.as[TokenContentAud])
        _ <- F.syncThrowable(assert(tokenAud.aud == aud))
      } yield {
        content
      }
    }

    //
    override def issueAuthToken(id: UserID): F[Nothing, String] =
      makeToken(id, "auth")

    override def parseAuthToken(token: String): F[Throwable, UserID] =
      parseToken(token, "auth")

    //
    override def issueRestrictedTokenForUnfinished2FA(
        id: UserID
    ): F[Nothing, String] =
      makeToken(id, "2fa")

    override def parseRestrictedTokenForUnfinished2FA(
        token: String
    ): F[Throwable, UserID] =
      parseToken(token, "2fa")

    //
    override def issuePassResetToken(id: UserID): F[Nothing, String] =
      makeToken(id, "passReset")

    override def parsePassResetToken(
        token: String
    ): F[Throwable, UserID] =
      parseToken(token, "2fa")

    //
    override def parseEmailConfirmationToken(
        token: String
    ): F[Throwable, String] = parseJsonToken[String](token, "emailConfirm")

    override def issueEmailConfirmationToken(
        email: String
    ): F[Nothing, String] = makeJsonToken(email, "emailConfirm")

    //
    override def parseSignedMfaAuthSecret(token: String): F[Throwable, String] =
      parseJsonToken[String](token, "2faSecret")

    override def issueSignedMfaAuthSecret(secret: String): F[Nothing, String] = makeJsonToken(secret, "2faSecret")

    //
    override def issueMfaAppAuthSecret(): F[Nothing, String] = F.sync {
      val secretGenerator = new DefaultSecretGenerator()
      secretGenerator.generate()
    }

    override def checkMfaCode(
        secret: String,
        value: String
    ): F[Nothing, Boolean] = F.sync {
      import dev.samstevens.totp.code.{DefaultCodeGenerator, DefaultCodeVerifier}
      import dev.samstevens.totp.time.SystemTimeProvider
      val timeProvider = new SystemTimeProvider
      val codeGenerator = new DefaultCodeGenerator
      val verifier = new DefaultCodeVerifier(codeGenerator, timeProvider)

      val successful = verifier.isValidCode(secret, value)
      successful
    }



  }
}
