package lectures.part3fp

import java.time.ZoneOffset
import scala.util.Random

object Options extends App{

  val myFirstOption:Option[Int]= Some(4)
  val noOption:Option[Int]=None


  //unsafe APIs
  def unsafeMethod():String=null

  val result = Some(unsafeMethod()) //WRONG! it takes the whole point out of using SOME

  //INSTEAD
  val resultCorrect=Option(unsafeMethod())

 //Chained methods and How you should work with unsafe APIs
def backupMethod():String="A valid result"

val chainedResult=Option(unsafeMethod()).orElse(Option(backupMethod()))

  // DESIGN unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A valid result")
  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()

  // Functions on options

  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // UNSAFE trying to access a null point DONT USE IT

  // map,flatMap,filter
println(myFirstOption.map(_*2))
println(myFirstOption.filter(x=>x>10))
println(myFirstOption.flatMap(x=>Option(x,x*10)))

// for-comprehension
/*
   Exercise.
  */
val config: Map[String, String] = Map(
  // fetched from elsewhere
  "host" -> "176.45.36.1",
  "port" -> "80"
)
  class Connection {
    def connect = "Connected" // connect to some server
  }
    object Connection {
      val random = new Random(System.nanoTime())

      def apply(host: String, port: String): Option[Connection] =
        if (random.nextBoolean()) Some(new Connection)
        else None
    }

    val host =config.get("host")
    val port =config.get("port")

  // try to establish a connection, if so - print the connect method

  /*
    if (h != null)
      if (p != null)
        return Connection.apply(h, p)
    return null
   */
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
  /*
    if (c != null)
      return c.connect
    return null
   */
  val connectionStatus = connection.map(c => c.connect)
  // if (connectionStatus == null) println(None) else print (Some(connectionstatus.get))
  println(connectionStatus)
  /*
    if (status != null)
      println(status)
   */
  connectionStatus.foreach(println)

  // chained calls --> what you get in practice
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port))
      .map(connection => connection.connect))
    .foreach(println)







}
