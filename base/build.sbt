name := "sapphire-demo-base"

organization := "com.sfxcode"

version := "0.8.0"

scalaVersion := "2.10.3"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalacOptions += "-target:jvm-1.7"

mainClass := Some("com.sfxcode.sapphire.core.demo.base.Application")

resolvers ++= Seq(
  "sfxcode-releases" at "https://github.com/sfxcode/mvn-repo/raw/master/releases",
  "sfxcode-snapshots" at "https://github.com/sfxcode/mvn-repo/raw/master/snapshots"
)

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.3.7" % "test"
)

libraryDependencies +=   "com.sfxcode.sapphire" %% "sapphire-core" % "0.8.1"
