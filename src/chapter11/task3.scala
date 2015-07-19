package chapter11

/**
 * task3 <Description>
 *
 * @author vadya
 */
object task3 extends App {

  class Fraction(n: Int, d: Int) {
    private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d)
    private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d)

    override def toString = num + "/" + den

    def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0

    def gcd(a: Int, b: Int): Int = if (b == 0) math.abs(a) else gcd(b, a % b)

    def *(other: Fraction): Fraction = new Fraction(num * other.num, den * other.den)

    def /(other: Fraction): Fraction = new Fraction(num * other.den, den * other.num)

    def +(other: Fraction): Fraction = new Fraction(num * other.den + other.num * den, den * other.den)

    def -(other: Fraction): Fraction = this.+(-other)

    def unary_-(): Fraction = new Fraction(-num, den)
  }

  val f1 = new Fraction(1, 2)
  val f2 = new Fraction(2, 3)

  println("Sum: " + (f1 + f2))
  println("Difference: " + (f1 - f2))
  println("Product: " + (f1 * f2))
  println("Division: " + (f1 / f2))
}
