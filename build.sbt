
name := "banking-data-engineering"

version := "1.0"

scalaVersion := "2.13.X"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % "4.2.X" % "provided"
)