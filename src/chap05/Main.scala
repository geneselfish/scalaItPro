package chap05

object Main extends App {
  
  def foo(s:String, n:Int): Int = s.length * n  
  println(foo("豆蔵太郎", 3))

  def bar(s:String, n:Int): Unit = for(i <- 1 to n) print(s)
  bar("あいう", 5)
  println()
  
  val bar1 = (s:String, n:Int) => for(i <- 1 to n) print(s) 
  
  val ssize = {(s:String) => s.length()}
  println(ssize("xyz"))
  
  val ssize1 = (_:String).length()
  println(ssize1("あいう"))
  
  val plus = (_:Int) + (_:Int)
  println(plus(3, 4))
}

//def foo(s:String, n:Int): Int = s.length * n