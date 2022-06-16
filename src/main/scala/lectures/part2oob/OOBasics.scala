package lectures.part2oob

object OOBasics extends App {


  val person = new Person("Raghad", 30) // class Instantiations : reserve the actual memory data structure that the class defined
  //println (person.age)
  val testWriter = new Writer("Tony", "Robbins", 1970)
  println(testWriter.fullName)
  val testBook = new Book("Awaken the giant within", 2000, testWriter)
  println(testBook.authorAge)
  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print
}

//constructor
class Person(name: String, val age: Int) {
  //body
  val x = 2
  println(1 + 3)

  def greet(name: String): Unit = println(s" ${this.name} says: Hi $name")

  //overloading
  def great(): Unit = print(s"Hi I'm an overloaded method that calls only class parameter name $name")

  //multiple constructores #TODO Review
  def this(name: String) = this(name, 0)

  def this() = this("RB") // it only took the constructed one I think .....
} // every single constructed piece of this class must have those class parameters
// organizes  data and behaviours which is code
//Class parameters are not fields

//EXERCISES

class Writer(firtName: String, surName: String, var year: Int) {
  def fullName(): String = {
    firtName + " " + surName
  }
}

class Book(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge = yearOfRelease - author.year

  def isWrittenBY(author: Writer) = author == this.author

  def copy(newYear: Int): Book = new Book(this.name, newYear, this.author)
}

class Counter(val numberToCount: Int = 0) {
  //def currentCount() = numberToCount
  def inc: Counter = {
    new Counter(numberToCount + 1)
  }

  def dec: Counter = {
    new Counter(numberToCount - 1)
  } // immutability

  def inc(offset: Int): Counter = {
    new Counter(this.numberToCount + offset)
  }

  def dec(offset: Int): Counter = {
    new Counter((this.numberToCount) - offset)
  }

  def print = println(numberToCount)
}

/*  Another way to implement it
class Counter(val count: Int = 0) {
  def inc = {
    println("incrementing")
    new Counter(count + 1)  // immutability
  }

  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n-1)
  }

  def dec(n: Int): Counter =
    if (n <= 0) this
    else dec.dec(n-1)

  def print = println(count)
}
 */