package chapter7.task3

/**
 * package <Description>
 *
 * @author vadya
 */
package object random {

  val a = 1664525
  val b = 1013904223
  val n = 32
  private var previous = 0.0

  def nextInt: Int = nextDouble.toInt

  def nextDouble: Double = {
    previous = (previous * a + b) % math.pow(2, n)
    previous
  }

  def setSeed(seed: Int) {
    previous = seed
  }
}
