package io.protoforce.guide.auth.authservice

import _root_.izumi.idealingua.model.typer.IRTRestSpec
import _root_.izumi.idealingua.model.typer.IRTRestSpec.{
  IRTBasicField,
  IRTBodyParameter,
  IRTBodySpec,
  IRTExtractorSpec,
  OnWireScalar
}
import _root_.izumi.idealingua.model.typer.IRTRestSpec.IRTPathSegment.{
  Parameter,
  Word
}
import _root_.izumi.idealingua.model.typer.SharedRestSpec.IRTType
import _root_.izumi.idealingua.model.typer.SharedRestSpec.HttpMethod.{
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

object AuthServiceSpecs {
  val _id: ServiceName = ServiceName(Some("io.protoforce.guide.auth.authservice"), "AuthService")
  
  val specs: Map[MethodId, IRTRestSpec] = Map(
    (MethodId(this._id, MethodName("signup")), IRTRestSpec(
      Post,
      IRTExtractorSpec(Map(), List(
        Word("auth"),
        Word("signup")
      )),
      IRTBodySpec(List(
        IRTBodyParameter(IRTBasicField("with"), List())
      ))
    )),
    (MethodId(this._id, MethodName("signin")), IRTRestSpec(
      Post,
      IRTExtractorSpec(Map(), List(
        Word("auth"),
        Word("signin")
      )),
      IRTBodySpec(List(
        IRTBodyParameter(IRTBasicField("with"), List())
      ))
    )),
    (MethodId(this._id, MethodName("confirmEmail")), IRTRestSpec(
      Get,
      IRTExtractorSpec(Map(), List(
        Word("auth"),
        Word("confirm"),
        Word("email"),
        Parameter(IRTBasicField("code"), List(), OnWireScalar(IRTType.IRTString))
      )),
      IRTBodySpec(List())
    )),
    (MethodId(this._id, MethodName("confirmPhone")), IRTRestSpec(
      Get,
      IRTExtractorSpec(Map(), List(
        Word("auth"),
        Word("confirm"),
        Word("phone"),
        Parameter(IRTBasicField("phone"), List(), OnWireScalar(IRTType.IRTString)),
        Parameter(IRTBasicField("code"), List(), OnWireScalar(IRTType.IRTString))
      )),
      IRTBodySpec(List())
    )),
    (MethodId(this._id, MethodName("resetPassword")), IRTRestSpec(
      Post,
      IRTExtractorSpec(Map(), List(
        Word("auth"),
        Word("pass"),
        Word("reset")
      )),
      IRTBodySpec(List(
        IRTBodyParameter(IRTBasicField("lookup"), List())
      ))
    )),
    (MethodId(this._id, MethodName("changePassword")), IRTRestSpec(
      Post,
      IRTExtractorSpec(Map(), List(
        Word("auth"),
        Word("pass"),
        Word("change")
      )),
      IRTBodySpec(List(
        IRTBodyParameter(IRTBasicField("changeToken"), List()),
        IRTBodyParameter(IRTBasicField("password"), List())
      ))
    ))
  )
}