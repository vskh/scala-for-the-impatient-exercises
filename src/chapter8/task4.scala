package chapter8

/**
 * task4 <Description>
 *
 * @author vadya
 */
object task4 extends App {
  abstract class Item {
    def price: Double
    def description: String

    override def toString = s"Item($price, $description)"
  }

  class SimpleItem(val price: Double, val description: String) extends Item

  class Bundle extends Item {
    private var items = List[Item]()

    def add(item: Item) = items = item :: items
    def price = items.map(_.price).sum
    def description = "Bundle of " + items.size + " items"
  }

  val i1 = new SimpleItem(10.0, "Test")
  val i2 = new SimpleItem(20.0, "Test2")

  println("Item 1: " + i1)
  println("Item 2: " + i2)

  val i3 = new Bundle
  i3.add(i1)
  i3.add(i2)
  println("Bundle: " + i3)
}
