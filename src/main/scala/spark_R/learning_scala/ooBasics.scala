package spark_R.learning_scala

//constructor

//class parameters are not fields. if we need to access those variables, we need to use val,var
class amus(name:String , val age1:Int)
{
  def greet(name:String): Unit =
  {
    println(s"$name says :-> Hi ${this.name}")
    println(s"${this.name} says :-> Hi ${name}")
  }
}
class novel(name:String,yol: Int, author:writer)
{
  def authorage=yol-author.year
  def iswrittenby(author:writer)= author==this.author

}

class writer(first_name :String,sur_name :String,val year:Int)
{
  def full_name: String =
  {
    first_name + " " + sur_name
   // println(s)
  }

}
object ooBasics extends App{

  val p= new amus("Daniel",3)
  println(p.age1)
  p.greet("shivam")
  val e= new writer("Daniel","Keen",23)
  println(e.full_name)

}

