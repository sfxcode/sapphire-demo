name := "sapphire-demo-login"

organization := "com.sfxcode"

version := "0.8.6"

scalaVersion := "2.11.0"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalacOptions += "-target:jvm-1.7"

mainClass := Some("com.sfxcode.sapphire.core.demo.login.Application")

addCompilerPlugin("org.scalamacros" % "paradise" % "2.0.0" cross CrossVersion.full)

resolvers ++= Seq(
  "sfxcode-releases" at "https://raw.github.com/sfxcode/mvn-repo/master/releases",
  "sfxcode-snapshots" at "https://raw.github.com/sfxcode/mvn-repo/master/snapshots"
)

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.3.11" % "test"
)

libraryDependencies += "com.sfxcode.sapphire" %% "sapphire-core" % "0.8.6"

libraryDependencies += "org.scalafx" % "scalafxml-core_2.10" % "0.1" intransitive()

libraryDependencies += "com.sfxcode.scalafxml" %% "scalafxml-core-macros" % "0.2.0" intransitive()
