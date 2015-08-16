package chapter15

import scala.annotation.tailrec

/**
 * task7 <Description>
 *
 * @author vadya
 */
object task7 extends App {
  class SampleClass {
    def foreach[T](l: List[T])(block: T => Unit): Unit = {
      println("In SampleClass")
      l match {
        case h :: t =>
          block(h)
          foreach(t)(block) // call overriden method instead of this one
        case _ =>
      }
    }
  }

  class ExtendedSampleClass extends SampleClass {
    override def foreach[T](l: List[T])(block: T => Unit) = {
      println("In ExtendedSampleClass")
      if (l.size % 2 == 0)
        super.foreach(l)(block)
      else
        foreach(l.tail)(block)
    }
  }

  val sc = new ExtendedSampleClass
  sc.foreach(List(1, 2, 3, 4, 5, 6, 7, 8, 9))(println)
}
