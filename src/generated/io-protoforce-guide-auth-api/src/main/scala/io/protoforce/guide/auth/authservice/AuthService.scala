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
  ChangePasswordOutput,
  ConfirmEmailOutput,
  ConfirmPhoneOutput,
  ResetPasswordOutput,
  SigninOutput,
  SignupOutput
}
import _root_.scala.Predef.String

/**
  * 
  *  Authentication service
  * 
  * Service io.protoforce.guide.auth.authservice:AuthService
  * 
  * Defined at auth.service.pfm @ 68:1
  */
trait AuthService[_C, _F[_, _]] {
  /**
    * 
    *  Sign up for a service with provided credentials
    * 
    * Defined at auth.service.pfm @ 73:3
    */
  def signup(_ctx: _C, `with`: SignUp): _F[SignupOutput, SigninSuccessResponse]
  
  /**
    * 
    *  Sign in with provided credentials
    * 
    * Defined at auth.service.pfm @ 78:3
    */
  def signin(_ctx: _C, `with`: SignIn): _F[SigninOutput, SigninResponse]
  
  /**
    * 
    *  Confirm email
    * 
    * Defined at auth.service.pfm @ 83:3
    */
  def confirmEmail(_ctx: _C, code: String): _F[ConfirmEmailOutput, GenericSuccess]
  
  /**
    * 
    *  Confirm phone number
    * 
    * Defined at auth.service.pfm @ 88:3
    */
  def confirmPhone(_ctx: _C, code: String, phone: String): _F[ConfirmPhoneOutput, GenericSuccess]
  
  /**
    * 
    *  Reset password
    * 
    * Defined at auth.service.pfm @ 93:3
    */
  def resetPassword(_ctx: _C, lookup: UserLookup): _F[ResetPasswordOutput, GenericSuccess]
  
  /**
    * 
    *  Change password
    * 
    * Defined at auth.service.pfm @ 98:3
    */
  def changePassword(_ctx: _C, changeToken: String, password: String): _F[ChangePasswordOutput, GenericSuccess]
}