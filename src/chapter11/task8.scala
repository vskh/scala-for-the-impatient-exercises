package chapter11

/**
 * task8 <Description>
 *
 * @author vadya
 */
object task8 extends App {


  val m1 = new Matrix(2, 2)
  val m2 = new Matrix(2, 2)

  class Matrix(val m: Int, val n: Int) {
    private val repr: Array[Array[Double]] = Array.ofDim(m, n)

    private def row(m: Int) = repr(m)
    private def col(n: Int) = repr.map(buf => buf(n))

    def apply(m: Int, n: Int) = repr(m)(n)

    def update(m: Int, n: Int, value: Double) = repr(m)(n) = value

    def +(other: Matrix) = {
      if (m != other.m || n != other.n)
        throw new IllegalArgumentException("Matrices should be of same dimensions: " + other)
      new Matrix(repr.zip(other.repr).map { case (thisrepr, thatrepr) => thisrepr.zip(thatrepr).map { case (a, b) => a + b } })
    }

    def *(scale: Double) = {
      new Matrix(repr.map(buf => buf.map(_ * scale)))
    }

    def *(other: Matrix) = {
      if (n != other.m)
        throw new IllegalArgumentException("Matrices should align in dimentions: " + other)

      val newrepr = (for (i <- 0 until m) yield {
        (for (j <- 0 until n) yield row(i).zip(other.col(j)).map{case (a, b) => a * b}.sum).toArray
      }).toArray

      new Matrix(newrepr)
    }

    def this(otherrepr: Array[Array[Double]]) = {
      this(otherrepr.length, otherrepr(0).length)
      for (i <- 0 until m; j <- 0 until n)
        repr(i)(j) = otherrepr(i)(j)
    }

    override def toString = "Matrix(\n" + repr.map(buf => buf.mkString(" ")).mkString("\n") + "\n)"
  }

  m1(0, 0) = 1
  m1(0, 1) = 2
  m1(1, 0) = 3
  m1(1, 1) = 4
  println(m1)
  m2(0, 0) = 4
  m2(0, 1) = 3
  m2(1, 0) = 2
  m2(1, 1) = 1
  println(m2)

  println(m1 * 2)

  println(m1 * m2)
}
