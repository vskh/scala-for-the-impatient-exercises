package chapter14

/**
 * task8 <Description>
 *
 * @author vadya
 */
object task8 extends App {

  sealed abstract class BinaryTree

  sealed abstract class Operator

  case class Leaf(value: Int) extends BinaryTree

  case class Node(op: Operator, children: BinaryTree*) extends BinaryTree

  case object Plus extends Operator

  case object Minus extends Operator

  case object Multiply extends Operator

  case object Divide extends Operator

  def eval(tree: BinaryTree): Int = tree match {
    case Leaf(n) => n
    case null => 0
    case Node(op, children @ _*) => op match {
      case Plus => children.map(eval).foldLeft(0)(_ + _)
      case Minus => children.map(eval).foldLeft(0)(_ - _)
      case Multiply => children.map(eval).foldLeft(1)(_ * _)
      case Divide => children.map(eval).foldLeft(1)(_ / _)
    }
  }

  println("Result: " + eval(Node(Plus, Node(Multiply, Leaf(3), Leaf(8)), Leaf(2), Node(Minus, Leaf(5)))))
}
