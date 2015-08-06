package chapter14

/**
 * task4 <Description>
 *
 * @author vadya
 */
object task4 extends App {

  sealed abstract class Item

  case class Article(description: String, price: Double) extends Item

  case class Bundle(description: String, discount: Double, items: Item*) extends Item

  case class Multiple(amount: Int, item: Item) extends Item

  def price(it: Item): Double = it match {
    case Article(_, p) => p
    case Bundle(_, disc, its @ _*) => its.map(price).sum - disc
    case Multiple(amount, item) => amount * price(item)
  }

  println("Price of 10 articles is " + price(Multiple(10, Article("Blackwell Toaster", 29.95))) + "$")
}
