package spark_R.learning_scala

object named_default extends  App{

  def stringops(first_name:String="rat",last_name:String,age:Int):Unit=
  {
    println(first_name)
    println(last_name)
    println(age)
  }
  stringops(last_name="Tiwari",age=24)

}
