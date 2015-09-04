package chapter16

/**
 * task1 <Description>
 *
 * @author vadya
 */
object task1 extends App {
  val r1 = <fred/> // Node
  val r2 = <fred/>(0) // Node is NodeSeq containing itself
  val r3 = <fred/>(0)(0) // Node again

  assert(r1 == r2)
  assert(r2 == r3)
}
