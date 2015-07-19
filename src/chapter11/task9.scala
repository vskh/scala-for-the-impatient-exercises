package chapter11

import java.io.File
import java.nio.file.{Paths, Files}

/**
 * task9 <Description>
 *
 * @author vadya
 */
object task9 extends App {
  object RichFile {
    def unapply(filepath: String) = {
      if (filepath.trim.isEmpty)
        None
      else {
        val f = new File(filepath)

        val Array(fileName, fileExt) = f.getName.split("\\.")
        Some((f.getParent, fileName, fileExt))
      }
    }
  }

  val RichFile(path, name, ext) = "/home/cay/readme.txt"

  println(s"Path: $path, Name: $name, Extension: $ext")
}
