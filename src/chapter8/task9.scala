package chapter8

/**
 * task9 <Description>
 *
 * @author vadya
 */
object task9 extends App {

  val ant = new Ant

  class Creature {
    // def is evaluated on every call, regular method
    val env: Array[Int] = new Array[Int](range)

    def range: Int = 10
  }

  class Ant extends Creature {
    override def range = 2 // override method to property
    // it will generate getter and private value

//    public class chapter8.task9$Ant extends chapter8.task9$Creature {
//      private final int range;
//
//      public int range();
//      Code:
//      0: aload_0
//      1: getfield      #10                 // Field range:I
//      4: ireturn

    // vs (with def)

//    public class chapter8.task9$Ant extends chapter8.task9$Creature {
//      public int range();
//      Code:
//      0: iconst_2
//      1: ireturn

    }
  println("Ant range: " + ant.range)
}
