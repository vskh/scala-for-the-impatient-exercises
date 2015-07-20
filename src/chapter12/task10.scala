package chapter12

/**
 * task10 <Description>
 *
 * @author vadya
 */
object task10 extends App {
  def unless[R](condition: => Boolean)(code: => R) =
    if (!condition)
      code

  unless (true) {
    println("Incorrect!")
  }

  unless (false) {
    println("Correct!")
  }
}
