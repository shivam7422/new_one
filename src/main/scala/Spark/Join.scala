package Spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{when, col,lit}

object Join extends App {

  val spark= SparkSession.builder().appName("joins").master("local")
    //.config("spark.sql.join.preferSortMergeJoin", "true")
    .getOrCreate()
  val a= spark.read.option("inferschema","true").option("header","true").csv("src\\main\\resources\\customers.csv")
 // a.show()
  val b= spark.read.option("inferschema","true").option("header","true").csv("src\\main\\resources\\sales.csv")
    .withColumnRenamed("customerId","salesid")
 // b.show()
  println("inner join")

 val c= a
  .join(b,a("customerId")===b("salesid"),"left").sort(a("customerId").asc).where("customerId =1")
   val f=a
   .join(b,a("customerId")===b("salesid"),"left").sort(a("customerId").asc).where("customerId =2")

  val g= c.union(f).union(a).dropDuplicates()
  g.printSchema()
  g.show(false)


  //println("left join")
  //a.join(b,a("customerId")===b("customerId"),"left").sort(a("customerId").asc).show()

  //c.explain()
  /*val d= c.withColumn("customer_name"
    ,when(col("customerName")==="John","Janani")
    .when(col("customerName")==="jon","Sita")
  )*/

 //d.show()



}
