package chapter17

import scala.runtime.RichInt

/**
 * task5 <Description>
 *
 * @author vadya
 */
object task5 extends App {
  // RichInt is extension for Int with implicit conversion.
  // If it implemented Comparable[RichInt] it would be useless for Ints where Comparable context is required.
  // Int does not implement Comparable as it is mapped to Integer java type which does not know anything about Scala
  // traits.
}
