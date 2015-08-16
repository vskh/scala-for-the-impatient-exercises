package chapter15

import org.junit.Test
import org.junit.Assert._
import org.hamcrest.core.IsEqual._
import org.hamcrest.core.IsNot._
import org.junit.runner.RunWith

/**
 * task1 <Description>
 *
 * @author vadya
 */
class task1 {

  def sum(args: Int *) = args.sum

  @Test
  def testWithoutParams = {
    assertThat("Sum of zeros is zero", sum(0, 0, 0, 0, 0), equalTo(0))
    assertThat("Sum of 1, 2, 3 is 6", sum(1, 2, 3), equalTo(6))
  }

  @Test(timeout = 1000)
  def testWithTimeout = {
    Thread.sleep(800)
    assertThat("Sum of ten ones is not eleven", sum(1, 1, 1, 1, 1, 1, 1, 1, 1, 1), not(equalTo(11)))
  }

  @Test(expected = classOf[Exception])
  def testWithException: Unit = {
    throw new Exception("Test exception")
  }
}
