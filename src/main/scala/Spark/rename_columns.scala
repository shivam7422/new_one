package Spark

import Spark.reporting_sec2.spark
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object rename_columns extends App{
  val spark= SparkSession.builder().appName("renaming columns").master("local").enableHiveSupport().getOrCreate()
  val a=spark.sql("select * from default.testing_sec2 ")
  a.show()
  val b= a
    .withColumnRenamed("state","state_new")
    .withColumnRenamed("empid","empid_new")
    .withColumnRenamed("deptid","deptid_new")
    .select(concat_ws(" ",col("fname"),col("lname")).as("fullname")
      ,col("state_new"),col("empid_new"),col("deptid_new"))
  b.show()

}
