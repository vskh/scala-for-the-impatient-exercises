package chapter12

/**
 * task4 <Description>
 *
 * @author vadya
 */
object task4 extends App {
  def factorial(n: Int) = (1 to n).foldLeft(1)((p, x) => p * x)

  println("Factorial of 5 is " + factorial(5))
  println("Factorial of 5 is " + factorial(-1))
}
