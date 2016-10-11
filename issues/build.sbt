name := "sapphire-demo-issues"

organization := "com.sfxcode"

version := "1.1.7"

scalaVersion := "2.11.8"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalacOptions += "-target:jvm-1.7"

mainClass := Some("com.sfxcode.sapphire.core.demo.issues.Application")

libraryDependencies +=   "com.sfxcode.sapphire" %% "sapphire-core" % "1.1.7"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.7"
