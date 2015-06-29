package chapter9

import scala.io.Source

/**
 * task3 <Description>
 *
 * @author vadya
 */
object task3 extends App {
  Source.fromFile("src/chapter9/task3.scala").getLines().toStream.flatMap(_.split("""\s""")).filter(_.length > 12).foreach(println)
}
