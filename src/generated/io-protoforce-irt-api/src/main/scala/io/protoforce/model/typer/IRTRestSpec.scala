package io.protoforce.model.typer

import io.protoforce.model.typer.IRTRestSpec.{IRTBodySpec, IRTExtractorSpec}
import io.protoforce.model.typer.SharedRestSpec.HttpMethod

// final annotation
final case class IRTRestSpec(method: HttpMethod, extractor: IRTExtractorSpec, body: IRTBodySpec)

object IRTRestSpec {
  import SharedRestSpec._

  final case class IRTBodySpec(fields: Seq[IRTBodyParameter])
  final case class IRTBasicField(name: String)
  final case class IRTBodyParameter(field: IRTBasicField, path: Seq[IRTBasicField])

  final case class IRTExtractorSpec(
    queryParameters: Map[QueryParameterName, IRTQueryParameterSpec],
    pathSpec: Seq[IRTPathSegment],
  )
  final case class IRTQueryParameterSpec(field: IRTBasicField, path: Seq[IRTBasicField], onWire: IRTOnWireType)

  sealed trait IRTPathSegment

  object IRTPathSegment {
    final case class Word(value: String) extends IRTPathSegment
    final case class Parameter(field: IRTBasicField, path: Seq[IRTBasicField], onWire: IRTOnWireType) extends IRTPathSegment
  }

  sealed trait IRTOnWireType
  final case class OnWireScalar(ref: IRTType) extends IRTOnWireType // will always be ref to builtin scalar
  final case class OnWireGeneric(tpe: OnWireGenericType) extends IRTOnWireType
}