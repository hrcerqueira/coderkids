package com.hernani.kidlang.parser.ast

import java.util.regex.Pattern

import com.hernani.kidlang.KidLang
import com.hernani.kidlang.ast._
import com.hernani.kidlang.parser.Utils

/**
  * Created by hernani on 14/04/2017.
  */
class ValueParser(settings: KidLang, variables: VariableParser) {

  import fastparse.all._
  import Utils._

  private val nullExpr = P( StringIn(settings.assignmentKeywords:_*) ).map(_ => Nothing)

  private val booleanExpr = P (StringIn(settings.trueFalseKeywords._1 ++ settings.trueFalseKeywords._2:_*).!)
    .map( b => Bool(settings.trueFalseKeywords._1.contains(b)))

  private val numberExpr = P( number.rep(1).! ~ ( CharIn(Seq(settings.decimalSeparator)) ~ number.rep ).?.! )
    .map( s => Num( BigDecimal( s"${s._1}${s._2}" ) ) )

  private val needEscapeChars = Seq(settings.stringDelimiters._2, settings.stringEscapeChar)
  private val unescapedChars = CharsWhile(c => !needEscapeChars.contains(c))

  private val strEscape = P( settings.stringEscapeChar.toString ~ CharIn(needEscapeChars ++ Seq('n', 't')).! )

  private val strChars = P(unescapedChars | strEscape)

  private val strExpr = P(settings.stringDelimiters._1.toString ~ strChars.rep.! ~ settings.stringDelimiters._2.toString)
    .map(_
      .replaceAll(escapeSequenceRegex('n'), "\n")
      .replaceAll(escapeSequenceRegex('t'), "\t")
      .replaceAll(escapeSequenceRegex(settings.stringDelimiters._2), settings.stringDelimiters._2.toString)
    )
    .map(Str)

  val expression:Parser[Value] = P( nullExpr | booleanExpr | numberExpr | strExpr | variables.expression )

  private def escapeSequence(char: Char) = s"${settings.stringEscapeChar}$char"

  private def escapeSequenceRegex(char: Char) = Pattern.quote(escapeSequence(char))
}
