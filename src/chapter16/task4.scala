package chapter16

import java.net.URL

import scala.xml.XML

/**
 * task4 <Description>
 *
 * @author vadya
 */
object task4 extends App {
  val xml = XML.load(new URL("http://www.w3.org/"))

  xml \\ "img" foreach {
    case n @ <img/> if n.attributes("alt").isEmpty =>
      println(n)
    case _ =>
  }
}
