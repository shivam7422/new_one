package spark_R.learning_scala

class person(name:String,age:Int){
  def greet(name:String):Unit=
  {
    println(s"${this.name} says ,Hi $name")
  }

}
object oop extends App{

  val s= new person("john",23)
  s.greet("Daniel")

}
