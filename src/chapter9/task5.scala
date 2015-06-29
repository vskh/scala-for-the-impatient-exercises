package chapter9

/**
 * task5 <Description>
 *
 * @author vadya
 */
object task5 extends App {
  import math.pow

  (0 to 20).map { exp => val p = pow(2, exp).toLong; (p, 1.0/p) } foreach(p => printf("%10d    %f\n", p._1, p._2))
}
