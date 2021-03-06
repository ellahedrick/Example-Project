lazy val root = (project in file("."))
  .settings(
    name                := "MonopolyDeal",
    scalaVersion        := "2.12.3",
    version             := "0.0.1",
    libraryDependencies ++= Seq(
	"org.scalatest" %% "scalatest" % "3.0.5" % "test",
	"org.scala-lang.modules" %% "scala-swing" % "2.0.0-M2"
    )
  )
