package chapter7

/**
 * package <Description>
 *
 * @author vadya
 */
package object task9 extends App {
  import java.lang.System.getProperty

  val pass = readLine("Enter password: ")
  if (pass == "secret")
    println("Welcome, " + getProperty("user.name"))
  else
    error("Invalid password")
}
