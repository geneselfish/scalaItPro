package chap05

object MyFunctions {
  def foo(s: String, n: Int): Int = s.length() * n
  def bar(s: String, n: Int	): Unit = for(i <- 1 to n) print(s)
}