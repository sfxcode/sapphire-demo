name := "blueprint"

organization := "com.sfxcode"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.11.6"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalacOptions += "-target:jvm-1.7"

resolvers ++= Seq(
  "sfxcode-releases" at "https://raw.github.com/sfxcode/mvn-repo/master/releases",
  "sfxcode-snapshots" at "https://raw.github.com/sfxcode/mvn-repo/master/snapshots"
)


libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "3.0.1" % "test"
)

libraryDependencies +=   "com.sfxcode.sapphire" %% "sapphire-extension" % "0.3.2"



