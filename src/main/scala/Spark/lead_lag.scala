package Spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

object lead_lag extends App{

  val spark= SparkSession.builder().appName("lead and lag").master("local").getOrCreate()
import spark.implicits._
  val a= Seq(("A","1","6","UP"),
  ("A","5","8","DOWN"),
    ("A","8","10","UP"),
  ("B","1","5","UP"),
  ("B","7","10","DOWN"),
  ("C","1","10","DOWN")).toDF("server","start","end","status")
  //a.printSchema()
  //a.show()
  //lead function
  val window= Window.partitionBy("server").orderBy("server")
  val s= lead(col("start"),1,0).over(window)
  val b=a.withColumn("desc",s)
  //b.show()
  val c= b.where("desc !=0")
   // c.show()
  val d= c.select (col("server"),col("status"),col("end"),col("status")
    ,(col("desc")-col("end")).as("new_data")).where ("new_data != 0.0")
  //d.show()

  // lag function

 // a.show()

  val g= Window.partitionBy("server").orderBy("server")
  val h= lag(col("end"),1,0).over(g)
  val i= a.withColumn("lag",h).where("lag !=0")
  val j= i.select (col("server"),col("status"),col("end"),col("status")
    ,(col("start")-col("lag")).as("new_data")).where ("new_data != 0.0")
  j.show()
}
