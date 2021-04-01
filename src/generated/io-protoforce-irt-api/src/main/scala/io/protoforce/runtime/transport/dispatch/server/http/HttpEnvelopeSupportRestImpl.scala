package io.protoforce.runtime.transport.dispatch.server.http

import io.circe.Json
import izumi.functional.bio.{F, IO2}
import izumi.fundamentals.collections.WildcardPrefixTree
import io.protoforce.model.typer.IRTRestSpec
import io.protoforce.model.typer.IRTRestSpec.{IRTBasicField, IRTPathSegment, IRTQueryParameterSpec}
import io.protoforce.model.typer.SharedRestSpec.{IRTType, OnWireGenericType, RawRestPath}
import io.protoforce.runtime.transport.dispatch.ServerIdRemapper
import io.protoforce.runtime.transport.dispatch.server.GeneratedServerBase.MethodId
import io.protoforce.runtime.transport.dispatch.server.{IRTEventListener, MethodIdExtractor, RPCServerHandlers}
import io.protoforce.runtime.transport.errors.ServerTransportError

import scala.annotation.tailrec

class HttpEnvelopeSupportRestImpl[F[+_, +_]: IO2, RC: AbstractRequestContext](
  idExtractor: MethodIdExtractor,
  dispatchers: RPCServerHandlers[F, Nothing, Json],
  undertowEventListener: IRTEventListener[F],
  idRemapper: ServerIdRemapper[F],
) extends HttpEnvelopeSupport[F, RC] {
  private val RC = implicitly[AbstractRequestContext[RC]]

  private val underlying =
    new HttpEnvelopeSupportDefaultImpl[F, RC](idExtractor, idRemapper)

  lazy val prefixes: WildcardPrefixTree[String, (MethodId, IRTRestSpec)] = {
    val allMethods = dispatchers.handlers.flatMap(_._specs.toSeq)
    val prefixed = allMethods.map {
      case (id, spec) =>
        val path = spec
          .extractor.pathSpec
          .map {
            case IRTPathSegment.Word(value) =>
              Some(value)
            case _: IRTPathSegment.Parameter =>
              None
          }

        (path, (id, spec))
    }

    WildcardPrefixTree.build(prefixed)
  }

  def indexesFor(path: RawRestPath): Seq[(MethodId, IRTRestSpec)] = {
    prefixes.findSubtrees(path.normalized).flatMap(_.values)
  }

  override def makeInput(context: RC): F[ServerTransportError, MethodInput] = {
    val relativePath = RC.getRelativePath(context)
    val restCandidates = indexesFor(relativePath)
    val method = RC.getMethodName(context)

    undertowEventListener.message(
      s"path `$method $relativePath` produced candidates to test: $restCandidates"
    )

    val maybeRest = restCandidates
      .map {
        case (id, spec) =>
          matches(context, id, spec)
      }
      .find(_.isDefined)
      .flatten

    maybeRest match {
      case Some(value) =>
        F.pure(value)
      case None =>
        underlying.makeInput(context)
    }
  }

  def matches(
    context: RC,
    id: MethodId,
    spec: IRTRestSpec,
  ): Option[MethodInput] = {
    val relativePath = RC.getRelativePath(context)
    val parts = relativePath.normalized

    val methodOk = spec.method.name.toUpperCase == RC.getMethodName(context)
    val partsCountOk = parts.length == spec.extractor.pathSpec.size
    if (methodOk && partsCountOk) {
      val mappedPath = spec
        .extractor.pathSpec
        .zip(parts)
        .map {
          case (s, p) =>
            s match {
              case IRTPathSegment.Word(value) =>
                (value == p, None)
              case parameter: IRTPathSegment.Parameter =>
                convert(p, parameter)
            }
        }

      val mappedParams = spec.extractor.queryParameters.toSeq.map {
        case (name, d) =>
          convert(RC.getQueryParameters(context).get(name.value), d)
      }

      val all = mappedPath ++ mappedParams
      if (all.forall(_._1)) {
        val pathPatch = all.flatMap(_._2.toSeq)
        val body = RC.body(context).json
        val fullPatch = pathPatch.foldLeft(body) {
          case (p, acc) =>
            acc.deepMerge(p)
        }
        undertowEventListener.message(
          s"mapped path: $relativePath?${RC.getQueryString(context)} => $id, $mappedPath, $mappedParams, Body: $body => $fullPatch"
        )

        Some(MethodInput(fullPatch, id))
      } else {
        None
      }
    } else {
      None
    }
  }

  @tailrec
  private def convert(
    value: String,
    p: IRTPathSegment.Parameter,
  ): (Boolean, Option[Json]) = {
    p.onWire match {
      case IRTRestSpec.OnWireScalar(ref) =>
        val out = convertScalar(Some(Seq(value)), p.path :+ p.field, ref)
        (out.isDefined, out)

      case IRTRestSpec.OnWireGeneric(tpe) =>
        tpe match {
          case OnWireGenericType.Option(tpe) =>
            convert(
              value,
              IRTPathSegment
                .Parameter(p.field, p.path, IRTRestSpec.OnWireScalar(tpe)),
            )
          case _ =>
            (false, None)
        }
    }
  }

  private def convert(
    value: Option[Seq[String]],
    p: IRTQueryParameterSpec,
  ): (Boolean, Option[Json]) = {
    val path = p.path :+ p.field
    p.onWire match {
      case IRTRestSpec.OnWireScalar(ref) =>
        val out = convertScalar(value, path, ref)
        (out.isDefined, out)

      case IRTRestSpec.OnWireGeneric(tpe) =>
        val out: Option[Json] = tpe match {
          case OnWireGenericType.Map(_, vref) =>
            val out = value.toSeq.flatten.flatMap(_.split(',')).map {
              s =>
                val parts = s.split('=')
                val key = Escaping.unescape(parts.head)
                val value = Escaping.unescape(parts.tail.mkString("="))
                mapScalar(vref, value).map(j => (key, j))
            }
            flatten(out).map(Json.fromFields)

          case OnWireGenericType.List(ref, unpacked) =>
            val v = if (unpacked) {
              flatten(
                value
                  .toSeq.flatten
                  .map(Escaping.unescape)
                  .map(mapScalar(ref, _))
              )
            } else {
              flatten(
                value
                  .toSeq.flatten
                  .map(Escaping.unescape)
                  .flatMap(_.split(','))
                  .map(mapScalar(ref, _))
              )
            }
            v.map(Json.fromValues)

          case OnWireGenericType.Option(ref) =>
            convertScalar(value, path, ref) match {
              case Some(value) =>
                Some(value)
              case None =>
                Some(Json.Null)
            }
        }
        out match {
          case Some(value) =>
            (true, Some(merge(path, value)))
          case None =>
            (false, None)
        }
    }
  }

  def flatten[T](values: Seq[Option[T]]): Option[Seq[T]] = {
    if (values.forall(_.isDefined)) {
      Some(values.collect({ case Some(v) => v }))
    } else {
      None
    }
  }

  private def convertScalar(
    value: Option[Seq[String]],
    path: Seq[IRTBasicField],
    ref: IRTType,
  ): Option[Json] = {
    for {
      v <- value
      first <- v.headOption
      jsonV <- mapScalar(ref, first)
    } yield {
      merge(path, jsonV)
    }
  }

  private def mapScalar(ref: IRTType, value: String): Option[Json] = {
    try {
      ref match {
        case IRTType.IRTString =>
          Some(Json.fromString(value))
        case IRTType.IRTInteger =>
          Some(Json.fromLong(java.lang.Long.parseLong(value)))
        case IRTType.IRTBool =>
          Some(Json.fromBoolean(java.lang.Boolean.parseBoolean(value)))
        case IRTType.IRTDouble =>
          Json.fromDouble(java.lang.Double.parseDouble(value))
      }
    } catch {
      case t: Throwable =>
        undertowEventListener.message(s"Rest mapping failure: $t")
        None
    }
  }

  private def merge(path: Seq[IRTBasicField], jsonV: Json): Json = {
    path.foldRight(jsonV) {
      case (v, acc) =>
        Json.obj((v.name, acc))
    }
  }
}