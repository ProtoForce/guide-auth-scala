package io.protoforce.demo.auth.api

import io.protoforce.demo.auth.integrations.{
  EmailService,
  FacebookService,
  GithubService,
  GoogleService,
  SmsService,
  TwitterService
}
import io.protoforce.demo.auth.models.{
  AppConfig,
  Contact,
  IncomingServerCtx,
  UserRecord
}
import io.protoforce.demo.auth.repos.UserRepo
import io.protoforce.demo.auth.services.{
  PasswordService,
  SanitationService,
  TokensService
}
import io.protoforce.guide.auth.SignIn.{
  EmailPassRef,
  FacebookAuthRef,
  GithubAuthRef,
  GoogleAuthRef,
  PhonePassRef,
  TwitterAuthRef,
  TwoFactor
}
import io.protoforce.guide.auth._
import io.protoforce.guide.auth.authservice.AuthService
import io.protoforce.guide.auth.authservice.models._
import izumi.functional.bio.{Entropy2, F, IO2}

object AuthServiceImpl {
  case class SignupParameters(contact: Contact, pass: Option[String])
  case class SigninParameters(
      lookup: UserLookup,
      pass: Option[String],
      verified: Boolean,
      twoFactor: Option[String]
  )
}

class AuthServiceImpl[F[+_, +_]: IO2](
    config: AppConfig,
    users: UserRepo[F],
    entropy2: Entropy2[F],
    tokens: TokensService[F],
    passwords: PasswordService[F],
    sanitation: SanitationService[F],
    twitter: TwitterService[F],
    facebook: FacebookService[F],
    google: GoogleService[F],
    github: GithubService[F],
    emailService: EmailService[F],
    smsService: SmsService[F]
) extends AuthService[IncomingServerCtx, F] {
  import AuthServiceImpl._

  /** Sign up for a service with provided credentials
    *
    * Defined at auth.service.pfm @ 73:3
    */
  override def signup(
      _ctx: IncomingServerCtx,
      `with`: SignUp
  ): F[SignupOutput, SigninSuccessResponse] = {
    for {
      params <- `with` match {
        case defn: SignUp.Phone.Defn =>
          for {
            code <- passwords.nextPhonecode()
            sanitized <- sanitation.sanitizePhone(defn.number)
            c = Contact.Phone(sanitized, defn.number, verified = false, code)
          } yield {
            SignupParameters(c, Some(defn.pass))
          }

        case defn: SignUp.Email.Defn =>
          for {
            sanitized <- sanitation.sanitizeEmail(defn.email)
            c = Contact.Email(sanitized, defn.email, verified = false)
          } yield {
            SignupParameters(c, Some(defn.pass))
          }
        case defn: SignUp.Twitter.Defn =>
          for {
            verified <- twitter.verifyTwitter(defn.accessToken)
            sanitized <- sanitation.sanitizeEmail(verified.email)
            c = Contact.Email(sanitized, verified.email, verified = true)
          } yield {
            SignupParameters(c, None)
          }
        case defn: SignUp.Facebook.Defn =>
          for {
            verified <- facebook.verifyFacebook(defn.accessToken)
            sanitized <- sanitation.sanitizeEmail(verified.email)
            c = Contact.Email(sanitized, verified.email, verified = true)
          } yield {
            SignupParameters(c, None)
          }
        case defn: SignUp.Github.Defn =>
          for {
            verified <- github.verifyGithub(defn.accessToken)
            sanitized <- sanitation.sanitizeEmail(verified.email)
            c = Contact.Email(sanitized, verified.email, verified = true)
          } yield {
            SignupParameters(c, None)
          }
        case defn: SignUp.Google.Defn =>
          for {
            verified <- google.verifyGoogle(defn.accessToken)
            sanitized <- sanitation.sanitizeEmail(verified.email)
            c = Contact.Email(sanitized, verified.email, verified = true)
          } yield {
            SignupParameters(c, None)
          }
      }
      uid <- entropy2.nextUUID().map(UserID.apply)
      salt <- entropy2.nextUUID().map(_.toString)
      user = User("", uid, params.contact.verified)
      passHash <- F.traverse(params.pass)(passwords.hash(_, salt))
      lookup = params.contact match {
        case c: Contact.Email =>
          UserLookup.Email(c.email)
        case c: Contact.Phone =>
          UserLookup.Phone(c.phone)
      }
      _ <-
        users
          .lookup(lookup)
          .redeem(
            _ => F.unit,
            _ => F.fail(SignupOutput.InternalErrorRef("User already exists"))
          )
      record = UserRecord(
        user,
        `with`.timezone,
        passHash,
        salt,
        List(params.contact),
        None
      )
      _ <- users.writeRecord(record)
      token <- tokens.issueAuthToken(uid)
    } yield {
      SigninSuccessResponse(user, token)
    }
  }

  /** Sign in with provided credentials
    *
    * Defined at auth.service.pfm @ 78:3
    */
  override def signin(
      _ctx: IncomingServerCtx,
      `with`: SignIn
  ): F[SigninOutput, SigninResponse] = {
    for {
      params <- `with` match {
        case defn: TwitterAuthRef.Defn =>
          for {
            verified <- twitter.verifyTwitter(defn.value.accessToken)
          } yield {
            SigninParameters(
              UserLookup.Email(verified.email),
              None,
              verified = true,
              None
            )
          }
        case defn: FacebookAuthRef.Defn =>
          for {
            verified <- facebook.verifyFacebook(defn.value.accessToken)
          } yield {
            SigninParameters(
              UserLookup.Email(verified.email),
              None,
              verified = true,
              None
            )
          }
        case defn: GithubAuthRef.Defn =>
          for {
            verified <- github.verifyGithub(defn.value.accessToken)
          } yield {
            SigninParameters(
              UserLookup.Email(verified.email),
              None,
              verified = true,
              None
            )
          }
        case defn: GoogleAuthRef.Defn =>
          for {
            verified <- google.verifyGoogle(defn.value.accessToken)
          } yield {
            SigninParameters(
              UserLookup.Email(verified.email),
              None,
              verified = true,
              None
            )
          }
        case defn: EmailPassRef.Defn =>
          F.pure(
            SigninParameters(
              UserLookup.Email(defn.value.email),
              Some(defn.value.pass),
              verified = false,
              None
            )
          )
        case defn: PhonePassRef.Defn =>
          F.pure(
            SigninParameters(
              UserLookup.Phone(defn.value.number),
              Some(defn.value.pass),
              verified = false,
              None
            )
          )
        case defn: TwoFactor.Defn =>
          for {
            userId <- tokens
              .parseRestrictedTokenForUnfinished2FA(defn.token)
              .leftMap(_ =>
                SigninOutput.InternalErrorRef("Can't parse provided token")
              )
          } yield {
            SigninParameters(
              UserLookup.UserIDRef(userId),
              None,
              verified = true,
              Some(defn.code)
            )
          }
      }
      user <- users
        .lookup(params.lookup)
        .leftMap(_ =>
          SigninOutput.NotFoundErrorRef(
            "User is not found or password is invalid"
          )
        )
      token <- tokens.issueAuthToken(user.user.id)

      out <- params.twoFactor match {
        case Some(value) =>
          user.mfaSecret match {
            case Some(secret) =>
              F.ifThenElse(tokens.checkMfaCode(secret, value))(
                F.pure(
                  SigninResponse.SigninSuccessResponseRef(user.user, token)
                ),
                F.fail(
                  SigninOutput.NotFoundErrorRef(
                    "User is not found or password is invalid"
                  )
                )
              )
            case None =>
              F.fail(
                SigninOutput.NotFoundErrorRef(
                  "User is not found or password is invalid"
                )
              )
          }
        case None =>
          user.mfaSecret match {
            case Some(_) =>
              for {
                preToken <- tokens.issueRestrictedTokenForUnfinished2FA(user.user.id)
              } yield {
                SigninResponse.Confirm2FA(
                  "Please provide a code from your authenticator app",
                  preToken
                )
              }
            case None if !params.verified =>
              params.pass match {
                case Some(value) =>
                  for {
                    hashed <- passwords.hash(value, user.passSalt)
                    out <- F.ifThenElse(user.passHash.contains(hashed))(
                      F.pure(
                        SigninResponse
                          .SigninSuccessResponseRef(user.user, token)
                      ),
                      F.fail(
                        SigninOutput.NotFoundErrorRef(
                          "User is not found or password is invalid"
                        )
                      )
                    )
                  } yield {
                    out
                  }
                case None =>
                  F.fail(
                    SigninOutput.NotFoundErrorRef(
                      "Password is not enabled, use provider login or reset a password"
                    )
                  )
              }
            case None if params.verified =>
              F.pure(SigninResponse.SigninSuccessResponseRef(user.user, token))
          }
      }
    } yield {
      out
    }

  }

  /** Confirm email
    *
    * Defined at auth.service.pfm @ 83:3
    */
  override def confirmEmail(
      _ctx: IncomingServerCtx,
      code: String
  ): F[ConfirmEmailOutput, GenericSuccess] = {
    for {
      email <- tokens
        .parseEmailConfirmationToken(code)
        .leftMap(_ =>
          ConfirmEmailOutput.NotFoundErrorRef(
            "The code is not valid or has expired"
          )
        )
      user <- users
        .lookup(UserLookup.Email(email))
        .leftMap(_ => ConfirmEmailOutput.NotFoundErrorRef("User not found"))
      sanitized <- sanitation.sanitizeEmail(email)
      thisEmail = user.contacts.collect {
        case c: Contact.Email if c.email == sanitized =>
          c
      }
      _ <- F.ifThenElse(thisEmail.isEmpty)(
        F.fail(ConfirmEmailOutput.NotFoundErrorRef("User not found")),
        F.unit
      )
      fixedContacts = user.contacts.map {
        case c: Contact.Email if c.email == sanitized =>
          c.copy(verified = true)
        case o => o
      }
      newUser = user.copy(contacts = fixedContacts)
      _ <- users.writeRecord(newUser)
    } yield {
      GenericSuccess(Some("Successfully confirmed"))
    }
  }

  /** Confirm phone number
    *
    * Defined at auth.service.pfm @ 88:3
    */
  override def confirmPhone(
      _ctx: IncomingServerCtx,
      code: String,
      phone: String
  ): F[ConfirmPhoneOutput, GenericSuccess] = {
    for {
      sanitized <- sanitation.sanitizePhone(phone)
      user <- users
        .lookup(UserLookup.Phone(phone))
        .leftMap(_ => ConfirmPhoneOutput.NotFoundErrorRef("User not found"))

      thisPhone = user.contacts.collect {
        case c: Contact.Phone if c.phone == sanitized =>
          c
      }
      _ <- F.ifThenElse(thisPhone.isEmpty)(
        F.fail(ConfirmPhoneOutput.NotFoundErrorRef("User not found")),
        F.unit
      )

      fixedContacts = user.contacts.map {
        case c: Contact.Phone if c.phone == sanitized && c.code == code =>
          c.copy(verified = true)
        case o => o
      }
      newUser = user.copy(contacts = fixedContacts)
      _ <- users.writeRecord(newUser)
    } yield {
      GenericSuccess(Some("Successfully confirmed"))
    }
  }

  /** Reset password
    *
    * Defined at auth.service.pfm @ 93:3
    */
  override def resetPassword(
      _ctx: IncomingServerCtx,
      lookup: UserLookup
  ): F[ResetPasswordOutput, GenericSuccess] = {
    for {
      user <- users
        .lookup(lookup)
        .leftMap(_ => ResetPasswordOutput.NotFoundErrorRef("User not found"))
      resetPasswordEndpoint = s"${config.email.resetPassEndpoint}${this.tokens
        .issuePassResetToken(user.user.id)}"
      resetPasswordMessage =
        s"You've requested password reset. Please follow a link: ${resetPasswordEndpoint}"
      _ <- user.contacts.headOption match {
        case Some(value) =>
          value match {
            case c: Contact.Email =>
              emailService.sendEmail(c.email, resetPasswordMessage)
            case c: Contact.Phone =>
              smsService.sendSMS(c.phone, resetPasswordMessage)
          }
        case None =>
          F.fail(ResetPasswordOutput.NotFoundErrorRef("User not found"))
      }
    } yield {
      GenericSuccess(Some("We've sent you a reset message"))
    }
  }

  /** Change password
    *
    * Defined at auth.service.pfm @ 98:3
    */
  override def changePassword(
      _ctx: IncomingServerCtx,
      changeToken: String,
      password: String
  ): F[ChangePasswordOutput, GenericSuccess] = {
    for {
      userId <- tokens
        .parsePassResetToken(changeToken)
        .leftMap(_ => ChangePasswordOutput.NotFoundErrorRef("Bad token"))
      user <- users
        .lookup(UserLookup.UserIDRef(userId))
        .leftMap(_ => ChangePasswordOutput.NotFoundErrorRef("Bad token"))
      hashed <- passwords.hash(password, user.passSalt)
      newUser = user.copy(passHash = Some(hashed))
      _ <- users.writeRecord(newUser)
    } yield {
      GenericSuccess(None)
    }
  }
}
