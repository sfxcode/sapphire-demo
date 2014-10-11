name := "sapphire-demo-login"

organization := "com.sfxcode"

version := "0.9.6"

scalaVersion := "2.11.2"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalacOptions += "-target:jvm-1.7"

mainClass := Some("com.sfxcode.sapphire.core.demo.login.Application")

resolvers ++= Seq(
  "sfxcode-releases" at "https://raw.github.com/sfxcode/mvn-repo/master/releases",
  "sfxcode-snapshots" at "https://raw.github.com/sfxcode/mvn-repo/master/snapshots"
)

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.3.12" % "test"
)

libraryDependencies +=   "com.sfxcode.sapphire" %% "sapphire-core" % "0.9.6"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.0.13"

unmanagedJars in Compile += Attributed.blank(file(System.getenv("JAVA_HOME") + "/jre/lib/ext/jfxrt.jar"))


