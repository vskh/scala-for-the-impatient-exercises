package chapter9

import scala.io.Source

/**
 * task4 <Description>
 *
 * @author vadya
 */
object task4 extends App {
  if (args.length != 1)
    println("Usage: task4 <fileWithFloats>")
  else {
    val values = Source.fromFile(args(0)).mkString.split("""\s""").map(_.toDouble)
    println("Sum: " + values.sum)
    println("Avg: " + values.sum / values.length)
    println("Max: " + values.max)
    println("Min: " + values.min)
  }
}
