package chapter15

/**
 * Created by vadya on 10.08.15.
 */
object task2 {
  @deprecated(message = "Deprecated class", since = "now")
  class AnnotationDemo @deprecated(message = "Deprecated constructor") (string: String) {
    @deprecated(message = "Deprecated method") def method(@deprecated(message = "Deprecated parameter") s: String) = {}
    @deprecated(message = "Deprecated member") val value = 1
  }
}
