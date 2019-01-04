name := "$name$"

organization := "$organization$"

version := "0.1-SNAPSHOT"

autoScalaLibrary := false

crossPaths := false

libraryDependencies ++= Seq(
	"com.google.guava" % "guava" % "25.1-jre",
	"com.novocode" % "junit-interface" % "0.11" % "test"
)

javacOptions ++= Seq("-source", "1.7")

packageOptions in(Compile, packageBin) +=
  Package.ManifestAttributes(new java.util.jar.Attributes.Name("Automatic-Module-Name") -> "com.dongjinlee.$name$")

// enable plugins: sbt-pack

enablePlugins(PackPlugin)

// sbt-pack configurations

packMain := Map("app" -> "$organization$.$name$.App")
