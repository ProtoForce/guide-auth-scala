name := "guide-auth-system"

organization in ThisBuild := "io.protoforce.guide"

version in ThisBuild := "1.0.0-SNAPSHOT"

homepage in ThisBuild := Some(url("https://www.protoforce.io/ProtoForce/post/extensive-guide-to-authentication-authorization-system-design-d96f5d7bc6674c7a8b1cca4f6b93c164"))

licenses in ThisBuild ++= Seq(
  "MIT" -> url("https://opensource.org/licenses/MIT")
)

resolvers in ThisBuild += Opts.resolver.sonatypeSnapshots

logBuffered in Test := false

scalaVersion in ThisBuild := "2.13.5"

crossScalaVersions in ThisBuild := Seq(
  "2.13.5"
)

updateOptions in ThisBuild := updateOptions.value.withLatestSnapshots(false)

scalacOptions in ThisBuild ++= Seq(
  "-encoding",
  "UTF-8",
  "-language:higherKinds",
  "-feature",
  "-unchecked",
  "-deprecation",
  "-Xsource:2.13"
)

libraryDependencies in ThisBuild ++= Seq(
   ("io.7mind.izumi" %% "fundamentals-platform" % "1.0.5") ,
   ("io.7mind.izumi" %% "fundamentals-bio" % "1.0.5") ,
   ("io.7mind.izumi" %% "fundamentals-collections" % "1.0.5") ,
   ("io.7mind.izumi" %% "fundamentals-functional" % "1.0.5") ,
   ("io.7mind.izumi" %% "fundamentals-json-circe" % "1.0.5") ,
   ("io.7mind.izumi" %% "distage-extension-logstage" % "1.0.5") ,
   ("io.7mind.izumi" %% "distage-framework" % "1.0.5") ,
   ( "org.scala-lang.modules" %% "scala-collection-compat" % "2.4.3") ,
   ( "dev.zio" %% "zio" % "1.0.3") ,
   ( "dev.zio" %%  "zio-interop-cats" % "2.2.0.1") ,
   ( "org.http4s" %% "http4s-blaze-server" % "1.0.0-M8") ,
   ( "org.asynchttpclient" %  "async-http-client" % "2.12.2") ,
   ( compilerPlugin("org.typelevel" % "kind-projector" % "0.11.3" cross CrossVersion.full) ) ,
   ("org.scalatest" %% "scalatest" % "3.2.3" % Test) 
)

scalacOptions in ThisBuild ++= {if (scalaVersion.value.startsWith("2.12")) {
      Seq(
        "-Xsource:2.13",
        "-Ypartial-unification",
      )
} else {
  Seq.empty
}}

lazy val `io-protoforce-guide-auth-api` = (project in file("io-protoforce-guide-auth-api"))
    .dependsOn(
      `io-protoforce-irt-api`
    )

lazy val `bundle-api` = (project in file("bundle-api"))
    .dependsOn(
      `io-protoforce-guide-auth-api`,
      `io-protoforce-irt-api`
    )

lazy val `api` = (project in file("."))
    .dependsOn(
      `io-protoforce-irt-api`
    )
    .aggregate(
      `io-protoforce-guide-auth-api`,
      `bundle-api`
    )

lazy val `io-protoforce-irt-api` = (project in file("io-protoforce-irt-api"))