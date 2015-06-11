/**
 * package <Description>
 *
 * @author vadya
 */
package object chapter6 extends App {
  def task1 = {
    object Conversions {
      def inchesToCentimeters(inches: Double) = 2.54 * inches

      def gallonsToLiters(gallons: Double) = 3.78541178 * gallons

      def milesToKilometers(miles: Double) = 1.609344 * miles
    }
    println("5 inches is " + Conversions.inchesToCentimeters(5) + " centimeters")
    println("2 gallons is " + Conversions.gallonsToLiters(2) + " liters")
    println("10 miles is " + Conversions.milesToKilometers(10) + " kilometers")
  }

  task1

  def task2 = {
    abstract class UnitConversion {
      def convert(value: Double): Double

      def apply(value: Double) = convert(value)
    }

    object InchesToCentimeters extends UnitConversion {
      def convert(value: Double) = 2.54 * value
    }

    object GallonsToLiters extends UnitConversion {
      def convert(value: Double) = 3.78541178 * value
    }

    object MilesToKilometers extends UnitConversion {
      def convert(value: Double) = 1.609344 * value
    }

    println("5 inches is " + InchesToCentimeters(5) + " centimeters")
    println("2 gallons is " + GallonsToLiters(2) + " liters")
    println("10 miles is " + MilesToKilometers(10) + " kilometers")
  }

  task2

  def task3 = {
    object Origin extends java.awt.Point
    // Point has instance specific methods (e.g. x, y) which do not make much sense in singleton
  }

  task3

  def task4 = {
    class Point(val x: Double, val y: Double) {
      override def toString = s"Point($x, $y)"
    }
    object Point {
      def apply(x: Double, y: Double) = new Point(x, y)
    }

    println("Point: " + Point(2, 3))
  }

  task4

  def task5 = {
    object Reverse extends App {
      println(args.reverse.mkString(" "))
    }
  }

  task5

  def task6 = {
    object Suit extends Enumeration {
      val SPADES = Value("♠")
      val CLUBS = Value("♣")
      val DIAMONDS = Value("♦")
      val HEARTS = Value("♥")
    }

    import Suit._
    println("Suits: " + SPADES + " " + CLUBS + " " + DIAMONDS + " " + HEARTS)
  }

  task6

  def task7 = {
    object Suit extends Enumeration {
      type Suit = Value
      val SPADES = Value("♠")
      val CLUBS = Value("♣")
      val DIAMONDS = Value("♦")
      val HEARTS = Value("♥")
    }

    import Suit._
    def isRedSuit(suit: Suit) = {
      if (suit == DIAMONDS || suit == HEARTS)
        true
      else
        false
    }

    println("SPADES is red: " + isRedSuit(SPADES))
    println("HEARTS is red: " + isRedSuit(HEARTS))
  }

  task7

  def task8 = {
    object RGBCube extends Enumeration {
      val RED = Value(0xff0000)
      val GREEN = Value(0x00ff00)
      val BLUE = Value(0x0000ff)
      val BLACK = Value(0x000000)
      val WHITE = Value(0xffffff)
      val YELLOW = Value(0xffff00)
      val CYAN = Value(0x00ffff)
      val MAGENTA = Value(0xff00ff)
    }
  }

  task8
}
