package chapter13

/**
 * task5 <Description>
 *
 * @author vadya
 */
object task5 extends App {
  def mkString(arr: TraversableOnce[String], sep: String) = arr.reduceLeft((acc, el) => acc + sep + el.toString)

  println(mkString(Array("1", "2", "3"), ", "))
}
