package lectures.part2oob

import Playground.{PrinceCharming, Princess => Cinderella}

import java.sql
import java.util.Date
import java.sql.{Date=>sqlDate}

object PackagingAndImports extends App {

  //package members are accessible by their simple name
  val writer = new Writer("Raghad","RockScala",2022)

  // import packages , I can import class and trait not object
  val princess = new Cinderella

  // Universal methods ---> package object
  sayHello
  println(speedOfTime)

  // More on imports
  val prince = new PrinceCharming

  // 1. use Fully Qualified names
  val d = new Date()// by default it will use the first import
  val sqlDate= new sql.Date(2022,6,15)
  //2. use aliasing


}
