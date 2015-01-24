name := "sapphire-demo-form"

organization := "com.sfxcode"

version := "0.9.9.6"

scalaVersion := "2.11.5"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalacOptions += "-target:jvm-1.7"

mainClass := Some("com.sfxcode.sapphire.core.demo.form.Application")

resolvers ++= Seq(
  "sfxcode-releases" at "https://raw.github.com/sfxcode/mvn-repo/master/releases",
  "sfxcode-snapshots" at "https://raw.github.com/sfxcode/mvn-repo/master/snapshots",
  "sonatype-snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
)


libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.4.14" % "test"
)

libraryDependencies +=   "com.sfxcode.sapphire" %% "sapphire-control" % "0.9.9.6"

libraryDependencies += "org.json4s" %% "json4s-native" % "3.2.11"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.2"
