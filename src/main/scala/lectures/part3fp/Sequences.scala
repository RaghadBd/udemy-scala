package lectures.part3fp

import java.time.{ZoneOffset, ZonedDateTime}
import scala.+:

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



}