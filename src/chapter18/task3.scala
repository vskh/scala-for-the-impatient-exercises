package chapter18

/**
  * task3 <Description>
  *
  * @author vadya
  */
object task3 extends App {
  object Title
  object Author

  class Document {
    private var useNextArgAs: Any = null
    private var title: String = null
    private var author: String = null

    def set(obj: Title.type): this.type = { useNextArgAs = obj; this }
    def set(obj: Author.type): this.type = { useNextArgAs = obj; this }
    def to(arg: String): this.type = {
      if (useNextArgAs == Title) {
        title = arg
      } else if (useNextArgAs == Author) {
        author = arg
      }

      this
    }
  }

  val book = new Document
  book set Title to "Scala for the Impatient" set Author to "Cay Horstmann"
}
