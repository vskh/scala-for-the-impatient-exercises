package chapter16

import scala.xml.Text
import scala.xml.Atom

/**
 * task3 <Description>
 *
 * @author vadya
 */
object task3 extends App {
  println(<li>Fred</li> match { case <li>{Text(t)}</li> => "1: " + t })
  println(<li>{"Fred"}</li> match { case <li>{t: Atom[String]}</li> => "2: " + t }) // embedded expressions get wrapped into Atom[T]
}
