package chapter10

import java.awt.Point
import java.beans.{IndexedPropertyChangeEvent, PropertyChangeEvent, PropertyChangeListener, PropertyChangeListenerProxy}

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
 * task5 <Description>
 *
 * @author vadya
 */
object task5 extends App {

  val p = new Point(0, 0) with PropertyChangeSupport[Point] {
    def setX(newX: Int) = {
      val prevX = x
      x = newX
      firePropertyChange("x", prevX, newX)
    }

    def setY(newY: Int) = {
      val prevY = y
      y = newY
      firePropertyChange("y", prevY, newY)
    }
  }

  p.addPropertyChangeListener("x", new PropertyChangeListener {
    override def propertyChange(evt: PropertyChangeEvent): Unit =
      println(s"Property ${evt.getPropertyName} has changed from ${evt.getOldValue} to ${evt.getNewValue}")
  })

  p.setX(100)

  trait PropertyChangeSupport[T] {

    private val map: mutable.Map[String, ArrayBuffer[PropertyChangeListener]] = mutable.Map[String, ArrayBuffer[PropertyChangeListener]]().withDefault(s => {
      map(s) = ArrayBuffer()
      map(s)
    })

    def getPropertyChangeListeners: Array[PropertyChangeListener] = map.values.flatten.toArray

    def getPropertyChangeListeners(property: String): Array[PropertyChangeListener] = map(property).toArray

    def hasListeners(property: String): Boolean = map(property).nonEmpty

    def addPropertyChangeListener(listener: PropertyChangeListener) = listener match {
      case null =>
      case pxy: PropertyChangeListenerProxy => map(pxy.getPropertyName) += pxy.getListener
      case _ => map(null) += listener
    }

    def addPropertyChangeListener(property: String, listener: PropertyChangeListener) = listener match {
      case null =>
      case pxy: PropertyChangeListenerProxy => map(property) += pxy.getListener
      case _ => map(property) += listener
    }

    def removePropertyChangeListener(listener: PropertyChangeListener) = listener match {
      case null =>
      case pxy: PropertyChangeListenerProxy => map(pxy.getPropertyName) -= pxy.getListener
      case _ => map(null) -= listener
    }

    def removePropertyChangeListener(property: String, listener: PropertyChangeListener) = listener match {
      case null =>
      case pxy: PropertyChangeListenerProxy => map(property) -= pxy.getListener
      case _ => map(property) -= listener
    }

    def firePropertyChange(propertyName: String, oldValue: AnyRef, newValue: AnyRef) {
      if (oldValue != null && newValue != null)
        firePropertyChange(new PropertyChangeEvent(this, propertyName, oldValue, newValue))
    }

    def firePropertyChange(propertyName: String, oldValue: Int, newValue: Int) {
      firePropertyChange(new PropertyChangeEvent(this, propertyName, oldValue, newValue))
    }

    def firePropertyChange(propertyName: String, oldValue: Boolean, newValue: Boolean) {
      firePropertyChange(new PropertyChangeEvent(this, propertyName, oldValue, newValue))
    }

    def fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: AnyRef, newValue: AnyRef) {
      if (oldValue != null && newValue != null)
        firePropertyChange(new IndexedPropertyChangeEvent(this, propertyName, oldValue, newValue, index))
    }

    def firePropertyChange(event: PropertyChangeEvent) {
      if (event.getOldValue != event.getNewValue) {
        map(event.getPropertyName).foreach(_.propertyChange(event))
        map(null).foreach(_.propertyChange(event))
      }
    }

  }

}
