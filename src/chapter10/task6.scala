package chapter10

/**
 * task6 <Description>
 *
 * @author vadya
 */
object task6 extends App {
  trait Component
  trait JComponent extends Component
  trait Container extends Component
  trait JContainer extends Container with JComponent

  class JButton extends JComponent // button is not container
  class JPanel extends JContainer // panel is both container and component
}
