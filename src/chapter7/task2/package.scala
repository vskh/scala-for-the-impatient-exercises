package com {
  object ComObject {
    override def toString = s"ComObject() is at " + getClass.getPackage.getName
  }
}

package chapter7 {

package com {

object ComObject {
  override def toString = s"ComObject() is at " + getClass.getPackage.getName
}

}

  /**
   * package <Description>
   *
   * @author vadya
   */
  package object task2 extends App {
    println(com.ComObject)
    println(_root_.com.ComObject)
  }

}
