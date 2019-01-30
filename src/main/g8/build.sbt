name := "$name$"

organization := "$organization$"

version := "0.1-SNAPSHOT"

autoScalaLibrary := false

crossPaths := false

// see: https://stackoverflow.com/questions/28174243/run-junit-tests-with-sbt
// see: https://github.com/sbt/junit-interface
libraryDependencies ++= Seq(
	"com.google.guava" % "guava" % "27.0.1-jre",
	"com.novocode" % "junit-interface" % "0.11" % Test exclude("junit", "junit-dep"),
	"junit" % "junit" % "4.12" % Test,
	"org.assertj" % "assertj-core" % "3.11.1" % Test
)

javacOptions ++= Seq("-source", "1.7")

packageOptions in(Compile, packageBin) +=
  Package.ManifestAttributes(new java.util.jar.Attributes.Name("Automatic-Module-Name") -> "com.dongjinlee.$name$")

// enable plugins: sbt-pack

enablePlugins(PackPlugin)

// sbt-pack configurations

packMain := Map("app" -> "$organization$.$name$.App")
