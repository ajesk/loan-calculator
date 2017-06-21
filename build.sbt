name := "loan-calculator"

version := "1.0"

scalaVersion := "2.12.1"

// Testing packages
libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-xml" % "2.11.0-M4" % "test",
  "junit" % "junit" % "4.12" % Test,
  "com.novocode" % "junit-interface" % "0.11" % "test"
)