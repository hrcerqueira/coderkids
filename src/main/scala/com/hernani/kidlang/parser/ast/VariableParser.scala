package com.hernani.kidlang.parser.ast

import com.hernani.kidlang.KidLang
import com.hernani.kidlang.ast.Variable
import com.hernani.kidlang.parser.Utils

/**
  * Created by hernani on 14/04/2017.
  */
class VariableParser(settings: KidLang) {

  import fastparse.all._
  import Utils._

  val expression:Parser[Variable] = P( (lowerCaseLetter ~ anyCaseLetter.rep(settings.minVarNameLength - 1)).! )
    .map(Variable)


}
