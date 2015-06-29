package chapter9

import java.io.File

import scala.io.Source

/**
 * task1 <Description>
 *
 * @author vadya
 */
object task1 extends App {
  if (args.length != 1) {
    println("Usage: task1 <filename>")
  } else {
    Source.fromFile(new File(args(0))).getLines().toStream.reverse.foreach(println(_))
  }
}
