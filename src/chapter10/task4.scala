package chapter10

/**
 * task4 <Description>
 *
 * @author vadya
 */
object task4 extends App {

  trait Logger {
    def log(msg: String)

    def info(msg: String) {
      log("INFO: " + msg)
    }

    def warn(msg: String) {
      log("WARN: " + msg)
    }

    def severe(msg: String) {
      log("SEVERE: " + msg)
    }
  }

  trait CryptoLogger extends Logger {
    val key = 3

    override def log(msg: String): Unit = {
      println(msg.map(c => (c + key).toChar))
    }
  }

  val myobj = new Object with CryptoLogger

  myobj.log("Hello, world!")

  val myobj2 = new Object with CryptoLogger {
    override val key = -3
  }

  myobj2.log("Hello, world!")
}
