package chapter8

/**
 * task1 <Description>
 *
 * @author vadya
 */
object task1 extends App {

  class BankAccount(initialBalance: Double) {
    private var balance = initialBalance
    def currentBalance = balance
    def deposit(amount: Double) = { balance += amount; balance }
    def withdraw(amount: Double) = { balance -= amount; balance }
  }

  class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
    override def deposit(amount: Double) = { super.deposit(amount - 1) }
    override def withdraw(amount: Double) = { super.withdraw(amount + 1) }
  }

  println("Regular account:\n================")
  val account = new BankAccount(10)
  println("Initial balance: " + account.currentBalance)
  println("Balance after deposit 10: " + account.deposit(10))
  println("Balance after withdrawing 5: " + account.withdraw(5))

  println("Checking account:\n================")
  val checkingAccount = new CheckingAccount(10)
  println("Initial balance: " + checkingAccount.currentBalance)
  println("Balance after deposit 10: " + checkingAccount.deposit(10))
  println("Balance after withdrawing 5: " + checkingAccount.withdraw(5))
}
