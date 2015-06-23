package chapter8

/**
 * task7 <Description>
 *
 * @author vadya
 */
object task7 extends App {
  class Square(width: Int = 0, val corner: (Int, Int) = (0, 0)) extends java.awt.Rectangle(corner._1, corner._2, width, width)

  println(new Square())
  println(new Square(10))
  println(new Square(20, (1, 1)))
}
