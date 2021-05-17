package Spark

import org.apache.spark.sql.SparkSession

object union_question extends App{
  val spark= SparkSession.builder().appName("CSV_reader").master("local").getOrCreate()
  import spark.implicits._
  val a= Seq(("abc","3","C",100),
  ("abc","3","C",100),
  ("xyz","4","C",500),
  ("abc","3","D",150),
  ("xyz","4","D",200),
  ("xyz","4","D",200)).toDF("cust","acct","type","amt")
  a.printSchema()
  a.show()
  val b= Seq(("a","3","C"),
    ("b","3","C",100),
    ("c","4","C",500),
    ("d","3","D",150),
    ("e","4","D",200),
    ("f","4","D",200)).toDF("cust","acct","type","amt")
  val c= a.union(b)
  c.printSchema()
  c.show()

}
