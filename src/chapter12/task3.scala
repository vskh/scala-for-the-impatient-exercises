package chapter12

/**
 * task3 <Description>
 *
 * @author vadya
 */
object task3 extends App {
  def factorial(n: Int) =
    if (n < 0)
      throw new IllegalArgumentException("Factorial is not defined for n < 0")
    else if (n == 0)
      1
    else
      (1 to n).reduceLeft((p, x) => p * x)

  println("Factorial of 5 is " + factorial(5))
}
