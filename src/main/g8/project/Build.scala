import sbt._
import Keys._

import com.typesafe.sbt.SbtScalariform._
import scalariform.formatter.preferences._
import sbtunidoc.Plugin._

object $name;format="Camel"$Build extends Build {

addCommandAlias("rebuild", ";clean; compile; package")

//////////////////////////////////////////////////////////////////////////////
// PROJECTS
//////////////////////////////////////////////////////////////////////////////
	lazy val $context$ = Project(id = "$context$",
                              base = file("."),
                              settings = commonSettings) aggregate(
                                persistence,
                              	core,
                                biz,
                              	protocol,
                              	transport)

	lazy val persistence = Project(id = "$context$-persistence",
                              	settings = commonSettings,
                                 base = file("persistence")) dependsOn (protocol)

	lazy val core = Project(id = "$context$-core",
                              	settings = commonSettings,
                                 base = file("core")) dependsOn (
                                   persistence,
                                   biz,
                                   protocol)

	lazy val biz = Project(id = "$context$-midgard",
                              	settings = commonSettings,
                                 base = file("biz")) dependsOn (protocol)
  
	lazy val protocol = Project(id = "$context$-protocol",
                              	settings = commonSettings,
                                 base = file("protocol"))
  
	lazy val transport = Project(id = "$context$-transport",
                              	settings = commonSettings,
                                 base = file("transport")) dependsOn(protocol)
  
//////////////////////////////////////////////////////////////////////////////
// PROJECT INFO
//////////////////////////////////////////////////////////////////////////////

  val ORGANIZATION    = "$package$"
  val PROJECT_NAME    = "$name;format="normalize"$"
  val PROJECT_VERSION = "0.1-SNAPSHOT"
  val SCALA_VERSION   = "2.11.4"


//////////////////////////////////////////////////////////////////////////////
// DEPENDENCY VERSIONS
//////////////////////////////////////////////////////////////////////////////

  val TYPESAFE_CONFIG_VERSION = "1.2.1"
  val SCALATEST_VERSION       = "2.2.2"
  val SLF4J_VERSION           = "1.7.9"
  val LOGBACK_VERSION         = "1.1.2"


//////////////////////////////////////////////////////////////////////////////
// SHARED SETTINGS
//////////////////////////////////////////////////////////////////////////////

  lazy val commonSettings = Project.defaultSettings ++
                            basicSettings ++
                            formatSettings ++
                            net.virtualvoid.sbt.graph.Plugin.graphSettings

  lazy val basicSettings = Seq(
    version := PROJECT_VERSION,
    organization := ORGANIZATION,
    scalaVersion := SCALA_VERSION,

    libraryDependencies ++= Seq(
      "com.typesafe"     % "config"          % TYPESAFE_CONFIG_VERSION,
      "org.slf4j"        % "slf4j-api"       % SLF4J_VERSION,
      "ch.qos.logback"   % "logback-classic" % LOGBACK_VERSION % "runtime",
      "org.scalatest"   %% "scalatest"       % SCALATEST_VERSION % "test",
    ),

    scalacOptions in Compile ++= Seq(
      "-unchecked",
      "-deprecation",
      "-feature"
    ),

    javaOptions += "-Djava.library.path=%s:%s".format(
      sys.props("java.library.path")
    ),

    fork in run := true,

    fork in Test := true,

    parallelExecution in Test := false
  )

  lazy val formatSettings = scalariformSettings ++ Seq(
    ScalariformKeys.preferences := FormattingPreferences()
      .setPreference(IndentWithTabs, false)
      .setPreference(IndentSpaces, 2)
      .setPreference(AlignParameters, false)
      .setPreference(DoubleIndentClassDeclaration, true)
      .setPreference(MultilineScaladocCommentsStartOnFirstLine, false)
      .setPreference(PlaceScaladocAsterisksBeneathSecondAsterisk, true)
      .setPreference(PreserveDanglingCloseParenthesis, true)
      .setPreference(CompactControlReadability, true)
      .setPreference(AlignSingleLineCaseStatements, true)
      .setPreference(PreserveSpaceBeforeArguments, true)
      .setPreference(SpaceBeforeColon, false)
      .setPreference(SpaceInsideBrackets, false)
      .setPreference(SpaceInsideParentheses, false)
      .setPreference(SpacesWithinPatternBinders, true)
      .setPreference(FormatXml, true)
  )


  
//credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

}
