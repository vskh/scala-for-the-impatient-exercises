package chapter12

/**
 * task5 <Description>
 *
 * @author vadya
 */
object task5 extends App {
  def largest(f: Int => Int, inputs: Seq[Int]) = inputs.map(f).max

  println(largest(x => 10 * x - x * x, 1 to 10))
}
