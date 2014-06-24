package chap05

object Main3 extends App {
  // メソッドを変数に束縛
  val f1 = MyFunctions.foo _
  
  println(f1("かきくけこ", 3))
  println()
  
  // 高階関数
  val list = List("あ", "Scala", "関数型", "言語")
  list.foreach( e => println(e) )
  //引数を１個だけ渡すメソッド呼び出しでは、引数を囲む括弧を中括弧に変えてもよい。
  list.foreach { e => println(e) }
  println()
  //プレースホルダー構文
  list.foreach { println(_) }
  println()

  val l1 = list map {s => s + "!"}
  println(l1)
  val l2 = l1 map {_ + "!!"}
  println(l2)
  
  println("\n★パターンマッチ")
  // パターンマッチ
  val value: Any = "文字列"
  def mtc(v: Any): Unit = {
    v match {
      case null => println("null!")
      case i: Int => println("Int: " + i)
      case s: String => println("String: " + s)
      case _ => println("その他：　何か")
    }
  }
  mtc(value)
  
  val mame = new Person("豆蔵太郎")
  mtc(mame)
  
}