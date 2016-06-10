name := "scala-markdown"

version := "0.3"

scalaVersion := "2.11.8"

scalacOptions ++= Seq( "-deprecation", "-feature", "-language:postfixOps", "-language:implicitConversions", "-language:existentials" )

incOptions := incOptions.value.withNameHashing( true )

organization := "ca.hyperreal"

//resolvers += Resolver.sonatypeRepo( "snapshots" )

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Hyperreal Repository" at "http://hyperreal.ca/maven2"

libraryDependencies ++= Seq(
	"org.scalatest" %% "scalatest" % "2.2.6" % "test",
	"org.scalacheck" %% "scalacheck" % "1.12.5" % "test"
)

libraryDependencies ++= Seq(
	"org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4",
	"org.scala-lang.modules" %% "scala-xml" % "1.0.5"
	)

mainClass in (Compile, run) := Some( "ca.hyperreal.__markdown__.TestMain" )

mainClass in assembly := Some( "ca.hyperreal.markdown.MarkdownParserTest" )

assemblyJarName in assembly := name.value + "-" + version.value + ".jar"


publishMavenStyle := true

//publishTo := Some( Resolver.sftp( "private", "hyperreal.ca", "/var/www/hyperreal.ca/maven2" ) )

//{
//  val nexus = "https://oss.sonatype.org/"
//  if (isSnapshot.value)
//    Some("snapshots" at nexus + "content/repositories/snapshots")
//  else
//    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
//}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

licenses := Seq("MIT" -> url("http://opensource.org/licenses/MIT"))

homepage := Some(url("https://github.com/edadma/markdown"))

pomExtra := (
  <scm>
    <url>git@github.com:edadma/markdown.git</url>
    <connection>scm:git:git@github.com:edadma/markdown.git</connection>
  </scm>
  <developers>
    <developer>
      <id>edadma</id>
      <name>Edward A. Maxedon, Sr.</name>
      <url>http://hyperreal.ca</url>
    </developer>
  </developers>)
