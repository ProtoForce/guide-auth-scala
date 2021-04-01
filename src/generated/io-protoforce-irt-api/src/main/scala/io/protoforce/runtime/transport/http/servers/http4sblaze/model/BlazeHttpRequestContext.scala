package io.protoforce.runtime.transport.http.servers.http4sblaze.model

import io.protoforce.model.typer.SharedRestSpec.RawRestPath
import io.protoforce.runtime.transport.dispatch.server.http.{AbstractRequestContext, HttpBody}
import org.http4s.Request

import scala.annotation.nowarn

@nowarn("msg=Unused import")
case class BlazeHttpRequestContext[F[_]](
  exchange: Request[F],
  body: HttpBody,
) {
  import scala.collection.compat._
  def headers: Map[String, Seq[String]] = {
    exchange.headers.iterator.map(h => (h.name.toString, h.value)).toSeq.groupBy(_._1).view.mapValues(_.map(_._2)).toMap
  }
}

@nowarn("msg=Unused import")
object BlazeHttpRequestContext {

  import scala.collection.compat._

  implicit def rc[F[_]]: RequestContext[F] = new RequestContext[F]

  class RequestContext[F[_]] extends AbstractRequestContext[BlazeHttpRequestContext[F]] {
    override def getRelativePath(rc: BlazeHttpRequestContext[F]): RawRestPath = {
      RawRestPath(rc.exchange.pathInfo.renderString)
    }

    override def getMethodName(rc: BlazeHttpRequestContext[F]): String = {
      rc.exchange.method.name.toUpperCase
    }

    override def body(rc: BlazeHttpRequestContext[F]): HttpBody = {
      rc.body
    }

    override def getQueryParameters(
      rc: BlazeHttpRequestContext[F]
    ): Map[String, List[String]] = {
      rc.exchange.uri.query.multiParams.view.mapValues(_.toList).toMap
    }

    override def getQueryString(rc: BlazeHttpRequestContext[F]): Option[String] = {
      Option(rc.exchange.queryString).filterNot(_.isEmpty)
    }
  }
}