package io.protoforce.demo.auth.services

import io.protoforce.demo.auth.models.{IncomingServerCtx, UserRecord}
import io.protoforce.demo.auth.repos.UserRepo
import io.protoforce.guide.auth.UserLookup
import izumi.functional.bio.{F, IO2}

trait UserAuthService[F[+_, +_]] {
  def user(_ctx: IncomingServerCtx): F[Nothing, UserRecord]
}

object UserAuthService {
  class UserAuthServiceImpl[F[+_, +_]: IO2](
                                             tokensService: TokensService[F],
                                             users: UserRepo[F]
                                           ) extends UserAuthService[F] {
    override def user(ctx: IncomingServerCtx): F[Nothing, UserRecord] = {
      // first we should normalize header names
      val lowercased = ctx.headers.map { case (k, v) =>
        (k.toLowerCase, v)
      }

      val user = for {
        // then we should extract Authorization header
        header <- F
          .fromOption(new RuntimeException("Missing authorization header"))(
            lowercased.get("authorization").flatMap(_.headOption)
          )
        // then we should check if header starts with "Bearer" scheme and extract token value
        prefix = "Bearer "
        token <-
          if (header.startsWith(prefix)) {
            F.pure(header.substring(prefix.length).trim)
          } else {
            F.fail(new RuntimeException("Wrong authorization header"))
          }
        // then we should parse the token and extract user data from user repository
        userId <- tokensService.parseAuthToken(token).orTerminate
        user <- users.lookup(UserLookup.UserIDRef(userId)).leftMap(_ => new RuntimeException("Unknown user"))
      } yield {
        user
      }

      user.orTerminate // in case something goes wrong we should immediately stop
    }
  }
}
