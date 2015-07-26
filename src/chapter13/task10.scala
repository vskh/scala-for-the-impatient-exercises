package chapter13

/**
 * task10 <Description>
 *
 * @author vadya
 */
object task10 extends App {
  val frequencies = new scala.collection.mutable.HashMap[Char, Int]
  val str = "abcabcbacacbacbabcbaccab"
  //  for (c <- str.par) {
  //    println(Thread.currentThread() + " is processing char '" + c + "'")
  //    frequencies(c) = frequencies.getOrElse(c, 0) + 1
  //  }

  // parallel run using immutable map
  val m = str.par.aggregate(Map[Char, Int]())((seq, c) => {
    seq.updated(c, seq.getOrElse(c, 0) + 1)
  }, (s1, s2) => {
    s1.map(p => (p._1, s2.getOrElse(p._1, 0) + p._2)) ++ (s2.keySet &~ s1.keySet).map(c => (c, s2(c)))
  })
  println(m)
}
