package chapter17

/**
 * task7 <Description>
 *
 * @author vadya
 */
object task7 extends App {
  // main method that is required by Iterable[T] is iterator: Iterator[T]
  // T participates in return type - covariant position

   class Animal {
     var name: String = "Unknown"

     def this(name: String) = {
       this()
       this.name = name
     }
     override def toString = s"Animal($name)"
   }
   class Dog(name: String) extends Animal(name)

   val di: Iterable[Dog] = Array(new Dog("Dobby"), new Dog("Bobby"), new Dog("Fido"))

   def processAnimals(ai: Iterable[Animal]) = {
     val it = ai.iterator

     while (it.hasNext) {
       println(it.next())
     }
   }

  processAnimals(di) // since Dog is subtype of Animal this call is possible
}
