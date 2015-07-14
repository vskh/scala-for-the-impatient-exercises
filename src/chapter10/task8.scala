package chapter10

import java.io.{File, InputStream, FileInputStream, FilterInputStream}

import chapter10.task4.CryptoLogger

/**
 * task8 <Description>
 *
 * @author vadya
 */
object task8 extends App {

  trait BufferedInputStream extends InputStream with CryptoLogger {
    private val buf: Array[Byte] = Array.ofDim(1024)
    private var iter: Iterator[Byte] = buf.iterator

    override def read(): Int = {
      if (iter.hasNext)
        iter.next()
      else if (read(buf) != -1) {
        log("\nRefilling buffer")
        iter = buf.iterator
        iter.next()
      } else
        -1
    }
  }

  val fstream = new FileInputStream(new File(getClass.getResource("lorem.txt").toURI)) with BufferedInputStream

  var c = fstream.read()
  while (c != -1) {
    print(c.toChar)
    c = fstream.read()
  }
}
