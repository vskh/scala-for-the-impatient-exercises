package chapter16

/**
 * task7 <Description>
 *
 * @author vadya
 */
object task7 extends App {
  def description_list(descriptions: Map[String, String]) = {
    <dl>{for ((k, v) <- descriptions) yield <dt>{k}</dt><dd>{v}</dd>}</dl>
  }

  println(description_list(Map(("Test", "Demo"), ("HTML", "Markup language"))))
}
