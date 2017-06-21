package io.acode.loancalc.util

import io.acode.loancalc.model.LoanGrouping
import junit.framework.TestCase

/**
  * Created by aaron on 6/21/17.
  */
class LoanLoaderTest extends TestCase {
  def testLoad() {
    val loanGrouping: LoanGrouping = LoanLoader.load("./src/test/resources/loans.json")
    assert(loanGrouping.size() == 5)
  }
}
