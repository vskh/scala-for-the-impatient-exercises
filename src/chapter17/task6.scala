package chapter17

/**
 * task6 <Description>
 *
 * @author vadya
 */
object task6 extends App {
  def middle[T](it: Iterable[T]) = it.drop(it.size / 2).head

  println(middle("World"))
}
