package lectures.part3fp

import jdk.jfr.internal.instrument.JDKEvents.remove

import scala.collection.convert.ImplicitConversions.`collection asJava`

object TuplesAndMaps extends App {


  //tuples= finite ordered "lists"

  val aTuple = new Tuple2(2, "love you") //Tuple2[INt,String] ==(Int,String)
  print(aTuple._1) //2
  println(aTuple.copy(_2 = "goodbye java"))
  println(aTuple.swap)


  //Maps are lists to associate things with other things

  //Maps - keys->values

  val aMap: Map[String, Int] = Map() //kind list constructing

  val phoneBook = Map(("Jim", 555), ("Daniel" -> 789)).withDefaultValue(-1) //in case element doesn't exist

  println(phoneBook.contains("Jim"))
  println(phoneBook("Mary"))

  val newPair = "Mary" -> 678
  val newPhoneBook = phoneBook + newPair
  println(newPhoneBook)
  println(newPhoneBook("Mary"))
  //Functions on Map
  // map,flatMap,filter

  println(newPhoneBook.map(pair => pair._1.toLowerCase -> pair._2))
  //FilterKeys
  println(newPhoneBook.view.filterKeys(x => x.startsWith("J")).toMap)

  //mapValues
  println(newPhoneBook.view.mapValues(number => number * 10).toMap)
  val newMap = newPhoneBook.view.mapValues(number => "0245-" + number).toMap
  println(newMap)

  //Conversions to other collections
  println(phoneBook.toList)
  println(List(("Raghad", 555)).toMap)
  val names = List("Fresh", "Amna", "Sara", "Safa", "Seham", "Fill")
  println(names.groupBy(name => name.charAt(0)))
  //output---.> HashMap(F -> List(Fresh, Fill), A -> List(Amna), S -> List(Sara, Safa, Seham))

  /*
    1.  What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900
        !!! careful with mapping keys.

        Answer : It
    2.  Overly simplified social network based on maps
        Person = String
        - add a person to the network
        - remove
        - friend (mutual)
        - unfriend
        - number of friends of a person
        - person with most friends
        - how many people have NO friends
        - if there is a social connection between two people (direct or not)
   */

  val test = ("JIM" -> 900)
  val newPhoneBookb = newPhoneBook + test
  println(newPhoneBookb)
  println(newPhoneBookb.map(pair => pair._1.toLowerCase -> pair._2))


  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    network + (person -> Set())
  }

  def friend(network: Map[String, Set[String]], personA: String, personB: String): Map[String, Set[String]] = {
    val friendA = network(personA)
    val friendB = network(personB)
    network + (personA -> (friendA + personB)) + (personB -> (friendB + personA))
  }

  def unfriend(network: Map[String, Set[String]], personA: String, personB: String): Map[String, Set[String]] = {
    val friendA = network(personA)
    val friendB = network(personB)
    network + (personA -> (friendA - personB)) + (personB -> (friendB - personA))

  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {

    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] = {

      if (friends.isEmpty) networkAcc

      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))
    }

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }


  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Mary")
  println(network)
  println(friend(network, "Bob", "Mary"))
  println(unfriend(friend(network, "Bob", "Mary"), "Bob", "Mary"))
  println(remove(friend(network, "Bob", "Mary"), "Bob"))
}
