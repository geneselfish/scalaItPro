package chap07

object Main3 extends App {

  val multiply = (x:Int) => x * 2
  
  def applyFunction(f:(Int => Int), num:Int): Int = f(num)
  println(applyFunction(multiply, 5))
  
}