name := "sapphire-demo-issues"

organization := "com.sfxcode"

version := "0.8.2"

scalaVersion := "2.11.0"

javacOptions ++= Seq("-source", "1.7", "-target", "1.7")

scalacOptions += "-target:jvm-1.7"

mainClass := Some("com.sfxcode.sapphire.core.demo.issues.Application")

resolvers ++= Seq(
  "sfxcode-releases" at "https://raw.github.com/sfxcode/mvn-repo/master/releases",
  "sfxcode-snapshots" at "https://raw.github.com/sfxcode/mvn-repo/master/snapshots"
)


libraryDependencies +=   "com.sfxcode.sapphire" %% "sapphire-core" % "0.8.2"
