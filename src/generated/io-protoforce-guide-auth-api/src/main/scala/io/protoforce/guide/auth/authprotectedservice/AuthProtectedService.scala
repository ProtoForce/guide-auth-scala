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
  AddIdentityOutput,
  Confirm2FAOutput,
  Disable2FAOutput,
  ListIdentitiesOutput,
  RemoveIdentityOutput,
  Request2FAOutput
}

/**
  * 
  *  Protected authentication service, requires authentication header to be present
  *  on all rquests, otherwise forbidden error is returned.
  * 
  * Service io.protoforce.guide.auth.authprotectedservice:AuthProtectedService
  * 
  * Defined at auth.service.pfm @ 105:1
  */
trait AuthProtectedService[_C, _F[_, _]] {
  /**
    * 
    *  Request two factor authentication
    * 
    * Defined at auth.service.pfm @ 110:3
    */
  def request2FA(_ctx: _C, method: MFAMethodRequest): _F[Request2FAOutput, MFAMethodPending]
  
  /**
    * 
    *  Confirm two factor authentication
    * 
    * Defined at auth.service.pfm @ 115:3
    */
  def confirm2FA(_ctx: _C, method: MFAMethodConfirm): _F[Confirm2FAOutput, GenericSuccess]
  
  /**
    * 
    *  Disable two factor authentication
    * 
    * Defined at auth.service.pfm @ 120:3
    */
  def disable2FA(_ctx: _C): _F[Disable2FAOutput, GenericSuccess]
  
  /**
    * 
    *  Add secondary identity
    * 
    * Defined at auth.service.pfm @ 126:3
    */
  def addIdentity(_ctx: _C, identity: SecondaryIdentity): _F[AddIdentityOutput, GenericSuccess]
  
  /**
    * 
    *  Remove secondary identity
    * 
    * Defined at auth.service.pfm @ 131:3
    */
  def removeIdentity(_ctx: _C, identity: SecondaryIdentity): _F[RemoveIdentityOutput, GenericSuccess]
  
  /**
    * 
    *  List known identities
    * 
    * Defined at auth.service.pfm @ 136:3
    */
  def listIdentities(_ctx: _C): _F[ListIdentitiesOutput, KnownIdentities]
}