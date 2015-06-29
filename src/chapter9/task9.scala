package chapter9

import java.nio.file._

/**
 * task9 <Description>
 *
 * @author vadya
 */
object task9 extends App {
  if (args.length == 0)
    println("Usage: task9 <directory>")
  else {
    Files.walkFileTree(Paths.get(args(0)), new SimpleFileVisitor[Path] {
      override def visitFile(p: Path, attrs: attribute.BasicFileAttributes) = {
//        println(p + ": " + p.toString.endsWith("class"))
        if (p.toString.endsWith("class"))
          println(p)
        FileVisitResult.CONTINUE
      }
    })
  }
}
