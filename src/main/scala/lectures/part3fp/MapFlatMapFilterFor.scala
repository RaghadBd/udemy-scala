package lectures.part3fp

object MapFlatMapFilterFor extends App{
val list=List(1,2,3)
  print(list)
   //map
  println(list.map(_+1))
  println(list.map(_+" is a number"))
  //filter
  println(list.filter(_ %2==0))
  //flatmap
  val toPair=(x:Int)=>List(x,x+1)
  println(list.flatMap(x=>List(x,x+1)))

  val endTime = java.time.ZonedDateTime.now

  val startTime = endTime.minusDays(4)

  println(endTime," ",startTime)
  val duration= java.time.Duration.between(startTime,endTime)
  println(duration)
  val numDays = java.time.Duration.between(startTime,endTime).toDays.toInt
  println(numDays)
  val day = (0 to numDays)
println(day )
  val dayFilter = (0 to numDays).map(i => startTime.plusDays(i)).map(d => f"(year='${d.getYear}%04d' AND month='${d.getMonthValue}%02d' AND day='${d.getDayOfMonth}%02d') ").mkString(" OR ")
println(dayFilter)

  val numbers=List(1,2,3,4)
  val chars=List('a','b','c','d')
  val colors = List("black","white")
 // val comb=(x,y)=>x.foreach(x+y)
 val c1=chars.flatMap (chars => numbers.map(n=>""+chars+n))
    println(c1.flatMap(c1=>colors.map(co=>""+co+c1)).length)
  val combinations = numbers.filter(_ % 2 == 0).flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))
  println(combinations.length)

  //foreach
  val forCombination=for{
    n<-numbers if n %2==0
    c<-chars
    color<-colors
  } yield ""+c+n+"-"+color
  println(forCombination)

  //1.MyList supports for comprehensions

}
