package Spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{when, _}

object prblm_stmt extends App{

  val spark=SparkSession.builder().appName("problem statement").master("local") .getOrCreate()
  import spark.implicits._

  val a= Seq(("x","a"),("x","b"),("y","c")).toDF("dept","emp")
  //a.show()
  val b =a.select("dept").groupBy("dept").count()
//  b.show()
  val c= a.join(b,a("dept") === b("dept"),"inner").drop(b("dept"))
    .withColumnRenamed("count","DeptHeadCount")
    .select (col("dept"),col("emp"),col("DeptHeadCount"))
  c.show()

  val z= a.withColumn("DeptHeadCount",
    when (col("dept")==="x",a.where("dept = 'x'").groupBy("dept").count().select(col("count").cast("string"))
      .head.getString(0))
      when (col("dept")==="y",a.where("dept = 'y'").groupBy("dept").count().select(col("count").cast("string"))
      .head.getString(0)))
  z.show()

  val f= z.withColumn("ass",c("col"))


}
