package chapter1

/**
 * Tasks <Description>
 *
 * @author vadya
 */

object Tasks extends App {
  // 1 REPL
  // 2 square roots
  import math._
  val rootOf3 = sqrt(3)
  val squareOfRootOf3 = rootOf3 * rootOf3
  println(3 - squareOfRootOf3)
  // 3 REPL res0 is val
  // 4 string multiplication
  println("crazy" * 3)
  // 5 max is method from RichInt
  println(10 max 2)
  // 6 2 pow 1024
  println(BigInt(2) pow 1024)
  // 7
  import util.Random, BigInt._
  println(probablePrime(100, Random))
  // 8
  println(BigInt(100, Random).toString(36))
  // 9
  val string = "Hello, World"
  println(string.head) // first
  println(string.last) // last
  // 10
  println(string.take(-2)) // ok with edge case - does not throw exception unlike substring
  println(string.drop(2))
  println(string.takeRight(2))
  println(string.dropRight(2))
}
