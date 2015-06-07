package chapter2

/**
 * Tasks <Description>
 *
 * @author vadya
 */
object Tasks extends App {
  // 1
  def signum(n: Int) =
    if (n < 0) -1
    else if (n > 0) 1
    else 0

  println(signum(-100))
  println(signum(500))
  println(signum(0))

  // 2 empty block type is Unit and value is ()
  // 3
  var x: Unit = ()
  var y = 0
  x = y = 1
  //4
  for (i <- (0 to 10).reverse) println(i)

  // 5
  def countdown(n: Int) = for (i <- (0 to n).reverse) println(i)

  countdown(5)
  // 6
  var product = 1L
  for (c <- "String") product *= c
  println(product)
  // 7
  println("String".map(_.toLong).product)

  // 8
  def product(s: String) = s.map(_.toLong).product

  println(product("String"))

  // 9
  def product2(s: String): Long =
    if (s.isEmpty)
      1
    else
      s.head * product2(s.tail)

  println(product2("String"))

  // 10
  def pow(x: Int, n: Int): Double =
    if (n > 0) {
      if (n % 2 == 0) {
        val y = pow(x, n / 2)
        y * y
      } else {
        x * pow(x, n - 1)
      }
    } else if (n < 0)
      1 / pow(x, -n)
    else
      1

  println(pow(2, 3))
  println(pow(3, 2))
  println(pow(10, 0))
  println(pow(100, -1))
}
