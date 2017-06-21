package io.acode.loancalc

import io.acode.loancalc.model.LoanGrouping
import io.acode.loancalc.simulator.PaymentSimulator
import io.acode.loancalc.util.LoanLoader

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
    val loanGrouping: LoanGrouping = LoanLoader.load()
    loanGrouping
  }
}
