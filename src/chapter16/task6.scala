package chapter16

import java.net.URL

import scala.xml.XML

/**
 * task6 <Description>
 *
 * @author vadya
 */
object task6 extends App {
  val xml = XML.load(new URL("http://www.w3.org/"))

  xml \\ "a" foreach {
    case link @ <a>{text}</a> =>
      println(text + " " + link.attributes("href"))
    case _ =>
  }
}
