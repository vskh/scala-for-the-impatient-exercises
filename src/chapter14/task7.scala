package chapter14

/**
 * task7 <Description>
 *
 * @author vadya
 */
object task7 extends App {

  def leafSum(tree: BinaryTree): Int = tree match {
    case Leaf(n) => n
    case Node(children@_*) => children.map(leafSum).sum
    case null => 0
  }

  sealed abstract class BinaryTree

  case class Leaf(value: Int) extends BinaryTree

  case class Node(children: BinaryTree*) extends BinaryTree

  println("Sum of leaves: " + leafSum(Node(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(5)))))
}
