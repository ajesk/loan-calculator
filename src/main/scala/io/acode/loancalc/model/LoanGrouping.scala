package io.acode.loancalc.model

import java.util

import scala.collection.JavaConverters._

/**
  * Created by aaron on 6/15/17.
  */
class LoanGrouping extends util.ArrayList[Loan] {
  //var loans: util.List[Loan] = new util.ArrayList[Loan]()
  var paymentAmount: Double = _

  def addLoan(balance: Double, interest: Double): Unit = {
    add(new Loan(balance, interest))
  }

  def maxInterest(): Double = {
    this.asScala.map(_.interest).max
  }

  def minInterest(): Double = {
    this.asScala.map(_.interest).min
  }

  def cleanLoans(): Unit = {
    val tmpList: util.List[Loan] = this.asScala.filter(_.balance > 0).asJava
    this.clear()
    this.addAll(tmpList)
  }
}
