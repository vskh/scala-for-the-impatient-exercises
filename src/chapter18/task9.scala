package chapter18

/**
  * task9 <Description>
  *
  * @author vadya
  */
object task9 extends App {
  abstract class Dim[T](val value: Double, val name: String) {
    protected def create(v: Double): T
    def +(other: this.type) = create(value + other.value)
    override def toString() = value + " " + name
  }

  class Seconds(v: Double) extends Dim[Seconds](v, "s") {
    override def create(v: Double) = new Seconds(v)
  }

  class Meters(v: Double) extends Dim[Seconds](v, "m") {
    override def create(v: Double) = new Seconds(v)
  }

  val s = new Seconds(10)
  val m = new Meters(5)

  s + m // now impossible to add seconds and meters
  s + s // ok
  m + m // ok
}
