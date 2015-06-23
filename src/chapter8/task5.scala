package chapter8

/**
 * task5 <Description>
 *
 * @author vadya
 */
object task5 extends App {
  class Point(val x: Double, val y: Double)
  class LabeledPoint(val label: String, x: Double, y: Double) extends Point(x, y)

  println(new LabeledPoint("Label", 1, 2))
}
