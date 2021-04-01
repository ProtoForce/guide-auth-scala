package io.protoforce.runtime.transport.dispatch

import izumi.functional.bio.Applicative2

trait ContextProvider[+F[+_, +_], +E, -WC, +C] {
  def decode(c: WC): F[E, C]
}

object ContextProvider {
  def const[F[+_, +_]: Applicative2, C](
    value: C
  ): ContextProvider[F, Nothing, Any, C] = forF[F].const(value)
  def pure[F[+_, +_]: Applicative2, W, C](
    f: W => C
  ): ContextProvider[F, Nothing, W, C] = forF[F].pure(f)

  def forF[F[+_, +_]](implicit F: Applicative2[F]): ForFPartiallyApplied[F] =
    new ForFPartiallyApplied[F](F)

  final class ForFPartiallyApplied[F[+_, +_]](private val F: Applicative2[F]) extends AnyVal {
    def const[C](value: C): ContextProvider[F, Nothing, Any, C] = {
      _: Any =>
        F.pure(value)
    }

    def pure[W, C](f: W => C): ContextProvider[F, Nothing, W, C] = {
      w: W =>
        F.pure(f(w))
    }

    def flat[W, C, E](f: W => F[E, C]): ContextProvider[F, E, W, C] = {
      w: W =>
        f(w)
    }
  }
}