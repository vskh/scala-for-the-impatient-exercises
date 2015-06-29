package chapter8

/**
 * task10 <Description>
 *
 * @author vadya
 */
object task10 extends App {
  class Stack[A] protected (protected val elems: List[A])

  class DerivedStack[A] extends Stack[A](List()) // primary constructor is available only for inheritance
//  val stack = new Stack[Int](List()) // but not for creation of Stack (as it is protected)
}
