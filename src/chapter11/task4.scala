package chapter11

/**
 * task4 <Description>
 *
 * @author vadya
 */
object task4 extends App {

  class Money(val dollars: Int, val cents: Int) {
    def +(other: Money): Money =
      new Money(dollars + other.dollars + (cents + other.cents) / 100, (cents + other.cents) % 100)

    def -(other: Money): Money = {
      val mycents = dollars * 100 + cents
      val othercents = other.dollars * 100 + other.cents

      new Money((mycents - othercents) / 100, (mycents - othercents) % 100)
    }

    def ==(other: Money) = dollars == other.dollars && cents == other.cents

    def <(other: Money) = dollars < other.dollars || (dollars == other.dollars && cents < other.cents)
  }

  object Money {
    def apply(dollars: Int, cents: Int) = new Money(dollars, cents)
  }

  println(Money(1, 75) + Money(0, 50) == Money(2, 25))
}
