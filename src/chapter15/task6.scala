package chapter15

/**
 * Created by vadya on 11.08.15.
 */
object task6 extends App {
  @volatile var boolField: Boolean = false

  new Thread { override def run = { while (!boolField) { Thread.sleep(100); println("Checking bool") }; println("Bool set") } }.start()
  new Thread { override def run = { Thread.sleep(5000); println("Setting bool"); boolField = true; } }.start()
}
