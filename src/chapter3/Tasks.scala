package chapter3

import java.awt.datatransfer.{DataFlavor, SystemFlavorMap}

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
 * Tasks <Description>
 *
 * @author vadya
 */
object Tasks extends App {
  // 1
  val n = 10
  val a = new Array[Int](n)
  for (i <- 0 until n)
    a(i) = i
  println("a = " + a.mkString(", "))
  // 2
  for (i <- 0 until(a.length, 2)) {
    val tmp = a(i)
    a(i) = a(i + 1)
    a(i + 1) = tmp
  }
  println("a = " + a.mkString(", "))
  // 3
  val b = for (i <- a.indices) yield {
    if (i % 2 == 0)
      a(i + 1)
    else
      a(i - 1)
  }
  println("b = " + b.mkString(", "))
  // 4
  val c = new Array[Int](10)
  for (i <- 0 until 10)
    c(i) = util.Random.nextInt()
  println(c.mkString("c = ", ", ", ""))
  val d = (for (i <- 0 until 10 if c(i) > 0) yield c(i)).toBuffer ++ (for (i <- 0 until 10 if c(i) <= 0) yield c(i))
  println(d.mkString("d = ", ", ", ""))
  // 5
  val e = new Array[Double](5)
  for (i <- 0 until 5)
    e(i) = util.Random.nextDouble()
  println("e = " + e.mkString(", "))
  println("Avg = " + e.sum / e.length)
  // 6
  println("reversed array e = " + e.reverse.mkString(", "))
  println("reversed arraybufer d = " + d.reverse.mkString(", "))
  // 7
  val f = Array(1, 2, 3, 4, 5, 5, 5, 6, 7, 7, 8, 9, 0, 0, 0, 0)
  println("unique = " + f.toSet.mkString(", "))
  // 8
  val g = new ArrayBuffer[Int]()
  g +=(1, 2, -4, 2, -3, -3, 10, 1, 2)
  println(g.mkString(", "))
  var first = true
  val indexes = for (i <- 0 until g.length if first || g(i) > 0) yield {
    if (g(i) < 0) first = false
    i
  }
  for (j <- 0 until indexes.length) g(j) = g(indexes(j))
  g.trimEnd(g.length - indexes.length)
  println(g.mkString(", "))

  // -- //
  val g2 = new ArrayBuffer[Int]()
  g2 +=(1, 2, -4, 2, -3, -3, 10, 1, 2)
  println(g2.mkString(", "))
  val indexes2 = for (i <- 0 until g2.length if g2(i) < 0) yield i
  //  println(indexes2.mkString(", "))
  for (i <- indexes2.tail.reverse) g2.remove(i)
  println(g2.mkString(", "))
  // 9
  println(java.util.TimeZone.getAvailableIDs
    .filter(_.startsWith("America"))
    .map(_.replace("America/", ""))
    .sorted.mkString("\n"))
  // 10
  import collection.JavaConversions.asScalaBuffer
  val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
  val natives: mutable.Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
  println("Natives: " + natives.mkString(", "))
}
