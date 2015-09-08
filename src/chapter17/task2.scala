package chapter17

/**
 * task2 <Description>
 *
 * @author vadya
 */
object task2 extends App {
  class Pair[T](f: T, s: T) {
    private var first = f
    private var second = s

    def swap() = {
      val tmp = second
      second = first
      first = tmp

      this
    }

    override def toString = s"Pair($first, $second)"
  }

  val p = new Pair(1, 2)

  println(p)
  p.swap
  println(p)
}
