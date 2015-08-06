package chapter14

/**
 * task5 <Description>
 *
 * @author vadya
 */
object task5 extends App {
  def leafSum(l: List[Any]): Int = {
    l match {
      case h :: t =>
        (h match {
          case l: List[Int] => l.sum
          case l: List[Any] => leafSum(l)
          case n: Int => n
        }) +leafSum(t)
      case Nil => 0
    }
  }

  println("Sum of leaves: " + leafSum(List(List(3, 8), 2, List(5))))
}
