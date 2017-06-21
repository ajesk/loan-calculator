package io.acode.loancalc

/**
  * Created by aaron on 6/15/17.
  */
class Loan(var balance: Double, var interest: Double) {
  def makePayment(amount: Double, interest: Boolean = true): Double = {
    if (interest) applyInterest()
    this.balance -= amount
    if (balance < 0) balance.abs
    else 0
  }

  def applyInterest(): Unit = {
    balance *= convertInterest()
  }

  def convertInterest(): Double = {
    if (interest >= 1) (interest / 100) / 12 + 1
    else if (interest == 0) 1
    else interest / 12 + 1
  }

  override def toString: String = {
    s"[ balance: $balance, interest: $interest ]"
  }
}
