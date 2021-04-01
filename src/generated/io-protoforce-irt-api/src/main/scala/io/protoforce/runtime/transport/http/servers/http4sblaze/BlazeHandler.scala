package io.protoforce.runtime.transport.http.servers.http4sblaze

import org.http4s.{Request, Response}
import zio.Task

trait BlazeHandler {
  def handle(request: Request[Task]): Task[Response[Task]]
  def handlePartial: PartialFunction[Request[Task], Task[Response[Task]]] = Function.unlift(r => Some(handle(r)))
}