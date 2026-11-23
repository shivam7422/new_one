package Spark

import org.apache.spark.sql.SparkSession

object Banking_Spark_Scala_Test extends App {

  // Create Spark Session
  val spark = SparkSession.builder()
    .appName("Banking Spark Scala Test")
    .getOrCreate()

  import spark.implicits._

  println("Spark Version: " + spark.version)
println("Scala Version: " + scala.util.Properties.versionNumberString)

  // Sample banking transaction data
  val transactions = Seq(
    (101, "Rahul", "Savings", 50000.0, "CREDIT"),
    (102, "Amit", "Current", 25000.0, "DEBIT"),
    (103, "Priya", "Savings", 75000.0, "CREDIT"),
    (104, "Neha", "Current", 15000.0, "DEBIT"),
    (105, "Raj", "Savings", 100000.0, "CREDIT")
  )

  // Convert Seq into DataFrame
  val transactionDF = transactions.toDF(
    "transaction_id",
    "customer_name",
    "account_type",
    "amount",
    "transaction_type"
  )

  // Display transactions
  println("===== BANKING TRANSACTIONS =====")
  transactionDF.show(false)

  // Count total records
  println("Total records: " + transactionDF.count())

  // Stop Spark Session
  spark.stop()
}
