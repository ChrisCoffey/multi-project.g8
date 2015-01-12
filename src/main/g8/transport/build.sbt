name := "$context$_transport"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.4"

scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-encoding", "utf8")

exportJars := true

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases")
  )

libraryDependencies ++= Seq(
  "io.spray"                     %% "spray-json"                 % "1.3.1",
  "io.spray"                     %% "spray-can"                  % "1.3.2",
  "io.spray"                     %% "spray-routing"              % "1.3.2",
  "org.xerial.snappy"            %  "snappy-java"                % "1.1.1.6",
  "net.jpountz.lz4"              %  "lz4"                        % "1.3.0",
  "com.github.nscala-time"       %% "nscala-time"                % "1.6.0"
  )
