package lectures.part3fp

object WhatsAFunction extends App {

  //use functions as first class elements
  //problem : oop -> everything is coming from class

  //How OOP works everything is instance of a class
  //  class Action{
  //    def execute(element:Int):String=???
  //  }
  // at most we can do this actions in class
  // trait Action[A,B]{
  //def execute(element:A):B }
  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }


  // We  have something called function types Function2[A,B,R] === (A,B)=>R
  //ALL SCALA FUNCTIONS ARE OBJECTS

  /*
    1.  a function which takes 2 strings and concatenates them
    2.  transform the MyPredicate and MyTransformer into function types
    3.  define a function which takes an int and returns another function which takes an int and returns an int
        - what's the type of this function
        - how to do it
   */

  //1-
  val concatenator: ((String, String) => String) = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }
  println(concatenator("love ", "you"))

  //3-
  val nestedFunction = new Function1[Int, Function1[Int, Int]] {
    override def apply(v1: Int) = new Function1[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }

val adder3=nestedFunction(3)
  print(nestedFunction(3)(4)) //ver weird --> Curried function called with multiple parameter list takes some kinfof param and return another function

}

  trait MyFunction [A,B]{
    def apply(element:A):B
  }

