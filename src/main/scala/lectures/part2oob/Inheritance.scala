package lectures.part2oob

/**
 * Raghad
 */
object Inheritance extends App {
  //single class inheritance in which you extend one class at a time
  class Animal {
    val creatureType = "wild"

    def eat: Unit = println("nomno")
  }


  // protected can only be used within the methods within the sub class but not outside
  //cat is subclass and Animal is super class
  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }

  }

  val cat = new Cat
  cat.crunch
  cat.eat


  // Constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  //overriding
  class Dog(override val creatureType: String) extends Animal {
    // override val creatureType: String = "domestic"
    override def eat: Unit = {
      super.eat
      println("crunch,crunch")
    }

  }

  val dog = new Dog("k9s")
  dog.eat
  println(dog.creatureType)

  //Polymorphism
  val unknownAnimal: Animal = new Dog("k9s")
  unknownAnimal.eat

  //overRiding vs overLOADING

  //super it will print the content od eat in the super class

  //preventing override
  //1- final on member : it will prevent method override
  //2-  final on the class : you won't be able to extend on it

}
