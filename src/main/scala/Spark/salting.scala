package Spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{when, col,lit}

object salting extends App {

  val spark= SparkSession.builder().appName("joins").master("local")
    .getOrCreate()
  
  val saltBuckets= 5
  val txnDf= Seq(("A",100),("A",200),("A",300),("A",400),("B",100),("C",100)).toDF("customer_id","amount")
  val customerDf= Seq(("A","John"),("B","Mike"),("C","Michel")).toDF("customer_id","customer_name")

  val txnSalted = txnDf.withColumn("salt",floor(rand()* saltBuckets))
  .withColumn("id",concat_ws("_",col("customer_id",col("salt"))))
  .drop("salt")
  val txnCustomer= customerDf.withColumn("salt",explode(Sequence(lit(0),lit(saltBuckets-1))))
  .withColumn("id",concat_ws("_",col("customer_id",col("salt"))))
  .drop("salt")

  val joinedDf = txnSalted.join(txnCustomer,Seq("id")).dropDuplicates()
  joinedDf.show(false)
  
}
