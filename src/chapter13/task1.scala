package chapter13

import scala.collection.mutable._

/**
 * task1 <Description>
 *
 * @author vadya
 */
object task1 extends App {
  def indexes(str: String) = {
    val result = Map[Char, Set[Int]]()
    for ((c, i) <- str.zipWithIndex) {
      result.get(c) match {
        case None => result(c) = SortedSet() // ensuring sorted set
        case _ =>
      }

      result(c) += i
    }

    result
  }

  println(indexes("Mississippi"))
}
