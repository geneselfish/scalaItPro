package chap12

import scala.collection.mutable

object Sect03 {

  def main(args: Array[String]): Unit = {
    val numbers = Set(1, 2, 3, 4, 5)
    val value = numbers(3)// numbers.contains(3)と同じ
    println(value)//true
    for (v <- numbers) {
      println(v)
    }
    
  }
  
  /**
   * ListからSetを得る定石１
   */
  def method1 = {
    //引数の型として「_*」を指定して，コレクションそのものではなくコレクションの内容を引数とするように指定する方法
    val data = List(1, 2, 3, 4, 5)
    val set = Set(data: _*)
  }
  
  /**
   * ListからSetを得る定石２
   */
  def method2 = {
    //
    val data = List(1, 2, 3, 4, 5)
    val set = Set.empty ++ data
  }
  
  def method3_4_3 = {
    /*
     * Setにオブジェクトを追加するためには，変更可能なSetを生成する必要があります。
     * そのためには，scala.collection.immutable.Setではなくて，scala.collection.mutable.Setを
     * 生成します。import scala.collection.mutable
     */
    val numbers = mutable.Set[Int]()
    //Setに対する値の追加，削除，値の集まりの一括追加
    numbers += 2
    numbers -= 2
    numbers ++= List(1, 2, 3, 4, 5)
    
  }

}