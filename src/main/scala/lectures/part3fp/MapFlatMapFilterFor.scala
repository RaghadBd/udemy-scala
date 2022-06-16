package lectures.part3fp

object MapFlatMapFilterFor extends App{
val list=List(1,2,3) //calling list method in the list companion object
  print(list)


  //map => build a new collection
  println(list.map(_+1))
  println(list.map(_+" is a number"))

  //filter
  println(list.filter(_ %2==0))

  //flatmap
  val toPair=(x:Int)=>List(x,x+1)
  println(list.flatMap(toPair))
  println(list.flatMap(x=>List(x,x+1)))

  // print all combinations between two lists
  val numbers = List("t1","t2")
  val chars = List("twamp","flowmeter","slm")
  val colors = List(1,2,3,4,5,6,7)

  // List("a1", "a2"... "d4")
  val c1=chars.flatMap (chars => numbers.map(n=>""+chars+n)) // flatmap in the first because for each element in numbers I'll produce a list
  // and the second is map because I'll return the composed of
println("my combination is ",c1)

  val c2=numbers.flatMap (n=> chars.flatMap(c=>c+n.toString))

  println("my flatMap combination is ",c2)

// Iterations
val c3=numbers.flatMap(n=>chars.flatMap(c=>colors.map(co=> ""+n+c+co)))

  println("my flatMap combination is ",c3)


  //foreach
  val forCombination=for{
    n<-numbers // equivalent to val c3=numbers.filter(_%2==0).flatMap(n=>chars.flatMap(c=>colors.map(co=> ""+n+c+co)))
    c<-chars
    color<-colors
  } yield println(n+"-"+c+"-"+color )
  println(forCombination)

list.map{
  x=> x*2
}
  //1.MyList supports for comprehensions

}
