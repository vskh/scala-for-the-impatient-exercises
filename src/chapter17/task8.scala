package chapter17

import java.io.{InputStreamReader, BufferedReader}
import java.util.Scanner

/**
 * Created by vadya on 31.10.15.
 */
object task8 {
  // example immutable pair with replaceFirst having type bound
  class ImmPair[+T](val first: T, val second: T) {
    def replaceFirst[R >: T](newFirst: R) = new ImmPair[R](newFirst, second)
  }
  // mutable pair with same does not compile
  class MutPair[T](var first: T, var second: T) {
    //def replaceFirst[R >: T](newFirst: R) { first = newFirst } // we can't assign some supertype of T to T
  }
}
