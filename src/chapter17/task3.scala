package chapter17

/**
 * task3 <Description>
 *
 * @author vadya
 */
object task3 extends App {
  sealed case class Pair[T, S](first: T, second: S)

  def swap[T, S](p: Pair[T, S]): Pair[S, T] = {
    new Pair(p.second, p.first)
  }

  val p1 = new Pair(1, "One")
  val p2 = swap(p1)

  println(p1)
  println(p2)
}
