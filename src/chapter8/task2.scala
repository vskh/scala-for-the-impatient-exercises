package chapter8

/**
 * task2 <Description>
 *
 * @author vadya
 */
object task2 extends App {

  class BankAccount(initialBalance: Double) {
    private var balance = initialBalance
    def currentBalance = balance
    def deposit(amount: Double) = { balance += amount; balance }
    def withdraw(amount: Double) = { balance -= amount; balance }
  }

  class SavingsAccount(initialBalance: Double, monthlyRate: Double) extends BankAccount(initialBalance) {
    private var transactionCount = 3

    def earnMonthlyInterest = {
      super.deposit(currentBalance * monthlyRate / 100)
      transactionCount = 3
    }

    override def deposit(amount: Double) = {
      if (transactionCount > 0) {
        transactionCount -= 1
        super.deposit(amount)
      } else
        super.deposit(amount - 1)
    }

    override def withdraw(amount: Double) = {
      if (transactionCount > 0) {
        transactionCount -= 1
        super.withdraw(amount)
      } else
        super.withdraw(amount + 1)
    }
  }

  println("Savings account:\n============")
  val savingsAccount = new SavingsAccount(100, 10)
  println("Initial balance: " + savingsAccount.currentBalance)
  println("Balance after deposit 10: " + savingsAccount.deposit(10))
  println("Balance after withdrawing 5: " + savingsAccount.withdraw(5))
  println("Balance after withdrawing another 5: " + savingsAccount.withdraw(5))
  println("Balance after withdrawing another 3: " + savingsAccount.withdraw(3))

  println("Earning monthly interest\n-------------")
  savingsAccount.earnMonthlyInterest

  println("Balance after deposit 10: " + savingsAccount.deposit(10))
  println("Balance after withdrawing 5: " + savingsAccount.withdraw(5))
  println("Balance after withdrawing another 5: " + savingsAccount.withdraw(5))
  println("Balance after withdrawing another 3: " + savingsAccount.withdraw(3))
}
