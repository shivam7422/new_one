package Spark

import org.apache.spark.sql.SparkSession

object read_file_from_abfss extends App {

     val spark = SparkSession.builder()
    .appName("Banking Spark Scala Test")
    .getOrCreate()

      val containerName = args(0)
       val fileName = args(1)

    val rawCustomerPath = s"abfss://$containerName@stbanking2011.dfs.core.windows.net/$fileName.csv"
    val customerDF = spark.read
    .option("header", "true")
    .option("inferSchema", "true")
  .csv(rawCustomerPath)
  
  customerDF.printSchema()
  println(customerDF.count().toInt)

}
