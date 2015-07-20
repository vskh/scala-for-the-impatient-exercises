package chapter12

/**
 * task8 <Description>
 *
 * @author vadya
 */
object task8 extends App {
  val strings = Array("Hello", "world", "from", "Scala")
  val lengthsOk = Array(5, 5, 4, 5)
  val lengthsNotOk = Array(1, 2, 3, 4)

  println(strings.corresponds(lengthsOk)(_.length  == _))
  println(strings.corresponds(lengthsNotOk)(_.length  == _))
}
