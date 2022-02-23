package lectures.part2oob
//import scala.concurrent.duration.Duration
import scala.language.postfixOps
import java.time.{Duration, ZonedDateTime}

object MethodNotations extends App {
  class Person(val name: String, favoriteMovie: String,val age:Int=0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    //def +(nickName:String):String = s"${this.name} ( $nickName )" wrong my solution
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)
    def unary_+ : Person=new Person(name, favoriteMovie, age+1)
    def unary_! : String = s"$name, what the heck?!"
    def isAlive : Boolean = true
    def apply():String=s"Hi, my name is $name and I like $favoriteMovie"
    def learns(language:String): String = s"$name, learn $language"
    def learnsScala=this.learns("scala")
    def apply(count:Int):String=s"${this.name} watched ${this.favoriteMovie} $count times"
  }

  val mary = new Person("Mary", "Inception")
  print(mary.likes("Inception"))
  print(mary likes "Inceptions") //equivalent
  // infix notation = operator notation (syntactic sugar)

  // Operator

  println(1+2)
  println(1.+(2)) // same but u call the method
   val x = -1 //unary operator are methods
   val y= 1.unary_-
  // unary_ only works with - _ ~ !

  val tom = new Person("Tom","fight club")
  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive) // only available with the scala.language.postfixOps import - discouraged
  println(mary())
  println(("Bonjour".sorted).apply(3))

  /*
    1.  Overload the + operator
        mary + "the rockstar" => new person "Mary (the rockstar)"
    2.  Add an age to the Person class
        Add a unary + operator => new person with the age + 1
        +mary => mary with the age incrementer
    3.  Add a "learns" method in the Person class => "Mary learns Scala"
        Add a learnsScala method, calls learns method with "Scala".
        Use it in postfix notation.
    4.  Overload the apply method
        mary.apply(2) => "Mary watched Inception 2 times"
   */

//1:
  println((mary+"the Rockstar").apply())
 //2:
  println((+mary).age)
  //3:
  println(mary learnsScala)
  //4:
 println(mary(10))
}
