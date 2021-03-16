package io.protoforce.demo.auth.app.roles

import distage.Lifecycle
import izumi.distage.roles.model.{RoleDescriptor, RoleService}
import izumi.functional.bio.{Async2, F, UnsafeRun2}
import izumi.fundamentals.platform.cli.model.raw.RawEntrypointParams
import org.http4s.server.Server

final class AuthServerRole[F[+_, +_] : Async2 : UnsafeRun2](
                                                            server: Server
                                                          ) extends RoleService[F[Throwable, *]] {
  override def start(roleParameters: RawEntrypointParams, freeArgs: Vector[String]): Lifecycle[F[Throwable, *], Unit] = {
    Lifecycle.make(start)(_ => stop)
  }

  private def stop: F[Nothing, Unit] = {
    F.unit
  }

  private def start: F[Nothing, Unit] = {
    F.unit
  }
}

object AuthServerRole extends RoleDescriptor {
  val id = "authserver"
}