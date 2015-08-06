package chapter14

import math.sqrt

/**
 * task10 <Description>
 *
 * @author vadya
 */
object task10 extends App {
  type func = (Double) => Option[Double]
  def compose(f: func, g: func): func = {
    (x: Double) => for (i <- g(x); j <- f(i)) yield j
  }

  def f(x: Double) = if (x >= 0) Some(sqrt(x)) else None
  def g(x: Double) = if (x != 1) Some(1 / (x - 1)) else None
  val h = compose(f, g)

  println(h(2))
  println(h(1))
  println(h(0))
}
