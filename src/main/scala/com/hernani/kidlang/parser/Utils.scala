package com.hernani.kidlang.parser

import fastparse.all.{Parser => FP, _}

import scala.language.implicitConversions

/**
  * Created by hernani on 14/04/2017.
  */
object Utils {

  private val lowerCaseLettersSeq = 'a' to 'z'
  private val upperCaseLettersSeq = 'A' to 'Z'
  private val numbersSeq = '0' to '9'

  val lowerCaseLetter = CharIn(lowerCaseLettersSeq)
  val upperCaseLetter = CharIn(upperCaseLettersSeq)
  val anyCaseLetter = CharIn(lowerCaseLettersSeq ++ upperCaseLettersSeq)
  val number = CharIn(numbersSeq)
  val letterOrNumber = CharIn(lowerCaseLettersSeq ++ upperCaseLettersSeq ++ numbersSeq)

  val whiteSpace = CharIn( Seq(' ', '\t')).rep
  val lineEnd = CharIn(Seq('\r', '\n')).rep

  implicit def toCharacterUtils[T](parser: FP[T]): Utils[T] = new Utils(parser)

}

class Utils[T](parser: FP[T]) {

  def trimRight: FP[T] = P( parser ~ Utils.whiteSpace.? )

}
