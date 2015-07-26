package chapter13

/**
 * task4 <Description>
 *
 * @author vadya
 */
object task4 extends App {
  def func(strings: Array[String], map: Map[String, Int]) =
    strings.flatMap(map.get)

  println(func(Array("Tom", "Fred", "Harry"), Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)).mkString(", "))
}
