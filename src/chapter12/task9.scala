package chapter12

/**
 * task9 <Description>
 *
 * @author vadya
 */
object task9 extends App {
  def corresponds[A, B](arr1: Array[A], arr2: Array[B], f: (A, B) => Boolean) =
    arr1.zip(arr2).map(p => f(p._1, p._2))

  val strings = Array("Hello", "world", "from", "Scala")
  val lengthsOk = Array(5, 5, 4, 5)
  val lengthsNotOk = Array(1, 2, 3, 4)

  println(corresponds(strings, lengthsOk, (a: String, b: Int) => a.length  == b)) // types must be specified explicitly
  println(corresponds(strings, lengthsNotOk, (a: String, b: Int) => a.length  == b))
}
