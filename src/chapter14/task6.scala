package chapter14

/**
 * task6 <Description>
 *
 * @author vadya
 */
object task6 extends App {

  sealed abstract class BinaryTree

  case class Leaf(value: Int) extends BinaryTree

  case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree

  def leafSum(tree: BinaryTree): Int = tree match {
    case Leaf(n) => n
    case Node(l, r) => leafSum(l) + leafSum(r)
    case null => 0
  }

  println("Sum of leaves: " + leafSum(Node(Node(Node(Leaf(3), Leaf(8)), Leaf(2)), Node(Leaf(5), null))))
}
