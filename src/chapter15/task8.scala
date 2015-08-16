package chapter15

import scala.collection.immutable.HashSet

/**
 * task8 <Description>
 *
 * @author vadya
 */
object task8 extends App {
//  def allDifferent[@specialized T](s: T *) = {
//    s.size == HashSet(s: _*).size
//  }

  // see specializations using '-print' argument for scalac
  // or
  // javap
  def allDifferent[@specialized(Int, Double) T](v1: T, v2: T) = {
    v1 != v2
  }
  
//  println("1, 2, 3: " + allDifferent(1, 2, 3))
//  println("1, 2, 3, 4, 4: " + allDifferent(1, 2, 3, 4, 4))
  println("1, 1: " + allDifferent(1, 1))
  println("1, 2: " + allDifferent(1, 2))
}
