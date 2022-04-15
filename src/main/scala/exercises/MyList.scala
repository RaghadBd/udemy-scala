package exercises

import scala.{+:, ::}

abstract class MyList(list: List[Int]) extends App {
  /*
      head = first element of  the  list,int
      tail = remainder of the list,
      isEmpty = is this list empty,boolean
      add(int) => new list with this element added
      toString => a string representation of the list
    */

abstract class PartsOfList{
  def head(myList: MyList):Int
  def tail(myList: MyList):MyList
  }
trait EditMyList{
  def add(myList: MyList,toAdd:Int):MyList // this instance will return a new instance whenever we modify it because it is immutable
  def toString(myList: MyList):String
}
trait CheckMyList{
 def isEmpty(myList: MyList):Boolean
}

  object MyList extends PartsOfList with EditMyList with CheckMyList {
    override def head(myList: MyList): Int = head(myList)

  //  override def tail(myList: MyList): Int = tail(myList)

  //  override def add(myList: MyList, toAdd: Int): List[Int] = MyList+:toAdd

    override def toString(myList: MyList): String = toString(myList)

    override def isEmpty(myList: MyList): Boolean = isEmpty(myList)

    override def tail(myList: MyList): MyList = ???

    override def add(myList: MyList, toAdd: Int): MyList = ???
  }


}
