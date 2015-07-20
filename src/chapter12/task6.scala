package chapter12

/**
 * task6 <Description>
 *
 * @author vadya
 */
object task6 extends App {
  def largestAt(f: Int => Int, inputs: Seq[Int]) = inputs.zip(inputs.map(f)).maxBy(_._2)._1

  println(largestAt(x => 10 * x - x * x, 1 to 10))
}
