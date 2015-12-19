package chapter19

import scala.util.parsing.combinator.RegexParsers

/**
  * Created by vadya on 19.12.15.
  */
object task2 extends App {

  class ArithmeticParser extends RegexParsers {
    val number = "[0-9]+".r

    def precedence3Expr: Parser[Int] = precedence2Expr ~ opt(rep(("+" | "-") ~ precedence2Expr)) ^^ {
      case n ~ None => n
      case n ~ Some(rs) => rs.foldLeft(n) {
        case (l, "+" ~ r) => l + r
        case (l, "-" ~ r) => l - r
      }
    }

    def precedence2Expr: Parser[Int] = precedence1Expr ~ rep(("*" | "/" | "%") ~ precedence1Expr) ^^ {
      case n ~ ops => ops.foldLeft(n) {
        case (l, "*" ~ r) => l * r
        case (l, "/" ~ r) => l / r
        case (l, "%" ~ r) => l % r
      }
    }

    def precedence1Expr: Parser[Int] = intExpr ~ opt("^" ~ intExpr) ^^ {
      case n ~ None => n
      case b ~ Some("^" ~ e) => math.pow(b, e).toInt
    }

    def intExpr: Parser[Int] = number ^^ { _.toInt } |
      "(" ~> precedence3Expr <~ ")"
  }

  val parser = new ArithmeticParser
  val expressions = Array(
    "2+2", "(2+2)", "2-1+2%3+10/2-3*5", "1*2/3%4+5-6", "1+2*(3-4)+5%6-7",
    "2^2", "2^2+1", "2^2*2", "2*3^4*5", "2+3^(3-1)"
  )
  expressions.map(e => {
    val r = parser.parseAll(parser.precedence3Expr, e)

    if (r.successful)
      e + " = " + r.get
    else
      "Parsing " + e + " failed at line " + r.next.pos.line + ", column " + r.next.pos.column
  }).foreach(println)
}
