name := "$context$_core"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.4"

exportJars := true

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases")
  )

libraryDependencies ++= Seq(
  "ch.qos.logback"               % "logback-classic"             % "1.1.2",
  "org.scalacheck"               %% "scalacheck"                 % "1.11.6" % "test",
  "org.scalatest"                % "scalatest_2.11"              % "2.2.1" % "test",
  "com.typesafe.akka"            %% "akka-contrib"               % "2.3.8",
  "com.typesafe.akka"            %% "akka-testkit"               % "2.3.8",
  "com.typesafe.akka"            %% "akka-persistence-experimental" % "2.3.8"
  )
