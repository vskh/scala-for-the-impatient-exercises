package chapter10

/**
 * task7 <Description>
 *
 * @author vadya
 */
object task7 extends App {

  trait Transport {
    val maxCargo: Int

    def transport(): String

    def move(cargoWeight: Int, from: String, to: String) =
      if (cargoWeight < maxCargo)
        println(s"$transport $cargoWeight kg from $from to $to")
      else
        println(s"Can $transport not more than $maxCargo kg")
  }

  trait SeaTransport extends Transport {
    override def transport(): String = "Sailing"
  }

  trait AutoTransport extends Transport {
    override def transport(): String = "Riding"
  }

  trait AviaTransport extends Transport {
    override def transport(): String = "Flying"
  }

  class Plane extends AviaTransport {
    val maxCargo = 100
  }

  val p = new Plane

  p.move(101, "Sydney", "Los-Angeles")
  p.move(99, "Sydney", "Los-Angeles")
}
