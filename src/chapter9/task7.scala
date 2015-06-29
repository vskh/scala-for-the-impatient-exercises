package chapter9

import scala.io.Source

/**
 * task7 <Description>
 *
 * @author vadya
 */
object task7 extends App {
  args match {
    case Array(filename) =>
      Source.fromFile(filename).mkString.split("\\s+").filter(s => !s.matches("[0-9-]+\\.?[0-9E-]*")).foreach(println)
    case _ => println("Usage: task7 <filename>")
  }
}
