package chapter19

import scala.util.parsing.combinator.RegexParsers

/**
  * Created by vadya on 20.12.15.
  */
object task3 extends App {
  class IntListParser extends RegexParsers {
    val integer = "[+-]?[0-9]+".r

    def intListExpr: Parser[List[Int]] = opt("(") ~> (intExpr ~ opt(rep("," ~> intExpr))) <~ opt(")") ^^ {
      case i ~ None => List(i)
      case i ~ Some(is) => i :: is
    }

    def intExpr: Parser[Int] = integer ^^ { _.toInt }
  }

  val parser = new IntListParser

  println(parser.parseAll(parser.intListExpr, "(1, 23, -79)"))
}
