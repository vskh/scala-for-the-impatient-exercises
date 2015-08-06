package chapter14

/**
 * task9 <Description>
 *
 * @author vadya
 */
object task9 extends App {
  def listSum(l: List[Option[Int]]): Int = l.map(_.getOrElse(0)).sum

  println("ListSum: " + listSum(List(None, None, Some(1), Some(3), None, Some(2))))
}
