# Extensive guide to authentication and authorization system implementation - Scala

This article continues the design previously described [here]().

Protoforce generates highly abstract and polymorphic Scala code, which is intended to be used in the most modern Pure Functional Programming settings.

In order to fully utilize Protoforce potential in Scala you should have at list basic understanding of the following concepts, patterns, approaches, libraries and technologies:

1) Higher-kinded types, [implicits](https://www.scala-lang.org/files/archive/spec/2.11/07-implicits.html),  [typeclasses](https://scalac.io/blog/typeclasses-in-scala/), [Algebraic Data Types](https://blog.softwaremill.com/algebraic-data-types-in-four-languages-858788043d4e)
2) [Tagless final style](https://blog.softwaremill.com/final-tagless-seen-alive-79a8d884691d)
3) [Either](https://www.scala-lang.org/api/current/scala/util/Either.html) and explicit error encoding
4) [IO Monad](https://typelevel.org/blog/2017/05/02/io-monad-for-cats.html) and [cats-effect](https://github.com/typelevel/cats-effect)
5) [Bifunctor IO](https://degoes.net/articles/bifunctor-io) and [ZIO](https://zio.dev)
6) [ZIO cats interop](https://github.com/zio/interop-cats)
7) [Izumi BIO](https://izumi.7mind.io/bio/index.html) typeclasses for Bifunctor IO
8) [Izumi distage](https://izumi.7mind.io/distage/index.html) dependency injection framework
9) [http4s](https://http4s.org/) web server
10) [Apache HTTP Client](https://hc.apache.org/httpcomponents-client-5.0.x/)
11) [SBT](https://www.scala-sbt.org/) build tool
12) [JWT](https://jwt.io) security standard
13) [Lightbend Config](https://github.com/lightbend/config)
14) [circe](https://github.com/circe/circe) JSON framework
15) [Cross-Origin Resource Sharing (CORS)](https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS)
16) Any robust Scala IDE or equivalent toolchain


Protoforce generates abstract interfaces with explicitly encoded errors and dispatchers utilizing BIO typeclasses. That code can be used with any Bifunctor IO implementation. Protoforce provides you ready to use runtime built on top of ZIO, and http4s (through ZIO cats interop layer). Runtime components are wired together with `distage`. You don't have to wire your application with distage, but it's recommended. In case you don't want to use an IO Monad, you still may use generated Protoforce stubs but you'll need to implement your own runtime.

Before you can proceed with this article, make sure you create a project in ProtoForce and copy the models into it. Once that is done, setup the publishing to a git repository which will hold all of your auth system code. If you are not familair with ProtoForce and publishing, please read documentation here first: https://www.protoforce.io/docs

## Project structure

First of all we should create an empty Github repository. Let's assume that it's URL is `git clone git@github.com:ProtoForce/guide-auth-scala.git`

Once we have the repository we need configure our Protoforce project to push generated Scala source code into a subdirectory in that repository. Let's use path `src/generated` for that directory.

Then we should create another folder, e.g. `src/server` for our application and artifact subfolders:

```bash
mkdir -p src/server/auth-app/src/main/scala
mkdir -p src/server/auth-app/src/main/resources
```


Now we should create an SBT project stub and put it into `src/server/build.sbt`.
The very minimal example of such project with all the necessary dependencies should look like so:

```scala
// dependencies
lazy val D = new {
  val cats = Seq(
    libraryDependencies += "org.typelevel" %% "cats-effect" % V.`cats-effect`
  )
  val zio = Seq(
    libraryDependencies += "dev.zio" %% "zio-interop-cats" % V.`zio-interop-cats`
  )
  val protoforce = Seq(
    // these two dependecies required only in case you don't use "embedded runtime" option
    // libraryDependencies += "io.protoforce" %% "protoforce-runtime-rpc-scala-server-blaze" % V.protoforce,
    // libraryDependencies += "io.protoforce" %% "protoforce-runtime-rpc-scala-client-asynchttp" % V.protoforce,
    libraryDependencies += "org.jboss.xnio" % "xnio-nio" % V.`xnio-nio`
  )
  val izumi = Seq(
    libraryDependencies += "io.7mind.izumi" %% "logstage-core" % V.izumi,
    libraryDependencies += "io.7mind.izumi" %% "logstage-adapter-slf4j" % V.izumi,
    libraryDependencies += "io.7mind.izumi" %% "distage-framework" % V.izumi,
    libraryDependencies += "io.7mind.izumi" %% "distage-testkit-scalatest" % V.izumi % Test,
    libraryDependencies += "io.7mind.izumi" %% "fundamentals-bio" % V.izumi,
    libraryDependencies += "io.7mind.izumi" %% "fundamentals-functional" % V.izumi,
    libraryDependencies += "io.7mind.izumi" %% "fundamentals-platform" % V.izumi,
    scalacOptions ++= Seq(
      s"-Xmacro-settings:product-name=${name.value}",
      s"-Xmacro-settings:product-version=${version.value}",
      s"-Xmacro-settings:product-group=${organization.value}",
      s"-Xmacro-settings:scala-version=${scalaVersion.value}",
      s"-Xmacro-settings:scala-versions=${crossScalaVersions.value.mkString(":")}"
    )
  )
  val jwt = Seq(
    libraryDependencies += "com.github.jwt-scala" %% "jwt-circe" % V.`jwt-circe`
  )
  val totp = Seq(
    libraryDependencies += "dev.samstevens.totp" % "totp" % V.totp
  )
}

// dependency versions
lazy val V = new {
  val scala = "2.13.3"
  val `kind-projector` = "0.11.3"

  val protoforce = "0.0.3-SNAPSHOT"

  val `cats-effect` = "2.1.2"
  val izumi = "1.0.3"
  val `zio-interop-cats` = "2.0.0.0-RC12"
  val `xnio-nio` = "3.8.4.Final"
  val `jwt-circe` = "7.1.1"
  val totp = "1.7.1"
}

libraryDependencies in ThisBuild += compilerPlugin(
  "org.typelevel" % "kind-projector" % V.`kind-projector` cross CrossVersion.full
)

scalacOptions in ThisBuild ++= Seq(
  "-encoding",
  "UTF-8",
  "-target:jvm-1.8",
  "-feature",
  "-unchecked",
  "-deprecation",
  "-language:higherKinds",

  // Compile-time project reflection for Izumi framework
  s"-Xmacro-settings:sbt-version=${sbtVersion.value}",
  s"-Xmacro-settings:git-repo-clean=${com.typesafe.sbt.SbtGit.GitKeys.gitUncommittedChanges.value}",
  s"-Xmacro-settings:git-branch=${com.typesafe.sbt.SbtGit.GitKeys.gitCurrentBranch.value}",
  s"-Xmacro-settings:git-described-version=${com.typesafe.sbt.SbtGit.GitKeys.gitDescribedVersion.value
    .getOrElse("")}",
  s"-Xmacro-settings:git-head-commit=${com.typesafe.sbt.SbtGit.GitKeys.gitHeadCommit.value.getOrElse("")}"
)

scalaVersion in ThisBuild := V.scala

crossScalaVersions in ThisBuild := Seq(
  V.scala
)

// Here we import generated project as a subproject
lazy val `generated-api` = ProjectRef(file("../generated"), "bundle-api")

// Our primary artifact
lazy val `auth-app` = (project in file("auth-app"))
  .dependsOn(`generated-api`)
  .settings(D.cats: _*)
  .settings(D.zio: _*)
  .settings(D.izumi: _*)
  .settings(D.jwt: _*)
  .settings(D.totp: _*)
  .settings(D.protoforce: _*)

val `guide-auth-server-demo` = (project in file("."))
  .aggregate(`auth-app`)

```

Once we have our project created we may open our `build.sbt` with [IntelliJ IDEA](https://www.jetbrains.com/idea/) and start writing implementations for our services.

## Application components

### Data models

Our APIs will be exposed with HTTP, so we need to describe our transport-level context. We will definitely need HTTP headers to extract our JWT tokens, some other metadata, like IP address, may also be useful:

```scala
final case class IncomingServerCtx(ip: String, headers: Map[String, Seq[String]])
```

Apart of `User` data class defined in our API models we would need internal model for our user, containing additional authentication attributes (like optional password salt and hash, contact details, etc):

```scala
sealed trait Contact {
  def verified: Boolean
}

object Contact {
  final case class Email(email: String, original: String, verified: Boolean)
      extends Contact

  final case class Phone(
      phone: String,
      original: String,
      verified: Boolean,
      code: String
  ) extends Contact
}

final case class UserRecord(
    user: User,
    timezone: String,
    passHash: Option[String],
    passSalt: String,
    contacts: List[Contact],
    mfaSecret: Option[String],
)
```

### Repositories

Our application would need to store user records.

A minimal interface for such storage should look like so:

```scala
trait UserRepo[F[+_, +_]] {
  def lookup(lookup: UserLookup): F[UserRepo.Errors.MissingRecord, UserRecord]
  def writeRecord(record: UserRecord): F[Nothing, Unit]
}

object UserRepo {
  sealed trait Errors
  object Errors {
    final case class MissingRecord() extends Errors
  }
}
```

Now we may write a simple in-memory implementation:

```scala
object UserRepo {
  sealed trait Errors
  object Errors {
    final case class MissingRecord() extends Errors
  }

  class UserRepoDummyImpl[F[+_, +_]: IO2] extends UserRepo[F] {
    private val storage = mutable.HashMap[UserID, UserRecord]()

    override def writeRecord(record: UserRecord): F[Nothing, Unit] = {
      F.sync(storage.synchronized(storage.put(record.user.id, record)))
    }

    override def lookup(lookup: UserLookup): F[MissingRecord, UserRecord] = {
        // full implementation omitted, use our demo repository as reference
    }
  }
}
```

Once we have our repository we should write [DI wirings](https://izumi.7mind.io/distage/basics.html#dependencies) for it:

```scala
import distage._
import distage.plugins._
import zio.IO

object ReposPlugin extends PluginDef {
  private def makeF[F[+_, +_] : TagKK]: ModuleDef = new ModuleDef {
    make[UserRepo[F]].from[UserRepo.UserRepoDummyImpl[F]]
  }

  include(makeF[IO])
}
```

Essentially this code tells our DI framework that component interface `UserRepo` should be implemented by `UserRepoDummyImpl` and should run within `zio.IO` IO monad.

We will have a closer look at wirings in further chapters.

### Core services

We will need several core components for our application:

1) User authentication service extracting user details from HTTP headers and verifying them
2) Passwords service supporting OTP code generation and password hashing service
3) JWT token service for token parsing and issuing
4) Data sanitation service for email and phone number normalization

#### Data Sanitation Service

The following simple interface would be sufficient for our purposes:

```scala
trait SanitationService[F[+_, +_]] {
  def sanitizePhone(phone: String): F[Nothing, String]
  def sanitizeEmail(email: String): F[Nothing, String]
}
```

The implementation is mostly trivial and just removes whitespaces, lowercases strings and removes non-digits from phone numbers:

```scala
object SanitationService {
  class SanitationServiceImpl[F[+_, +_]: IO2] extends SanitationService[F] {
    override def sanitizePhone(phone: String): F[Nothing, String] = {
      F.sync(phone.trim.toLowerCase.replaceAll("\\D", ""))
    }

    override def sanitizeEmail(email: String): F[Nothing, String] = {
      F.sync(email.trim.toLowerCase)
    }
  }
}
```

#### Passwords Service

This service is completely trivial:

```scala
trait PasswordService[F[+_, +_]] {
  def nextPhonecode(): F[Nothing, String]

  def hash(value: String, salt: String): F[Nothing, String]
}

object PasswordService {
  class PasswordServiceImpl[F[+_, +_]: IO2: Entropy2]
      extends PasswordService[F] {
      }
}
```

The actual implementations for `PasswordService` methods are mostly mechanical, you should use our demo repository as reference.

#### JWT tokens service

Let's start by defining configuration case class containing JWT key and expiration time:

```scala
case class TokensConfig(jwtKey: String, expiration: FiniteDuration)
```

Apart of using JWT tokens to confirm user identity after authentication, we will use JWT for the following purposes:

1) To sign password reset and email confirmation secrets
2) To confirm user identity after password entry and before response to 2FA challenge
3) To confirm 2FA secret authenticity during 2FA activation process

Such approach allows us to avoid storing any additional state on server side. The clients would keep all necessary state at their side though wouldn't be able to fake or alter it.

Let's write down the interface for our Tokens service:

```scala
trait TokensService[F[+_, +_]] {
  // Primary JWT tokens confirming user identity
  def issueAuthToken(id: UserID): F[Nothing, String]
  def parseAuthToken(token: String): F[Throwable, UserID]

  // Password reset JWT tokens
  def issuePassResetToken(id: UserID): F[Nothing, String]
  def parsePassResetToken(token: String): F[Throwable, UserID]

  // Email confirmation JWT tokens
  def issueEmailConfirmationToken(email: String): F[Nothing, String]
  def parseEmailConfirmationToken(token: String): F[Throwable, String]

  // 2FA challenge JWT tokens
  def issueRestrictedTokenForUnfinished2FA(
      id: UserID
  ): F[Nothing, String]
  def parseRestrictedTokenForUnfinished2FA(token: String): F[Throwable, UserID]

  // 2FA activation JWT tokens
  def parseSignedMfaAuthSecret(token: String): F[Throwable, String]
  def issueSignedMfaAuthSecret(secret: String): F[Nothing, String]

  // TOTP helpers
  def issueMfaAppAuthSecret(): F[Nothing, String]
  def checkMfaCode(secret: String, value: String): F[Nothing, Boolean]
}
```

This service also takes responsibility of TOTP token validation, while, probably it's not the best approach to application design as it reduces [cohesion](https://en.wikipedia.org/wiki/Cohesion_(computer_science)) it's good enough for our demo purposes.

The implementation of this service is bulky but mostly mechanical, please look at our demo repository for the actual implementation.

#### User Authentication Service

This service should extract JWT token strings from HTTP headrs, use JWT Tokens service to parse them into user identifiers and query user repository for user records:

```scala
trait UserAuthService[F[+_, +_]] {
  def user(_ctx: IncomingServerCtx): F[Nothing, UserRecord]
}

object UserAuthService {
  class UserAuthServiceImpl[F[+_, +_]: IO2](
      tokensService: TokensService[F],
      users: UserRepo[F]
  ) extends UserAuthService[F] {
    override def user(ctx: IncomingServerCtx): F[Nothing, UserRecord] = {
      // first we should normalize header names
      val lowercased = ctx.headers.map { case (k, v) =>
        (k.toLowerCase, v)
      }

      val user = for {
        // then we should extract Authorization header
        header <- F
          .fromOption(new RuntimeException("Missing authorization header"))(
            lowercased.get("authorization").flatMap(_.headOption)
          )
        // then we should check if header starts with "Bearer" scheme and extract token value
        prefix = "Bearer "
        token <-
          if (header.startsWith(prefix)) {
            F.pure(header.substring(prefix.length).trim)
          } else {
            F.fail(new RuntimeException("Wrong authorization header"))
          }
        // then we should parse the token and extract user data from user repository
        userId <- tokensService.parseAuthToken(token).orTerminate
        user <- users.lookup(UserLookup.UserIDRef(userId)).leftMap(_ => new RuntimeException("Unknown user"))
      } yield {
        user
      }

      user.orTerminate // in case something goes wrong we should immediately stop
    }
  }
}
```

Production implementation should use better error reporing though this one is enough for our demo.

### Wirings

```scala
import distage._
import distage.plugins._
import zio.IO

object ComponentsPlugin extends PluginDef {
  private def makeF[F[+_, +_]: TagKK]: ModuleDef = new ModuleDef {
    make[PasswordService[F]].from[PasswordService.PasswordServiceImpl[F]]
    make[TokensService[F]].from[TokensService.TokensServiceImpl[F]]
    make[SanitationService[F]].from[SanitationService.SanitationServiceImpl[F]]
    make[UserAuthService[F]].from[UserAuthService.UserAuthServiceImpl[F]]
  }

  include(makeF[IO])
}
```

### Integration points

We will use the following external APIs:

1) Mailgun (email provider)
2) Facebook (identity provider)
3) Github (identity provider)
4) Google (identity provider)
5) Twilio (SMS provider)
6) Twitter (identity provider)

Let's start by declaring configuration case classes for all these API providers:

```scala
case class EmailConfig(resetPassEndpoint: String)
case class SmsConfig(apiKey: String)
case class GithubConfig(clientId: String, clientSecret: String)
case class TwitterConfig(customerId: String, customerSecret: String)
case class GoogleConfig(
    clientId: String,
    clientSecret: String,
    redirectUrl: String
)
case class FacebookConfig(appId: String)
```

Now we may define our full application configuration:

```scala
case class AppConfig(
    email: EmailConfig,
    sms: SmsConfig,
    google: GoogleConfig,
    github: GithubConfig,
    twitter: TwitterConfig,
    facebook: FacebookConfig,
    tokens: TokensConfig
)
```

Let's write down interfaces for these APIs:

```scala
trait EmailService[F[+_, +_]] {
  def sendEmail(email: String, message: String): F[Nothing, Unit]
}
object EmailService {
  class EmailServiceImpl[F[+_, +_] : IO2](
    client: AsyncHttpClient,
    config: EmailConfig,
    logger: LogIO2[F],
    ) extends EmailService[F] {
        // implementation goes here
    }
}
trait FacebookService[F[+_, +_]] {
  def verifyFacebook(accessToken: String) : F[Nothing, VerifiedFacebook]
}
object FacebookService {
  case class VerifiedFacebook(email: String)
  class FacebookServiceImpl[F[+_, +_] : IO2 : Async2](
        client: AsyncHttpClient,
        config: FacebookConfig,
    ) extends FacebookService[F] {
        // implementation goes here
    }
}

trait GithubService[F[+_, +_]] {
  def verifyGithub(accessToken: String): F[Nothing, VerifiedGithub]

}
object GithubService {
  case class VerifiedGithub(email: String)
  class GithubServiceImpl[F[+_, +_]: IO2: Async2](
      client: AsyncHttpClient,
      config: GithubConfig,
  ) extends GithubService[F] {
    // implementation goes here
  }
}

trait GoogleService[F[+_, +_]] {
  def verifyGoogle(accessToken: String): F[Nothing, VerifiedGoogle]
}
object GoogleService {
  case class VerifiedGoogle(email: String)
    class GoogleServiceImpl[F[+_, +_]: IO2: Async2](
      client: AsyncHttpClient,
      config: GoogleConfig,
  ) extends GoogleService[F] {
    // implementation goes here
  }
}

trait SmsService[F[+_, +_]] {
  def sendSMS(phone: String, message: String): F[Nothing, Unit]
}
object SmsService {
  class SmsServiceDummyImpl[F[+_, +_] : IO2](
        client: AsyncHttpClient,
        config: SmsConfig,
    ) extends SmsService[F] {
        // implementation goes here
    }
}
trait TwitterService[F[+_, +_]] {
  def verifyTwitter(accessToken: String) : F[Nothing, VerifiedTwitter]
}
object TwitterService {
    class TwitterServiceImpl[F[+_, +_] : IO2 : Async2](
    client: AsyncHttpClient,
    config: TwitterConfig,
    ) {
        // implementation goes here
    }
}
```

The actual implementations for these components are mostly mechanical, you should use our demo repository as reference.

Now we may create DI plugin with all the wirings for these components:

```scala
import distage._
import distage.plugins._
import izumi.distage.config._
import zio.IO

object IntegrationsPlugin extends PluginDef {
  private def makeF[F[+_, +_] : TagKK]: ModuleDef = new ModuleDef {
    make[EmailService[F]].from[EmailService.EmailServiceDummyImpl[F]]
    make[SmsService[F]].from[SmsService.SmsServiceDummyImpl[F]]

    make[FacebookService[F]].from[FacebookService.FacebookServiceImpl[F]]
    make[GithubService[F]].from[GithubService.GithubServiceImpl[F]]
    make[GoogleService[F]].from[GoogleService.GoogleServiceImpl[F]]
    make[TwitterService[F]].from[TwitterService.TwitterServiceImpl[F]]
  }

  include(makeF[IO])
}
```

## API implementations

Once we have all the necessary components we may start implementing our APIs.

Let's start by declaring implementations of our API stubs:

```scala
class AuthServiceImpl[F[+_, +_]: IO2](
    config: AppConfig,
    users: UserRepo[F],
    entropy2: Entropy2[F],
    tokens: TokensService[F],
    passwords: PasswordService[F],
    sanitation: SanitationService[F],
    twitter: TwitterService[F],
    facebook: FacebookService[F],
    google: GoogleService[F],
    github: GithubService[F],
    emailService: EmailService[F],
    smsService: SmsService[F]
) extends AuthService[IncomingServerCtx, F] {
}

class AuthProtectedServiceImpl[F[+_, +_]: IO2](
    auth: UserAuthService[F],
    tokens: TokensService[F],
    users: UserRepo[F],
    sanitation: SanitationService[F],
    passwords: PasswordService[F]
) extends AuthProtectedService[IncomingServerCtx, F] {
}
```

Now we should put our cursor between the curly braces in both classes and use `Code -> Implement methods` in IDEA to generate method stubs.

Note that every generated method will have `_ctx: IncomingServerCtx` parameter which will contain transport-level metadata (in our case that metadata would be HTTP headers).

The implementation of this service is bulky, please look at our demo repository for the full code.

It's worth noting that every method in `AuthProtectedServiceImpl` should start by parsing JWT token.
`UserAuthService` is responsible for that, so it's simple:

```scala
  override def confirm2FA(
      _ctx: IncomingServerCtx,
      method: MFAMethodConfirm
  ): F[Confirm2FAOutput, GenericSuccess] = {
    for {
      user <- auth.user(_ctx)
      // we either have valid user object or the code does not progress further
      // ...
    } yield {
      GenericSuccess(None)
    }
  }
```

We need to do the following to make our implementations live:

1) Bind instances of `AuthService` and `AuthProtectedService` to their implementations we wrote
2) Add their dispatchers into a set of *service dispatchers* which is required for Protoforce runtime

The DI plugin for that should look like so:

```scala
import distage._
import distage.plugins._
import zio.IO

object ApiPlugin extends PluginDef {
  private def makeF[F[+_, +_] : TagKK]: ModuleDef = new ModuleDef {
    make[AuthService[IncomingServerCtx, F]].from[AuthServiceImpl[F]]
    make[AuthProtectedService[IncomingServerCtx, F]].from[AuthProtectedServiceImpl[F]]

    many[GeneratedServerBase[F, IncomingServerCtx, Json]]
      .add[AuthServiceServerDispatcher[F, IncomingServerCtx, Json]]
      .add[AuthProtectedServiceServerDispatcher[F, IncomingServerCtx, Json]]

  }

  include(makeF[IO])
}
```

#### JSON Codecs

Protoforce generates comprehensive codecs. These codecs intended to be resolved in compile time thus implemented as typeclasses. Also protoforce generates default implementations utilizing `circe` library.

At the same time, unlike when you use `circe` directly, Protoforce allows you to customize any particular codec in centralized manner.

```scala
trait Codecs
  extends IRTCodecAuthCirce

object Codecs extends Codecs
```

In case you wish to customize any codecs you may override corresponding `Codecs` methods.

Wiring definition for codecs provider should look like:

```scala
object ApiPlugin extends PluginDef {
  // ...
  make[Codecs]
    .fromValue(Codecs)
    .aliased[IRTCodecAuthAbstract[Json]]
}
```

Now you may inject `codecs: Codecs` whereever you need to serialize/deserialize Protoforce models and import codec definitions from `codec` variable:

```scala
class CodecUser(codecs: Codecs) {
  import codecs._
  // codec typeclasses available here
}
```

## Application and wirings

### HTTP Server

This is the most annoying part of our wirings. Protoforce runtime does most of the job for you, though you still need to:

1) Define context extractors for your HTTP server, converting HTTP requests into instances of `IncomingServerCtx`
2) Define and configure an instance of `http4s`' `Server`
3) Turn on optional CORS handlers
4) Provide an event logger implementation

All these things are done in the following DI plugin:

```scala
object HttpServerPlugin extends PluginDef with ConfigModuleDef {
  include(makeHandlersF[IO])
  include(makeApiBindings[IO])
  include(makeProtoforceRuntimeF[IO])

  private def makeHandlersF[F[+_, +_] : IO2 : TagKK]: ModuleDef = new ModuleDef {
    val httpContextExtractor: ContextProvider[IO, Nothing, BlazeHttpRequestContext[Task], IncomingServerCtx] =
      ContextProvider
        .forF[IO]
        .pure((w: BlazeHttpRequestContext[Task]) => IncomingServerCtx(w.exchange.remoteAddr.getOrElse(""), w.headers))

    include(new PfServerBlazeHttpModule[IncomingServerCtx, Nothing](httpContextExtractor))

    make[IRTEventListener[F]].from {
      (bio: IO2[F], logger: IzLogger) =>
        new IRTEventListener[F] {
          override def message(str: String): Unit = {
            logger.info(s"transport message: $str")
          }

          override def onHttpResponse(response: String, code: Int, headers: Map[String, String]): F[Nothing, Unit] = {
            bio.sync(logger.info(s"http response: $code, $headers, $response"))
          }

          override def onWsSend(value: String, isBuzzer: Boolean): F[Nothing, Unit] = {
            bio.sync(logger.info(s"ws send: $value"))
          }

          override def onWsBodyReceived(sbody: String): F[Nothing, Unit] = {
            bio.sync(logger.info(s"ws body: $sbody"))
          }

          override def onHttpBodyReceived(path: String, sbody: String): F[Nothing, Unit] = {
            bio.sync(logger.info(s"http body: $path, $sbody"))
          }
        }
    }
  }

  private def makeApiBindings[F[+_, +_] : IO2 : TagKK]: ModuleDef = new ModuleDef {
    // here we expose our API implementations to Protoforce runtime
    make[RPCServerHandlers[F, IncomingServerCtx, Json]]
      .from { handlers: Set[GeneratedServerBase[F, IncomingServerCtx, Json]] => RPCServerHandlers(handlers.toSeq) }
      .aliased[RPCServerHandlers[F, Nothing, Json]]
  }

  private def makeProtoforceRuntimeF[F[+_, +_] : IO2 : TagKK]: ModuleDef = new ModuleDef {
    // shared Protoforce runtime
    include(new InfraDIModule[F]())
    // Protoforce HTTP client
    include(new PfAHCClientModule())

    // CORS support helpers
    make[CORSBase]

    // Protoforce RPC convention
    make[HttpResponseHeaders[String]].aliased[AbstractHttpResponseHeaders[String]]

    // http4s server initialization
    make[Server].fromResource {
      (h: BlazeHandler@Id("rest"), cors: BlazeCORSHandler, runtime: zio.Runtime[Any], config: HttpConfig) =>
        import org.http4s.implicits._
        import org.http4s.server.Router
        import org.http4s.server.blaze._
        import zio.interop.catz._
        import zio.interop.catz.implicits._

        val serviceRest = HttpRoutes.of[Task](h.handlePartial)

        // here we expose the same APIs under several different prefixes adding permissive CORS configuration
        val app = Router(
          "api/v1" -> cors.withCors(serviceRest),
          "prod/api/v1" -> cors.withCors(serviceRest),
          "dev/api/v1" -> cors.withCors(serviceRest),
        ).orNotFound
        implicit val rt = runtime
        val b = BlazeServerBuilder[Task](ExecutionContext.global)
          .bindHttp(config.port, config.host)
          .withWebSockets(true)
          .withHttpApp(app)

        Lifecycle.fromCats(b.resource)
    }
  }
}
```

A full implementation in our repository also defines Websocket bindings for the same APIs.

This chunk of code may look a bit bulky and cryptic, though we deemed it necessary to keep these things configurable.
Once you start hacking this code you should quickly develop an intuition about it and Scala compiler will always help you to avoid making mistakes.

### Configuration files

`distage` provides useful [Lightbend Config Support Module](https://izumi.7mind.io/distage/distage-framework.html#typesafe-config)

We need to create a file `src/main/resources/authserver-reference.conf` containing HOCON definitions corresponding to our appliction config under `demo` section and HTTP server configuration under `http` section:

```hocon
demo {
  tokens = {
    jwtKey = "2d8g277f72387dy2387fgy246fg3qf"
    expiration = "1 hour"
  }
  facebook {
    appId = ""
  }
  // etc
}

http {
  listen {
    host = "localhost"
    port = 8080
  }
}
```

After that we need to write a simple plugin declaring wirings for our configuration data classes:

```scala
import distage.plugins._
import izumi.distage.config._

object ConfigPlugin extends PluginDef with ConfigModuleDef {
  // first we parse two top-level config sections
  makeConfig[AppConfig]("demo")
  makeConfig[HttpConfig]("http.listen")

  // now make available sub-sections of AppConfig available for injection
  make[GithubConfig].from { c: AppConfig => c.github}
  make[GoogleConfig].from { c: AppConfig => c.google}
  make[TwitterConfig].from { c: AppConfig => c.twitter}
  make[TokensConfig].from { c: AppConfig => c.tokens}
  make[EmailConfig].from { c: AppConfig => c.email}
  make[FacebookConfig].from { c: AppConfig => c.facebook}
  make[SmsConfig].from {c: AppConfig => c.sms}
}
```

Once we have these definitions the application would use `authserver-reference.conf` as configuration defaults and would support config customizations through Java property flags (`-Dproperty=value`) and through other means provided by Lightbend Config and `distage`.


### Application entrypoint

`distage` provides us a useful concept of [Role](https://izumi.7mind.io/distage/distage-framework.html#roles), essentially a Role is an independent entrypoint in an applicaiton and one application may run multiple Roles at the same time.

Our application should have only one Role which is not expected to do anything apart of requiring HTTP server resource and retaining it during application lifetime:

```
import distage._
import izumi.distage.roles.model._
import izumi.functional.bio._
import izumi.fundamentals.platform.cli.model.raw._
import org.http4s.server._

final class AuthServerRole[F[+_, +_] : Async2 : UnsafeRun2](
                                                            server: Server
                                                          ) extends RoleService[F[Throwable, *]] {
  override def start(roleParameters: RawEntrypointParams, freeArgs: Vector[String]): Lifecycle[F[Throwable, *], Unit] = {
    Lifecycle.make(F.unit)(_ => F.unit)
  }
}

object AuthServerRole extends RoleDescriptor {
  val id = "authserver"
}
```

Our role has name "authserver" and we may invoke our application with `:authserver` command line parameter to access it.

Let's also define application launcher which would spawn our role by default and trigger application wiring using all the plugins we implemented before:

```scala
import distage.plugins._
import izumi.distage.roles._
import izumi.fundamentals.platform.cli.model.raw._
import zio.IO

object AuthDemoApp extends RoleAppMain.LauncherBIO2[IO] {
  override protected def requiredRoles(
      argv: RoleAppMain.ArgV
  ): Vector[RawRoleParams] = {
    Vector(RawRoleParams(AuthServerRole.id))
  }

  override protected def pluginConfig: PluginConfig = PluginConfig.const(
    Seq(
      HttpServerPlugin,
      ApiPlugin,
      IntegrationsPlugin,
      ReposPlugin,
      ComponentsPlugin,
      ConfigPlugin,
      ApplicationPlugin
    )
  )
}
```

Now we just need to declare a simple plugin wiring our Role:

```scala
object ApplicationPlugin extends PluginDef with RoleModuleDef {
  private def makeF[F[+_, +_]: IO2: TagKK]: ModuleDef = new ModuleDef {
    makeRole[AuthServerRole[F]]
  }
  include(makeF[IO])
}
```

`AuthDemoApp` has `main` method inherited from its base class and can be launched directly without any arguments.

As you can see we didn't write any single `new` keyword in our codebase and all the hard work of wiring applicaiton components together is done automagically behind the scene.
