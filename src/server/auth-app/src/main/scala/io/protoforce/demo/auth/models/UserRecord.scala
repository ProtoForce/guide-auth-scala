package io.protoforce.demo.auth.models

import io.protoforce.guide.auth.User






final case class UserRecord(
    user: User,
    timezone: String,
    passHash: Option[String],
    passSalt: String,
    contacts: List[Contact],
    mfaSecret: Option[String],
)
