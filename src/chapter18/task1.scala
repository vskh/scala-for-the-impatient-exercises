package chapter18

/**
  * Created by vadya on 12.11.15.
  */
object task1 extends App {
  class Bug(private var pos: Int = 0, private var direction: Int = 1) {
    def move(distance: Int): this.type = { pos += direction * distance; this }
    def turn(): this.type = { direction = -direction; this }
    def show(): this.type = { print(s"$pos "); this }
  }

  val bugsy = new Bug
  bugsy.move(4).show().move(6).show().turn().move(5).show()
}
