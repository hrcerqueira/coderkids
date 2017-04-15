package com.hernani.kidlang.runner

import com.hernani.kidlang.KidLang
import com.hernani.kidlang.parser.Parser

/**
  * Created by hernani on 14/04/2017.
  */
class Runner(settings: KidLang) {

  private val parser = new Parser(settings)





  /*private val assigmentKeyword = StringIn(settings.assignmentKeywords:_*)

  private val assignment = P( variable ~ whiteSpace.? ~ assigmentKeyword ~ whiteSpace.? ~ expression )

  private val block = P( assignment )

  private val program = P( block.rep )*/

  def run(code: String) = {
    parser.parse(code)
  }
}
