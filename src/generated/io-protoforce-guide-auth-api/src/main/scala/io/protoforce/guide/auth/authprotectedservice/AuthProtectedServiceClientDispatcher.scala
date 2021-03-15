package io.protoforce.guide.auth.authprotectedservice

import _root_.io.protoforce.guide.auth.{
  GenericSuccess,
  KnownIdentities,
  MFAMethodConfirm,
  MFAMethodPending,
  MFAMethodRequest,
  SecondaryIdentity
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
import _root_.izumi.functional.bio.Panic2
import _root_.izumi.idealingua.runtime.codecs.IRTCodec
import _root_.izumi.idealingua.runtime.transport.dispatch.RPCResult
import _root_.izumi.idealingua.runtime.transport.dispatch.client.{
  ClientTransport,
  GeneratedClientBase
}
import _root_.izumi.idealingua.runtime.transport.dispatch.server.GeneratedServerBase.{
  MethodId,
  MethodName,
  ServiceName
}
import _root_.izumi.idealingua.runtime.transport.errors.ClientDispatcherException
import _root_.scala.Some
import _root_.scala.Predef.implicitly

class AuthProtectedServiceClientDispatcher[_F[+_, +_]: Panic2, _C, _WV](
  val _codecs: IRTCodecAuthAbstract[_WV],
  val _transport: ClientTransport[_F, _C, _WV]
) extends GeneratedClientBase[_F, _C, _WV] with AuthProtectedService[_C, _F] {
  import _codecs._
  
  val _id: ServiceName = ServiceName(Some("io.protoforce.guide.auth.authprotectedservice"), "AuthProtectedService")
  
  def request2FA(_ctx: _C, method: MFAMethodRequest): _F[Request2FAOutput, MFAMethodPending] = {
    val _codec = implicitly[IRTCodec[Request2FAInput, _WV]]
    val _out = for {
      _input <- Panic2[_F].pure(Request2FAInput(
        method = method
      ))
      _encoded = _codec.encode(_input)
      _dispatched <- _transport.dispatch(_ctx, MethodId(this._id, MethodName("request2FA")), _encoded)
      _decodedRes <- _doDecode[RPCResult[Request2FAOutput, MFAMethodPending]](_dispatched)
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
  
  def confirm2FA(_ctx: _C, method: MFAMethodConfirm): _F[Confirm2FAOutput, GenericSuccess] = {
    val _codec = implicitly[IRTCodec[Confirm2FAInput, _WV]]
    val _out = for {
      _input <- Panic2[_F].pure(Confirm2FAInput(
        method = method
      ))
      _encoded = _codec.encode(_input)
      _dispatched <- _transport.dispatch(_ctx, MethodId(this._id, MethodName("confirm2FA")), _encoded)
      _decodedRes <- _doDecode[RPCResult[Confirm2FAOutput, GenericSuccess]](_dispatched)
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
  
  def disable2FA(_ctx: _C): _F[Disable2FAOutput, GenericSuccess] = {
    val _codec = implicitly[IRTCodec[Disable2FAInput, _WV]]
    val _out = for {
      _input <- Panic2[_F].pure(Disable2FAInput())
      _encoded = _codec.encode(_input)
      _dispatched <- _transport.dispatch(_ctx, MethodId(this._id, MethodName("disable2FA")), _encoded)
      _decodedRes <- _doDecode[RPCResult[Disable2FAOutput, GenericSuccess]](_dispatched)
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
  
  def addIdentity(_ctx: _C, identity: SecondaryIdentity): _F[AddIdentityOutput, GenericSuccess] = {
    val _codec = implicitly[IRTCodec[AddIdentityInput, _WV]]
    val _out = for {
      _input <- Panic2[_F].pure(AddIdentityInput(
        identity = identity
      ))
      _encoded = _codec.encode(_input)
      _dispatched <- _transport.dispatch(_ctx, MethodId(this._id, MethodName("addIdentity")), _encoded)
      _decodedRes <- _doDecode[RPCResult[AddIdentityOutput, GenericSuccess]](_dispatched)
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
  
  def removeIdentity(_ctx: _C, identity: SecondaryIdentity): _F[RemoveIdentityOutput, GenericSuccess] = {
    val _codec = implicitly[IRTCodec[RemoveIdentityInput, _WV]]
    val _out = for {
      _input <- Panic2[_F].pure(RemoveIdentityInput(
        identity = identity
      ))
      _encoded = _codec.encode(_input)
      _dispatched <- _transport.dispatch(_ctx, MethodId(this._id, MethodName("removeIdentity")), _encoded)
      _decodedRes <- _doDecode[RPCResult[RemoveIdentityOutput, GenericSuccess]](_dispatched)
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
  
  def listIdentities(_ctx: _C): _F[ListIdentitiesOutput, KnownIdentities] = {
    val _codec = implicitly[IRTCodec[ListIdentitiesInput, _WV]]
    val _out = for {
      _input <- Panic2[_F].pure(ListIdentitiesInput())
      _encoded = _codec.encode(_input)
      _dispatched <- _transport.dispatch(_ctx, MethodId(this._id, MethodName("listIdentities")), _encoded)
      _decodedRes <- _doDecode[RPCResult[ListIdentitiesOutput, KnownIdentities]](_dispatched)
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