name := "learn-fp"

version := "0.1"

scalaVersion := "2.12.7"

val catsVersion = "1.4.0"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.4"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test"
libraryDependencies += "org.typelevel" %% "cats-core" % catsVersion


scalacOptions ++= Seq("-language:_")