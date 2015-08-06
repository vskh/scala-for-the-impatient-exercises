package chapter14

import scala.reflect.ClassTag

/**
 * task3 <Description>
 *
 * @author vadya
 */
object task3 extends App {
  def swap[T: ClassTag](arr: Array[T]): Array[T] = arr match {
    case Array(l, r, rest@_*) => Array(r, l) ++ rest
    case _ => arr
  }

  println(swap(Array(1)).mkString(", "))
  println(swap(Array(1, 2)).mkString(", "))
  println(swap(Array(1, 2, 3)).mkString(", "))
}
