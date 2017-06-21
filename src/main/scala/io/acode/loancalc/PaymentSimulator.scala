package io.acode.loancalc

import scala.collection.JavaConverters._
import java.util

/**
  * Created by aaron on 6/15/17.
  */
class PaymentSimulator(var loanGrouping: LoanGrouping, val paymentAmount: Double) {
  def payWithOrder(how: String, comparative: (Loan, Loan) => Boolean) {
    var paymentsMade: Int = 0
    var payment: Double = paymentAmount
    while (!loanGrouping.isEmpty) {
      payment = paymentAmount
      loanGrouping.asScala
        .sortWith(comparative)
        .foreach(loan => {
          payment = loan.makePayment(payment)
        })
      paymentsMade += 1
      loanGrouping.cleanLoans()
    }
    exportResults(paymentsMade, paymentsMade * paymentAmount - payment, how)
  }

  def highInterestLowBalanceFirst() {
    payWithOrder("high interest low balance first", (_1, _2) => _1.interest>_2.interest || (_1.interest == _2.interest && _1.balance<_2.balance))
  }

  def highInterestHighBalanceFirst() {
    payWithOrder("high interest high balance first", (_1, _2) => _1.interest>_2.interest || (_1.interest == _2.interest && _1.balance>_2.balance))
  }

  def highBalanceFirst() {
    payWithOrder("high balance first", _.balance>_.balance)
  }

  def lowInterestFirst() {
    payWithOrder("low interest first", _.interest<_.interest)
  }

  def lowBalanceFirst() {
    payWithOrder("low balance first", _.balance<_.balance)

  }

  def equalPayments(payment: Double = paymentAmount, recurse: Boolean = false) {
    var paymentsMade: Int = 0
    var remainder: Double = 0
    while (!loanGrouping.isEmpty) {
      loanGrouping.cleanLoans()
      if (!recurse) paymentsMade += 1
      remainder = dispersePayment(payment)
    }
    if (!recurse) exportResults(paymentsMade, paymentsMade * paymentAmount - remainder, "equal payments")
  }

  def dispersePayment(payment: Double = paymentAmount): Double = {
    loanGrouping.cleanLoans()
    var remainingPayment: Double = 0
    if (loanGrouping.isEmpty) payment
    loanGrouping.asScala
      .foreach(loan => {
        remainingPayment += loan.makePayment(payment / loanGrouping.size())

      })
    if (remainingPayment >= 1)
      dispersePayment(remainingPayment)
    0
  }

  def exportResults(payments: Int, amount: Double, how: String): Unit = {
    println(how + ": " + payments + " payments for $" + "%.2f".format(amount).toDouble)
  }
}
