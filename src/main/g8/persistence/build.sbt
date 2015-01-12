name := "$context$_persistence"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.4"

exportJars := true

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases")
//  "krasserm at bintray" at "http://dl.bintray.com/krasserm/maven",
//  "jdgoldie at bintray" at "http://dl.bintray.com/jdgoldie/maven",
//  "amateras-repo" at "http://amateras.sourceforge.jp/mvn/"
  )

libraryDependencies ++= Seq(
  "ch.qos.logback"               % "logback-classic"             % "1.1.2",
  "org.scalacheck"               %% "scalacheck"                 % "1.11.6" % "test",
  "org.scalatest"                % "scalatest_2.11"              % "2.2.1" % "test",
 // "com.github.krasserm"          %% "akka-persistence-kafka"     % "0.4-SNAPSHOT",
  "mysql"                        %  "mysql-connector-java"       % "5.1.34",
  "mysql"                        %  "mysql-connector-java"       % "5.1.34",
  "org.jooq"                     % "jooq-scala"                  % "3.5.0"
)
