package chapter18

import java.io.{OutputStreamWriter, PrintWriter, OutputStream, BufferedOutputStream}

/**
  * task7 <Description>
  *
  * @author vadya
  */
object task7 extends App {
  def autoclose[T <: { def close(): Unit }](autocloseable: T, processor: (T) => Unit) = {
    try {
      processor(autocloseable)
    } finally {
      autocloseable.close
    }
  }

  val owriter = new PrintWriter(new OutputStreamWriter(System.out))
  def print1to10(outputStream: PrintWriter) = 1 to 10 foreach outputStream.println

  autoclose(owriter, print1to10)
}
