package chapter19

import scala.util.parsing.combinator.RegexParsers

/**
  * Created by vadya on 19.12.15.
  */
object task1 extends App {

  class ArithmeticParser extends RegexParsers {
    val number = "[0-9]+".r

    def precedence2Expr: Parser[Int] = precedence1Expr ~ opt(rep(("+" | "-") ~ precedence1Expr)) ^^ {
      case (n ~ None) => n
      case (n ~ Some(rs)) => rs.foldLeft(n) {
        case (l, "+" ~ r) => l + r
        case (l, "-" ~ r) => l - r
      }
    }

    def precedence1Expr: Parser[Int] = intExpr ~ rep(("*" | "/" | "%") ~ intExpr) ^^ {
      case n ~ ops => ops.foldLeft(n) {
        case (l, "*" ~ r) => l * r
        case (l, "/" ~ r) => l / r
        case (l, "%" ~ r) => l % r
      }
    }

    def intExpr: Parser[Int] = number ^^ { _.toInt } |
                              "(" ~> precedence2Expr <~ ")"
  }

  val parser = new ArithmeticParser
  val expressions = Array("2+2", "(2+2)", "1+2+3+4", "1+2-3+4", "2+2*2", "(2+2)*2")
  expressions.map(e => {
    val r = parser.parseAll(parser.precedence2Expr, e)
    println(r)
    if (r.successful)
      e + " = " + r.get
    else
      "Parsing " + e + " failed at line " + r.next.pos.line + ", column " + r.next.pos.column
  }).foreach(println)
}
