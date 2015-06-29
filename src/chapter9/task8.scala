package chapter9

import scala.io.Source

/**
 * task8 <Description>
 *
 * @author vadya
 */
object task8 extends App {
  args match {
    case Array(url) =>
      val p = """<img.*?src="(.*?)".*?/?>""".r
      for (p(src) <- p.findAllIn(Source.fromURL(url).mkString))
        println(src)
    case _ => println("Usage: task8 <URL>")
  }
}
