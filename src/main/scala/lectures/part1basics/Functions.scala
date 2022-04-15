package lectures.part1basics

import scala.sys.exit

object Functions extends App {

  def aFunction(a:String,b:Int):String={
    a + " " + b
  }

  def aParameterslessFunction():Int=42
  println(aParameterslessFunction())
  println(aParameterslessFunction)

  def aRepeatedFunction(aString:String,n:Int):String ={
    if (n==1) aString
    else aString+aRepeatedFunction(aString,n-1)
  }
  println(aRepeatedFunction("you are doing great! ",3))

  def aFunWithSideEffects(aString:String):Unit={ //we need those when we don't care about the computation
println(aString)
  }
  def aBigFunction(n:Int):Int={
    def aSmallerFunction(a:Int,b:Int):Int=a+b
    aSmallerFunction(n,n-1) //return expression auxilieries
  }
  /*
    Exercises:
    1.  A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
    2.  Factorial function 1 * 2 * 3 * .. * n
    3.  A Fibonacci function
        f(1) = 1
        f(2) = 1
        f(n) = f(n - 1) + f(n - 2)
    4.  Tests if a number is prime.
   */
 def greetings(name:String,age:Int):Unit={
   println(s"Hi my name is $name and I am $age years old.")
 }

  def factorial(n:Int):Int={
    if (n>0) n*factorial(n-1)
    else 1
  }

  println(factorial(3))
}
