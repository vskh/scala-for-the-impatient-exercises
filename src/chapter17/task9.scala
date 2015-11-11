package chapter17

/**
  * Created by vadya on 11.11.15.
  */
object task9 {
  class Pair[+T](val first: T, val second: T) {
    //def replaceFirst(newFirst: T) = new Pair(newFirst, second) // imagine this is ok
  }

  class NastyDoublePair(first: Double, second: Double) extends Pair[Double](first, second) {
    //override def replaceFirst(newFirst: Double) = new NastyDoublePair(newFirst * newFirst, second)
  }

  // unsound usage

  // no complains, valid assignment as:
  // - Pair is covariant AND
  // - Any is supertype of Double SO
  // ------- Pair[Any] is supertype of Pair[Double]
  // thus assignment is perfectly valid
  val ndp: Pair[Any] = new NastyDoublePair(0.0, 1.1)
  // since ndp is Pair of Any and String is subtype of Any this call seems to be valid
  //ndp.replaceFirst("LOL") // but actual pair is still Double!
}
