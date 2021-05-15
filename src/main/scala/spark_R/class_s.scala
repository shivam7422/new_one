package spark_R

class emp1(id:Int,name:String)
{
  def func(): Unit =
  {
    println(f" the first name is $id")
    println(f" the first name is $name")
  }
}

class emp2()
{
  def func1(): Unit =
  {
    val s= "printing press"
    val e= "printing paper"
    println(s + " "+ e)
  }
}
class emp3()
{
  def func2 (a:String): String=
  {
    return a + " "+ "paper"

  }
  def func3(a:Int):String={
    return a +" "+ "Glass"
  }
}

object class_s extends App {

  val ob=new emp1(1,"shivam")
  ob.func()
  val ob1= new emp2
  ob1.func1()
  val ob2 = new emp3
  println(ob2.func2("printing"))
  println(ob2.func3(5))

}
