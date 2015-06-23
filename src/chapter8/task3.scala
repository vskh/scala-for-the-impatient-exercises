package chapter8

/**
 * task3 <Description>
 *
 * @author vadya
 */
object task3 extends App {

  override def toString = s"task3()"

  abstract class Position {
    def toString: String
  }

  abstract class Shape(initialPosition: Position) {
    private var currentPosition = initialPosition

    def position: Position = currentPosition

    def move(newPosition: Position) = currentPosition = newPosition

    def draw()
  }

  abstract class Shape2D(initialPosition: Position2D = Position(0, 0)) extends Shape(initialPosition) {
    def dimensions(): (Double, Double)
  }

  abstract class Shape3D(initialPosition: Position3D = Position(0, 0, 0)) extends Shape(initialPosition) {
    def dimensions(): (Double, Double, Double)
  }

  class Rectangle(val width: Double, val height: Double) extends Shape2D {

    override def dimensions(): (Double, Double) = (width, height)

    override def draw(): Unit = println("Drawing Rectangle")
  }

  class Circle(val radius: Double) extends Shape2D {
    override def dimensions(): (Double, Double) = (2 * radius, 2 * radius)

    override def draw(): Unit = println("Drawing Circle")
  }

  class Parallelepiped(val width: Double, val height: Double, val depth: Double) extends Shape3D {
    override def dimensions(): (Double, Double, Double) = (width, height, depth)

    override def draw(): Unit = println("Drawing Parallelepiped")
  }

  class Sphere(val radius: Double) extends Shape3D {
    override def dimensions(): (Double, Double, Double) = (2 * radius, 2 * radius, 2 * radius)

    override def draw(): Unit = println("Drawing Sphere")
  }

  class Position2D(val x: Double, val y: Double) extends Position {
    override def toString = s"Position2D($x, $y)"
  }

  class Position3D(val x: Double, val y: Double, val z: Double) extends Position {

    override def toString = s"Position3D($x, $y, $z)"
  }

  object Position {
    def apply(x: Double, y: Double) = new Position2D(x, y)

    def apply(x: Double, y: Double, z: Double) = new Position3D(x, y, z)
  }

  val shapes = List(new Circle(10), new Sphere(30), new Rectangle(10, 20), new Parallelepiped(10, 20, 30))
  shapes.foreach(_.draw())
}
