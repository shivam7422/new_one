package Spark

import org.apache.spark.sql.functions._
import org.apache.spark.sql.SparkSession

object atos extends App{


  val spark= SparkSession.builder().appName("CSV_reader").getOrCreate()
  val a= spark.sparkContext.textFile("s3n://files7422/atos.txt")
 // a.foreach(println)
  val b= a.flatMap(x=>x.split(" "))
  val c= b.groupBy(w=>w)
  val d= c.map(t=>(t._1,t._2.size))
  //d.foreach(println)

  import spark.implicits._
  val e= d.toDF("name","count")
  //e.printSchema()
 // e.show(100,false)
 //e.createOrReplaceTempView("temp_table")
 // val f= spark.sql("select * from temp_table order by count desc limit 5")
  //val g= f.drop("count").show()

 val df2= e.orderBy(desc("count")).limit(5)
  df2.write.mode("overwrite").save("s3n://mypythonfile7422/output3")
  println("==================================")
  spark.read.load("s3n://mypythonfile7422/output3").show()


}
