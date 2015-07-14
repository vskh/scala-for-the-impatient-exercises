package chapter10

import java.awt.Point

import scala.util.Sorting.quickSort

/**
 * task2 <Description>
 *
 * @author vadya
 */
object task2 extends App {

  val points = Array(new OrderedPoint(1, 2), new OrderedPoint(2, 3), new OrderedPoint(1, 4))

  quickSort(points)
  println("Points: " + points.mkString(", "))

  class OrderedPoint(x: Int = 0, y: Int = 0) extends Point(x, y) with Ordered[OrderedPoint] {

    override def compare(that: OrderedPoint): Int =
      if (x < that.x)
        -1
      else if (x == that.x) {
        if (y < that.y)
          -1
        else if (y == that.y)
          0
        else
          1
      } else
        1

    override def toString = s"OrderedPoint($x, $y)"
  }
}
