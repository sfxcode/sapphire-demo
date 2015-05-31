import sbt.Keys._

name := "sapphire-demo-login"

organization := "com.sfxcode"

version := "1.0.0"

scalaVersion := "2.11.6"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalacOptions += "-target:jvm-1.7"

mainClass := Some("com.sfxcode.sapphire.core.demo.login.Application")

resolvers ++= Seq(
  "sfxcode-releases" at "https://raw.github.com/sfxcode/mvn-repo/master/releases",
  "sfxcode-snapshots" at "https://raw.github.com/sfxcode/mvn-repo/master/snapshots",
  "sonatype-snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
)

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.4.16" % "test"
)

libraryDependencies +=   "com.sfxcode.sapphire" %% "sapphire-core" % "1.0.0"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.2"


jfxSettings

JFX.mainClass := Some("com.sfxcode.sapphire.core.demo.login.Application")

JFX.nativeBundles := "dmg"

JFX.vendor := "SFXCode"

JFX.verbose := true




