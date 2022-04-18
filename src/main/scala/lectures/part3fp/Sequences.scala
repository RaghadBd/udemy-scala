package lectures.part3fp

import java.time.{ZoneOffset, ZonedDateTime}
import scala.+:
import scala.util.Random

object Sequences extends App {

  val aSequence = Seq(1, 2, 3, 4)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5, 6, 7))

  //Ranges --> also Seq
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  (1 to 10).foreach(println)

  val latentAppStartScanningTime=ZonedDateTime.now(ZoneOffset.UTC)
  val hours = (0 until 3).map(i => latentAppStartScanningTime.plusHours(i))
println("hours",hours)

  //Doesn't make any sense example
//  val t:ZonedDateTime=null
//  val hoursWithFor = (0 until 3).foreach(i =>  t.toString++latentAppStartScanningTime.plusHours(i))
//println("hoursWithFor",t)

  //Lists

  val aList=List(1,2,3)
  println(42+:aList) // :: prepending
  println(aList:+45) // appending

  println(aList.mkString("-|-"))

  //Arrays
val numbers = Array(1,2,3,4)
  val threeElements=Array.ofDim[Int](3)
  threeElements.foreach(println)

// mutation
numbers(2)=0 //syntax sugar for numbers.update(2,0)

val numberSeq:Seq[Int]=numbers
 println(numberSeq)

val vectors:Vector[Int]=Vector(1,2,3)
println(vectors)



///////// Perf test list vs vector

val maxRuns=1000
val maxCapacity=10000
def getWriteTime(collection:Seq[Int]): Double ={
  val r = new Random
  val times = for {
    it <- 1 to maxRuns
  } yield {
    val currentTime=System.nanoTime()
    collection.updated(r.nextInt(maxCapacity),r.nextInt)
    System.nanoTime()-currentTime
  }
  times.sum*1.0/maxRuns
}
  val numberList=(1 to maxCapacity).toList
  val numberVector=(1 to maxCapacity).toVector

  //  + saves refrence to the tails ,
  // - update element in the end is effcienct but update element in the middle is not
  println(getWriteTime(numberList))

  // + depth of the tree is small
  // - needs to replace an entire 32 element chunk
  println(getWriteTime(numberVector))
}