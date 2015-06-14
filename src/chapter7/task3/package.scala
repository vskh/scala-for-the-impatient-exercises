package chapter7

/**
 * package <Description>
 *
 * @author vadya
 */
package object task3 extends App {
  random.setSeed(10)
  (1 to 10) foreach (i => println(i + ": " + random.nextDouble))
  (11 to 20) foreach (i => println(i + ": " + random.nextInt))
}
