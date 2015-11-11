package chapter17

/**
  * Created by vadya on 11.11.15.
  */
object task10 extends App {
  class Pair[S, T](var s: S, var t: T) {
    def swap(implicit ev1: S =:= T, ev2: T =:= S) {
      val tmp = t
      t = s
      s = tmp
    }

    override def toString = s"Pair($s, $t)"
  }

  val p: Pair[String, String] = new Pair("LOL1", "LOL2")
  println(p)
  p.swap
  println(p)
}
