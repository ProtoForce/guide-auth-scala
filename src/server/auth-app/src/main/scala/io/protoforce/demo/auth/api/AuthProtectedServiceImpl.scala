package io.protoforce.demo.auth.api

import io.protoforce.demo.auth.models.{Contact, IncomingServerCtx}
import io.protoforce.demo.auth.repos.UserRepo
import io.protoforce.demo.auth.services.{
  PasswordService,
  SanitationService,
  TokensService,
  UserAuthService
}
import io.protoforce.guide.auth.MFAMethodConfirm.App
import io.protoforce.guide.auth.SecondaryIdentity.{Email, Phone}
import io.protoforce.guide.auth._
import io.protoforce.guide.auth.authprotectedservice.AuthProtectedService
import io.protoforce.guide.auth.authprotectedservice.models._
import izumi.functional.bio.{F, IO2}

class AuthProtectedServiceImpl[F[+_, +_]: IO2](
    auth: UserAuthService[F],
    tokens: TokensService[F],
    users: UserRepo[F],
    sanitation: SanitationService[F],
    passwords: PasswordService[F]
) extends AuthProtectedService[IncomingServerCtx, F] {

  /** Request two factor authentication
    *
    * Defined at auth.service.pfm @ 110:3
    */
  override def request2FA(
      _ctx: IncomingServerCtx,
      method: MFAMethodRequest
  ): F[Request2FAOutput, MFAMethodPending] = {
    for {
      user <- auth.user(_ctx)
      secret <- user.mfaSecret match {
        case Some(_) =>
          F.fail(
            Request2FAOutput.ForbiddenErrorRef(
              "Inconsistent state, the user has 2FA already enabled"
            )
          )
        case None =>
          tokens.issueMfaAppAuthSecret()
      }
      signedSecret <- tokens.issueSignedMfaAuthSecret(secret)
    } yield {
      MFAMethodPending.App(secret, signedSecret)
    }
  }

  /** Confirm two factor authentication
    *
    * Defined at auth.service.pfm @ 115:3
    */
  override def confirm2FA(
      _ctx: IncomingServerCtx,
      method: MFAMethodConfirm
  ): F[Confirm2FAOutput, GenericSuccess] = {
    for {
      user <- auth.user(_ctx)
      secret <- user.mfaSecret match {
        case Some(_) =>
          F.fail(
            Confirm2FAOutput.ForbiddenErrorRef(
              "Inconsistent state, the user has 2FA already enabled"
            )
          )
        case None =>
          tokens.issueMfaAppAuthSecret()
      }
      newSecret <- (method match {
        case defn: App.Defn =>
          for {
            secret <- tokens.parseSignedMfaAuthSecret(defn.token)
            _ <- tokens.checkMfaCode(secret, defn.code)
          } yield {
            secret
          }
      }).orTerminate
      newUser = user.copy(mfaSecret = Some(newSecret))
      _ <- users.writeRecord(newUser)
    } yield {
      GenericSuccess(None)
    }
  }

  /** Disable two factor authentication
    *
    * Defined at auth.service.pfm @ 120:3
    */
  override def disable2FA(
      _ctx: IncomingServerCtx
  ): F[Disable2FAOutput, GenericSuccess] = {
    for {
      user <- auth.user(_ctx)
      _ <- user.mfaSecret match {
        case Some(_) =>
          F.unit
        case None =>
          F.fail(
            Disable2FAOutput.ForbiddenErrorRef(
              "Inconsistent state, the user has 2FA already enabled"
            )
          )
      }
      newUser = user.copy(mfaSecret = None)
      _ <- users.writeRecord(newUser)
    } yield {
      GenericSuccess(None)
    }
  }

  /** Add secondary identity
    *
    * Defined at auth.service.pfm @ 126:3
    */
  override def addIdentity(
      _ctx: IncomingServerCtx,
      identity: SecondaryIdentity
  ): F[AddIdentityOutput, GenericSuccess] = {
    for {
      user <- auth.user(_ctx)
      newContacts <- identity match {
        case defn: Phone.Defn =>
          for {
            s <- sanitation.sanitizePhone(defn.phone)
            code <- passwords.nextPhonecode()
          } yield {
            Contact.Phone(s, defn.phone, verified = false, code)
          }
        case defn: Email.Defn =>
          for {
            s <- sanitation.sanitizeEmail(defn.email)
          } yield {
            Contact.Email(s, defn.email, verified = false)
          }
      }
      newUser = user.copy(contacts = user.contacts :+ newContacts)
      _ <- users.writeRecord(newUser)
    } yield {
      GenericSuccess(None)
    }
  }

  /** Remove secondary identity
    *
    * Defined at auth.service.pfm @ 131:3
    */
  override def removeIdentity(
      _ctx: IncomingServerCtx,
      identity: SecondaryIdentity
  ): F[RemoveIdentityOutput, GenericSuccess] = {
    for {
      user <- auth.user(_ctx)
      toRemove <- identity match {
        case defn: Phone.Defn =>
          for {
            s <- sanitation.sanitizePhone(defn.phone)
          } yield {
            Phone(s)
          }
        case defn: Email.Defn =>
          for {
            s <- sanitation.sanitizeEmail(defn.email)
          } yield {
            Email(s)
          }
      }
      updatedContacts = user.contacts
        .map(c =>
          (
            c,
            c match {
              case c: Contact.Email =>
                Email(c.email)
              case c: Contact.Phone =>
                Phone(c.phone)
            }
          )
        )
        .filterNot(_._2 == toRemove)
        .map(_._1)
      _ <- F.ifThenElse(updatedContacts.size == user.contacts.size)(
        F.fail(RemoveIdentityOutput.NotFoundErrorRef("No contact is found")),
        F.unit
      )
      newUser = user.copy(contacts = updatedContacts)
      _ <- users.writeRecord(newUser)
    } yield {
      GenericSuccess(None)
    }
  }

  /** List known identities
    *
    * Defined at auth.service.pfm @ 136:3
    */
  override def listIdentities(
      _ctx: IncomingServerCtx
  ): F[ListIdentitiesOutput, KnownIdentities] = {
    for {
      user <- auth.user(_ctx)
      idts: List[SecondaryIdentity] = user.contacts.map {
        case c: Contact.Email =>
          SecondaryIdentity.Email(c.original)
        case c: Contact.Phone =>
          SecondaryIdentity.Phone(c.original)
      }
      (confirmed, unconfirmed) = (idts
        .zip(user.contacts.map(_.verified)))
        .partition(_._2)
    } yield {
      KnownIdentities(confirmed.map(_._1).toSet, unconfirmed.map(_._1).toSet)
    }
  }
}
