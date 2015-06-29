package chapter9

import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}

/**
 * task10 <Description>
 *
 * @author vadya
 */
object task10 extends App {

  val alice = new Person("Alice")
  val bob = new Person("Bob")
  val fred = new Person("Fred")
  val candice = new Person("Candice")
  val persons = Array(alice, bob, fred, candice)

  alice.addFriend(candice)
  bob.addFriend(fred)
  bob.addFriend(alice)
  candice.addFriend(fred)
  val os = new ObjectOutputStream(new FileOutputStream("persons.obj"))
  val is = new ObjectInputStream(new FileInputStream("persons.obj"))
  os.writeObject(persons)
  os.close()
  val readPersons = is.readObject().asInstanceOf[Array[Person]]
  readPersons.foreach(println)

  class Person(val name: String) extends Serializable {
    private var friends: Set[Person] = Set()

    def addFriend(p: Person) = {
      friends += p
      p.friends += this
    }

    def getFriends = friends

    def removeFriend(p: Person) = {
      friends -= p
      p.friends -= this
    }


    override def toString = s"Person($name) with friends: " + friends.map(_.name).mkString(", ")
  }

}
