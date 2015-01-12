name := "$context$_biz"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.4"

exportJars := true

libraryDependencies ++= Seq(
  "ch.qos.logback"               % "logback-classic"             % "1.1.2",
  "org.scalacheck" %% "scalacheck" % "1.11.6" % "test"
  )
