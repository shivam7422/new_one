package spark_R.learning_scala

object Recursion extends App {

  def factorial (n:Int):Int=
  {
    if(n==0) 1
    else n* factorial(n-1)
  }
  println("The factorial is "+ factorial(3))



    def reuHelper(x:Int,ax:BigInt=1):BigInt=
    {
      if(x<=1) ax
      else reuHelper(x-1,x* ax)
    }
  println(reuHelper(20000))




}
