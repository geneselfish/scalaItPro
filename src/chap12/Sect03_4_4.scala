package chap12

object Sect03_4_4 {

  def main(args: Array[String]): Unit = {
    val map = Map(1 -> 10, 2 -> 20, 3 -> 30)
  }

  /**
   * ListからMapを得る定石１
   */
  def method1 = {
    //引数の型として「_*」を指定して，コレクションそのものではなくコレクションの内容を引数とするように指定する方法
    val data = List((1, 10), (2, 20), (3, 30))
    val map = Map(data: _*)
  }
  
  /**
   * ListからMapを得る定石２
   */
  def method2 = {
    val data = List(1->10, 2->20, 3->30)
    val map = Map.empty ++ data
  }
}