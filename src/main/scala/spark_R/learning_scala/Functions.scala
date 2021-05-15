package spark_R.learning_scala

object Functions extends App{

  def aFunction(a:String,b:Int):String=
  {
    a +" "+ b
  }
  println(aFunction("Hello",3))

  def repeatedFunction(a:String, b:Int):String=
  {
    if(b==1) a
    else a +" "+ repeatedFunction(a,b-1)
  }

  println(repeatedFunction("Hello",3))

  def greeting (name:String,age:Int):String=
  {
     s"My name is $name and I am $age years old"
  }
  println(greeting("shyam",14))

  def prime(n:Int):Boolean= {

  n%2==0
  }

  println(prime(5))
  def factorial(n:Int):Int=
  {

    if(n==0) 1
    else n*factorial(n-1 )

  }
  println(factorial(3))

  def fibonacci (n:Int):Int=
  {
    if(n<=2) 1
    else fibonacci(n-1)+ fibonacci(n-2)
  }
  println(fibonacci(3))
}
