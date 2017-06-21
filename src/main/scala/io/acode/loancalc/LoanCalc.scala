package io.acode.loancalc

/**
  * Created by aaron on 6/15/17.
  */
object LoanCalc extends App {
  var loanGrouping = refreshGrouping()
  var paymentSimulator: PaymentSimulator = new PaymentSimulator(loanGrouping, 400)
  paymentSimulator.highInterestLowBalanceFirst()
  paymentSimulator.loanGrouping = refreshGrouping()
  paymentSimulator.highInterestHighBalanceFirst()
  paymentSimulator.loanGrouping = refreshGrouping()
  paymentSimulator.lowInterestFirst()
  paymentSimulator.loanGrouping = refreshGrouping()
  paymentSimulator.highBalanceFirst()
  paymentSimulator.loanGrouping = refreshGrouping()
  paymentSimulator.lowBalanceFirst()
  paymentSimulator.loanGrouping = refreshGrouping()
  paymentSimulator.equalPayments()

  def refreshGrouping(): LoanGrouping = {
    val loanGrouping: LoanGrouping = new LoanGrouping
    loanGrouping.addLoan(4730.23, 6.55)
    loanGrouping.addLoan(2731.81, 6.55)
    loanGrouping.addLoan(3939.26, 3.61)
    loanGrouping.addLoan(6830.37, 3.61)
    loanGrouping.addLoan(6666.56, 3.61)
    loanGrouping
  }
}
