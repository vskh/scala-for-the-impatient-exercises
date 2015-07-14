package chapter10

import java.io.{File, FileInputStream, InputStream}

/**
 * task10 <Description>
 *
 * @author vadya
 */
object task10 extends App {

  val ifstream = new FileInputStream(new File(getClass.getResource("lorem.txt").toURI)) with IterableInputStream

  ifstream.foreach(b => println(b.toChar))

  trait IterableInputStream extends InputStream with Iterable[Byte] {

    override def iterator: Iterator[Byte] = new Iterator[Byte] {

      private var buf: Option[Byte] = None

      private def pickNext(): Byte = buf match {
        case None =>
          val c = read().toByte
          buf = Some(c)
          c
        case Some(c) => c
      }

      private def getNext(): Byte = {
        val c = pickNext()
        buf = None
        c
      }

      override def hasNext: Boolean = pickNext() != -1

      override def next(): Byte = {
        val c = getNext()

        if (c == -1)
          throw new NoSuchElementException()
        else
          c
      }
    }
  }
}
