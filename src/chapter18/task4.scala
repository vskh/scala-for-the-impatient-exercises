package chapter18

/**
  * task4 <Description>
  *
  * @author vadya
  */
object task4 extends App {

  import scala.collection.mutable.ArrayBuffer

  class Network {

    private val members = new ArrayBuffer[Member]

    def join(name: String) = {
      val m = new Member(name)
      members += m
      m
    }

    class Member(val name: String) {
      val contacts = new ArrayBuffer[Member]

      override def equals(other: Any): Boolean = other match {
        case that: Member => true
        case _ => false
      }
    }

  }

  val network1 = new Network
  val m1 = network1.join("m1")
  val m2 = network1.join("m2")

  println("m1 == m2: " + m1.equals(m2))

  val network2 = new Network
  val m3 = network2.join("m3")
  val m4 = network2.join("m4")

  println("m3 == m4: " + m3.equals(m4))

  println("m1 == m3: " + m1.equals(m3))
}
