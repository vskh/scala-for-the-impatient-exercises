package chapter11

/**
 * task7 <Description>
 *
 * @author vadya
 */
object task7 extends App {

  val bs = new BitSequence(1)

  class BitSequence(init: Long = 0) {

    private var value: Long = init

    def apply(idx: Int) = ((value >> idx) & 1) == 1

    def update(idx: Int, bitvalue: Boolean) =
      if (bitvalue)
        value |= (1 << idx)
      else
        value &= ~(1 << idx)


    override def toString = s"BitSequence($value)"
  }

  println(bs(0))

  bs(8) = true

  println(bs(8))

  println(bs)
}
