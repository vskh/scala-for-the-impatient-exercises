package chapter11

/**
 * task2 <Description>
 *
 * @author vadya
 */
object task2 {

  // if ** is used as pow:
  // 2 * 2 ** 3 would be treated as (2 * 2) ** 3 instead of expected 2 * (2 ** 3)
  // due to Scala operator precedence rules

  // if ^ is used as pow:
  // 2 * 2 ^ 2 would be treated as (2 * 2) ^ 2
  // 2 ^ 2 * 2 would be treated as 2 ^ (2 * 2)
}
