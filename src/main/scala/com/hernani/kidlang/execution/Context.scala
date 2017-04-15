package com.hernani.kidlang.execution

import com.hernani.kidlang.ast.Value

/**
  * Created by hernani on 14/04/2017.
  */
case class Context(
                  vars: Map[String, Value] = Map())
