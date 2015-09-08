package chapter17

/**
 * task1 <Description>
 *
 * @author vadya
 */
object task1 extends App {
  class Pair[T, S](val first: T, val second: S) {
    def swap() = {
      new Pair(second, first)
    }

    override def toString = s"Pair($first, $second)"
  }

  val p1 = new Pair(1, "One")

  val p2 = p1.swap()

  println(p1)
  println(p2)
}
