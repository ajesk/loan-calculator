package io.acode.loancalc

import io.acode.loancalc.model.LoanGrouping
import junit.framework.TestCase

import scala.collection.JavaConverters._

/**
  * Created by aaron on 6/20/17.
  */
class SortTest extends TestCase {
  def testSort(): Unit = {
    val loanGrouping: LoanGrouping = new LoanGrouping
    loanGrouping.addLoan(4730.23, 6.55)
    loanGrouping.addLoan(3939.26, 3.61)
    loanGrouping.addLoan(6830.37, 3.61)
    loanGrouping.addLoan(2731.81, 6.55)
    loanGrouping.addLoan(6666.56, 3.61)
    loanGrouping.addLoan(2345678.81, 6.55)

    loanGrouping.asScala
      .sortWith((_1, _2) =>
        _1.interest>_2.interest ||
          (_1.interest == _2.interest && _1.balance<_2.balance) )
      .foreach(loan => {
        //println(loan)
      })
  }

}
