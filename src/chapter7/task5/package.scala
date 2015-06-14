package chapter7

package com {
  object ComRaiser {
    private[com] def giveRaise(rate: Double) = println("Giving raise of " + rate + "$")
  }

  object ComManager {
    def praise = ComRaiser.giveRaise(10)
    def praiseMore = ComRaiser.giveRaise(20)
  }
}

/**
 * package <Description>
 *
 * @author vadya
 */
package object task5 {
  import com._

  // private[com] limits accessibility of giveRaise to com package only.
  // ComRaiser.giveRaise(10)

  // it is useful to hide implementation details on package level so that friend classes could have extended interface
  ComManager.praise
}
