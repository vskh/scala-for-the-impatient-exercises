package chapter9

import java.io.{File, PrintWriter}
import java.nio.file.{StandardCopyOption, CopyOption, Paths, Files}

import scala.io.Source

/**
 * task2 <Description>
 *
 * @author vadya
 */
object task2 extends App {
  args match {
    case Array(filename) => retabFile(filename)
    case Array(filename, columnWidth) => retabFile(filename, columnWidth.toInt)
    case Array() | _ => println("Usage: task2 <filename> [columnwidth]")
  }

  def retabFile(filename: String, columnWidth: Int = 4): Unit = {
    val tempfilename = filename + ".tmp"
    val pw = new PrintWriter(tempfilename)

    Source.fromFile(filename)
      .getLines()
      .toStream
      .map(_.replaceAll("\t", " " * columnWidth))
      .foldLeft(pw) { (pw, s) => pw.println(s); pw }
      .close()

    Files.move(Paths.get(tempfilename), Paths.get(filename), StandardCopyOption.REPLACE_EXISTING)
  }
}
