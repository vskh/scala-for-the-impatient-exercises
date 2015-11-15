package chapter18

import chapter18.task4.Network

/**
  * Created by vadya on 15.11.15.
  */
object task5 extends App {
  type NetworkMember = n.Member forSome { val n: Network } // this is the same as Network#Member

  def process1(m1: NetworkMember, m2: NetworkMember) = (m1, m2) // this accepts Members of any Network
  def process2[M <: n.Member forSome { val n: Network } ](m1: M, m2: M) = (m1, m2) // this accepts single subtype M of
  // specific Member of some Network. Since M is one type, it can't be the same for Network1#Member and Network2#Member.
  // Thus it accepts members only of the same network.

  val n1 = new Network
  val m1 = n1.join("m1")
  val m2 = n1.join("m2")

  val n2 = new Network
  val m3 = n2.join("m3")

  println(process1(m1, m2)) // ok
  println(process1(m1, m3)) // ok

  println(process2(m1, m2)) // ok
  // println(process2(m1, m3)) // fail
}
