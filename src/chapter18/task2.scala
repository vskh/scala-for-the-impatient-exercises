package chapter18

import chapter18.task1.Bug

/**
  * Created by vadya on 12.11.15.
  */
object task2 extends App {
  object around
  object show
  object then
  class FluentBug extends Bug {
    def and(c: chapter18.task2.show.type): this.type = { show(); this }
    def and(c: then.type): this.type = this
    def turn(t: around.type): this.type = { turn(); this }
  }

  val bugsy = new FluentBug
  bugsy move 4 and show and then move 6 and show turn around move 5 and show
}
