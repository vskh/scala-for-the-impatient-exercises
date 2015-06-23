package chapter8

/**
 * task6 <Description>
 *
 * @author vadya
 */
object task6 extends App {
  abstract class Shape {
    def centerPoint: (Double, Double)
  }

  class Circle(val center: (Double, Double), val radius: Double) extends Shape {
    override def centerPoint: (Double, Double) = center
  }

  class Rectangle(val left: Double, val top: Double, val width: Double, val height: Double) extends Shape {
    override def centerPoint: (Double, Double) = (left + width / 2, top - height / 2)
  }

  val s1 = new Circle((0, 0), 1.0)
  val s2 = new Rectangle(-10, 10, 20, 20)

  println("Circle center: " + s1.centerPoint)
  println("Rect center: " + s2.centerPoint)
}
