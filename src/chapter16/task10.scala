package chapter16

import scala.io.Source
import scala.xml._
import scala.xml.dtd.{DocType, PublicID}
import scala.xml.parsing.ConstructingParser
import scala.xml.transform.{RuleTransformer, RewriteRule}

/**
 * task10 <Description>
 *
 * @author vadya
 */
object task10 extends App {
  val parser = ConstructingParser.fromSource(Source.fromString(
    """<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
      |<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
      | <body>
      | <![CDATA[ TEST COMMENT ]]>
      |   <img src='1.png'/>
      | </body>
      |</html>
    """.stripMargin), true)

  val doc = parser.document()
  val docRoot = doc.docElem

  val todoRule = new RewriteRule {
    override def transform(n: Node) = n match {
      case i @ <img/> if i.attributes.get("alt").isEmpty => {
        i.asInstanceOf[Elem].copy() % Attribute(null, "alt", "TODO", Null)
      }
      case _ => n
    }
  }

  XML.save("output.html", (new RuleTransformer(todoRule).transform(docRoot))(0), doctype = DocType("html", doc.dtd.externalID, Nil))
}
