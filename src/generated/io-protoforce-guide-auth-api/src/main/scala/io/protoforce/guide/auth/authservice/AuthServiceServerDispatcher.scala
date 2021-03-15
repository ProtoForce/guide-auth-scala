package io.protoforce.guide.auth.authservice

import _root_.io.protoforce.guide.auth.{
  GenericSuccess,
  SigninResponse,
  SigninSuccessResponse
}
import _root_.io.protoforce.guide.auth.authservice.models.{
  ChangePasswordInput,
  ChangePasswordOutput,
  ConfirmEmailInput,
  ConfirmEmailOutput,
  ConfirmPhoneInput,
  ConfirmPhoneOutput,
  ResetPasswordInput,
  ResetPasswordOutput,
  SigninInput,
  SigninOutput,
  SignupInput,
  SignupOutput
}
import _root_.io.protoforce.guide.auth.codecs.IRTCodecAuthAbstract
import _root_.izumi.functional.bio.Error2
import _root_.izumi.idealingua.model.typer.IRTRestSpec
import _root_.izumi.idealingua.runtime.transport.dispatch.RPCResult
import _root_.izumi.idealingua.runtime.transport.dispatch.server.GeneratedServerBaseImpl
import _root_.izumi.idealingua.runtime.transport.dispatch.server.GeneratedServerBase.{
  MethodId,
  MethodName,
  ServiceName
}
import _root_.izumi.idealingua.runtime.transport.errors.ServerDispatcherError
import _root_.scala.{
  Nothing,
  Some
}
import _root_.scala.Predef.Map

class AuthServiceServerDispatcher[_F[+_, +_]: Error2, _C, _WV](
  val _server: AuthService[_C, _F],
  val _codecs: IRTCodecAuthAbstract[_WV]
) extends GeneratedServerBaseImpl[_F, _C, _WV] {
  import _codecs._
  
  val _id: ServiceName = ServiceName(Some("io.protoforce.guide.auth.authservice"), "AuthService")
  
  val _specs: Map[MethodId, IRTRestSpec] = AuthServiceSpecs.specs
  
  val _methods: Map[MethodId, _Req => _F[ServerDispatcherError, _Res]] = Map(
    (MethodId(this._id, MethodName("signup")), signup),
    (MethodId(this._id, MethodName("signin")), signin),
    (MethodId(this._id, MethodName("confirmEmail")), confirmEmail),
    (MethodId(this._id, MethodName("confirmPhone")), confirmPhone),
    (MethodId(this._id, MethodName("resetPassword")), resetPassword),
    (MethodId(this._id, MethodName("changePassword")), changePassword)
  )
  
  private def signup(request: _Req): _F[ServerDispatcherError, _Res] = for {
    reqBody <- doDecode[SignupInput](request)
    resBody <- _server.signup(
      request.c,
      `with` = reqBody.`with`
    ).redeem[Nothing, RPCResult[SignupOutput, SigninSuccessResponse]](e => Error2[_F].pure(RPCResult.Bad(e)), g => Error2[_F].pure(RPCResult.Good(g)))
    response <- doEncode(request, reqBody, resBody, resBody.kind)
  } yield {
    response
  }
  private def signin(request: _Req): _F[ServerDispatcherError, _Res] = for {
    reqBody <- doDecode[SigninInput](request)
    resBody <- _server.signin(
      request.c,
      `with` = reqBody.`with`
    ).redeem[Nothing, RPCResult[SigninOutput, SigninResponse]](e => Error2[_F].pure(RPCResult.Bad(e)), g => Error2[_F].pure(RPCResult.Good(g)))
    response <- doEncode(request, reqBody, resBody, resBody.kind)
  } yield {
    response
  }
  private def confirmEmail(request: _Req): _F[ServerDispatcherError, _Res] = for {
    reqBody <- doDecode[ConfirmEmailInput](request)
    resBody <- _server.confirmEmail(
      request.c,
      code = reqBody.code
    ).redeem[Nothing, RPCResult[ConfirmEmailOutput, GenericSuccess]](e => Error2[_F].pure(RPCResult.Bad(e)), g => Error2[_F].pure(RPCResult.Good(g)))
    response <- doEncode(request, reqBody, resBody, resBody.kind)
  } yield {
    response
  }
  private def confirmPhone(request: _Req): _F[ServerDispatcherError, _Res] = for {
    reqBody <- doDecode[ConfirmPhoneInput](request)
    resBody <- _server.confirmPhone(
      request.c,
      code = reqBody.code,
      phone = reqBody.phone
    ).redeem[Nothing, RPCResult[ConfirmPhoneOutput, GenericSuccess]](e => Error2[_F].pure(RPCResult.Bad(e)), g => Error2[_F].pure(RPCResult.Good(g)))
    response <- doEncode(request, reqBody, resBody, resBody.kind)
  } yield {
    response
  }
  private def resetPassword(request: _Req): _F[ServerDispatcherError, _Res] = for {
    reqBody <- doDecode[ResetPasswordInput](request)
    resBody <- _server.resetPassword(
      request.c,
      lookup = reqBody.lookup
    ).redeem[Nothing, RPCResult[ResetPasswordOutput, GenericSuccess]](e => Error2[_F].pure(RPCResult.Bad(e)), g => Error2[_F].pure(RPCResult.Good(g)))
    response <- doEncode(request, reqBody, resBody, resBody.kind)
  } yield {
    response
  }
  private def changePassword(request: _Req): _F[ServerDispatcherError, _Res] = for {
    reqBody <- doDecode[ChangePasswordInput](request)
    resBody <- _server.changePassword(
      request.c,
      changeToken = reqBody.changeToken,
      password = reqBody.password
    ).redeem[Nothing, RPCResult[ChangePasswordOutput, GenericSuccess]](e => Error2[_F].pure(RPCResult.Bad(e)), g => Error2[_F].pure(RPCResult.Good(g)))
    response <- doEncode(request, reqBody, resBody, resBody.kind)
  } yield {
    response
  }
  
}