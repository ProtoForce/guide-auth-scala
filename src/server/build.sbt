lazy val `generated-api` = ProjectRef(file("../generated"), "bundle-api")

val V = new {
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

val D = new {
  val cats = Seq(
    libraryDependencies += "org.typelevel" %% "cats-effect" % V.`cats-effect`
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
  val protoforce = Seq(
    // libraryDependencies += "io.protoforce" %% "protoforce-runtime-rpc-scala-server-blaze" % V.protoforce,
    // libraryDependencies += "io.protoforce" %% "protoforce-runtime-rpc-scala-client-asynchttp" % V.protoforce,
    libraryDependencies += "org.jboss.xnio" % "xnio-nio" % V.`xnio-nio`
  )
  val zio = Seq(
    libraryDependencies += "dev.zio" %% "zio-interop-cats" % V.`zio-interop-cats`
  )
  val jwt = Seq(
    libraryDependencies += "com.github.jwt-scala" %% "jwt-circe" % V.`jwt-circe`
  )
  val totp = Seq(
    libraryDependencies += "dev.samstevens.totp" % "totp" % V.totp
  )
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
  "-Ybackend-parallelism",
  math.min(16, math.max(1, sys.runtime.availableProcessors() - 1)).toString,
  "-explaintypes",
  "-Ycache-plugin-class-loader:always",
  "-Ycache-macro-class-loader:last-modified",
  "-Xlint:_,-eta-sam,-multiarg-infix,-byname-implicit",
  "-Wdead-code",
  "-Wextra-implicit",
  "-Wnumeric-widen",
  "-Woctal-literal",
  "-Wunused:_",
  "-Wvalue-discard",
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

lazy val `auth-app` = (project in file("auth-app"))
  .dependsOn(`generated-api`)
  .settings(D.izumi: _*)
  .settings(D.cats: _*)
  .settings(D.zio: _*)
  .settings(D.protoforce: _*)
  .settings(D.jwt: _*)
  .settings(D.totp: _*)

val `guide-auth-server-demo` = (project in file("."))
  .aggregate(`auth-app`)
