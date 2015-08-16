package chapter15

import scala.annotation.varargs

/**
 * Created by vadya on 10.08.15.
 */
object task4 extends App {
  @varargs def sum(args: Int *) = args.sum

}
