package Spark

import org.apache.spark.sql.SparkSession

object read_file_from_abfss extends App {

     val spark = SparkSession.builder()
    .appName("Banking Spark Scala Test")
    .getOrCreate()

    val rawCustomerPath = "abfss://raw@stbanking2011.dfs.core.windows.net/customer.csv"
    val customerDF = spark.read
    .option("header", "true")
    .option("inferSchema", "true")
  .csv(rawCustomerPath)
  
  customerDF.printSchema()
  customerDF.count().toInt

}
