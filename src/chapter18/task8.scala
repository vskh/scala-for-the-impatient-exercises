package chapter18

/**
  * task8 <Description>
  *
  * @author vadya
  */
object task8 extends App {
  def printValues(range: { def apply(idx: Int): Int }, from: Int, to: Int) = {
    (from to to).foreach(idx => print(range(idx) + " "))
  }

  printValues((x: Int) => x * x, 3, 6) // Prints 9 16 25 36
  println()
  printValues(Array(1, 1, 2, 3, 5, 8, 13, 21, 34, 55), 3, 6) // Prints 3 5 8 13
}
