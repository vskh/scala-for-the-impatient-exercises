package chapter13

/**
 * task7 <Description>
 *
 * @author vadya
 */
object task7 extends App {
  val arr1 = Array("one", "two", "three", "four", "five", "six", "seven")
  val arr2 = Array(1, 2, 3, 4, 5, 6, 7)

  println(arr1 zip arr2 mkString ", ")

  println((arr1 zip arr2).map(((_: String) * (_: Int)).tupled).mkString(", "))
}
