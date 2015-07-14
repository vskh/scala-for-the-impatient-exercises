package chapter10

/**
 * task1 <Description>
 *
 * @author vadya
 */
object task1 extends App {

  import java.awt.Rectangle

  val r = new Rectangle(0, 0, 5, 10)

  r.translate(2, 3)

  println(r)

  r.grow(1, 1)

  println(r)

  import java.awt.geom.Ellipse2D

  val e = new Ellipse2D.Double(0, 0, 5, 10)

  println(e)

  val er = new Ellipse2D.Double(0, 0, 5, 10) with RectangleLike

  er.translate(2, 3)
  er.grow(1, 2)

  println(er)

  trait RectangleLike {

    def getX(): Double
    def getY(): Double
    def getWidth(): Double
    def getHeight(): Double

    def setFrame(x: Double, y: Double, w: Double, h: Double)

    def translate(dx: Double, dy: Double): Unit = {
      setFrame(getX() + dx, getY() + dy, getWidth(), getHeight())
    }

    def grow(h: Double, w: Double): Unit = {
      setFrame(getX() - h, getY() - w, getHeight() + 2 * h, getWidth() + 2 * w)
    }

    override def toString = s"RectangleLike($getX, $getY, $getWidth, $getHeight)"
  }

}
