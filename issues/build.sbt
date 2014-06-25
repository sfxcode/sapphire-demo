name := "sapphire-demo-issues"

organization := "com.sfxcode"

version := "0.9.1"

scalaVersion := "2.11.1"

javacOptions ++= Seq("-source", "1.7", "-target", "1.7")

scalacOptions += "-target:jvm-1.7"

mainClass := Some("com.sfxcode.sapphire.core.demo.issues.Application")

addCompilerPlugin("org.scalamacros" % "paradise" % "2.0.0" cross CrossVersion.full)

resolvers ++= Seq(
  "sfxcode-releases" at "https://raw.github.com/sfxcode/mvn-repo/master/releases",
  "sfxcode-snapshots" at "https://raw.github.com/sfxcode/mvn-repo/master/snapshots"
)

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.3.12" % "test"
)


libraryDependencies += "com.sfxcode.sapphire" %% "sapphire-control" % "0.9.1"

libraryDependencies += "org.scalafx" % "scalafxml-core_2.10" % "0.2" intransitive()

libraryDependencies += "com.sfxcode.scalafxml" %% "scalafxml-core-macros" % "0.3.0" intransitive()
