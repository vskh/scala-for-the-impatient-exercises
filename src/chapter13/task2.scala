package chapter13

/**
 * task2 <Description>
 *
 * @author vadya
 */
object task2 extends App {
  def indexes(str: String) =
    str.zipWithIndex
       .groupBy(_._1)
       .foldLeft(Map[Char, Set[Int]]()) { (acc, el) => acc.updated(el._1, el._2.map(_._2).toSet) }

  println(indexes("Mississippi"))
}
