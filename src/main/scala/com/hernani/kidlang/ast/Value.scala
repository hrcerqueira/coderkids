package com.hernani.kidlang.ast

import com.hernani.kidlang.execution.Context

/**
  * Created by hernani on 14/04/2017.
  */
trait Value {
  def calculate(ctx: Context): Value = this
}

object Nothing extends Value

case class Bool(bool: Boolean) extends Value

case class Num(num: BigDecimal) extends Value

case class Str(str: String) extends Value

case class Variable(name: String) extends Value {
  override def calculate(ctx: Context): Value = ctx.vars.get(name) match {
    case Some(value) => value
    case None => Nothing
  }
}