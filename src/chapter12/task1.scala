package chapter12

/**
 * task1 <Description>
 *
 * @author vadya
 */
object task1 extends App {
  def values(f: Int => Int, low: Int, high: Int): Seq[(Int, Int)] = (low to high).zip((low to high) map f)

  println(values(x => x * x, 0, 10))

}
