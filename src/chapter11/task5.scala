package chapter11

import scala.collection.mutable.ArrayBuffer

/**
 * task5 <Description>
 *
 * @author vadya
 */
object task5 extends App {

  class Table {
    private val repr: ArrayBuffer[ArrayBuffer[String]] = ArrayBuffer(ArrayBuffer())
    private var currentRow: Int = 0

    def |(string: String): Table = {
      repr(currentRow) += string
      this
    }

    def ||(string: String): Table = {
      currentRow += 1
      repr += ArrayBuffer()
      this
    }

    override def toString =
      "<table>" +
        repr.map(buf => buf.mkString("<td>", "</td><td>", "</td>")).mkString("<tr>", "</tr><tr>", "</tr>") +
        "</table>"
  }

  object Table {
    def apply() = new Table
  }

  println(Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM, .NET")
}
