package Spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.expressions._

object collectlist extends App{
  val spark= SparkSession.builder().appName("lead and lag").master("local").getOrCreate()
  import spark.implicits._
  val a= Seq(("1","shivam"),
    ("2","Sourish"),
    ("3",""),
    ("4","")).toDF("id","name")
   a.show()

  a.createOrReplaceTempView("table")
  val b= spark.sql("select id, (case when name ='' then NULL  else name end) as name from table  ")
   b.show()
   val c= b.agg(collect_set("name").as("collectset"))
   c.show(false)

}
