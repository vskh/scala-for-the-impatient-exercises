package chapter14

/**
 * task2 <Description>
 *
 * @author vadya
 */
object task2 extends App {
  def swap(p: (Int, Int)): (Int, Int) = p match {
    case (l, r) => (r, l)
  }

  print(swap((1, 2)))
}
