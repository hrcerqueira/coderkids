package com.hernani.kidlang

/**
  * Created by hernani on 14/04/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {

    val runner = KidLang().build

    val code =
      """cool is true
        |
      """.stripMargin

    val result = runner.run(code)

    println(code)
    println(result)
  }
}
