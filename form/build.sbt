name := "sapphire-demo-form"

organization := "com.sfxcode"

version := "0.8.2"

scalaVersion := "2.11.0"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalacOptions += "-target:jvm-1.7"

mainClass := Some("com.sfxcode.sapphire.core.demo.form.Application")

resolvers ++= Seq(
  "sfxcode-releases" at "https://raw.github.com/sfxcode/mvn-repo/master/releases",
  "sfxcode-snapshots" at "https://raw.github.com/sfxcode/mvn-repo/master/snapshots"
)


libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.3.7" % "test"
)

libraryDependencies +=   "com.sfxcode.sapphire" %% "sapphire-core" % "0.8.2"
