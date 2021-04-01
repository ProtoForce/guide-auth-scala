package io.protoforce.guide.auth.authservice

import _root_.io.protoforce.guide.auth.{
  GenericSuccess,
  SignIn,
  SignUp,
  SigninResponse,
  SigninSuccessResponse,
  UserLookup
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
import _root_.io.protoforce.runtime.codecs.IRTCodec
import _root_.io.protoforce.runtime.transport.dispatch.RPCResult
import _root_.io.protoforce.runtime.transport.dispatch.client.{
  ClientTransport,
  GeneratedClientBase
}
import _root_.io.protoforce.runtime.transport.dispatch.server.GeneratedServerBase.{
  MethodId,
  MethodName,
  ServiceName
}
import _root_.io.protoforce.runtime.transport.errors.ClientDispatcherException
import _root_.izumi.functional.bio.Panic2
import _root_.scala.Some
import _root_.scala.Predef.{
  String,
  implicitly
}

class AuthServiceClientDispatcher[_F[+_, +_]: Panic2, _C, _WV](
  val _codecs: IRTCodecAuthAbstract[_WV],
  val _transport: ClientTransport[_F, _C, _WV]
) extends GeneratedClientBase[_F, _C, _WV] with AuthService[_C, _F] {
  import _codecs._
  
  val _id: ServiceName = ServiceName(Some("io.protoforce.guide.auth.authservice"), "AuthService")
  
  def signup(_ctx: _C, `with`: SignUp): _F[SignupOutput, SigninSuccessResponse] = {
    val _codec = implicitly[IRTCodec[SignupInput, _WV]]
    val _out = for {
      _input <- Panic2[_F].pure(SignupInput(
        `with` = `with`
      ))
      _encoded = _codec.encode(_input)
      _dispatched <- _transport.dispatch(_ctx, MethodId(this._id, MethodName("signup")), _encoded)
      _decodedRes <- _doDecode[RPCResult[SignupOutput, SigninSuccessResponse]](_dispatched)
    } yield {
      _decodedRes
    }
    
    for {
      _res <- _out.catchAll(e => Panic2[_F].terminate(ClientDispatcherException(e)))
      _out <- Panic2[_F].fromEither(_res.toEither)
    } yield {
      _out
    }
    
  }
  
  def signin(_ctx: _C, `with`: SignIn): _F[SigninOutput, SigninResponse] = {
    val _codec = implicitly[IRTCodec[SigninInput, _WV]]
    val _out = for {
      _input <- Panic2[_F].pure(SigninInput(
        `with` = `with`
      ))
      _encoded = _codec.encode(_input)
      _dispatched <- _transport.dispatch(_ctx, MethodId(this._id, MethodName("signin")), _encoded)
      _decodedRes <- _doDecode[RPCResult[SigninOutput, SigninResponse]](_dispatched)
    } yield {
      _decodedRes
    }
    
    for {
      _res <- _out.catchAll(e => Panic2[_F].terminate(ClientDispatcherException(e)))
      _out <- Panic2[_F].fromEither(_res.toEither)
    } yield {
      _out
    }
    
  }
  
  def confirmEmail(_ctx: _C, code: String): _F[ConfirmEmailOutput, GenericSuccess] = {
    val _codec = implicitly[IRTCodec[ConfirmEmailInput, _WV]]
    val _out = for {
      _input <- Panic2[_F].pure(ConfirmEmailInput(
        code = code
      ))
      _encoded = _codec.encode(_input)
      _dispatched <- _transport.dispatch(_ctx, MethodId(this._id, MethodName("confirmEmail")), _encoded)
      _decodedRes <- _doDecode[RPCResult[ConfirmEmailOutput, GenericSuccess]](_dispatched)
    } yield {
      _decodedRes
    }
    
    for {
      _res <- _out.catchAll(e => Panic2[_F].terminate(ClientDispatcherException(e)))
      _out <- Panic2[_F].fromEither(_res.toEither)
    } yield {
      _out
    }
    
  }
  
  def confirmPhone(_ctx: _C, code: String, phone: String): _F[ConfirmPhoneOutput, GenericSuccess] = {
    val _codec = implicitly[IRTCodec[ConfirmPhoneInput, _WV]]
    val _out = for {
      _input <- Panic2[_F].pure(ConfirmPhoneInput(
        code = code,
        phone = phone
      ))
      _encoded = _codec.encode(_input)
      _dispatched <- _transport.dispatch(_ctx, MethodId(this._id, MethodName("confirmPhone")), _encoded)
      _decodedRes <- _doDecode[RPCResult[ConfirmPhoneOutput, GenericSuccess]](_dispatched)
    } yield {
      _decodedRes
    }
    
    for {
      _res <- _out.catchAll(e => Panic2[_F].terminate(ClientDispatcherException(e)))
      _out <- Panic2[_F].fromEither(_res.toEither)
    } yield {
      _out
    }
    
  }
  
  def resetPassword(_ctx: _C, lookup: UserLookup): _F[ResetPasswordOutput, GenericSuccess] = {
    val _codec = implicitly[IRTCodec[ResetPasswordInput, _WV]]
    val _out = for {
      _input <- Panic2[_F].pure(ResetPasswordInput(
        lookup = lookup
      ))
      _encoded = _codec.encode(_input)
      _dispatched <- _transport.dispatch(_ctx, MethodId(this._id, MethodName("resetPassword")), _encoded)
      _decodedRes <- _doDecode[RPCResult[ResetPasswordOutput, GenericSuccess]](_dispatched)
    } yield {
      _decodedRes
    }
    
    for {
      _res <- _out.catchAll(e => Panic2[_F].terminate(ClientDispatcherException(e)))
      _out <- Panic2[_F].fromEither(_res.toEither)
    } yield {
      _out
    }
    
  }
  
  def changePassword(_ctx: _C, changeToken: String, password: String): _F[ChangePasswordOutput, GenericSuccess] = {
    val _codec = implicitly[IRTCodec[ChangePasswordInput, _WV]]
    val _out = for {
      _input <- Panic2[_F].pure(ChangePasswordInput(
        changeToken = changeToken,
        password = password
      ))
      _encoded = _codec.encode(_input)
      _dispatched <- _transport.dispatch(_ctx, MethodId(this._id, MethodName("changePassword")), _encoded)
      _decodedRes <- _doDecode[RPCResult[ChangePasswordOutput, GenericSuccess]](_dispatched)
    } yield {
      _decodedRes
    }
    
    for {
      _res <- _out.catchAll(e => Panic2[_F].terminate(ClientDispatcherException(e)))
      _out <- Panic2[_F].fromEither(_res.toEither)
    } yield {
      _out
    }
    
  }
}