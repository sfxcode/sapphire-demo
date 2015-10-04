import sbt.Keys._

name := "sapphire-demo-login"

organization := "com.sfxcode"

version := "1.0.0"

scalaVersion := "2.11.7"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalacOptions += "-target:jvm-1.7"

mainClass := Some("com.sfxcode.sapphire.core.demo.login.Application")

libraryDependencies += "org.specs2" %% "specs2-core" % "3.6.4" % "test"

libraryDependencies += "com.sfxcode.sapphire" %% "sapphire-core" % "1.0.2"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.3"


jfxSettings

JFX.mainClass := Some("com.sfxcode.sapphire.core.demo.login.Application")

JFX.nativeBundles := "dmg"

JFX.vendor := "SFXCode"

JFX.verbose := true




