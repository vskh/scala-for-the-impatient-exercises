package chapter13

/**
 * task6 <Description>
 *
 * @author vadya
 */
object task6 extends App {
  val lst = Array(1, 2, 3, 4, 5, 7)
  println((lst :\ List[Int]())(_ :: _)) // foldLeft, converts sequence to list
  println((List[Int]() /: lst)(_ :+ _)) // foldRight, same
  println((List[Int]() /: lst)((l, e) => e :: l)) // reverse the list
}
