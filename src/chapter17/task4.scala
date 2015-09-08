package chapter17

/**
 * task4 <Description>
 *
 * @author vadya
 */
object task4 extends App {
  class Pair[T](val first: T, val second: T) {
    def replaceFirst[R /*>: T*/](newFirst: R) = new Pair(newFirst, second)
  }

  class Person
  class Student extends Person

  val p1 = new Pair(new Student, new Student)
  p1.replaceFirst(new Person) // requires lower bound in method definition as Pair class has one type for both first and
                              // second parts thus R type of first should agree with T type of second
                              // if bound is not specified then Pair would by typed with Any, closest common supertype
                              // of two different types R and T
  val p2 = new Pair(new Person, new Person)
  p2.replaceFirst(new Student) // p2 is Pair[Person] thus both first and second can contain Students which is subtype of
                               // Person
}
