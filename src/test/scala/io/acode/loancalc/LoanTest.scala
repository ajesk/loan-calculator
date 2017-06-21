package io.acode.loancalc

import junit.framework.TestCase

/**
  * Created by aaron on 6/15/17.
  */
class LoanTest extends TestCase {
  def testInit(): Unit = {
    val loan: Loan = new Loan(1, 0)
    assert(loan != null)
    assert(loan.interest == 0)
    assert(loan.balance == 1)
  }

  def testConvertInterest(): Unit = {
    val loan1: Loan = new Loan(1, 1)
    val loan2: Loan = new Loan(1, 0)
    val loan3: Loan = new Loan(1, .01)
    assert(loan1.convertInterest() == 1.01/12)
    assert(loan2.convertInterest() == 1/12)
    assert(loan3.convertInterest() == 1.01/12)
  }

  def testApplyInterest(): Unit = {
    val loan: Loan = new Loan(100, 1)
    loan.applyInterest()
    assert(loan.balance == 101)
    val loan2: Loan = new Loan(100, 0)
    loan.applyInterest()
    assert(loan2.balance == 100)
  }

  def testMakeFullPayment(): Unit = {
    val loan: Loan = new Loan(100, 1)
    val remainingPayment = loan.makePayment(101)
    assert(remainingPayment == 0)
    assert(loan.balance == 0)
  }

  def testMakePartialPayment(): Unit = {
    val loan: Loan = new Loan(100, 1)
    val remainingPayment = loan.makePayment(1)
    assert(remainingPayment == 0)
    assert(loan.balance == 100)
  }

  def testMakeExcessPayment(): Unit = {
    val loan: Loan = new Loan(100, 0)
    val remainingPayment = loan.makePayment(101)
    assert(remainingPayment == 1)
    assert(loan.balance < 0)
  }
}
