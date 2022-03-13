package lectures.part2oob

object AbstractDataTypes {
  def main(args: Array[String]): Unit = {

    //abstract --> don't supply values
    //abstract classes can't be instantiated and object creations are impossible because
    // the values and methods in it are not implemented
    abstract class Animal {
      val creatureType: String

      def eat: Unit

    }

    class Dog extends Animal {
      override val creatureType: String = "Canine"

       def eat: Unit = println("crunch crunch")
    }


    trait Carnivore {
      def eat(animal: Animal): Unit
    }

    class Crocodile extends Animal with Carnivore{
      val creatureType: String ="croc"

       def eat: Unit = print("nomnomnom")

       def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")

    }

    val dog = new Dog
    val croc = new Crocodile
    croc.eat(dog)
  }

  // traits vs abstract classes
  // 1 - traits do not have constructor parameters
  // 2 - multiple traits may be inherited by the same class
  // 3 - traits = behavior, abstract class = "thing"
}
