package chapter13

/**
 * task9 <Description>
 *
 * @author vadya
 */
object task9 extends App {
// ??? - both variants work (second needs to be corrected as causes compilation error (book uses older sdk): http://stackoverflow.com/questions/18660769/best-practices-for-mixing-in-scala-concurrent-map)
  val frequencies = new scala.collection.mutable.HashMap[Char, Int] with
    scala.collection.mutable.SynchronizedMap[Char, Int]

//  import scala.collection.JavaConversions.mapAsScalaConcurrentMap
//  val frequencies: java.util.concurrent.ConcurrentMap[Char, Int] =
//    new java.util.concurrent.ConcurrentHashMap[Char, Int]

  val str = "This is string to count char frequencies"

  for (c <- str.par) {
    println(Thread.currentThread() + " is processing char '" + c + "'")
    frequencies(c) = frequencies.getOrElse(c, 0) + 1
  }

  println(frequencies)
}
