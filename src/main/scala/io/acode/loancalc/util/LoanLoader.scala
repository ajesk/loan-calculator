package io.acode.loancalc.util

import com.google.gson.Gson
import io.acode.loancalc.model.LoanGrouping

/**
  * Created by aaron on 6/21/17.
  */
object LoanLoader {
  val gson: Gson = new Gson()
  def load(path: String = "./src/main/resources/loans.json"): LoanGrouping = {
    gson.fromJson(scala.io.Source.fromFile(path).mkString, classOf[LoanGrouping])
  }
}
