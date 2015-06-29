package chapter9

import scala.io.Source

/**
 * task6 <Description>
 *
 * @author vadya
 */
object task6 extends App {
  args match {
    case Array(filename) =>
      "(?<!\\\\)\".*?(?<!\\\\)\"".r.findAllMatchIn(Source.fromFile(filename).mkString).foreach(println)
    case _ => println("Usage: task6 <filename>")
  }
}
