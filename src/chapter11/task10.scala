package chapter11

import java.io.File

/**
 * task10 <Description>
 *
 * @author vadya
 */
object task10 extends App {
  object RichFile {
    def unapplySeq(filepath: String): Option[Seq[String]] = {
      if (filepath.trim.isEmpty)
        None
      else {
        Some(filepath.trim.split(File.separatorChar).filter(!_.isEmpty))
      }
    }
  }

  val RichFile(pathElements @ _*) = "/home/cay/readme.txt"

  println(pathElements)
}
