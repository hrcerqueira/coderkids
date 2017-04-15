package com.hernani.kidlang.parser

import com.hernani.kidlang.KidLang
import com.hernani.kidlang.parser.ast.{InstructionParser, ValueParser, VariableParser}

/**
  * Created by hernani on 14/04/2017.
  */
class Parser(settings: KidLang) {

  private val variableParser = new VariableParser(settings)
  private val valueParser = new ValueParser(settings, variableParser)
  private val instructionParser = new InstructionParser(settings, variableParser, valueParser)

  import fastparse.all._
  import Utils._

  private val instructionWithNewLine = P (instructionParser.expression ~ whiteSpace.? ~ lineEnd.?)
  private val expression = P ( instructionWithNewLine.rep )

  def parse(code: String) = expression.parse(code)
}
