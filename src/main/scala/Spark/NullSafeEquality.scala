/*object NullSafeEquality extends App
{

  val spark= SparkSession.builder().appName("joins").master("local") .getOrCreate()
  val a= Seq(("A","A"),("A","B"),(null,null),("null","null"),("null","A"),(null,"A"),("","")).toDF("col1","col2")
  val b= a.withColumn("result",when(col("col1").eqNullSafe(col("col2")),"equal").otherWise(lit("Not Equal")))
  b.show(false)

}*/
