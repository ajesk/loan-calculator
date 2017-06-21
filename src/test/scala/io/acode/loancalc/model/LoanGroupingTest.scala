package io.acode.loancalc.model

import junit.framework.TestCase

/**
  * Created by aaron on 6/15/17.
  */
class LoanGroupingTest extends TestCase {
  def testInit(): Unit = {
    val loanGrouping = new LoanGrouping
    assert(loanGrouping != null)
  }

  def testAddLoan(): Unit = {
    val loanGrouping: LoanGrouping = new LoanGrouping
    loanGrouping.addLoan(100, 1)
    assert(loanGrouping.size() == 1)
  }

  def testMaxInterest(): Unit = {
    val loanGrouping: LoanGrouping = new LoanGrouping
    loanGrouping.addLoan(100, 1)
    loanGrouping.addLoan(100, 2)
    loanGrouping.addLoan(100, 3)
    assert(loanGrouping.maxInterest() == 3)
  }

  def testMinInterest(): Unit = {
    val loanGrouping: LoanGrouping = new LoanGrouping
    loanGrouping.addLoan(100, 1)
    loanGrouping.addLoan(100, 2)
    loanGrouping.addLoan(100, 3)
    assert(loanGrouping.minInterest() == 1)
  }

  def testCleanLoans(): Unit = {
    val loanGrouping: LoanGrouping = new LoanGrouping
    loanGrouping.addLoan(-1, 1)
    loanGrouping.addLoan(100, 2)
    loanGrouping.addLoan(0, 3)
    loanGrouping.cleanLoans()
    assert(loanGrouping.size() == 1)
    assert(loanGrouping.get(0).balance == 100)
  }
}
