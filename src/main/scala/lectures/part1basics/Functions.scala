package lectures.part1basics

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
}
