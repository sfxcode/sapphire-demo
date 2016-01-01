name := "tutorial"

organization := "com.sfxcode"

version := "1.1.0"

scalaVersion := "2.11.7"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalacOptions += "-target:jvm-1.7"

resolvers += JCenterRepository


libraryDependencies += "org.specs2" %% "specs2-core" % "3.6.6" % "test"

libraryDependencies += "com.sfxcode.sapphire" %% "sapphire-core" % "1.1.0"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.3"




