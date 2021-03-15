package io.protoforce.guide.auth.codecs

import _root_.io.protoforce.guide.auth.{
  ClientConfig,
  EmailServerConfig,
  FacebookConfig,
  GenericSuccess,
  GithubClientConfig,
  GithubServerConfig,
  GoogleClientConfig,
  GoogleServerConfig,
  IRTErrorAuth,
  KnownIdentities,
  MFAMethodConfirm,
  MFAMethodPending,
  MFAMethodRequest,
  OAuthData,
  SMSServerConfig,
  SecondaryIdentity,
  ServerConfig,
  SignIn,
  SignUp,
  SigninResponse,
  SignupAttributes,
  TokensServerConfig,
  TwitterClientConfig,
  TwitterServerConfig,
  User,
  UserInfo,
  UserLookup
}
import _root_.io.protoforce.guide.auth.SignIn.TwoFactor
import _root_.io.protoforce.guide.auth.SignUp.{
  Facebook,
  Github,
  Google,
  Twitter
}
import _root_.io.protoforce.guide.auth.SigninResponse.Confirm2FA
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
import _root_.izumi.idealingua.runtime.codecs.IRTDomainCodec

trait IRTCodecAuthAbstract[_WIRE] extends IRTDomainCodec[_WIRE] {
  implicit def codec_io_protoforce_guide_auth_authservice_models_SigninOutput_irt: IRTCodecWire[SigninOutput]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_AddIdentityOutput_irt: IRTCodecWire[AddIdentityOutput]
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ResetPasswordOutput_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ResetPasswordOutput.InternalErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_AddIdentityOutput_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.InternalErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_AddIdentityOutput_ForbiddenError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.ForbiddenErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_SignupOutput_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.SignupOutput.InternalErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_TokensServerConfig_irt: IRTCodecWire[TokensServerConfig]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_RemoveIdentityInput_irt: IRTCodecWire[RemoveIdentityInput]
  
  implicit def codec_io_protoforce_guide_auth_GoogleClientConfig_irt: IRTCodecWire[GoogleClientConfig]
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_SigninOutput_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.SigninOutput.InternalErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_GithubClientConfig_irt: IRTCodecWire[GithubClientConfig]
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_SigninInput_irt: IRTCodecWire[SigninInput]
  
  implicit def codec_io_protoforce_guide_auth_SignIn_TwitterAuth_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.TwitterAuthRef]
  
  implicit def codec_io_protoforce_guide_auth_FacebookConfig_irt: IRTCodecWire[FacebookConfig]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_RemoveIdentityOutput_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.InternalErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_EmailPass_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.EmailPass]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_ListIdentitiesOutput_irt: IRTCodecWire[ListIdentitiesOutput]
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ResetPasswordOutput_NotFoundError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ResetPasswordOutput.NotFoundErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_SecondaryIdentity_Phone_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.SecondaryIdentity.Phone]
  
  implicit def codec_io_protoforce_guide_auth_UserLookup_irt: IRTCodecWire[UserLookup]
  
  implicit def codec_io_protoforce_guide_auth_KnownIdentities_irt: IRTCodecWire[KnownIdentities]
  
  implicit def codec_io_protoforce_guide_auth_SignUp_Twitter_irt: IRTCodecWire[Twitter]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_ListIdentitiesInput_irt: IRTCodecWire[ListIdentitiesInput]
  
  implicit def codec_io_protoforce_guide_auth_SignIn_FacebookAuth_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.FacebookAuthRef]
  
  implicit def codec_io_protoforce_guide_auth_GoogleAuth_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.GoogleAuth]
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ConfirmPhoneOutput_NotFoundError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ConfirmPhoneOutput.NotFoundErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_SignUp_Phone_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.SignUp.Phone]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_Confirm2FAOutput_ForbiddenError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Confirm2FAOutput.ForbiddenErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ConfirmEmailInput_irt: IRTCodecWire[ConfirmEmailInput]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_Request2FAOutput_irt: IRTCodecWire[Request2FAOutput]
  
  implicit def codec_io_protoforce_guide_auth_UserInfo_irt: IRTCodecWire[UserInfo]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_RemoveIdentityOutput_NotFoundError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.NotFoundErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ChangePasswordOutput_NotFoundError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ChangePasswordOutput.NotFoundErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_ListIdentitiesOutput_ForbiddenError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.ListIdentitiesOutput.ForbiddenErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_SignUp_irt: IRTCodecWire[SignUp]
  
  implicit def codec_io_protoforce_guide_auth_ForbiddenError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.ForbiddenError]
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ConfirmEmailOutput_NotFoundError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ConfirmEmailOutput.NotFoundErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_SignIn_irt: IRTCodecWire[SignIn]
  
  implicit def codec_io_protoforce_guide_auth_UserLookup_Email_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.UserLookup.Email]
  
  implicit def codec_io_protoforce_guide_auth_FacebookAuth_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.FacebookAuth]
  
  implicit def codec_io_protoforce_guide_auth_SigninResponse_SigninSuccessResponse_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.SigninResponse.SigninSuccessResponseRef]
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_SigninOutput_NotFoundError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.SigninOutput.NotFoundErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ChangePasswordOutput_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ChangePasswordOutput.InternalErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_SigninResponse_Confirm2FA_irt: IRTCodecWire[Confirm2FA]
  
  implicit def codec_io_protoforce_guide_auth_SecondaryIdentity_Email_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.SecondaryIdentity.Email]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_RemoveIdentityOutput_ForbiddenError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.ForbiddenErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_SignUp_Email_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.SignUp.Email]
  
  implicit def codec_io_protoforce_guide_auth_ClientConfig_irt: IRTCodecWire[ClientConfig]
  
  implicit def codec_io_protoforce_guide_auth_TwitterServerConfig_irt: IRTCodecWire[TwitterServerConfig]
  
  implicit def codec_io_protoforce_guide_auth_OAuthData_irt: IRTCodecWire[OAuthData]
  
  implicit def codec_io_protoforce_guide_auth_GithubAuth_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.GithubAuth]
  
  implicit def codec_io_protoforce_guide_auth_SignUp_Facebook_irt: IRTCodecWire[Facebook]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_ListIdentitiesOutput_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.ListIdentitiesOutput.InternalErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_SignIn_GithubAuth_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.GithubAuthRef]
  
  implicit def codec_io_protoforce_guide_auth_AlreadyExistsError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.AlreadyExistsError]
  
  implicit def codec_io_protoforce_guide_auth_SignIn_PhonePass_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.PhonePassRef]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_Request2FAInput_irt: IRTCodecWire[Request2FAInput]
  
  implicit def codec_io_protoforce_guide_auth_IRTErrorAuth_irt: IRTCodecWire[IRTErrorAuth]
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_SignupOutput_irt: IRTCodecWire[SignupOutput]
  
  implicit def codec_io_protoforce_guide_auth_GoogleServerConfig_irt: IRTCodecWire[GoogleServerConfig]
  
  implicit def codec_io_protoforce_guide_auth_MFAMethodConfirm_irt: IRTCodecWire[MFAMethodConfirm]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_AddIdentityInput_irt: IRTCodecWire[AddIdentityInput]
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ConfirmPhoneOutput_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ConfirmPhoneOutput.InternalErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_GithubServerConfig_irt: IRTCodecWire[GithubServerConfig]
  
  implicit def codec_io_protoforce_guide_auth_ServerConfig_irt: IRTCodecWire[ServerConfig]
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ResetPasswordInput_irt: IRTCodecWire[ResetPasswordInput]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_Request2FAOutput_ForbiddenError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Request2FAOutput.ForbiddenErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_Disable2FAInput_irt: IRTCodecWire[Disable2FAInput]
  
  implicit def codec_io_protoforce_guide_auth_GenericSuccess_irt: IRTCodecWire[GenericSuccess]
  
  implicit def codec_io_protoforce_guide_auth_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.InternalError]
  
  implicit def codec_io_protoforce_guide_auth_UserID_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.UserID]
  
  implicit def keycodec_io_protoforce_guide_auth_UserID_irt: IRTKeyCodecWire[_root_.io.protoforce.guide.auth.UserID]
  
  implicit def codec_io_protoforce_guide_auth_SignupAttributes_irt: IRTCodecWire[SignupAttributes]
  
  implicit def codec_io_protoforce_guide_auth_SigninSuccessResponse_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.SigninSuccessResponse]
  
  implicit def codec_io_protoforce_guide_auth_MFAMethodRequest_irt: IRTCodecWire[MFAMethodRequest]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_RemoveIdentityOutput_irt: IRTCodecWire[RemoveIdentityOutput]
  
  implicit def codec_io_protoforce_guide_auth_PhonePass_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.PhonePass]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_AddIdentityOutput_AlreadyExistsError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.AlreadyExistsErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_Confirm2FAOutput_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Confirm2FAOutput.InternalErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_User_irt: IRTCodecWire[User]
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ResetPasswordOutput_irt: IRTCodecWire[ResetPasswordOutput]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_Confirm2FAOutput_irt: IRTCodecWire[Confirm2FAOutput]
  
  implicit def codec_io_protoforce_guide_auth_SMSServerConfig_irt: IRTCodecWire[SMSServerConfig]
  
  implicit def codec_io_protoforce_guide_auth_MFAMethodConfirm_App_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.MFAMethodConfirm.App]
  
  implicit def codec_io_protoforce_guide_auth_NotFoundError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.NotFoundError]
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ChangePasswordInput_irt: IRTCodecWire[ChangePasswordInput]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_Confirm2FAInput_irt: IRTCodecWire[Confirm2FAInput]
  
  implicit def codec_io_protoforce_guide_auth_TwitterClientConfig_irt: IRTCodecWire[TwitterClientConfig]
  
  implicit def codec_io_protoforce_guide_auth_SignIn_TwoFactor_irt: IRTCodecWire[TwoFactor]
  
  implicit def codec_io_protoforce_guide_auth_EmailServerConfig_irt: IRTCodecWire[EmailServerConfig]
  
  implicit def codec_io_protoforce_guide_auth_MFAMethodRequest_App_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.MFAMethodRequest.App]
  
  implicit def codec_io_protoforce_guide_auth_SignUp_Github_irt: IRTCodecWire[Github]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_Request2FAOutput_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Request2FAOutput.InternalErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_SignupOutput_AlreadyExistsError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.SignupOutput.AlreadyExistsErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_Disable2FAOutput_irt: IRTCodecWire[Disable2FAOutput]
  
  implicit def codec_io_protoforce_guide_auth_MFAMethodPending_App_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.MFAMethodPending.App]
  
  implicit def codec_io_protoforce_guide_auth_TwitterAuth_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.TwitterAuth]
  
  implicit def codec_io_protoforce_guide_auth_SignIn_GoogleAuth_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.GoogleAuthRef]
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ChangePasswordOutput_irt: IRTCodecWire[ChangePasswordOutput]
  
  implicit def codec_io_protoforce_guide_auth_SignUp_Google_irt: IRTCodecWire[Google]
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_SignupInput_irt: IRTCodecWire[SignupInput]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_Disable2FAOutput_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Disable2FAOutput.InternalErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_SecondaryIdentity_irt: IRTCodecWire[SecondaryIdentity]
  
  implicit def codec_io_protoforce_guide_auth_UserLookup_UserID_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.UserLookup.UserIDRef]
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ConfirmPhoneInput_irt: IRTCodecWire[ConfirmPhoneInput]
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_Disable2FAOutput_ForbiddenError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Disable2FAOutput.ForbiddenErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_SignIn_EmailPass_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.EmailPassRef]
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ConfirmPhoneOutput_irt: IRTCodecWire[ConfirmPhoneOutput]
  
  implicit def codec_io_protoforce_guide_auth_SigninResponse_irt: IRTCodecWire[SigninResponse]
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ConfirmEmailOutput_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ConfirmEmailOutput.InternalErrorRef]
  
  implicit def codec_io_protoforce_guide_auth_MFAMethodPending_irt: IRTCodecWire[MFAMethodPending]
  
  implicit def codec_io_protoforce_guide_auth_UserLookup_Phone_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.UserLookup.Phone]
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ConfirmEmailOutput_irt: IRTCodecWire[ConfirmEmailOutput]
}