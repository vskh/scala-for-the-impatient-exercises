package chapter16

import scala.xml.Node

/**
 * task8 <Description>
 *
 * @author vadya
 */
object task8 extends App {
  def description_list(xml: Node) = {
    xml \\ "dl" flatMap { list =>
      list.child.map {
        case <dt>{k}</dt> => k
        case <dd>{v}</dd> => v
      }.grouped(2).map(s => (s(0), s(1)))
    } toMap
  }

  println(description_list(<dl><dt>Test</dt><dd>Test D</dd><dt>Test 2</dt><dd>Test D 2</dd></dl>))
}
