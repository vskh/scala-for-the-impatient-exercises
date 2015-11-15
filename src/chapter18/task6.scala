package chapter18

/**
  * Created by vadya on 15.11.15.
  */
object task6 extends App {
  def find(arr: Array[Int], value: Int): Int Either Int = {
    val closestEl = arr.zipWithIndex
      .foldLeft((Math.abs(arr.head - value), 0)) {
        (min, el) =>
          val diff = Math.abs(el._1 - value)
          if (min._1 > diff) {
            (diff, el._2)
          } else {
            min
          }
      }

    closestEl match {
      case (0, exactMatchIdx) => Right(exactMatchIdx)
      case (_, closestMatchIdx) => Left(closestMatchIdx)
    }
  }

  println(find(Array(1, 20, 300, 4000, 50000), 301)) // = Left(2)   fail
  println(find(Array(100, 200, 300, 400, 500), 200)) // = Right(1)  ok
}
