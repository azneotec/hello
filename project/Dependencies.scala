import sbt._

object Dependencies {

  lazy val akkaVersion = "2.5.26"
  lazy val akkaHttpVersion = "10.1.11"

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
  lazy val akkaStream = "com.typesafe.akka" %% "akka-stream" % akkaVersion
  lazy val akkaHttp = "com.typesafe.akka" %% "akka-http" % akkaHttpVersion
  lazy val akkaHttpSprayJson = "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion
}
