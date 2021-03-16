package io.protoforce.demo.auth.repos

import io.protoforce.demo.auth.models.{Contact, UserRecord}
import io.protoforce.demo.auth.repos.UserRepo.Errors.MissingRecord
import io.protoforce.guide.auth.UserLookup.{Email, Phone, UserIDRef}
import io.protoforce.guide.auth.{UserID, UserLookup}
import izumi.functional.bio.{F, IO2}

import scala.collection.mutable

trait UserRepo[F[+_, +_]] {
  def lookup(lookup: UserLookup): F[MissingRecord, UserRecord]

  def writeRecord(record: UserRecord): F[Nothing, Unit]
}

object UserRepo {
  sealed trait Errors
  object Errors {
    final case class MissingRecord() extends Errors
  }
  class UserRepoDummyImp[F[+_, +_]: IO2] extends UserRepo[F] {
    private val storage = mutable.HashMap[UserID, UserRecord]()

    override def lookup(lookup: UserLookup): F[MissingRecord, UserRecord] = {
      val maybeUsers = storage.synchronized {
        lookup match {
          case defn: UserIDRef.Defn =>
            storage.get(defn.value).toSeq
          case defn: Phone.Defn =>
            storage.values.filter(
              _.contacts.exists(c =>
                c match {
                  case _: Contact.Email =>
                    false
                  case c: Contact.Phone =>
                    c.phone == defn.phone
                }
              )
            )
          case defn: Email.Defn =>
            storage.values.filter(
              _.contacts.exists(c =>
                c match {
                  case c: Contact.Email =>
                    c.email == defn.email
                  case c: Contact.Phone =>
                    false
                }
              )
            )
        }
      }
      F.ifThenElse(maybeUsers.size > 1)(
        F.terminate(new RuntimeException(s"Incorrect storage state: many users with the same contact: $lookup")),
        F.fromOption(Errors.MissingRecord())(maybeUsers.headOption)
      )
    }

    override def writeRecord(record: UserRecord): F[Nothing, Unit] = {
      F.sync(storage.synchronized(storage.put(record.user.id, record)))
    }
  }
}
