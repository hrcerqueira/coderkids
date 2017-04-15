package com.hernani.kidlang.ast

import com.hernani.kidlang.execution.Context

/**
  * Created by hernani on 14/04/2017.
  */
trait Instruction {

  def exec(ctx: Context): Context
}

case class Assignment(variable: Variable, expression: Value) extends Instruction {
  override def exec(ctx: Context): Context =
    ctx.copy(vars = ctx.vars + (variable.name -> expression.calculate(ctx)))
}
