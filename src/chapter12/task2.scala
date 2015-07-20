package chapter12;

/**
 * task2 <Description>
 *
 * @author vadya
 */
object task2 extends App {
  println(Array(-100, 100, 10, 23, 1, 0, 500, 1000, 1).reduceLeft(math.max))
}
