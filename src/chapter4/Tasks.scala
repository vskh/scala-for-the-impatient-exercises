package chapter4

import java.io.File
import java.util
import java.util.{Calendar, Scanner}

import scala.collection.immutable.SortedMap

/**
 * Tasks <Description>
 *
 * @author vadya
 */
object Tasks extends App {
  // 1
  def task1 = {
    val prices = Map("something1" -> 1, "something2" -> 2, "something3" -> 3)
    println(prices)
    val discountedPrices = for ((k, v) <- prices) yield (k, v - v * 0.2)
    println(discountedPrices)
  }

  task1

  // 2
  def task2 = {
    val in = new Scanner(new File("src/chapter4/Tasks.scala"))
    val wordMap = scala.collection.mutable.Map[String, Int]()
    while (in.hasNext()) {
      val word = in.next
      if (wordMap contains word)
        wordMap(word) += 1
      else
        wordMap(word) = 1
    }
    println(wordMap)
  }

  task2

  // 3
  def task3 = {
    def iter(in: Scanner, map: Map[String, Int]): Map[String, Int] = {
      if (in.hasNext()) {
        val word = in.next
        iter(in, map.updated(word, map.withDefaultValue(1)(word) + 1))
      } else map
    }

    val in = new Scanner(new File("src/chapter4/Tasks.scala"))
    val wordMap = Map[String, Int]()

    println(iter(in, wordMap))
  }

  task3

  // 4
  def task4 = {
    def iter(in: Scanner, acc: Map[String, Int]): Map[String, Int] = {
      if (in.hasNext()) {
        val word = in.next
        iter(in, acc.updated(word, acc.getOrElse(word, 0) + 1))
      } else acc
    }

    val in = new Scanner(new File("src/chapter4/Tasks.scala"))
    val wordMap = SortedMap[String, Int]()

    println(iter(in, wordMap))
  }

  task4

  def task5 = {
    import scala.collection.JavaConversions.mapAsScalaMap

    val in = new Scanner(new File("src/chapter4/Tasks.scala"))
    val wordMap: scala.collection.mutable.Map[String, Int] = new util.TreeMap[String, Int]()

    while (in.hasNext()) {
      val word = in.next
      if (wordMap contains word)
        wordMap(word) += 1
      else
        wordMap(word) = 1
    }

    println(wordMap)
  }

  task5

  def task6 = {
    import scala.collection.JavaConversions.mapAsScalaMap
    val days: scala.collection.mutable.Map[String, Int] = new java.util.LinkedHashMap[String, Int]()
    days += "Monday" -> Calendar.MONDAY
    days += "Tuesday" -> Calendar.TUESDAY
    days += "Wednesday" -> Calendar.WEDNESDAY
    days += "Thursday" -> Calendar.THURSDAY
    days += "Friday" -> Calendar.FRIDAY
    days += "Saturday" -> Calendar.SATURDAY
    days += "Sunday" -> Calendar.SUNDAY

    days
  }

  println(task6)

  // 7
  def task7 = {
    import scala.collection.JavaConversions.propertiesAsScalaMap
    val props: scala.collection.mutable.Map[String, String] = System.getProperties()
    val maxLen = props.keys.reduce((k1, k2) => if (k1.length < k2.length) k2 else k1).length

    props.foreach((p: (String, String)) => {
      printf("%-" + maxLen + "s| %s\n", p._1, p._2)
    })
  }

  task7

  // 8
  def task8 = {
    def minmax(values: Array[Int]) = (values.min, values.max)

    println(minmax(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -100)))
  }

  task8

  // 9
  def task9 = {
    def lteqgt(values: Array[Int], v: Int) = (values.count(_ < v), values.count(_ == v), values.count(_ > v))

    println(lteqgt(Array(1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,10,11,12,13), 10))
  }

  task9

  // 10
  println("Hello".zip("World").toMap)
}
