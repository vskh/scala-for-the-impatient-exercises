package chapter7

import java.util
import java.util.Map.Entry
import java.util.function.{BiFunction, BinaryOperator}

/**
 * package <Description>
 *
 * @author vadya
 */
package object task6 extends App {

  import java.util.{HashMap => JavaMap, Map => IJavaMap}

  import scala.collection.{Map => ScalaMap}

  val javaMap = new JavaMap[Int, String]()
  javaMap.put(0, "Zero")
  javaMap.put(1, "One")
  javaMap.put(2, "Two")
  javaMap.put(3, "Three")
  javaMap.put(4, "Four")
  javaMap.put(5, "Five")
  javaMap.put(6, "Six")
  javaMap.put(7, "Seven")
  javaMap.put(8, "Eight")
  javaMap.put(9, "Nine")
  val scalaMap = javaMap2ScalaMap(javaMap)
  val scalaMap8 = java8Map2ScalaMap(javaMap)

  def javaMap2ScalaMap[K, V](javaMap: JavaMap[K, V]): ScalaMap[K, V] = {
    def iter(iterator: util.Iterator[IJavaMap.Entry[K, V]], scalaMap: ScalaMap[K, V]): ScalaMap[K, V] = {
      if (!iterator.hasNext)
        scalaMap
      else {
        val e = iterator.next
        iter(iterator, scalaMap.updated(e.getKey, e.getValue))
      }
    }

    iter(javaMap.entrySet().iterator(), ScalaMap())
  }

  // SHIIIIIII~! Looking for Scala 2.12 to provide better integration with Java 8
  def java8Map2ScalaMap[K, V](javaMap: JavaMap[K, V]): ScalaMap[K, V] = {
    javaMap.entrySet
      .stream
      .reduce(ScalaMap[K, V](), new BiFunction[ScalaMap[K, V], IJavaMap.Entry[K, V], ScalaMap[K, V]] {
      override def apply(t: ScalaMap[K, V], u: Entry[K, V]): ScalaMap[K, V] = t.updated(u.getKey, u.getValue)
    }
        , new BinaryOperator[ScalaMap[K, V]] {
      override def apply(t: ScalaMap[K, V], u: ScalaMap[K, V]): ScalaMap[K, V] = t ++ u
    })
  }

  println("JavaMap: " + javaMap)
  println("ScalaMap: " + scalaMap)
  println("ScalaMap8: " + scalaMap8)
}
