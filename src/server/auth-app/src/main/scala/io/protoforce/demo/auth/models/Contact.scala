package io.protoforce.demo.auth.models

sealed trait Contact {
  def verified: Boolean
}

object Contact {
  final case class Email(email: String, original: String, verified: Boolean)
      extends Contact

  final case class Phone(
      phone: String,
      original: String,
      verified: Boolean,
      code: String
  ) extends Contact
}
