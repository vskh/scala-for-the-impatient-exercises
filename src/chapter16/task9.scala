package chapter16

import scala.xml._
import scala.xml.transform.{RewriteRule, RuleTransformer}

/**
 * task9 <Description>
 *
 * @author vadya
 */
object task9 extends App {
  val xml = <html>
    <body>
      <img src="1.png"/>
    </body>
  </html> // XML.load(new URL("http://www.w3.org/"))

  val todoRule = new RewriteRule {
    override def transform(n: Node) = n match {
      case i @ <img/> if i.attributes.get("alt").isEmpty => {
        i.asInstanceOf[Elem].copy() % Attribute(null, "alt", "TODO", Null)
      }
      case _ => n
    }
  }

  println(new RuleTransformer(todoRule).transform(xml))
}
