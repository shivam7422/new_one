package Spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

case class du( c1:String,c2:String,c3:String,c4:String)

object fixedfile extends App{

  val spark= SparkSession.builder().appName("Fixed File").master("local").getOrCreate()
  import spark.implicits._
  val a= spark.sparkContext.textFile("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\file.txt")
    .map(e => (e.substring(0,5).trim()
      ,e.substring(5,10).trim()
      ,e.substring(10,15).trim()
      ,e.substring(15,20).trim()))
    .map({case(e1,e2,e3,e4) => du(e1.toString,e2.toString,e3.toString,e4.toString)}).toDF
  a.printSchema()
  a.show()

}
