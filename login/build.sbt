import sbt.Keys._

name := "sapphire-demo-login"

organization := "com.sfxcode"

version := "1.3.0"

scalaVersion := "2.12.4"

mainClass := Some("com.sfxcode.sapphire.core.demo.issues.Application")

libraryDependencies +=   "com.sfxcode.sapphire" %% "sapphire-core" % "1.3.0"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"


