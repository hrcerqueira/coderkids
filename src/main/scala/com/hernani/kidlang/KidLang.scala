package com.hernani.kidlang

import com.hernani.kidlang.runner.Runner

/**
  * Created by hernani on 14/04/2017.
  */
case class KidLang(
                  minVarNameLength: Int = 2,
                  assignmentKeywords: Seq[String] = Seq("is", "is a"),
                  nullKeywords: Seq[String] = Seq("nothing", "none"),
                  decimalSeparator: Char = '.',
                  stringDelimiters: (Char, Char) = ('"', '"'),
                  stringEscapeChar: Char = '\\') {

  def build = new Runner(this)
}
