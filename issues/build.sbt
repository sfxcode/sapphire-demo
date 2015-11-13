name := "sapphire-demo-issues"

organization := "com.sfxcode"

version := "1.0.7"

scalaVersion := "2.11.7"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalacOptions += "-target:jvm-1.7"

mainClass := Some("com.sfxcode.sapphire.core.demo.issues.Application")

addCompilerPlugin("org.scalamacros" % "paradise" % "2.0.1" cross CrossVersion.full)

libraryDependencies += "org.specs2" %% "specs2-core" % "3.6.5" % "test"

libraryDependencies +=   "com.sfxcode.sapphire" %% "sapphire-core" % "1.0.7"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.3"
