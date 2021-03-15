name := "guide-auth-system"

organization in ThisBuild := "io.protoforce.guide"

version in ThisBuild := "1.0.0-SNAPSHOT"

homepage in ThisBuild := Some(url("https://www.protoforce.io/ProtoForce/post/extensive-guide-to-authentication-authorization-system-design-d96f5d7bc6674c7a8b1cca4f6b93c164"))

licenses in ThisBuild ++= Seq(
  "MIT" -> url("https://opensource.org/licenses/MIT")
)

resolvers in ThisBuild += Opts.resolver.sonatypeSnapshots

logBuffered in Test := false

scalaVersion in ThisBuild := "2.13.3"

crossScalaVersions in ThisBuild := Seq(
  "2.13.3"
)

updateOptions in ThisBuild := updateOptions.value.withLatestSnapshots(false)

scalacOptions in ThisBuild ++= Seq(
  "-encoding",
  "UTF-8",
  "-language:higherKinds",
  "-feature",
  "-unchecked",
  "-deprecation"
)

libraryDependencies in ThisBuild ++= Seq(
   ("io.protoforce" %% "idealingua-runtime-rpc-scala" % "0.0.3-SNAPSHOT") ,
   ("org.scalatest" %% "scalatest" % "3.2.3" % "test") 
)

lazy val `io-protoforce-guide-auth-api` = (project in file("io-protoforce-guide-auth-api"))

lazy val `bundle-api` = (project in file("bundle-api"))
    .dependsOn(
      `io-protoforce-guide-auth-api`
    )

lazy val `api` = (project in file("."))
    .aggregate(
      `io-protoforce-guide-auth-api`,
      `bundle-api`
    )