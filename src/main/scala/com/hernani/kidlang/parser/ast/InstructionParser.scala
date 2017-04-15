package com.hernani.kidlang.parser.ast

import com.hernani.kidlang.KidLang
import com.hernani.kidlang.ast.{Assignment, Instruction, Value}
import com.hernani.kidlang.parser.Utils

/**
  * Created by hernani on 14/04/2017.
  */
class InstructionParser(settings: KidLang, variableParser: VariableParser, valueParser: ValueParser) {

  import fastparse.all._
  import Utils._

  private val assignmentKeyword = StringIn(settings.assignmentKeywords:_*)

  val assignmentExpr:Parser[Assignment] = P(
    variableParser.expression.trimRight ~
      assignmentKeyword.trimRight ~
      valueParser.expression )

    .map((Assignment.apply _).tupled)

  val expression:Parser[Instruction] = P ( assignmentExpr )
}
