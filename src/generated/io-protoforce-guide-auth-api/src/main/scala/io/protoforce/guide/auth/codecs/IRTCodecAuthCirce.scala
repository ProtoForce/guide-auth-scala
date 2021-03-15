package io.protoforce.guide.auth.codecs

import _root_.io.circe.Json
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
import _root_.izumi.idealingua.runtime.codecs.IRTCodec.IRTCodecFailure
import _root_.izumi.idealingua.runtime.codecs.circe.IRTDomainCodecCirceJson
import _root_.java.util.UUID
import _root_.scala.{
  Boolean,
  Either,
  List,
  Long,
  Option
}
import _root_.scala.Predef.{
  Set,
  String,
  implicitly
}

trait IRTCodecAuthCirce extends IRTCodecAuthAbstract[Json] with IRTDomainCodecCirceJson {
  implicit def codec_io_protoforce_guide_auth_authservice_models_SigninOutput_irt: IRTCodecWire[SigninOutput] = new IRTCodecWire[SigninOutput] {
    override def encode(_value: SigninOutput): Json = _value match {
      case v: _root_.io.protoforce.guide.auth.authservice.models.SigninOutput.InternalErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.SigninOutput.InternalErrorRef]].encode(v), "InternalError")
      case v: _root_.io.protoforce.guide.auth.authservice.models.SigninOutput.NotFoundErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.SigninOutput.NotFoundErrorRef]].encode(v), "NotFoundError")
    }
    override def decode(_value: Json): Either[List[IRTCodecFailure], SigninOutput] = for {
      parts <- _decCircePolyNested(_value)
      wireid = parts._1
      _body = parts._2
      result <- wireid match {
        case "InternalError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.SigninOutput.InternalErrorRef]].decode(_body)
        case "NotFoundError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.SigninOutput.NotFoundErrorRef]].decode(_body)
      }
    } yield { result }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_AddIdentityOutput_irt: IRTCodecWire[AddIdentityOutput] = new IRTCodecWire[AddIdentityOutput] {
    override def encode(_value: AddIdentityOutput): Json = _value match {
      case v: _root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.InternalErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.InternalErrorRef]].encode(v), "InternalError")
      case v: _root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.ForbiddenErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.ForbiddenErrorRef]].encode(v), "ForbiddenError")
      case v: _root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.AlreadyExistsErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.AlreadyExistsErrorRef]].encode(v), "AlreadyExistsError")
    }
    override def decode(_value: Json): Either[List[IRTCodecFailure], AddIdentityOutput] = for {
      parts <- _decCircePolyNested(_value)
      wireid = parts._1
      _body = parts._2
      result <- wireid match {
        case "InternalError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.InternalErrorRef]].decode(_body)
        case "ForbiddenError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.ForbiddenErrorRef]].decode(_body)
        case "AlreadyExistsError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.AlreadyExistsErrorRef]].decode(_body)
      }
    } yield { result }
  }
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ResetPasswordOutput_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ResetPasswordOutput.InternalErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ResetPasswordOutput.InternalErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authservice.models.ResetPasswordOutput.InternalErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.InternalError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authservice.models.ResetPasswordOutput.InternalErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.InternalError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authservice.models.ResetPasswordOutput.InternalErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_AddIdentityOutput_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.InternalErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.InternalErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.InternalErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.InternalError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.InternalErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.InternalError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.InternalErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_AddIdentityOutput_ForbiddenError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.ForbiddenErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.ForbiddenErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.ForbiddenErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.ForbiddenError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.ForbiddenErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.ForbiddenError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.ForbiddenErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_SignupOutput_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.SignupOutput.InternalErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.SignupOutput.InternalErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authservice.models.SignupOutput.InternalErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.InternalError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authservice.models.SignupOutput.InternalErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.InternalError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authservice.models.SignupOutput.InternalErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_TokensServerConfig_irt: IRTCodecWire[TokensServerConfig] = new IRTCodecWire[TokensServerConfig] {
    override def encode(_value: TokensServerConfig): Json = _enc_object_fields(
      ("jwtKey", implicitly[IRTCodecWire[String]].encode(_value.jwtKey), false),
      ("expiration", implicitly[IRTCodecWire[Long]].encode(_value.expiration), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], TokensServerConfig] = for {
      _ <- Right(())
      jwtKey <- _dec_field[String](_value, "jwtKey")
      expiration <- _dec_field[Long](_value, "expiration")
    } yield {
      new TokensServerConfig(
        jwtKey = jwtKey,
        expiration = expiration
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_RemoveIdentityInput_irt: IRTCodecWire[RemoveIdentityInput] = new IRTCodecWire[RemoveIdentityInput] {
    override def encode(_value: RemoveIdentityInput): Json = _enc_object_fields(
      ("identity", implicitly[IRTCodecWire[SecondaryIdentity]].encode(_value.identity), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], RemoveIdentityInput] = for {
      _ <- Right(())
      identity <- _dec_field[SecondaryIdentity](_value, "identity")
    } yield {
      new RemoveIdentityInput(
        identity = identity
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_GoogleClientConfig_irt: IRTCodecWire[GoogleClientConfig] = new IRTCodecWire[GoogleClientConfig] {
    override def encode(_value: GoogleClientConfig): Json = _enc_object_fields(
      ("clientId", implicitly[IRTCodecWire[String]].encode(_value.clientId), false),
      ("redirectUrl", implicitly[IRTCodecWire[String]].encode(_value.redirectUrl), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], GoogleClientConfig] = for {
      _ <- Right(())
      clientId <- _dec_field[String](_value, "clientId")
      redirectUrl <- _dec_field[String](_value, "redirectUrl")
    } yield {
      new GoogleClientConfig(
        clientId = clientId,
        redirectUrl = redirectUrl
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_SigninOutput_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.SigninOutput.InternalErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.SigninOutput.InternalErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authservice.models.SigninOutput.InternalErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.InternalError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authservice.models.SigninOutput.InternalErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.InternalError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authservice.models.SigninOutput.InternalErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_GithubClientConfig_irt: IRTCodecWire[GithubClientConfig] = new IRTCodecWire[GithubClientConfig] {
    override def encode(_value: GithubClientConfig): Json = _enc_object_fields(
      ("clientId", implicitly[IRTCodecWire[String]].encode(_value.clientId), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], GithubClientConfig] = for {
      _ <- Right(())
      clientId <- _dec_field[String](_value, "clientId")
    } yield {
      new GithubClientConfig(
        clientId = clientId
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_SigninInput_irt: IRTCodecWire[SigninInput] = new IRTCodecWire[SigninInput] {
    override def encode(_value: SigninInput): Json = _enc_object_fields(
      ("with", implicitly[IRTCodecWire[SignIn]].encode(_value.`with`), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], SigninInput] = for {
      _ <- Right(())
      `with` <- _dec_field[SignIn](_value, "with")
    } yield {
      new SigninInput(
        `with` = `with`
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_SignIn_TwitterAuth_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.TwitterAuthRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.TwitterAuthRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.SignIn.TwitterAuthRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.TwitterAuth]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.SignIn.TwitterAuthRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.TwitterAuth](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.SignIn.TwitterAuthRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_FacebookConfig_irt: IRTCodecWire[FacebookConfig] = new IRTCodecWire[FacebookConfig] {
    override def encode(_value: FacebookConfig): Json = _enc_object_fields(
      ("appId", implicitly[IRTCodecWire[String]].encode(_value.appId), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], FacebookConfig] = for {
      _ <- Right(())
      appId <- _dec_field[String](_value, "appId")
    } yield {
      new FacebookConfig(
        appId = appId
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_RemoveIdentityOutput_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.InternalErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.InternalErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.InternalErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.InternalError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.InternalErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.InternalError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.InternalErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_EmailPass_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.EmailPass] = new IRTCodecWire[_root_.io.protoforce.guide.auth.EmailPass] {
    override def encode(_value: _root_.io.protoforce.guide.auth.EmailPass): Json = _enc_object_fields(
      ("email", implicitly[IRTCodecWire[String]].encode(_value.email), false),
      ("pass", implicitly[IRTCodecWire[String]].encode(_value.pass), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.EmailPass] = for {
      _ <- Right(())
      email <- _dec_field[String](_value, "email")
      pass <- _dec_field[String](_value, "pass")
    } yield {
      new _root_.io.protoforce.guide.auth.EmailPass(
        email = email,
        pass = pass
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_ListIdentitiesOutput_irt: IRTCodecWire[ListIdentitiesOutput] = new IRTCodecWire[ListIdentitiesOutput] {
    override def encode(_value: ListIdentitiesOutput): Json = _value match {
      case v: _root_.io.protoforce.guide.auth.authprotectedservice.models.ListIdentitiesOutput.InternalErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.ListIdentitiesOutput.InternalErrorRef]].encode(v), "InternalError")
      case v: _root_.io.protoforce.guide.auth.authprotectedservice.models.ListIdentitiesOutput.ForbiddenErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.ListIdentitiesOutput.ForbiddenErrorRef]].encode(v), "ForbiddenError")
    }
    override def decode(_value: Json): Either[List[IRTCodecFailure], ListIdentitiesOutput] = for {
      parts <- _decCircePolyNested(_value)
      wireid = parts._1
      _body = parts._2
      result <- wireid match {
        case "InternalError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.ListIdentitiesOutput.InternalErrorRef]].decode(_body)
        case "ForbiddenError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.ListIdentitiesOutput.ForbiddenErrorRef]].decode(_body)
      }
    } yield { result }
  }
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ResetPasswordOutput_NotFoundError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ResetPasswordOutput.NotFoundErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ResetPasswordOutput.NotFoundErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authservice.models.ResetPasswordOutput.NotFoundErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.NotFoundError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authservice.models.ResetPasswordOutput.NotFoundErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.NotFoundError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authservice.models.ResetPasswordOutput.NotFoundErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_SecondaryIdentity_Phone_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.SecondaryIdentity.Phone] = new IRTCodecWire[_root_.io.protoforce.guide.auth.SecondaryIdentity.Phone] {
    override def encode(_value: _root_.io.protoforce.guide.auth.SecondaryIdentity.Phone): Json = _enc_object_fields(
      ("phone", implicitly[IRTCodecWire[String]].encode(_value.phone), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.SecondaryIdentity.Phone] = for {
      _ <- Right(())
      phone <- _dec_field[String](_value, "phone")
    } yield {
      new _root_.io.protoforce.guide.auth.SecondaryIdentity.Phone(
        phone = phone
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_UserLookup_irt: IRTCodecWire[UserLookup] = new IRTCodecWire[UserLookup] {
    override def encode(_value: UserLookup): Json = _value match {
      case v: _root_.io.protoforce.guide.auth.UserLookup.UserIDRef => _encCircePolyFlatJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.UserLookup.UserIDRef]].encode(v), "$method", "UserID")
      case v: _root_.io.protoforce.guide.auth.UserLookup.Email => _encCircePolyFlatJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.UserLookup.Email]].encode(v), "$method", "Email")
      case v: _root_.io.protoforce.guide.auth.UserLookup.Phone => _encCircePolyFlatJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.UserLookup.Phone]].encode(v), "$method", "Phone")
    }
    override def decode(_value: Json): Either[List[IRTCodecFailure], UserLookup] = for {
      parts <- _decCircePolyFlat(_value, "$method")
      wireid = parts._1
      _body = parts._2
      result <- wireid match {
        case "UserID" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.UserLookup.UserIDRef]].decode(_body)
        case "Email" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.UserLookup.Email]].decode(_body)
        case "Phone" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.UserLookup.Phone]].decode(_body)
      }
    } yield { result }
  }
  
  implicit def codec_io_protoforce_guide_auth_KnownIdentities_irt: IRTCodecWire[KnownIdentities] = new IRTCodecWire[KnownIdentities] {
    override def encode(_value: KnownIdentities): Json = _enc_object_fields(
      ("confirmed", implicitly[IRTCodecWire[Set[SecondaryIdentity]]].encode(_value.confirmed), false),
      ("unconfirmed", implicitly[IRTCodecWire[Set[SecondaryIdentity]]].encode(_value.unconfirmed), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], KnownIdentities] = for {
      _ <- Right(())
      confirmed <- _dec_field[Set[SecondaryIdentity]](_value, "confirmed")
      unconfirmed <- _dec_field[Set[SecondaryIdentity]](_value, "unconfirmed")
    } yield {
      new KnownIdentities(
        confirmed = confirmed,
        unconfirmed = unconfirmed
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_SignUp_Twitter_irt: IRTCodecWire[Twitter] = new IRTCodecWire[Twitter] {
    override def encode(_value: Twitter): Json = _enc_object_fields(
      ("timezone", implicitly[IRTCodecWire[String]].encode(_value.timezone), false),
      ("accessToken", implicitly[IRTCodecWire[String]].encode(_value.accessToken), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], Twitter] = for {
      _ <- Right(())
      timezone <- _dec_field[String](_value, "timezone")
      accessToken <- _dec_field[String](_value, "accessToken")
    } yield {
      new Twitter(
        timezone = timezone,
        accessToken = accessToken
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_ListIdentitiesInput_irt: IRTCodecWire[ListIdentitiesInput] = new IRTCodecWire[ListIdentitiesInput] {
    override def encode(_value: ListIdentitiesInput): Json = _enc_object_fields()
    override def decode(_value: Json): Either[List[IRTCodecFailure], ListIdentitiesInput] = for {
      _ <- Right(())
    } yield {
      new ListIdentitiesInput()
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_SignIn_FacebookAuth_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.FacebookAuthRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.FacebookAuthRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.SignIn.FacebookAuthRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.FacebookAuth]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.SignIn.FacebookAuthRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.FacebookAuth](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.SignIn.FacebookAuthRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_GoogleAuth_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.GoogleAuth] = new IRTCodecWire[_root_.io.protoforce.guide.auth.GoogleAuth] {
    override def encode(_value: _root_.io.protoforce.guide.auth.GoogleAuth): Json = _enc_object_fields(
      ("accessToken", implicitly[IRTCodecWire[String]].encode(_value.accessToken), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.GoogleAuth] = for {
      _ <- Right(())
      accessToken <- _dec_field[String](_value, "accessToken")
    } yield {
      new _root_.io.protoforce.guide.auth.GoogleAuth(
        accessToken = accessToken
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ConfirmPhoneOutput_NotFoundError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ConfirmPhoneOutput.NotFoundErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ConfirmPhoneOutput.NotFoundErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authservice.models.ConfirmPhoneOutput.NotFoundErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.NotFoundError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authservice.models.ConfirmPhoneOutput.NotFoundErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.NotFoundError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authservice.models.ConfirmPhoneOutput.NotFoundErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_SignUp_Phone_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.SignUp.Phone] = new IRTCodecWire[_root_.io.protoforce.guide.auth.SignUp.Phone] {
    override def encode(_value: _root_.io.protoforce.guide.auth.SignUp.Phone): Json = _enc_object_fields(
      ("timezone", implicitly[IRTCodecWire[String]].encode(_value.timezone), false),
      ("number", implicitly[IRTCodecWire[String]].encode(_value.number), false),
      ("pass", implicitly[IRTCodecWire[String]].encode(_value.pass), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.SignUp.Phone] = for {
      _ <- Right(())
      timezone <- _dec_field[String](_value, "timezone")
      number <- _dec_field[String](_value, "number")
      pass <- _dec_field[String](_value, "pass")
    } yield {
      new _root_.io.protoforce.guide.auth.SignUp.Phone(
        timezone = timezone,
        number = number,
        pass = pass
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_Confirm2FAOutput_ForbiddenError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Confirm2FAOutput.ForbiddenErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Confirm2FAOutput.ForbiddenErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authprotectedservice.models.Confirm2FAOutput.ForbiddenErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.ForbiddenError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authprotectedservice.models.Confirm2FAOutput.ForbiddenErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.ForbiddenError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authprotectedservice.models.Confirm2FAOutput.ForbiddenErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ConfirmEmailInput_irt: IRTCodecWire[ConfirmEmailInput] = new IRTCodecWire[ConfirmEmailInput] {
    override def encode(_value: ConfirmEmailInput): Json = _enc_object_fields(
      ("code", implicitly[IRTCodecWire[String]].encode(_value.code), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], ConfirmEmailInput] = for {
      _ <- Right(())
      code <- _dec_field[String](_value, "code")
    } yield {
      new ConfirmEmailInput(
        code = code
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_Request2FAOutput_irt: IRTCodecWire[Request2FAOutput] = new IRTCodecWire[Request2FAOutput] {
    override def encode(_value: Request2FAOutput): Json = _value match {
      case v: _root_.io.protoforce.guide.auth.authprotectedservice.models.Request2FAOutput.InternalErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Request2FAOutput.InternalErrorRef]].encode(v), "InternalError")
      case v: _root_.io.protoforce.guide.auth.authprotectedservice.models.Request2FAOutput.ForbiddenErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Request2FAOutput.ForbiddenErrorRef]].encode(v), "ForbiddenError")
    }
    override def decode(_value: Json): Either[List[IRTCodecFailure], Request2FAOutput] = for {
      parts <- _decCircePolyNested(_value)
      wireid = parts._1
      _body = parts._2
      result <- wireid match {
        case "InternalError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Request2FAOutput.InternalErrorRef]].decode(_body)
        case "ForbiddenError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Request2FAOutput.ForbiddenErrorRef]].decode(_body)
      }
    } yield { result }
  }
  
  implicit def codec_io_protoforce_guide_auth_UserInfo_irt: IRTCodecWire[UserInfo] = new IRTCodecWire[UserInfo] {
    override def encode(_value: UserInfo): Json = _value match {
      case v: _root_.io.protoforce.guide.auth.UserInfo.Impl => _encCircePolyNestedJson(_enc_object_fields(
        ("name", implicitly[IRTCodecWire[String]].encode(v.name), false)
      ), "io.protoforce.guide.auth:UserInfo")
    }
    override def decode(_value: Json): Either[List[IRTCodecFailure], UserInfo] = for {
      parts <- _decCircePolyNested(_value)
      wireid = parts._1
      _body = parts._2
      result <- wireid match {
        case "io.protoforce.guide.auth:UserInfo" => for {
          _ <- Right(())
          name <- _dec_field[String](_body, "name")
        } yield {
          new _root_.io.protoforce.guide.auth.UserInfo.Impl(
            name = name
          )
        }
      }
    } yield { result }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_RemoveIdentityOutput_NotFoundError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.NotFoundErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.NotFoundErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.NotFoundErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.NotFoundError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.NotFoundErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.NotFoundError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.NotFoundErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ChangePasswordOutput_NotFoundError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ChangePasswordOutput.NotFoundErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ChangePasswordOutput.NotFoundErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authservice.models.ChangePasswordOutput.NotFoundErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.NotFoundError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authservice.models.ChangePasswordOutput.NotFoundErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.NotFoundError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authservice.models.ChangePasswordOutput.NotFoundErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_ListIdentitiesOutput_ForbiddenError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.ListIdentitiesOutput.ForbiddenErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.ListIdentitiesOutput.ForbiddenErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authprotectedservice.models.ListIdentitiesOutput.ForbiddenErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.ForbiddenError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authprotectedservice.models.ListIdentitiesOutput.ForbiddenErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.ForbiddenError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authprotectedservice.models.ListIdentitiesOutput.ForbiddenErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_SignUp_irt: IRTCodecWire[SignUp] = new IRTCodecWire[SignUp] {
    override def encode(_value: SignUp): Json = _value match {
      case v: _root_.io.protoforce.guide.auth.SignUp.Email => _encCircePolyFlatJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.SignUp.Email]].encode(v), "$method", "Email")
      case v: _root_.io.protoforce.guide.auth.SignUp.Phone => _encCircePolyFlatJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.SignUp.Phone]].encode(v), "$method", "Phone")
      case v: Google => _encCircePolyFlatJson(implicitly[IRTCodecWire[Google]].encode(v), "$method", "Google")
      case v: Github => _encCircePolyFlatJson(implicitly[IRTCodecWire[Github]].encode(v), "$method", "Github")
      case v: Facebook => _encCircePolyFlatJson(implicitly[IRTCodecWire[Facebook]].encode(v), "$method", "Facebook")
      case v: Twitter => _encCircePolyFlatJson(implicitly[IRTCodecWire[Twitter]].encode(v), "$method", "Twitter")
    }
    override def decode(_value: Json): Either[List[IRTCodecFailure], SignUp] = for {
      parts <- _decCircePolyFlat(_value, "$method")
      wireid = parts._1
      _body = parts._2
      result <- wireid match {
        case "Email" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.SignUp.Email]].decode(_body)
        case "Phone" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.SignUp.Phone]].decode(_body)
        case "Google" => implicitly[IRTCodecWire[Google]].decode(_body)
        case "Github" => implicitly[IRTCodecWire[Github]].decode(_body)
        case "Facebook" => implicitly[IRTCodecWire[Facebook]].decode(_body)
        case "Twitter" => implicitly[IRTCodecWire[Twitter]].decode(_body)
      }
    } yield { result }
  }
  
  implicit def codec_io_protoforce_guide_auth_ForbiddenError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.ForbiddenError] = new IRTCodecWire[_root_.io.protoforce.guide.auth.ForbiddenError] {
    override def encode(_value: _root_.io.protoforce.guide.auth.ForbiddenError): Json = _enc_object_fields(
      ("message", implicitly[IRTCodecWire[String]].encode(_value.message), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.ForbiddenError] = for {
      _ <- Right(())
      message <- _dec_field[String](_value, "message")
    } yield {
      new _root_.io.protoforce.guide.auth.ForbiddenError(
        message = message
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ConfirmEmailOutput_NotFoundError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ConfirmEmailOutput.NotFoundErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ConfirmEmailOutput.NotFoundErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authservice.models.ConfirmEmailOutput.NotFoundErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.NotFoundError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authservice.models.ConfirmEmailOutput.NotFoundErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.NotFoundError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authservice.models.ConfirmEmailOutput.NotFoundErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_SignIn_irt: IRTCodecWire[SignIn] = new IRTCodecWire[SignIn] {
    override def encode(_value: SignIn): Json = _value match {
      case v: _root_.io.protoforce.guide.auth.SignIn.EmailPassRef => _encCircePolyFlatJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.EmailPassRef]].encode(v), "$method", "EmailPass")
      case v: _root_.io.protoforce.guide.auth.SignIn.PhonePassRef => _encCircePolyFlatJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.PhonePassRef]].encode(v), "$method", "PhonePass")
      case v: _root_.io.protoforce.guide.auth.SignIn.GoogleAuthRef => _encCircePolyFlatJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.GoogleAuthRef]].encode(v), "$method", "GoogleAuth")
      case v: _root_.io.protoforce.guide.auth.SignIn.GithubAuthRef => _encCircePolyFlatJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.GithubAuthRef]].encode(v), "$method", "GithubAuth")
      case v: _root_.io.protoforce.guide.auth.SignIn.FacebookAuthRef => _encCircePolyFlatJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.FacebookAuthRef]].encode(v), "$method", "FacebookAuth")
      case v: _root_.io.protoforce.guide.auth.SignIn.TwitterAuthRef => _encCircePolyFlatJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.TwitterAuthRef]].encode(v), "$method", "TwitterAuth")
      case v: TwoFactor => _encCircePolyFlatJson(implicitly[IRTCodecWire[TwoFactor]].encode(v), "$method", "TwoFactor")
    }
    override def decode(_value: Json): Either[List[IRTCodecFailure], SignIn] = for {
      parts <- _decCircePolyFlat(_value, "$method")
      wireid = parts._1
      _body = parts._2
      result <- wireid match {
        case "EmailPass" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.EmailPassRef]].decode(_body)
        case "PhonePass" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.PhonePassRef]].decode(_body)
        case "GoogleAuth" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.GoogleAuthRef]].decode(_body)
        case "GithubAuth" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.GithubAuthRef]].decode(_body)
        case "FacebookAuth" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.FacebookAuthRef]].decode(_body)
        case "TwitterAuth" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.TwitterAuthRef]].decode(_body)
        case "TwoFactor" => implicitly[IRTCodecWire[TwoFactor]].decode(_body)
      }
    } yield { result }
  }
  
  implicit def codec_io_protoforce_guide_auth_UserLookup_Email_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.UserLookup.Email] = new IRTCodecWire[_root_.io.protoforce.guide.auth.UserLookup.Email] {
    override def encode(_value: _root_.io.protoforce.guide.auth.UserLookup.Email): Json = _enc_object_fields(
      ("email", implicitly[IRTCodecWire[String]].encode(_value.email), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.UserLookup.Email] = for {
      _ <- Right(())
      email <- _dec_field[String](_value, "email")
    } yield {
      new _root_.io.protoforce.guide.auth.UserLookup.Email(
        email = email
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_FacebookAuth_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.FacebookAuth] = new IRTCodecWire[_root_.io.protoforce.guide.auth.FacebookAuth] {
    override def encode(_value: _root_.io.protoforce.guide.auth.FacebookAuth): Json = _enc_object_fields(
      ("accessToken", implicitly[IRTCodecWire[String]].encode(_value.accessToken), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.FacebookAuth] = for {
      _ <- Right(())
      accessToken <- _dec_field[String](_value, "accessToken")
    } yield {
      new _root_.io.protoforce.guide.auth.FacebookAuth(
        accessToken = accessToken
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_SigninResponse_SigninSuccessResponse_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.SigninResponse.SigninSuccessResponseRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.SigninResponse.SigninSuccessResponseRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.SigninResponse.SigninSuccessResponseRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.SigninSuccessResponse]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.SigninResponse.SigninSuccessResponseRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.SigninSuccessResponse](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.SigninResponse.SigninSuccessResponseRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_SigninOutput_NotFoundError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.SigninOutput.NotFoundErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.SigninOutput.NotFoundErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authservice.models.SigninOutput.NotFoundErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.NotFoundError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authservice.models.SigninOutput.NotFoundErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.NotFoundError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authservice.models.SigninOutput.NotFoundErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ChangePasswordOutput_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ChangePasswordOutput.InternalErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ChangePasswordOutput.InternalErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authservice.models.ChangePasswordOutput.InternalErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.InternalError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authservice.models.ChangePasswordOutput.InternalErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.InternalError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authservice.models.ChangePasswordOutput.InternalErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_SigninResponse_Confirm2FA_irt: IRTCodecWire[Confirm2FA] = new IRTCodecWire[Confirm2FA] {
    override def encode(_value: Confirm2FA): Json = _enc_object_fields(
      ("message", implicitly[IRTCodecWire[String]].encode(_value.message), false),
      ("token", implicitly[IRTCodecWire[String]].encode(_value.token), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], Confirm2FA] = for {
      _ <- Right(())
      message <- _dec_field[String](_value, "message")
      token <- _dec_field[String](_value, "token")
    } yield {
      new Confirm2FA(
        message = message,
        token = token
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_SecondaryIdentity_Email_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.SecondaryIdentity.Email] = new IRTCodecWire[_root_.io.protoforce.guide.auth.SecondaryIdentity.Email] {
    override def encode(_value: _root_.io.protoforce.guide.auth.SecondaryIdentity.Email): Json = _enc_object_fields(
      ("email", implicitly[IRTCodecWire[String]].encode(_value.email), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.SecondaryIdentity.Email] = for {
      _ <- Right(())
      email <- _dec_field[String](_value, "email")
    } yield {
      new _root_.io.protoforce.guide.auth.SecondaryIdentity.Email(
        email = email
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_RemoveIdentityOutput_ForbiddenError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.ForbiddenErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.ForbiddenErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.ForbiddenErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.ForbiddenError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.ForbiddenErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.ForbiddenError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.ForbiddenErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_SignUp_Email_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.SignUp.Email] = new IRTCodecWire[_root_.io.protoforce.guide.auth.SignUp.Email] {
    override def encode(_value: _root_.io.protoforce.guide.auth.SignUp.Email): Json = _enc_object_fields(
      ("timezone", implicitly[IRTCodecWire[String]].encode(_value.timezone), false),
      ("email", implicitly[IRTCodecWire[String]].encode(_value.email), false),
      ("pass", implicitly[IRTCodecWire[String]].encode(_value.pass), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.SignUp.Email] = for {
      _ <- Right(())
      timezone <- _dec_field[String](_value, "timezone")
      email <- _dec_field[String](_value, "email")
      pass <- _dec_field[String](_value, "pass")
    } yield {
      new _root_.io.protoforce.guide.auth.SignUp.Email(
        timezone = timezone,
        email = email,
        pass = pass
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_ClientConfig_irt: IRTCodecWire[ClientConfig] = new IRTCodecWire[ClientConfig] {
    override def encode(_value: ClientConfig): Json = _enc_object_fields(
      ("endpoint", implicitly[IRTCodecWire[String]].encode(_value.endpoint), false),
      ("facebook", implicitly[IRTCodecWire[FacebookConfig]].encode(_value.facebook), false),
      ("google", implicitly[IRTCodecWire[GoogleClientConfig]].encode(_value.google), false),
      ("twitter", implicitly[IRTCodecWire[TwitterClientConfig]].encode(_value.twitter), false),
      ("github", implicitly[IRTCodecWire[GithubClientConfig]].encode(_value.github), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], ClientConfig] = for {
      _ <- Right(())
      endpoint <- _dec_field[String](_value, "endpoint")
      facebook <- _dec_field[FacebookConfig](_value, "facebook")
      google <- _dec_field[GoogleClientConfig](_value, "google")
      twitter <- _dec_field[TwitterClientConfig](_value, "twitter")
      github <- _dec_field[GithubClientConfig](_value, "github")
    } yield {
      new ClientConfig(
        endpoint = endpoint,
        facebook = facebook,
        google = google,
        twitter = twitter,
        github = github
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_TwitterServerConfig_irt: IRTCodecWire[TwitterServerConfig] = new IRTCodecWire[TwitterServerConfig] {
    override def encode(_value: TwitterServerConfig): Json = _enc_object_fields(
      ("customerId", implicitly[IRTCodecWire[String]].encode(_value.customerId), false),
      ("customerSecret", implicitly[IRTCodecWire[String]].encode(_value.customerSecret), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], TwitterServerConfig] = for {
      _ <- Right(())
      customerId <- _dec_field[String](_value, "customerId")
      customerSecret <- _dec_field[String](_value, "customerSecret")
    } yield {
      new TwitterServerConfig(
        customerId = customerId,
        customerSecret = customerSecret
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_OAuthData_irt: IRTCodecWire[OAuthData] = new IRTCodecWire[OAuthData] {
    override def encode(_value: OAuthData): Json = _value match {
      case v: _root_.io.protoforce.guide.auth.OAuthData.Impl => _encCircePolyNestedJson(_enc_object_fields(
        ("accessToken", implicitly[IRTCodecWire[String]].encode(v.accessToken), false)
      ), "io.protoforce.guide.auth:OAuthData")
    }
    override def decode(_value: Json): Either[List[IRTCodecFailure], OAuthData] = for {
      parts <- _decCircePolyNested(_value)
      wireid = parts._1
      _body = parts._2
      result <- wireid match {
        case "io.protoforce.guide.auth:OAuthData" => for {
          _ <- Right(())
          accessToken <- _dec_field[String](_body, "accessToken")
        } yield {
          new _root_.io.protoforce.guide.auth.OAuthData.Impl(
            accessToken = accessToken
          )
        }
      }
    } yield { result }
  }
  
  implicit def codec_io_protoforce_guide_auth_GithubAuth_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.GithubAuth] = new IRTCodecWire[_root_.io.protoforce.guide.auth.GithubAuth] {
    override def encode(_value: _root_.io.protoforce.guide.auth.GithubAuth): Json = _enc_object_fields(
      ("accessToken", implicitly[IRTCodecWire[String]].encode(_value.accessToken), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.GithubAuth] = for {
      _ <- Right(())
      accessToken <- _dec_field[String](_value, "accessToken")
    } yield {
      new _root_.io.protoforce.guide.auth.GithubAuth(
        accessToken = accessToken
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_SignUp_Facebook_irt: IRTCodecWire[Facebook] = new IRTCodecWire[Facebook] {
    override def encode(_value: Facebook): Json = _enc_object_fields(
      ("timezone", implicitly[IRTCodecWire[String]].encode(_value.timezone), false),
      ("accessToken", implicitly[IRTCodecWire[String]].encode(_value.accessToken), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], Facebook] = for {
      _ <- Right(())
      timezone <- _dec_field[String](_value, "timezone")
      accessToken <- _dec_field[String](_value, "accessToken")
    } yield {
      new Facebook(
        timezone = timezone,
        accessToken = accessToken
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_ListIdentitiesOutput_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.ListIdentitiesOutput.InternalErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.ListIdentitiesOutput.InternalErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authprotectedservice.models.ListIdentitiesOutput.InternalErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.InternalError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authprotectedservice.models.ListIdentitiesOutput.InternalErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.InternalError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authprotectedservice.models.ListIdentitiesOutput.InternalErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_SignIn_GithubAuth_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.GithubAuthRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.GithubAuthRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.SignIn.GithubAuthRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.GithubAuth]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.SignIn.GithubAuthRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.GithubAuth](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.SignIn.GithubAuthRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_AlreadyExistsError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.AlreadyExistsError] = new IRTCodecWire[_root_.io.protoforce.guide.auth.AlreadyExistsError] {
    override def encode(_value: _root_.io.protoforce.guide.auth.AlreadyExistsError): Json = _enc_object_fields(
      ("message", implicitly[IRTCodecWire[String]].encode(_value.message), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.AlreadyExistsError] = for {
      _ <- Right(())
      message <- _dec_field[String](_value, "message")
    } yield {
      new _root_.io.protoforce.guide.auth.AlreadyExistsError(
        message = message
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_SignIn_PhonePass_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.PhonePassRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.PhonePassRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.SignIn.PhonePassRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.PhonePass]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.SignIn.PhonePassRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.PhonePass](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.SignIn.PhonePassRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_Request2FAInput_irt: IRTCodecWire[Request2FAInput] = new IRTCodecWire[Request2FAInput] {
    override def encode(_value: Request2FAInput): Json = _enc_object_fields(
      ("method", implicitly[IRTCodecWire[MFAMethodRequest]].encode(_value.method), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], Request2FAInput] = for {
      _ <- Right(())
      method <- _dec_field[MFAMethodRequest](_value, "method")
    } yield {
      new Request2FAInput(
        method = method
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_IRTErrorAuth_irt: IRTCodecWire[IRTErrorAuth] = new IRTCodecWire[IRTErrorAuth] {
    override def encode(_value: IRTErrorAuth): Json = _enc_object_fields(
      ("message", implicitly[IRTCodecWire[String]].encode(_value.message), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], IRTErrorAuth] = for {
      _ <- Right(())
      message <- _dec_field[String](_value, "message")
    } yield {
      new IRTErrorAuth(
        message = message
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_SignupOutput_irt: IRTCodecWire[SignupOutput] = new IRTCodecWire[SignupOutput] {
    override def encode(_value: SignupOutput): Json = _value match {
      case v: _root_.io.protoforce.guide.auth.authservice.models.SignupOutput.InternalErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.SignupOutput.InternalErrorRef]].encode(v), "InternalError")
      case v: _root_.io.protoforce.guide.auth.authservice.models.SignupOutput.AlreadyExistsErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.SignupOutput.AlreadyExistsErrorRef]].encode(v), "AlreadyExistsError")
    }
    override def decode(_value: Json): Either[List[IRTCodecFailure], SignupOutput] = for {
      parts <- _decCircePolyNested(_value)
      wireid = parts._1
      _body = parts._2
      result <- wireid match {
        case "InternalError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.SignupOutput.InternalErrorRef]].decode(_body)
        case "AlreadyExistsError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.SignupOutput.AlreadyExistsErrorRef]].decode(_body)
      }
    } yield { result }
  }
  
  implicit def codec_io_protoforce_guide_auth_GoogleServerConfig_irt: IRTCodecWire[GoogleServerConfig] = new IRTCodecWire[GoogleServerConfig] {
    override def encode(_value: GoogleServerConfig): Json = _enc_object_fields(
      ("clientId", implicitly[IRTCodecWire[String]].encode(_value.clientId), false),
      ("redirectUrl", implicitly[IRTCodecWire[String]].encode(_value.redirectUrl), false),
      ("clientSecret", implicitly[IRTCodecWire[String]].encode(_value.clientSecret), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], GoogleServerConfig] = for {
      _ <- Right(())
      clientId <- _dec_field[String](_value, "clientId")
      redirectUrl <- _dec_field[String](_value, "redirectUrl")
      clientSecret <- _dec_field[String](_value, "clientSecret")
    } yield {
      new GoogleServerConfig(
        clientId = clientId,
        redirectUrl = redirectUrl,
        clientSecret = clientSecret
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_MFAMethodConfirm_irt: IRTCodecWire[MFAMethodConfirm] = new IRTCodecWire[MFAMethodConfirm] {
    override def encode(_value: MFAMethodConfirm): Json = _value match {
      case v: _root_.io.protoforce.guide.auth.MFAMethodConfirm.App => _encCircePolyFlatJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.MFAMethodConfirm.App]].encode(v), "$method", "App")
    }
    override def decode(_value: Json): Either[List[IRTCodecFailure], MFAMethodConfirm] = for {
      parts <- _decCircePolyFlat(_value, "$method")
      wireid = parts._1
      _body = parts._2
      result <- wireid match {
        case "App" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.MFAMethodConfirm.App]].decode(_body)
      }
    } yield { result }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_AddIdentityInput_irt: IRTCodecWire[AddIdentityInput] = new IRTCodecWire[AddIdentityInput] {
    override def encode(_value: AddIdentityInput): Json = _enc_object_fields(
      ("identity", implicitly[IRTCodecWire[SecondaryIdentity]].encode(_value.identity), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], AddIdentityInput] = for {
      _ <- Right(())
      identity <- _dec_field[SecondaryIdentity](_value, "identity")
    } yield {
      new AddIdentityInput(
        identity = identity
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ConfirmPhoneOutput_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ConfirmPhoneOutput.InternalErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ConfirmPhoneOutput.InternalErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authservice.models.ConfirmPhoneOutput.InternalErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.InternalError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authservice.models.ConfirmPhoneOutput.InternalErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.InternalError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authservice.models.ConfirmPhoneOutput.InternalErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_GithubServerConfig_irt: IRTCodecWire[GithubServerConfig] = new IRTCodecWire[GithubServerConfig] {
    override def encode(_value: GithubServerConfig): Json = _enc_object_fields(
      ("clientId", implicitly[IRTCodecWire[String]].encode(_value.clientId), false),
      ("clientSecret", implicitly[IRTCodecWire[String]].encode(_value.clientSecret), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], GithubServerConfig] = for {
      _ <- Right(())
      clientId <- _dec_field[String](_value, "clientId")
      clientSecret <- _dec_field[String](_value, "clientSecret")
    } yield {
      new GithubServerConfig(
        clientId = clientId,
        clientSecret = clientSecret
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_ServerConfig_irt: IRTCodecWire[ServerConfig] = new IRTCodecWire[ServerConfig] {
    override def encode(_value: ServerConfig): Json = _enc_object_fields(
      ("tokens", implicitly[IRTCodecWire[TokensServerConfig]].encode(_value.tokens), false),
      ("email", implicitly[IRTCodecWire[EmailServerConfig]].encode(_value.email), false),
      ("sms", implicitly[IRTCodecWire[SMSServerConfig]].encode(_value.sms), false),
      ("facebook", implicitly[IRTCodecWire[FacebookConfig]].encode(_value.facebook), false),
      ("google", implicitly[IRTCodecWire[GoogleServerConfig]].encode(_value.google), false),
      ("twitter", implicitly[IRTCodecWire[TwitterServerConfig]].encode(_value.twitter), false),
      ("github", implicitly[IRTCodecWire[GithubServerConfig]].encode(_value.github), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], ServerConfig] = for {
      _ <- Right(())
      tokens <- _dec_field[TokensServerConfig](_value, "tokens")
      email <- _dec_field[EmailServerConfig](_value, "email")
      sms <- _dec_field[SMSServerConfig](_value, "sms")
      facebook <- _dec_field[FacebookConfig](_value, "facebook")
      google <- _dec_field[GoogleServerConfig](_value, "google")
      twitter <- _dec_field[TwitterServerConfig](_value, "twitter")
      github <- _dec_field[GithubServerConfig](_value, "github")
    } yield {
      new ServerConfig(
        tokens = tokens,
        email = email,
        sms = sms,
        facebook = facebook,
        google = google,
        twitter = twitter,
        github = github
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ResetPasswordInput_irt: IRTCodecWire[ResetPasswordInput] = new IRTCodecWire[ResetPasswordInput] {
    override def encode(_value: ResetPasswordInput): Json = _enc_object_fields(
      ("lookup", implicitly[IRTCodecWire[UserLookup]].encode(_value.lookup), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], ResetPasswordInput] = for {
      _ <- Right(())
      lookup <- _dec_field[UserLookup](_value, "lookup")
    } yield {
      new ResetPasswordInput(
        lookup = lookup
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_Request2FAOutput_ForbiddenError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Request2FAOutput.ForbiddenErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Request2FAOutput.ForbiddenErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authprotectedservice.models.Request2FAOutput.ForbiddenErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.ForbiddenError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authprotectedservice.models.Request2FAOutput.ForbiddenErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.ForbiddenError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authprotectedservice.models.Request2FAOutput.ForbiddenErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_Disable2FAInput_irt: IRTCodecWire[Disable2FAInput] = new IRTCodecWire[Disable2FAInput] {
    override def encode(_value: Disable2FAInput): Json = _enc_object_fields()
    override def decode(_value: Json): Either[List[IRTCodecFailure], Disable2FAInput] = for {
      _ <- Right(())
    } yield {
      new Disable2FAInput()
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_GenericSuccess_irt: IRTCodecWire[GenericSuccess] = new IRTCodecWire[GenericSuccess] {
    override def encode(_value: GenericSuccess): Json = _enc_object_fields(
      ("message", implicitly[IRTCodecWire[Option[String]]].encode(_value.message), true)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], GenericSuccess] = for {
      _ <- Right(())
      message <- _dec_field[Option[String]](_value, "message")
    } yield {
      new GenericSuccess(
        message = message
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.InternalError] = new IRTCodecWire[_root_.io.protoforce.guide.auth.InternalError] {
    override def encode(_value: _root_.io.protoforce.guide.auth.InternalError): Json = _enc_object_fields(
      ("message", implicitly[IRTCodecWire[String]].encode(_value.message), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.InternalError] = for {
      _ <- Right(())
      message <- _dec_field[String](_value, "message")
    } yield {
      new _root_.io.protoforce.guide.auth.InternalError(
        message = message
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_UserID_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.UserID] = new IRTCodecWire[_root_.io.protoforce.guide.auth.UserID] {
    override def encode(_value: _root_.io.protoforce.guide.auth.UserID): Json = _enc_identifier[_root_.io.protoforce.guide.auth.UserID](_value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.UserID] = _dec_identifier[_root_.io.protoforce.guide.auth.UserID](_value)
  }
  
  implicit def keycodec_io_protoforce_guide_auth_UserID_irt: IRTKeyCodecWire[_root_.io.protoforce.guide.auth.UserID] = new IRTKeyCodecWire[_root_.io.protoforce.guide.auth.UserID] {
    override def encode(_value: _root_.io.protoforce.guide.auth.UserID): String = {
      val elements = List(
        ("id", implicitly[IRTKeyCodecWire[UUID]].encode(_value.id))
      )
      _enc_circe_identifier_StringToString("UserID", elements)
    }
    override def decode(_value: String): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.UserID] = {
      val elements = List(
        "id"
      )
      val maybeDecoded = for {
        _unpacked <- _decCirceIdtUnpack("UserID", _value, elements)
        id <- _decCirceCursor[UUID](_value, "id", _unpacked)
      } yield {
        new _root_.io.protoforce.guide.auth.UserID(
          id = id
        )
      }
      maybeDecoded
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_SignupAttributes_irt: IRTCodecWire[SignupAttributes] = new IRTCodecWire[SignupAttributes] {
    override def encode(_value: SignupAttributes): Json = _value match {
      case v: _root_.io.protoforce.guide.auth.SignupAttributes.Impl => _encCircePolyNestedJson(_enc_object_fields(
        ("timezone", implicitly[IRTCodecWire[String]].encode(v.timezone), false)
      ), "io.protoforce.guide.auth:SignupAttributes")
    }
    override def decode(_value: Json): Either[List[IRTCodecFailure], SignupAttributes] = for {
      parts <- _decCircePolyNested(_value)
      wireid = parts._1
      _body = parts._2
      result <- wireid match {
        case "io.protoforce.guide.auth:SignupAttributes" => for {
          _ <- Right(())
          timezone <- _dec_field[String](_body, "timezone")
        } yield {
          new _root_.io.protoforce.guide.auth.SignupAttributes.Impl(
            timezone = timezone
          )
        }
      }
    } yield { result }
  }
  
  implicit def codec_io_protoforce_guide_auth_SigninSuccessResponse_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.SigninSuccessResponse] = new IRTCodecWire[_root_.io.protoforce.guide.auth.SigninSuccessResponse] {
    override def encode(_value: _root_.io.protoforce.guide.auth.SigninSuccessResponse): Json = _enc_object_fields(
      ("user", implicitly[IRTCodecWire[User]].encode(_value.user), false),
      ("accessToken", implicitly[IRTCodecWire[String]].encode(_value.accessToken), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.SigninSuccessResponse] = for {
      _ <- Right(())
      user <- _dec_field[User](_value, "user")
      accessToken <- _dec_field[String](_value, "accessToken")
    } yield {
      new _root_.io.protoforce.guide.auth.SigninSuccessResponse(
        user = user,
        accessToken = accessToken
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_MFAMethodRequest_irt: IRTCodecWire[MFAMethodRequest] = new IRTCodecWire[MFAMethodRequest] {
    override def encode(_value: MFAMethodRequest): Json = _value match {
      case v: _root_.io.protoforce.guide.auth.MFAMethodRequest.App => _encCircePolyFlatJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.MFAMethodRequest.App]].encode(v), "$method", "App")
    }
    override def decode(_value: Json): Either[List[IRTCodecFailure], MFAMethodRequest] = for {
      parts <- _decCircePolyFlat(_value, "$method")
      wireid = parts._1
      _body = parts._2
      result <- wireid match {
        case "App" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.MFAMethodRequest.App]].decode(_body)
      }
    } yield { result }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_RemoveIdentityOutput_irt: IRTCodecWire[RemoveIdentityOutput] = new IRTCodecWire[RemoveIdentityOutput] {
    override def encode(_value: RemoveIdentityOutput): Json = _value match {
      case v: _root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.InternalErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.InternalErrorRef]].encode(v), "InternalError")
      case v: _root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.ForbiddenErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.ForbiddenErrorRef]].encode(v), "ForbiddenError")
      case v: _root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.NotFoundErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.NotFoundErrorRef]].encode(v), "NotFoundError")
    }
    override def decode(_value: Json): Either[List[IRTCodecFailure], RemoveIdentityOutput] = for {
      parts <- _decCircePolyNested(_value)
      wireid = parts._1
      _body = parts._2
      result <- wireid match {
        case "InternalError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.InternalErrorRef]].decode(_body)
        case "ForbiddenError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.ForbiddenErrorRef]].decode(_body)
        case "NotFoundError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.RemoveIdentityOutput.NotFoundErrorRef]].decode(_body)
      }
    } yield { result }
  }
  
  implicit def codec_io_protoforce_guide_auth_PhonePass_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.PhonePass] = new IRTCodecWire[_root_.io.protoforce.guide.auth.PhonePass] {
    override def encode(_value: _root_.io.protoforce.guide.auth.PhonePass): Json = _enc_object_fields(
      ("number", implicitly[IRTCodecWire[String]].encode(_value.number), false),
      ("pass", implicitly[IRTCodecWire[String]].encode(_value.pass), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.PhonePass] = for {
      _ <- Right(())
      number <- _dec_field[String](_value, "number")
      pass <- _dec_field[String](_value, "pass")
    } yield {
      new _root_.io.protoforce.guide.auth.PhonePass(
        number = number,
        pass = pass
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_AddIdentityOutput_AlreadyExistsError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.AlreadyExistsErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.AlreadyExistsErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.AlreadyExistsErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.AlreadyExistsError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.AlreadyExistsErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.AlreadyExistsError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authprotectedservice.models.AddIdentityOutput.AlreadyExistsErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_Confirm2FAOutput_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Confirm2FAOutput.InternalErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Confirm2FAOutput.InternalErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authprotectedservice.models.Confirm2FAOutput.InternalErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.InternalError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authprotectedservice.models.Confirm2FAOutput.InternalErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.InternalError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authprotectedservice.models.Confirm2FAOutput.InternalErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_User_irt: IRTCodecWire[User] = new IRTCodecWire[User] {
    override def encode(_value: User): Json = _enc_object_fields(
      ("name", implicitly[IRTCodecWire[String]].encode(_value.name), false),
      ("id", implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.UserID]].encode(_value.id), false),
      ("verified", implicitly[IRTCodecWire[Boolean]].encode(_value.verified), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], User] = for {
      _ <- Right(())
      name <- _dec_field[String](_value, "name")
      id <- _dec_field[_root_.io.protoforce.guide.auth.UserID](_value, "id")
      verified <- _dec_field[Boolean](_value, "verified")
    } yield {
      new User(
        name = name,
        id = id,
        verified = verified
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ResetPasswordOutput_irt: IRTCodecWire[ResetPasswordOutput] = new IRTCodecWire[ResetPasswordOutput] {
    override def encode(_value: ResetPasswordOutput): Json = _value match {
      case v: _root_.io.protoforce.guide.auth.authservice.models.ResetPasswordOutput.InternalErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ResetPasswordOutput.InternalErrorRef]].encode(v), "InternalError")
      case v: _root_.io.protoforce.guide.auth.authservice.models.ResetPasswordOutput.NotFoundErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ResetPasswordOutput.NotFoundErrorRef]].encode(v), "NotFoundError")
    }
    override def decode(_value: Json): Either[List[IRTCodecFailure], ResetPasswordOutput] = for {
      parts <- _decCircePolyNested(_value)
      wireid = parts._1
      _body = parts._2
      result <- wireid match {
        case "InternalError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ResetPasswordOutput.InternalErrorRef]].decode(_body)
        case "NotFoundError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ResetPasswordOutput.NotFoundErrorRef]].decode(_body)
      }
    } yield { result }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_Confirm2FAOutput_irt: IRTCodecWire[Confirm2FAOutput] = new IRTCodecWire[Confirm2FAOutput] {
    override def encode(_value: Confirm2FAOutput): Json = _value match {
      case v: _root_.io.protoforce.guide.auth.authprotectedservice.models.Confirm2FAOutput.InternalErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Confirm2FAOutput.InternalErrorRef]].encode(v), "InternalError")
      case v: _root_.io.protoforce.guide.auth.authprotectedservice.models.Confirm2FAOutput.ForbiddenErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Confirm2FAOutput.ForbiddenErrorRef]].encode(v), "ForbiddenError")
    }
    override def decode(_value: Json): Either[List[IRTCodecFailure], Confirm2FAOutput] = for {
      parts <- _decCircePolyNested(_value)
      wireid = parts._1
      _body = parts._2
      result <- wireid match {
        case "InternalError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Confirm2FAOutput.InternalErrorRef]].decode(_body)
        case "ForbiddenError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Confirm2FAOutput.ForbiddenErrorRef]].decode(_body)
      }
    } yield { result }
  }
  
  implicit def codec_io_protoforce_guide_auth_SMSServerConfig_irt: IRTCodecWire[SMSServerConfig] = new IRTCodecWire[SMSServerConfig] {
    override def encode(_value: SMSServerConfig): Json = _enc_object_fields(
      ("apiKey", implicitly[IRTCodecWire[String]].encode(_value.apiKey), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], SMSServerConfig] = for {
      _ <- Right(())
      apiKey <- _dec_field[String](_value, "apiKey")
    } yield {
      new SMSServerConfig(
        apiKey = apiKey
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_MFAMethodConfirm_App_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.MFAMethodConfirm.App] = new IRTCodecWire[_root_.io.protoforce.guide.auth.MFAMethodConfirm.App] {
    override def encode(_value: _root_.io.protoforce.guide.auth.MFAMethodConfirm.App): Json = _enc_object_fields(
      ("code", implicitly[IRTCodecWire[String]].encode(_value.code), false),
      ("token", implicitly[IRTCodecWire[String]].encode(_value.token), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.MFAMethodConfirm.App] = for {
      _ <- Right(())
      code <- _dec_field[String](_value, "code")
      token <- _dec_field[String](_value, "token")
    } yield {
      new _root_.io.protoforce.guide.auth.MFAMethodConfirm.App(
        code = code,
        token = token
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_NotFoundError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.NotFoundError] = new IRTCodecWire[_root_.io.protoforce.guide.auth.NotFoundError] {
    override def encode(_value: _root_.io.protoforce.guide.auth.NotFoundError): Json = _enc_object_fields(
      ("message", implicitly[IRTCodecWire[String]].encode(_value.message), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.NotFoundError] = for {
      _ <- Right(())
      message <- _dec_field[String](_value, "message")
    } yield {
      new _root_.io.protoforce.guide.auth.NotFoundError(
        message = message
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ChangePasswordInput_irt: IRTCodecWire[ChangePasswordInput] = new IRTCodecWire[ChangePasswordInput] {
    override def encode(_value: ChangePasswordInput): Json = _enc_object_fields(
      ("changeToken", implicitly[IRTCodecWire[String]].encode(_value.changeToken), false),
      ("password", implicitly[IRTCodecWire[String]].encode(_value.password), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], ChangePasswordInput] = for {
      _ <- Right(())
      changeToken <- _dec_field[String](_value, "changeToken")
      password <- _dec_field[String](_value, "password")
    } yield {
      new ChangePasswordInput(
        changeToken = changeToken,
        password = password
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_Confirm2FAInput_irt: IRTCodecWire[Confirm2FAInput] = new IRTCodecWire[Confirm2FAInput] {
    override def encode(_value: Confirm2FAInput): Json = _enc_object_fields(
      ("method", implicitly[IRTCodecWire[MFAMethodConfirm]].encode(_value.method), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], Confirm2FAInput] = for {
      _ <- Right(())
      method <- _dec_field[MFAMethodConfirm](_value, "method")
    } yield {
      new Confirm2FAInput(
        method = method
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_TwitterClientConfig_irt: IRTCodecWire[TwitterClientConfig] = new IRTCodecWire[TwitterClientConfig] {
    override def encode(_value: TwitterClientConfig): Json = _enc_object_fields(
      ("customerId", implicitly[IRTCodecWire[String]].encode(_value.customerId), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], TwitterClientConfig] = for {
      _ <- Right(())
      customerId <- _dec_field[String](_value, "customerId")
    } yield {
      new TwitterClientConfig(
        customerId = customerId
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_SignIn_TwoFactor_irt: IRTCodecWire[TwoFactor] = new IRTCodecWire[TwoFactor] {
    override def encode(_value: TwoFactor): Json = _enc_object_fields(
      ("token", implicitly[IRTCodecWire[String]].encode(_value.token), false),
      ("code", implicitly[IRTCodecWire[String]].encode(_value.code), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], TwoFactor] = for {
      _ <- Right(())
      token <- _dec_field[String](_value, "token")
      code <- _dec_field[String](_value, "code")
    } yield {
      new TwoFactor(
        token = token,
        code = code
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_EmailServerConfig_irt: IRTCodecWire[EmailServerConfig] = new IRTCodecWire[EmailServerConfig] {
    override def encode(_value: EmailServerConfig): Json = _enc_object_fields(
      ("apiKey", implicitly[IRTCodecWire[String]].encode(_value.apiKey), false),
      ("confirmEndpoint", implicitly[IRTCodecWire[String]].encode(_value.confirmEndpoint), false),
      ("resetPassEndpoint", implicitly[IRTCodecWire[String]].encode(_value.resetPassEndpoint), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], EmailServerConfig] = for {
      _ <- Right(())
      apiKey <- _dec_field[String](_value, "apiKey")
      confirmEndpoint <- _dec_field[String](_value, "confirmEndpoint")
      resetPassEndpoint <- _dec_field[String](_value, "resetPassEndpoint")
    } yield {
      new EmailServerConfig(
        apiKey = apiKey,
        confirmEndpoint = confirmEndpoint,
        resetPassEndpoint = resetPassEndpoint
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_MFAMethodRequest_App_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.MFAMethodRequest.App] = new IRTCodecWire[_root_.io.protoforce.guide.auth.MFAMethodRequest.App] {
    override def encode(_value: _root_.io.protoforce.guide.auth.MFAMethodRequest.App): Json = _enc_object_fields()
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.MFAMethodRequest.App] = for {
      _ <- Right(())
    } yield {
      new _root_.io.protoforce.guide.auth.MFAMethodRequest.App()
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_SignUp_Github_irt: IRTCodecWire[Github] = new IRTCodecWire[Github] {
    override def encode(_value: Github): Json = _enc_object_fields(
      ("timezone", implicitly[IRTCodecWire[String]].encode(_value.timezone), false),
      ("accessToken", implicitly[IRTCodecWire[String]].encode(_value.accessToken), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], Github] = for {
      _ <- Right(())
      timezone <- _dec_field[String](_value, "timezone")
      accessToken <- _dec_field[String](_value, "accessToken")
    } yield {
      new Github(
        timezone = timezone,
        accessToken = accessToken
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_Request2FAOutput_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Request2FAOutput.InternalErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Request2FAOutput.InternalErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authprotectedservice.models.Request2FAOutput.InternalErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.InternalError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authprotectedservice.models.Request2FAOutput.InternalErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.InternalError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authprotectedservice.models.Request2FAOutput.InternalErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_SignupOutput_AlreadyExistsError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.SignupOutput.AlreadyExistsErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.SignupOutput.AlreadyExistsErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authservice.models.SignupOutput.AlreadyExistsErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.AlreadyExistsError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authservice.models.SignupOutput.AlreadyExistsErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.AlreadyExistsError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authservice.models.SignupOutput.AlreadyExistsErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_Disable2FAOutput_irt: IRTCodecWire[Disable2FAOutput] = new IRTCodecWire[Disable2FAOutput] {
    override def encode(_value: Disable2FAOutput): Json = _value match {
      case v: _root_.io.protoforce.guide.auth.authprotectedservice.models.Disable2FAOutput.InternalErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Disable2FAOutput.InternalErrorRef]].encode(v), "InternalError")
      case v: _root_.io.protoforce.guide.auth.authprotectedservice.models.Disable2FAOutput.ForbiddenErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Disable2FAOutput.ForbiddenErrorRef]].encode(v), "ForbiddenError")
    }
    override def decode(_value: Json): Either[List[IRTCodecFailure], Disable2FAOutput] = for {
      parts <- _decCircePolyNested(_value)
      wireid = parts._1
      _body = parts._2
      result <- wireid match {
        case "InternalError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Disable2FAOutput.InternalErrorRef]].decode(_body)
        case "ForbiddenError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Disable2FAOutput.ForbiddenErrorRef]].decode(_body)
      }
    } yield { result }
  }
  
  implicit def codec_io_protoforce_guide_auth_MFAMethodPending_App_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.MFAMethodPending.App] = new IRTCodecWire[_root_.io.protoforce.guide.auth.MFAMethodPending.App] {
    override def encode(_value: _root_.io.protoforce.guide.auth.MFAMethodPending.App): Json = _enc_object_fields(
      ("secret", implicitly[IRTCodecWire[String]].encode(_value.secret), false),
      ("token", implicitly[IRTCodecWire[String]].encode(_value.token), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.MFAMethodPending.App] = for {
      _ <- Right(())
      secret <- _dec_field[String](_value, "secret")
      token <- _dec_field[String](_value, "token")
    } yield {
      new _root_.io.protoforce.guide.auth.MFAMethodPending.App(
        secret = secret,
        token = token
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_TwitterAuth_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.TwitterAuth] = new IRTCodecWire[_root_.io.protoforce.guide.auth.TwitterAuth] {
    override def encode(_value: _root_.io.protoforce.guide.auth.TwitterAuth): Json = _enc_object_fields(
      ("accessToken", implicitly[IRTCodecWire[String]].encode(_value.accessToken), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.TwitterAuth] = for {
      _ <- Right(())
      accessToken <- _dec_field[String](_value, "accessToken")
    } yield {
      new _root_.io.protoforce.guide.auth.TwitterAuth(
        accessToken = accessToken
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_SignIn_GoogleAuth_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.GoogleAuthRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.GoogleAuthRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.SignIn.GoogleAuthRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.GoogleAuth]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.SignIn.GoogleAuthRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.GoogleAuth](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.SignIn.GoogleAuthRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ChangePasswordOutput_irt: IRTCodecWire[ChangePasswordOutput] = new IRTCodecWire[ChangePasswordOutput] {
    override def encode(_value: ChangePasswordOutput): Json = _value match {
      case v: _root_.io.protoforce.guide.auth.authservice.models.ChangePasswordOutput.InternalErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ChangePasswordOutput.InternalErrorRef]].encode(v), "InternalError")
      case v: _root_.io.protoforce.guide.auth.authservice.models.ChangePasswordOutput.NotFoundErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ChangePasswordOutput.NotFoundErrorRef]].encode(v), "NotFoundError")
    }
    override def decode(_value: Json): Either[List[IRTCodecFailure], ChangePasswordOutput] = for {
      parts <- _decCircePolyNested(_value)
      wireid = parts._1
      _body = parts._2
      result <- wireid match {
        case "InternalError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ChangePasswordOutput.InternalErrorRef]].decode(_body)
        case "NotFoundError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ChangePasswordOutput.NotFoundErrorRef]].decode(_body)
      }
    } yield { result }
  }
  
  implicit def codec_io_protoforce_guide_auth_SignUp_Google_irt: IRTCodecWire[Google] = new IRTCodecWire[Google] {
    override def encode(_value: Google): Json = _enc_object_fields(
      ("timezone", implicitly[IRTCodecWire[String]].encode(_value.timezone), false),
      ("accessToken", implicitly[IRTCodecWire[String]].encode(_value.accessToken), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], Google] = for {
      _ <- Right(())
      timezone <- _dec_field[String](_value, "timezone")
      accessToken <- _dec_field[String](_value, "accessToken")
    } yield {
      new Google(
        timezone = timezone,
        accessToken = accessToken
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_SignupInput_irt: IRTCodecWire[SignupInput] = new IRTCodecWire[SignupInput] {
    override def encode(_value: SignupInput): Json = _enc_object_fields(
      ("with", implicitly[IRTCodecWire[SignUp]].encode(_value.`with`), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], SignupInput] = for {
      _ <- Right(())
      `with` <- _dec_field[SignUp](_value, "with")
    } yield {
      new SignupInput(
        `with` = `with`
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_Disable2FAOutput_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Disable2FAOutput.InternalErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Disable2FAOutput.InternalErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authprotectedservice.models.Disable2FAOutput.InternalErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.InternalError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authprotectedservice.models.Disable2FAOutput.InternalErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.InternalError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authprotectedservice.models.Disable2FAOutput.InternalErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_SecondaryIdentity_irt: IRTCodecWire[SecondaryIdentity] = new IRTCodecWire[SecondaryIdentity] {
    override def encode(_value: SecondaryIdentity): Json = _value match {
      case v: _root_.io.protoforce.guide.auth.SecondaryIdentity.Phone => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.SecondaryIdentity.Phone]].encode(v), "Phone")
      case v: _root_.io.protoforce.guide.auth.SecondaryIdentity.Email => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.SecondaryIdentity.Email]].encode(v), "Email")
    }
    override def decode(_value: Json): Either[List[IRTCodecFailure], SecondaryIdentity] = for {
      parts <- _decCircePolyNested(_value)
      wireid = parts._1
      _body = parts._2
      result <- wireid match {
        case "Phone" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.SecondaryIdentity.Phone]].decode(_body)
        case "Email" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.SecondaryIdentity.Email]].decode(_body)
      }
    } yield { result }
  }
  
  implicit def codec_io_protoforce_guide_auth_UserLookup_UserID_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.UserLookup.UserIDRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.UserLookup.UserIDRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.UserLookup.UserIDRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.UserID]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.UserLookup.UserIDRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.UserID](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.UserLookup.UserIDRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ConfirmPhoneInput_irt: IRTCodecWire[ConfirmPhoneInput] = new IRTCodecWire[ConfirmPhoneInput] {
    override def encode(_value: ConfirmPhoneInput): Json = _enc_object_fields(
      ("code", implicitly[IRTCodecWire[String]].encode(_value.code), false),
      ("phone", implicitly[IRTCodecWire[String]].encode(_value.phone), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], ConfirmPhoneInput] = for {
      _ <- Right(())
      code <- _dec_field[String](_value, "code")
      phone <- _dec_field[String](_value, "phone")
    } yield {
      new ConfirmPhoneInput(
        code = code,
        phone = phone
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authprotectedservice_models_Disable2FAOutput_ForbiddenError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Disable2FAOutput.ForbiddenErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authprotectedservice.models.Disable2FAOutput.ForbiddenErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authprotectedservice.models.Disable2FAOutput.ForbiddenErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.ForbiddenError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authprotectedservice.models.Disable2FAOutput.ForbiddenErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.ForbiddenError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authprotectedservice.models.Disable2FAOutput.ForbiddenErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_SignIn_EmailPass_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.EmailPassRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.SignIn.EmailPassRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.SignIn.EmailPassRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.EmailPass]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.SignIn.EmailPassRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.EmailPass](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.SignIn.EmailPassRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ConfirmPhoneOutput_irt: IRTCodecWire[ConfirmPhoneOutput] = new IRTCodecWire[ConfirmPhoneOutput] {
    override def encode(_value: ConfirmPhoneOutput): Json = _value match {
      case v: _root_.io.protoforce.guide.auth.authservice.models.ConfirmPhoneOutput.InternalErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ConfirmPhoneOutput.InternalErrorRef]].encode(v), "InternalError")
      case v: _root_.io.protoforce.guide.auth.authservice.models.ConfirmPhoneOutput.NotFoundErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ConfirmPhoneOutput.NotFoundErrorRef]].encode(v), "NotFoundError")
    }
    override def decode(_value: Json): Either[List[IRTCodecFailure], ConfirmPhoneOutput] = for {
      parts <- _decCircePolyNested(_value)
      wireid = parts._1
      _body = parts._2
      result <- wireid match {
        case "InternalError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ConfirmPhoneOutput.InternalErrorRef]].decode(_body)
        case "NotFoundError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ConfirmPhoneOutput.NotFoundErrorRef]].decode(_body)
      }
    } yield { result }
  }
  
  implicit def codec_io_protoforce_guide_auth_SigninResponse_irt: IRTCodecWire[SigninResponse] = new IRTCodecWire[SigninResponse] {
    override def encode(_value: SigninResponse): Json = _value match {
      case v: _root_.io.protoforce.guide.auth.SigninResponse.SigninSuccessResponseRef => _encCircePolyFlatJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.SigninResponse.SigninSuccessResponseRef]].encode(v), "$class", "SigninSuccessResponse")
      case v: Confirm2FA => _encCircePolyFlatJson(implicitly[IRTCodecWire[Confirm2FA]].encode(v), "$class", "Confirm2FA")
    }
    override def decode(_value: Json): Either[List[IRTCodecFailure], SigninResponse] = for {
      parts <- _decCircePolyFlat(_value, "$class")
      wireid = parts._1
      _body = parts._2
      result <- wireid match {
        case "SigninSuccessResponse" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.SigninResponse.SigninSuccessResponseRef]].decode(_body)
        case "Confirm2FA" => implicitly[IRTCodecWire[Confirm2FA]].decode(_body)
      }
    } yield { result }
  }
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ConfirmEmailOutput_InternalError_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ConfirmEmailOutput.InternalErrorRef] = new IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ConfirmEmailOutput.InternalErrorRef] {
    override def encode(_value: _root_.io.protoforce.guide.auth.authservice.models.ConfirmEmailOutput.InternalErrorRef): Json = implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.InternalError]].encode(_value.value)
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.authservice.models.ConfirmEmailOutput.InternalErrorRef] = for {
      _ <- Right(())
      value <- _dec_type[_root_.io.protoforce.guide.auth.InternalError](_value)
    } yield {
      new _root_.io.protoforce.guide.auth.authservice.models.ConfirmEmailOutput.InternalErrorRef(
        value = value
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_MFAMethodPending_irt: IRTCodecWire[MFAMethodPending] = new IRTCodecWire[MFAMethodPending] {
    override def encode(_value: MFAMethodPending): Json = _value match {
      case v: _root_.io.protoforce.guide.auth.MFAMethodPending.App => _encCircePolyFlatJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.MFAMethodPending.App]].encode(v), "$method", "App")
    }
    override def decode(_value: Json): Either[List[IRTCodecFailure], MFAMethodPending] = for {
      parts <- _decCircePolyFlat(_value, "$method")
      wireid = parts._1
      _body = parts._2
      result <- wireid match {
        case "App" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.MFAMethodPending.App]].decode(_body)
      }
    } yield { result }
  }
  
  implicit def codec_io_protoforce_guide_auth_UserLookup_Phone_irt: IRTCodecWire[_root_.io.protoforce.guide.auth.UserLookup.Phone] = new IRTCodecWire[_root_.io.protoforce.guide.auth.UserLookup.Phone] {
    override def encode(_value: _root_.io.protoforce.guide.auth.UserLookup.Phone): Json = _enc_object_fields(
      ("phone", implicitly[IRTCodecWire[String]].encode(_value.phone), false)
    )
    override def decode(_value: Json): Either[List[IRTCodecFailure], _root_.io.protoforce.guide.auth.UserLookup.Phone] = for {
      _ <- Right(())
      phone <- _dec_field[String](_value, "phone")
    } yield {
      new _root_.io.protoforce.guide.auth.UserLookup.Phone(
        phone = phone
      )
    }
  }
  
  implicit def codec_io_protoforce_guide_auth_authservice_models_ConfirmEmailOutput_irt: IRTCodecWire[ConfirmEmailOutput] = new IRTCodecWire[ConfirmEmailOutput] {
    override def encode(_value: ConfirmEmailOutput): Json = _value match {
      case v: _root_.io.protoforce.guide.auth.authservice.models.ConfirmEmailOutput.InternalErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ConfirmEmailOutput.InternalErrorRef]].encode(v), "InternalError")
      case v: _root_.io.protoforce.guide.auth.authservice.models.ConfirmEmailOutput.NotFoundErrorRef => _encCircePolyNestedJson(implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ConfirmEmailOutput.NotFoundErrorRef]].encode(v), "NotFoundError")
    }
    override def decode(_value: Json): Either[List[IRTCodecFailure], ConfirmEmailOutput] = for {
      parts <- _decCircePolyNested(_value)
      wireid = parts._1
      _body = parts._2
      result <- wireid match {
        case "InternalError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ConfirmEmailOutput.InternalErrorRef]].decode(_body)
        case "NotFoundError" => implicitly[IRTCodecWire[_root_.io.protoforce.guide.auth.authservice.models.ConfirmEmailOutput.NotFoundErrorRef]].decode(_body)
      }
    } yield { result }
  }
}

object IRTCodecAuthCirce {
  object DefaultCodec extends IRTCodecAuthCirce with _root_.izumi.idealingua.runtime.codecs.circe.IRTDomainCodecCirceString {
    
  }
}