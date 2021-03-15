package io.protoforce.guide.auth.authprotectedservice

import _root_.izumi.idealingua.model.typer.IRTRestSpec
import _root_.izumi.idealingua.model.typer.IRTRestSpec.{
  IRTBasicField,
  IRTBodyParameter,
  IRTBodySpec,
  IRTExtractorSpec
}
import _root_.izumi.idealingua.model.typer.IRTRestSpec.IRTPathSegment.Word
import _root_.izumi.idealingua.model.typer.SharedRestSpec.HttpMethod.{
  Delete,
  Get,
  Post
}
import _root_.izumi.idealingua.runtime.transport.dispatch.server.GeneratedServerBase.{
  MethodId,
  MethodName,
  ServiceName
}
import _root_.scala.{
  List,
  Some
}
import _root_.scala.Predef.Map

object AuthProtectedServiceSpecs {
  val _id: ServiceName = ServiceName(Some("io.protoforce.guide.auth.authprotectedservice"), "AuthProtectedService")
  
  val specs: Map[MethodId, IRTRestSpec] = Map(
    (MethodId(this._id, MethodName("request2FA")), IRTRestSpec(
      Post,
      IRTExtractorSpec(Map(), List(
        Word("auth"),
        Word("settings"),
        Word("2fa"),
        Word("request")
      )),
      IRTBodySpec(List(
        IRTBodyParameter(IRTBasicField("method"), List())
      ))
    )),
    (MethodId(this._id, MethodName("confirm2FA")), IRTRestSpec(
      Post,
      IRTExtractorSpec(Map(), List(
        Word("auth"),
        Word("settings"),
        Word("2fa"),
        Word("confirm")
      )),
      IRTBodySpec(List(
        IRTBodyParameter(IRTBasicField("method"), List())
      ))
    )),
    (MethodId(this._id, MethodName("disable2FA")), IRTRestSpec(
      Delete,
      IRTExtractorSpec(Map(), List(
        Word("auth"),
        Word("settings"),
        Word("2fa")
      )),
      IRTBodySpec(List())
    )),
    (MethodId(this._id, MethodName("addIdentity")), IRTRestSpec(
      Post,
      IRTExtractorSpec(Map(), List(
        Word("auth"),
        Word("identity")
      )),
      IRTBodySpec(List(
        IRTBodyParameter(IRTBasicField("identity"), List())
      ))
    )),
    (MethodId(this._id, MethodName("removeIdentity")), IRTRestSpec(
      Delete,
      IRTExtractorSpec(Map(), List(
        Word("auth"),
        Word("identity")
      )),
      IRTBodySpec(List(
        IRTBodyParameter(IRTBasicField("identity"), List())
      ))
    )),
    (MethodId(this._id, MethodName("listIdentities")), IRTRestSpec(
      Get,
      IRTExtractorSpec(Map(), List(
        Word("auth"),
        Word("identity")
      )),
      IRTBodySpec(List())
    ))
  )
}