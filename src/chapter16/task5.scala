package chapter16

import java.net.URL

import scala.xml.XML

/**
 * task5 <Description>
 *
 * @author vadya
 */
object task5 extends App {

  val xml = XML.load(new URL("http://www.w3.org/"))

  xml \\ "img" foreach { n => println(n.attributes("src")) }

}
