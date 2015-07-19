package chapter11

import scala.collection.mutable.ArrayBuffer

/**
 * task6 <Description>
 *
 * @author vadya
 */
object task6 extends App {

  class ASCIIArt(s: ArrayBuffer[String]) {
    private val repr: ArrayBuffer[String] = s

    def this(s: String) = {
      this(s.split("\n").to[ArrayBuffer])
    }

    def |(other: ASCIIArt) = new ASCIIArt(repr.zip(other.repr).map { case (a, b) => a + b })
    def __(other: ASCIIArt) = new ASCIIArt(repr ++ other.repr)


    override def toString = repr.mkString("\n")
  }

  val art1 = new ASCIIArt(
    """
      | /\_/\
      |( ' ' )
      |(  -  )
      | | | |
      |(__|__)
    """.stripMargin)

  val art2 = new ASCIIArt(
    """
      |   -----
      | / Hello \
      |<  Scala  |
      | \ Coder /
      |   -----
    """.stripMargin)

  println(art1 | art2)
  println(art1 __ art2)
}
