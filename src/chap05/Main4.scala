package chap05

object Main4 extends App {
  //パターンマッチ。caseクラス
  println("★パターンマッチ。caseクラス")
  val man = Person("豆蔵太郎")
  man match {
    case Person(ns) => println("人: " + ns)
    case _ => println("その他: 何か")
  }
  // → 人: 豆蔵太郎　※コンストラクタ変数を取り出せる。
  
  
  def eval(t: Term): Int = t match {
    case N(v) => v
    case Add(l, r) => eval(l) + eval(r)
    case Mult(l, r) => eval(l) * eval(r)
  }
  println(eval(Mult(N(2), Add(N(3), N(4)))))
  
  println()
  println("★forとパターンマッチ。")
  val list = List((1, "a"), (2, "b"), (3, "c"), (1, "z"), (1, "a"))
  println(for( (1, x) <- list) yield (1, x))
  println(for( (1, "a") <- list) yield (1, "a"))
  
  val list2 = List(Some(1), None, Some(3), None, Some(5))
  for(Some(v) <- list2) println(v)
  
  println()
  val list3 = List(1, "two", Some(3), 4, "five", 6.0, 7)
  for(x <- list3) x match {
    case x:Int => println("integer " + x)
    case s:String => println("String " + s)
    case Some(x) => println("some " + x)
    case _ => println("else " + x)
  }
  
}