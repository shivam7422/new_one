name := "new_one"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.5"
libraryDependencies += "com.databricks" %% "spark-xml" % "0.9.0"
libraryDependencies += "org.apache.spark" %% "spark-hive" % "2.4.5"
libraryDependencies += "org.apache.hadoop" % "hadoop-aws" % "2.6.0"
libraryDependencies += "com.amazonaws" % "aws-java-sdk" % "1.7.4"
libraryDependencies += "io.delta" %% "delta-core" % "0.8.0"
libraryDependencies += "org.apache.spark" %% "spark-catalyst" % "2.4.0"

