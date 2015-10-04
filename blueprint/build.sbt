name := "blueprint"

organization := "com.sfxcode"

version := "1.0.2"

scalaVersion := "2.11.7"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalacOptions += "-target:jvm-1.7"

libraryDependencies += "org.specs2" %% "specs2-core" % "3.6.4" % "test"

libraryDependencies +=   "com.sfxcode.sapphire" %% "sapphire-core" % "1.0.2"



