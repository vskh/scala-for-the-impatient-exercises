import java.io.File
import javax.print.attribute.standard.PrinterMoreInfoManufacturer

import scala.beans.BeanProperty

/**
 * package <Description>
 *
 * @author vadya
 */
package object chapter5 extends App {
  def task1 {
    class Counter {
      private var value = 0

      def increment() {
        if (value != Int.MaxValue)
          value += 1
        else throw new IllegalStateException("Counter overflow!")
      }

      def current() = value
    }
  }

  task1

  def task2 {
    class BankAccount {
      private var current = 0.0

      def balance = current

      def deposit(amount: Double) {
        current += amount
      }

      def withdraw(amount: Double) {
        current -= amount
      }
    }

    val account = new BankAccount
    println("Bank account after create: " + account.balance)
    account.deposit(100)
    println("Bank account after deposit: " + account.balance)
    account.withdraw(50)
    println("Bank account after withdraw: " + account.balance)
  }

  task2

  def task3 {
    class Time(val hours: Int, val minutes: Int) {
      if (hours > 23 || hours < 0) throw new IllegalArgumentException("Invalid hours: " + hours)
      if (minutes > 59 || minutes < 0) throw new IllegalArgumentException("Invalid minutes: " + minutes)

      def before(other: Time) = other.hours > hours || (other.hours == hours && other.minutes > minutes)
    }

    val t1 = new Time(12, 0)
    val t2 = new Time(15, 0)
    println("t1 before t2: " + (t1 before t2))
  }

  task3

  def task4 {
    class Time(hours: Int, minutes: Int) {
      if (hours > 23 || hours < 0) throw new IllegalArgumentException("Invalid hours: " + hours)
      if (minutes > 59 || minutes < 0) throw new IllegalArgumentException("Invalid minutes: " + minutes)

      val time = hours * 60 + minutes

      def before(other: Time) = other.time > time
    }

    val t1 = new Time(12, 0)
    val t2 = new Time(15, 0)
    println("t1 before t2: " + (t1 before t2))
  }

  task4

  def task5 {
    class Student(@BeanProperty id: Int, @BeanProperty name: String)

    val s = new Student(1, "Vadym")

    import scala.sys.process._
    Process("javap -p -v -l -c package", new File("out/production/scala-for-the-impatient-exercises/chapter5")) !
  }

  task5

  def task6 {
    class Person(personAge: Int) {
      val age = if (personAge < 0) 0 else personAge
    }

    val p = new Person(-100)
    println("Negative age: " + p.age)
  }

  task6

  def task7: Unit = {
    class Person(firstNameAndLastName: String) {
      val firstName = firstNameAndLastName.split(" ")(0)
      val lastName = firstNameAndLastName.split(" ")(1)
    }

    val p = new Person("Freddie Mercury")
    println("Person: " + p.firstName + " " + p.lastName)
  }

  task7

  def task8: Unit = {
    class Car1(val manufacturer: String, val model: String, val modelYear: Int = -1, var licensePlate: String = "") {
      override def toString: String = {
        "Car1{manufacturer: " + manufacturer + ", model: " + model + ", year: " + modelYear + ", license: " + licensePlate + "}"
      }
    }

    val c11 = new Car1("testManufacturer", "testModel")
    val c12 = new Car1("testManufacturer", "testModel", 1987)
    val c13 = new Car1("testManufacturer", "testModel", 1987, "testLicence")

    println(c11, c12, c13)

    class Car2(val manufacturer: String, val model: String) {

      private var modelYear: Int = -1
      var licensePlate: String = ""

      def year = modelYear

      def this(manufacturer: String, model: String, modelYear: Int) {
        this(manufacturer, model)
        this.modelYear = modelYear
      }

      def this(manufacturer: String, model: String, modelYear: Int, licensePlate: String) {
        this(manufacturer, model, modelYear)
        this.licensePlate = licensePlate
      }

      override def toString = s"Car2($modelYear, $licensePlate, $manufacturer, $model)"
    }

    val c21 = new Car2("testManufacturer", "testModel")
    val c22 = new Car2("testManufacturer", "testModel", 1987)
    val c23 = new Car2("testManufacturer", "testModel", 1987, "testLicence")

    println(c21, c22, c23)
  }

  task8

  def task9 = {
    // implement in Java
    val javaImpl =
      """
        |public class Car {
        |    private String manufacturer;
        |    private String model;
        |    private int modelYear = -1;
        |    private String licensePlate = "";
        |
        |    public Car(String manufacturer, String model) {
        |        this.manufacturer = manufacturer;
        |        this.model = model;
        |    }
        |
        |    public Car(String manufacturer, String model, int modelYear) {
        |        this.manufacturer = manufacturer;
        |        this.model = model;
        |        this.modelYear = modelYear;
        |    }
        |
        |    public Car(String manufacturer, String model, int modelYear, String licensePlate) {
        |        this.manufacturer = manufacturer;
        |        this.model = model;
        |        this.modelYear = modelYear;
        |        this.licensePlate = licensePlate;
        |    }
        |
        |    public String getManufacturer() {
        |        return manufacturer;
        |    }
        |
        |    public String getModel() {
        |        return model;
        |    }
        |
        |    public int getModelYear() {
        |        return modelYear;
        |    }
        |
        |    public String getLicensePlate() {
        |        return licensePlate;
        |    }
        |
        |    public void setLicensePlate(String licensePlate) {
        |        this.licensePlate = licensePlate;
        |    }
        |
        |    @Override
        |    public String toString() {
        |        return "Car{" +
        |                "manufacturer='" + manufacturer + '\'' +
        |                ", model='" + model + '\'' +
        |                ", modelYear=" + modelYear +
        |                ", licensePlate='" + licensePlate + '\'' +
        |                '}';
        |    }
        |}
      """.stripMargin
    val scalaImpl = """class Car1(val manufacturer: String, val model: String, val modelYear: Int = -1, var licensePlate: String = "") {
                     |      override def toString: String = {
                     |        "Car1{manufacturer: " + manufacturer + ", model: " + model + ", year: " + modelYear + ", license: " + licensePlate + "}"
                     |      }
                     |}""".stripMargin

    println("Java implementation took " + javaImpl.split("\n").size + " lines, Scala implementation tool " + scalaImpl.split("\n").size + " lines")
  }

  task9

  def task10 = {
    // code with explicit fields takes more lines
    class Employee {
      private var name = ""
      var salary = 0.0

      def this(name: String, salary: Double) {
        this()
        this.name = name
        this.salary = salary
      }
    }
  }
}
