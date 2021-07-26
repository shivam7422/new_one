package Spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.catalyst.dsl.plans._

import java.sql._
import java.util.Properties
import org.apache.spark.sql.functions._
import io.delta._
import io.delta.tables.DeltaTable
import org.apache.commons.io.FileUtils

import java.io.File


//case class Customer(customerid: Int, address: String, loc :String)
object hive_update extends App{

  val spark=SparkSession.builder().appName("wc_DF").master("local")
    .config("spark.sql.extensions", "io.delta.sql.DeltaSparkSessionExtension")
    .config("spark.sql.catalog.spark_catalog", "org.apache.spark.sql.delta.catalog.DeltaCatalog")

    .getOrCreate()
 /* import spark.implicits._
  val a= Seq((1,"shivam","kadipur"),(4,"Deep","Basti")).toDF("id","name","loc")
  //a.show()
  a.createOrReplaceTempView("temp_table1")
  val b=Seq((1,"shivam","Lucknow")).toDF("id","name","loc")
  b.createOrReplaceTempView("temp_table2")
  // creating table
  spark.sql("use default")
  spark.sql("create table if not exists default.master(id int,name string,loc string)")
  spark.sql("create table if not exists default.dummy(id int,name string,loc string)")

  // inserting records
  spark.sql("insert overwrite table default.master select * from temp_table1")
  spark.sql("insert overwrite table default.dummy select * from temp_table2")
  spark.sql("use default")
  val asa= spark.sql(""" MERGE INTO default.master a USING default.dummy b" +
    " ON a.id= b.id WHEN MATCHED THEN" +
    "UPDATE SET a.id=b.id,a.name=b.name,c.loc=b.loc"+
  "WHEN NOT MATCHED THEN " +
    "INSERT (a.id,a.name,a.loc) VALUES(b.id,a.name,a.loc)""")
  asa.show()


  /*Seq(
    Customer(1,"shivam","kadipur"),
    Customer(4,"Deep","Basti")

  ).toDF().write.format("delta").mode("overwrite").saveAsTable("temp_table1")
  (table("temp_table1"))
  val b=Seq((1,"shivam","Lucknow")).toDF("id","name","loc")
  b.createOrReplaceTempView("temp_table2")
  (table("temp_table2"))

  /*val updatedDF = a.as("main")
    .join(b.as("delta"), $"main.id" === $"delta.id", "outer")
    .select(a.columns.map(c => coalesce($"delta.$c", $"main.$c") as c): _*)
  updatedDF.show()*/
*/
*/
  /*val spark = SparkSession
    .builder()
    .appName("Utilities")
    .master("local[*]")
    .config("spark.sql.extensions", "io.delta.sql.DeltaSparkSessionExtension")
    .config("spark.sql.catalog.spark_catalog", "org.apache.spark.sql.delta.catalog.DeltaCatalog")
    // control the parallelism for vacuum
    .config("spark.sql.sources.parallelPartitionDiscovery.parallelism", "4")
    .getOrCreate()

  // Create a table
  println("Create a parquet table")
  val data = spark.range(0, 5)
  val file = new File("/tmp/parquet-table")
  val path = file.getAbsolutePath
  data.write.format("parquet").save(path)

  // Convert to delta
  println("Convert to Delta")
  DeltaTable.convertToDelta(spark, s"parquet.`$path`")

  // Read table as delta
  var df = spark.read.format("delta").load(path)

  // Read old version of data using time travel
  df = spark.read.format("delta").option("versionAsOf", 0).load(path)
  df.show()

  val deltaTable = DeltaTable.forPath(path)

  // Utility commands
  println("Vacuum the table")
  deltaTable.vacuum()

  println("Describe History for the table")
  deltaTable.history().show()

  // Generate manifest
  println("Generate Manifest files")
  deltaTable.generate("SYMLINK_FORMAT_MANIFEST")

  // SQL utility commands
  println("SQL Vacuum")
  spark.sql(s"VACUUM '$path' RETAIN 169 HOURS")

  println("SQL Describe History")
  println(spark.sql(s"DESCRIBE HISTORY '$path'").collect())

  // Cleanup
  FileUtils.deleteDirectory(new File(path))
  spark.stop()
  */
  val data = spark.range(0, 5)
  data.write.format("delta").save("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\res_par1\\temp.parquet\\")
}
