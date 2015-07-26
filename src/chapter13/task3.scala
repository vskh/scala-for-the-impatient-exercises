package chapter13

/**
 * task3 <Description>
 *
 * @author vadya
 */
object task3 extends App {
  def removeZeros(list: List[Int]) = list.filter(_ != 0)

  println(removeZeros(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 1)))
}
