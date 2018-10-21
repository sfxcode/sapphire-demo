import sbt.Keys._

name := "sapphire-demo-login"

organization := "com.sfxcode"

version := "1.4.1"

scalaVersion := "2.12.7"

mainClass := Some("com.sfxcode.sapphire.core.demo.issues.Application")

libraryDependencies +=   "com.sfxcode.sapphire" %% "sapphire-core" % "1.4.1"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"


