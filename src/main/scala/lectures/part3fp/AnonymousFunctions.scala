package lectures.part3fp

object AnonymousFunctions extends App{

  //anonymus functions (LAMBDA)
  val doubler: Int=>Int = (x:Int) => x*2


  //Multiple params in a lambda
  val adder: (Int,Int)=>Int =(x:Int,y:Int)=> x + y //because we have multiple parameters we need to put them between paranthese


// No parameter

  val justDoSomething = ()=> 3

  println(justDoSomething) // Function itself
  println(justDoSomething()) //call


  //Curly braces with lamdas
  val stringToInt : String=>Int = { x=> x.toInt }


  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a,b) => a + b

}
