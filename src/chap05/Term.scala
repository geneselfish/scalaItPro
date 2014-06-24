package chap05

abstract class Term {

}

case class N(v: Int) extends Term

case class Add(l: Term, r: Term) extends Term

case class Mult(l: Term, r: Term) extends Term
