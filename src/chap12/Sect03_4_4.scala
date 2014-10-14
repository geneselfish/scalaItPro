package chap12

import scala.collection.mutable

object Sect03_4_4 {

  def main(args: Array[String]): Unit = {
    val numbers = Map(1 -> 10, 2 -> 20, 3 -> 30)
    val value = numbers(3)
    println(value)//30
    //ただし，この場合は指定した鍵が存在しない場合にはjava.util.NoSuchElementException例外となります。
    //鍵/値対がない場合にも使用するには，鍵/値対がない場合の対応を織り込んだ処理をする必要があります。
    //まずgetメソッドを使い復帰値で返されるOptionをmatch文で判定する方法があります。
    numbers.get(9) match {
      case Some(x) => println("x is %d".format(x))
      case None =>    println("x is None")
    }
    //また，鍵/値対が存在しない場合にはデフォルト値を用いてよいのであれば，getOrElseメソッドを用いるとよいでしょう。
    //以下の例では，鍵「9」に対応する値がある場合にはその値を，対応する値がない場合には「0」が返されます。
    val num = numbers.getOrElse(9, 0)
    
    //Map内の内容一覧はfor文を使ってアクセスします。この時，以下のようにして鍵と値をそれぞれ別の変数に
    //取り出すことができます。
    for ((key, value) <- numbers) {
      println("%d is %d".format(key, value))
    }
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
  
  /**
   * Mapに鍵/値対を追加するためには，変更可能なMapを生成する必要があります。そのためには，
   * scala.collection.immutable.Mapではなくて，scala.collection.mutable.Mapを生成します。
   */
  def method3_4_6 = {
    val numbers = mutable.Map[Int, Int]()
    numbers += 9->90
    numbers ++= List(1->10, 2->20, 3->30)
    numbers -= 2
  }
}