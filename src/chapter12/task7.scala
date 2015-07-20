package chapter12

/**
 * task7 <Description>
 *
 * @author vadya
 */
object task7 extends App {
  val pairs = (1 to 10) zip (11 to 20)

  def adjustToPair(f: (Int, Int) => Int)(p: (Int, Int)) = f(p._1, p._2)

  println(pairs.map(adjustToPair(_ + _)))
}
