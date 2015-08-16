package chapter15

import scala.io.Source

/**
 * Created by vadya on 11.08.15.
 */
object task5 extends App {
  def readFile(path: String) = Source.fromFile(path).mkString
}
