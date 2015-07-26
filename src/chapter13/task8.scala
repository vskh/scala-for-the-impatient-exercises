package chapter13

/**
 * task8 <Description>
 *
 * @author vadya
 */
object task8 extends App {
  def arr2multidim(arr: Array[Double], cols: Int) = arr.grouped(cols)

  println(arr2multidim(Array(1, 2, 3, 4, 5, 6, 7), 2).map(_.mkString(", ")).mkString("; "))
}
