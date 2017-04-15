package com.hernani.kidlang.parser.ast

import com.hernani.kidlang.KidLang
import com.hernani.kidlang.ast.{Nothing, Num, Value}
import com.hernani.kidlang.parser.Utils

/**
  * Created by hernani on 14/04/2017.
  */
class ValueParser(settings: KidLang, variables: VariableParser) {

  import fastparse.all._
  import Utils._

  private val numberExpr = P( number.rep.! ~ ( CharIn(Seq(settings.decimalSeparator)) ~ number.rep ).?.! )
    .map { s => Num( BigDecimal( s"${s._1}${s._2}" ) ) }

  private val nullExpr = P( StringIn(settings.assignmentKeywords:_*) ).map(_ => Nothing)

  val expression:Parser[Value] = P( nullExpr | variables.expression | numberExpr )

}
