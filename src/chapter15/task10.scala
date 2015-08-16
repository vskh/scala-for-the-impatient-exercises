package chapter15

/**
 * task10 <Description>
 *
 * @author vadya
 */
object task10 extends App {
  def factorial(n: Int): Int = {
    assert(n >= 0)
    if (n == 0)
      1
    else
      n * factorial(n - 1)
  }

  println("1! = " + factorial(1))
  println("5! = " + factorial(5))
  println("(-1)! = " + factorial(-1))
}
// use javap -v task10$ (class with dollar sign contains the code of scala object)
// use -Xdisable-assertions option for scalac
// basically, call to assert is removed from bytecode in latter case
