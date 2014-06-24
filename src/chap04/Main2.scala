package chap04

object Main2 extends App {
  val act1 = new RealAction with TBeforeAfter
  act1.doAction
  
  println()
  val act2 = new RealAction with TBeforeAfter with TTwiceAction
  act2.doAction
  
  println()
  val act3 = new RealAction with TTwiceAction with TBeforeAfter
  act3.doAction
}