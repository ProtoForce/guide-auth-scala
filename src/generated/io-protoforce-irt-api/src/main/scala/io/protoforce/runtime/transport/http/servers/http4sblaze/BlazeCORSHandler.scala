package io.protoforce.runtime.transport.http.servers.http4sblaze

import cats.data.{Kleisli, OptionT}
import io.protoforce.runtime.transport.dispatch.server.http.CORSBase
import org.http4s._
import zio.Task

class BlazeCORSHandler(
  base: CORSBase
) {
  import zio.interop.catz._
  private val corsHeaders = (base.corsBase ++ base.corsMore).map(h => Header(h._1, h._2)).toSeq

  def withCors(service: HttpRoutes[Task]): HttpRoutes[Task] = Kleisli {
    (req: Request[Task]) =>
      req.method match {
        case Method.OPTIONS =>
          OptionT.pure[Task](
            Response[Task](
              status = Status.Ok,
              headers = Headers.of(corsHeaders: _*),
            )
          )
        case _ =>
          service(req).map(_.putHeaders(corsHeaders: _*))
      }

  }
}