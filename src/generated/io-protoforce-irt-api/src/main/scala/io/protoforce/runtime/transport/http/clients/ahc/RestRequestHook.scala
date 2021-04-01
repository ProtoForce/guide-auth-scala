package io.protoforce.runtime.transport.http.clients.ahc

import java.net.URI

import io.circe.Json
import izumi.functional.IzEither._
import io.protoforce.model.typer.IRTRestSpec
import io.protoforce.model.typer.IRTRestSpec.IRTPathSegment
import io.protoforce.model.typer.SharedRestSpec.{HttpMethod, OnWireGenericType, RawRestPath}
import io.protoforce.runtime.transport.dispatch.client.ClientRequestHook
import io.protoforce.runtime.transport.dispatch.server.GeneratedServerBase.MethodId
import io.protoforce.runtime.transport.dispatch.server.http.Escaping
import io.protoforce.runtime.transport.errors.MappingError.UnexpectedEmptyRemoval
import io.protoforce.runtime.transport.errors.{ClientDispatcherError, MappingError}
import org.asynchttpclient.BoundRequestBuilder

import scala.annotation.nowarn
import scala.jdk.CollectionConverters._

@nowarn("msg=Unused import")
class RestRequestHook[F[+_, +_], RC](
  methods: Map[MethodId, IRTRestSpec]
) extends ClientRequestHook[AHCClientContext[RC], BoundRequestBuilder] {
  import scala.collection.compat._

  override def onRequest(
    c: AHCClientContext[RC],
    request: AHCClientContext[RC] => BoundRequestBuilder,
  ): Either[ClientDispatcherError, BoundRequestBuilder] = {
    methods.get(c.methodId) match {
      case Some(value) =>
        processRest(c, value).left.map(e => ClientDispatcherError.RestMappingError(e))

      case None =>
        Right(request(c))
    }
  }

  def cleanup(
    body: Json,
    removals: Seq[List[String]],
  ): Either[List[MappingError], Json] = {
    body.asObject match {
      case Some(value) =>
        val (toRemove, toDig) = removals.partition(_.size == 1)
        for {
          nextGroups <- toDig.map {
            case Nil =>
              Left(List(UnexpectedEmptyRemoval(body, removals)))
            case head :: tail =>
              Right((head, tail))
          }.biAggregate
          next <-
            nextGroups
              .groupBy(_._1)
              .view
              .mapValues(_.map(_._2))
              .toSeq
              .flatMap {
                case (sub, r) =>
                  value
                    .apply(sub)
                    .map {
                      s =>
                        cleanup(s, r).map(r => (sub, r))
                    }
                    .toSeq
              }
              .biAggregate

        } yield {
          val leave = value.toMap -- nextGroups.map(_._1)
          Json.fromFields((next ++ leave).toMap -- toRemove.map(_.head))
        }

      case None =>
        Right(body)
    }
  }

  private def processRest(
    c: AHCClientContext[RC],
    value: IRTRestSpec,
  ): Either[List[MappingError], BoundRequestBuilder] = {
    val removals = value.extractor.pathSpec.collect {
      case IRTPathSegment.Parameter(field, path, _) =>
        (path :+ field).map(_.name).toList
    } ++ value.extractor.queryParameters.toSeq.map {
      case (_, v) =>
        (v.path :+ v.field).map(_.name).toList
    }

    val newPath = value
      .extractor.pathSpec.toList.map {
        case IRTPathSegment.Word(value) =>
          Right(value)
        case IRTPathSegment.Parameter(field, path, _) =>
          extract(List.empty, c.body)((path :+ field).map(_.name).toList, c.body)
      }.biAggregate

    val params = value
      .extractor.queryParameters.toSeq
      .map {
        case (k, v) =>
          val path = (v.path :+ v.field).map(_.name).toList

          val values = v.onWire match {
            case IRTRestSpec.OnWireScalar(_) =>
              for {
                l <- extract(List.empty, c.body)(path, c.body)
              } yield {
                List(l)
              }
            case IRTRestSpec.OnWireGeneric(tpe) =>
              tpe match {
                case OnWireGenericType.Map(_, _) =>
                  val elements = extractMap(List.empty, c.body)(path, c.body)
                  for {
                    m <- elements
                  } yield {
                    List(
                      m.map {
                        case (k, v) =>
                          s"${Escaping.escape(k)}=${Escaping.escape(v)}"
                      }
                        .mkString(",")
                    )
                  }

                case OnWireGenericType.List(_, unpacked) =>
                  val elements = extractList(List.empty, c.body)(path, c.body)
                  if (unpacked) {
                    elements
                  } else {
                    for {
                      l <- elements
                    } yield {
                      List(l.map(Escaping.escape).mkString(","))
                    }

                  }
                case OnWireGenericType.Option(_) =>
                  for {
                    l <- extractMaybe(List.empty, c.body)(path, c.body)
                  } yield {
                    List(l.getOrElse(""))
                  }
              }
          }

          for {
            v <- values
          } yield {
            (k.value, v)
          }
      }
      .toList
      .biAggregate
      .map(_.toMap)

    for {
      parameters <- params
      np <- newPath
      newbody <- cleanup(c.body, removals)
    } yield {
      val t = c.target.uri
      val url = new URI(
        t.getScheme,
        t.getUserInfo,
        t.getHost,
        t.getPort,
        (RawRestPath(t.getPath) ++ np).value,
        t.getQuery,
        t.getFragment,
      )

      //println(s"transformed: ${c.body} => ${value.method.name}, $newPath, $params, $newbody")
      val base = c
        .client
        .prepare(value.method.name.toUpperCase, url.toString)
        .setQueryParams(parameters.view.mapValues(_.asJava).toMap.asJava)

      value.method match {
        case HttpMethod.Get =>
          base
        case _ =>
          base.setBody(c.printer.print(newbody))
      }
    }
  }

  private def extract(
    currentPath: List[String],
    baseJson: Json,
  )(path: List[String],
    json: Json,
  ): Either[List[MappingError], String] = {
    path match {
      case Nil =>
        foldScalar(currentPath, baseJson)(json)
      case head :: tail =>
        for {
          obj <- json
            .asObject.toRight(
              List(MappingError.ObjectExpected(currentPath, baseJson))
            )
          el <-
            obj
              .apply(head)
              .toRight(
                List(MappingError.ElementExpected(currentPath, baseJson, head))
              )
          v <- extract(currentPath :+ head, baseJson)(tail, el)
        } yield {
          v
        }
    }
  }

  private def extractMap(
    currentPath: List[String],
    baseJson: Json,
  )(path: List[String],
    json: Json,
  ): Either[List[MappingError], Map[String, String]] = {
    path match {
      case Nil =>
        for {
          obj <- json
            .asObject.toRight(
              List(MappingError.ObjectExpected(currentPath, baseJson))
            )
          v <-
            obj
              .toMap.toSeq
              .map {
                case (k, v) =>
                  foldScalar(currentPath, baseJson)(v).map(j => (k, j))
              }
              .biAggregate
              .map(_.toMap)
        } yield {
          v
        }

      case head :: tail =>
        for {
          obj <- json
            .asObject.toRight(
              List(MappingError.ObjectExpected(currentPath, baseJson))
            )
          el <-
            obj
              .apply(head)
              .toRight(
                List(MappingError.ElementExpected(currentPath, baseJson, head))
              )
          v <- extractMap(currentPath :+ head, baseJson)(tail, el)
        } yield {
          v
        }

    }
  }

  private def extractList(
    currentPath: List[String],
    baseJson: Json,
  )(path: List[String],
    json: Json,
  ): Either[List[MappingError], List[String]] = {
    path match {
      case Nil =>
        for {
          arr <- json
            .asArray.toRight(
              List(MappingError.ArrayExpected(currentPath, baseJson))
            )
          v <- arr.map(foldScalar(currentPath, baseJson)).toList.biAggregate
        } yield {
          v
        }

      case head :: tail =>
        for {
          obj <- json
            .asObject.toRight(
              List(MappingError.ObjectExpected(currentPath, baseJson))
            )
          el <-
            obj
              .apply(head)
              .toRight(
                List(MappingError.ElementExpected(currentPath, baseJson, head))
              )
          v <- extractList(currentPath :+ head, baseJson)(tail, el)
        } yield {
          v
        }
    }
  }

  private def extractMaybe(
    currentPath: List[String],
    baseJson: Json,
  )(path: List[String],
    json: Json,
  ): Either[List[MappingError], Option[String]] = {
    path match {
      case Nil =>
        for {
          value <- foldScalar(currentPath, baseJson)(json)
        } yield {
          Some(value)
        }
      case head :: tail =>
        for {
          obj <- json
            .asObject.toRight(
              List(MappingError.ObjectExpected(currentPath, baseJson))
            )
          v <- obj.apply(head) match {
            case Some(value) =>
              extractMaybe(currentPath :+ head, baseJson)(tail, value)
            case None =>
              Right(None)
          }
        } yield {
          v
        }
    }
  }

  private def foldScalar(
    currentPath: List[String],
    baseJson: Json,
  )(json: Json
  ): Either[List[MappingError], String] = {
    def onError =
      Left(
        List(
          MappingError.UnexpectedNonScalarEntity(currentPath, baseJson, json)
        )
      )

    json.fold(
      onError,
      b => Right(b.toString),
      n => Right(n.toString),
      s => Right(s),
      _ => onError,
      _ => onError,
    )
  }
}