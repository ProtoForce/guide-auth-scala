package io.protoforce.guide.auth.authprotectedservice

import _root_.io.protoforce.guide.auth.{
  GenericSuccess,
  KnownIdentities,
  MFAMethodPending
}
import _root_.io.protoforce.guide.auth.authprotectedservice.models.{
  AddIdentityInput,
  AddIdentityOutput,
  Confirm2FAInput,
  Confirm2FAOutput,
  Disable2FAInput,
  Disable2FAOutput,
  ListIdentitiesInput,
  ListIdentitiesOutput,
  RemoveIdentityInput,
  RemoveIdentityOutput,
  Request2FAInput,
  Request2FAOutput
}
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthAbstract
import _root_.io.protoforce.model.typer.IRTRestSpec
import _root_.io.protoforce.runtime.transport.dispatch.RPCResult
import _root_.io.protoforce.runtime.transport.dispatch.server.GeneratedServerBaseImpl
import _root_.io.protoforce.runtime.transport.dispatch.server.GeneratedServerBase.{
  MethodId,
  MethodName,
  ServiceName
}
import _root_.io.protoforce.runtime.transport.errors.ServerDispatcherError
import _root_.izumi.functional.bio.Error2
import _root_.scala.{
  Nothing,
  Some
}
import _root_.scala.Predef.Map

class AuthProtectedServiceServerDispatcher[_F[+_, +_]: Error2, _C, _WV](
  val _server: AuthProtectedService[_C, _F],
  val _codecs: IRTCodecAuthAbstract[_WV]
) extends GeneratedServerBaseImpl[_F, _C, _WV] {
  import _codecs._
  
  val _id: ServiceName = ServiceName(Some("io.protoforce.guide.auth.authprotectedservice"), "AuthProtectedService")
  
  val _specs: Map[MethodId, IRTRestSpec] = AuthProtectedServiceSpecs.specs
  
  val _methods: Map[MethodId, _Req => _F[ServerDispatcherError, _Res]] = Map(
    (MethodId(this._id, MethodName("request2FA")), request2FA),
    (MethodId(this._id, MethodName("confirm2FA")), confirm2FA),
    (MethodId(this._id, MethodName("disable2FA")), disable2FA),
    (MethodId(this._id, MethodName("addIdentity")), addIdentity),
    (MethodId(this._id, MethodName("removeIdentity")), removeIdentity),
    (MethodId(this._id, MethodName("listIdentities")), listIdentities)
  )
  
  private def request2FA(request: _Req): _F[ServerDispatcherError, _Res] = for {
    reqBody <- doDecode[Request2FAInput](request)
    resBody <- _server.request2FA(
      request.c,
      method = reqBody.method
    ).redeem[Nothing, RPCResult[Request2FAOutput, MFAMethodPending]](e => Error2[_F].pure(RPCResult.Bad(e)), g => Error2[_F].pure(RPCResult.Good(g)))
    response <- doEncode(request, reqBody, resBody, resBody.kind)
  } yield {
    response
  }
  private def confirm2FA(request: _Req): _F[ServerDispatcherError, _Res] = for {
    reqBody <- doDecode[Confirm2FAInput](request)
    resBody <- _server.confirm2FA(
      request.c,
      method = reqBody.method
    ).redeem[Nothing, RPCResult[Confirm2FAOutput, GenericSuccess]](e => Error2[_F].pure(RPCResult.Bad(e)), g => Error2[_F].pure(RPCResult.Good(g)))
    response <- doEncode(request, reqBody, resBody, resBody.kind)
  } yield {
    response
  }
  private def disable2FA(request: _Req): _F[ServerDispatcherError, _Res] = for {
    reqBody <- doDecode[Disable2FAInput](request)
    resBody <- _server.disable2FA(
      request.c
    ).redeem[Nothing, RPCResult[Disable2FAOutput, GenericSuccess]](e => Error2[_F].pure(RPCResult.Bad(e)), g => Error2[_F].pure(RPCResult.Good(g)))
    response <- doEncode(request, reqBody, resBody, resBody.kind)
  } yield {
    response
  }
  private def addIdentity(request: _Req): _F[ServerDispatcherError, _Res] = for {
    reqBody <- doDecode[AddIdentityInput](request)
    resBody <- _server.addIdentity(
      request.c,
      identity = reqBody.identity
    ).redeem[Nothing, RPCResult[AddIdentityOutput, GenericSuccess]](e => Error2[_F].pure(RPCResult.Bad(e)), g => Error2[_F].pure(RPCResult.Good(g)))
    response <- doEncode(request, reqBody, resBody, resBody.kind)
  } yield {
    response
  }
  private def removeIdentity(request: _Req): _F[ServerDispatcherError, _Res] = for {
    reqBody <- doDecode[RemoveIdentityInput](request)
    resBody <- _server.removeIdentity(
      request.c,
      identity = reqBody.identity
    ).redeem[Nothing, RPCResult[RemoveIdentityOutput, GenericSuccess]](e => Error2[_F].pure(RPCResult.Bad(e)), g => Error2[_F].pure(RPCResult.Good(g)))
    response <- doEncode(request, reqBody, resBody, resBody.kind)
  } yield {
    response
  }
  private def listIdentities(request: _Req): _F[ServerDispatcherError, _Res] = for {
    reqBody <- doDecode[ListIdentitiesInput](request)
    resBody <- _server.listIdentities(
      request.c
    ).redeem[Nothing, RPCResult[ListIdentitiesOutput, KnownIdentities]](e => Error2[_F].pure(RPCResult.Bad(e)), g => Error2[_F].pure(RPCResult.Good(g)))
    response <- doEncode(request, reqBody, resBody, resBody.kind)
  } yield {
    response
  }
  
}