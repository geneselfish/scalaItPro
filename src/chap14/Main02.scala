package chap14

/**
 * モナドの例　Listモナド。
 * ここでのポイントは，2つの関数ともに，1つの引数に対してモナド（ここではList）が戻り値になっていることです。
 * これはMaybeモナドと一緒です。モナドらしいプログラムを書く最大のポイントは，
 * flatMapに渡せる関数を書くことです。
 * flatMapの定義はこんな感じのイメージです（実際はちょっと違いますが説明を簡単にするためにこう書いています）。
 *   def flatMap[B](f : (A) => List[B])
 * つまり，flatMapに渡すのは，Aという何らかの型の引数を取って，List（モナド）を返す関数です。
 * この条件にあった関数だと，簡単につなぎ合わせてより複雑な演算を表現することができます。
 */
object Main02 {

  def main(args: Array[String]): Unit = {
    println(expandCharClass("abc[012].{jpg,mpg}"))
    println(expandCharClass("abc3.{jpg,mpg}"))

    println(expandAltClass("abc[012].{jpg,mpg}"))
    println(expandAltClass("abc[012].mp3"))
    
    /*
     * 2つの関数はこの条件を満たしています。例によって2つの関数をflatMapでつなぎます。
     */
    println(expandAltClass("abc[123].{jpg,mpg}").flatMap(expandCharClass))
    println(expandAltClass("abc0.{jpg,mpg}").flatMap(expandCharClass))
    println(expandAltClass("abc[123].mp3").flatMap(expandCharClass))
    println(expandAltClass("abc[0].{mp3}").flatMap(expandCharClass))
  }
  
  def expandCharClass(x: String): List[String] = {
    val pattern = """(.*)\[(.*)\](.*)""".r
    
    def expandChar(x: String): List[String] = {
      val pattern(start, ext, end) = x
      ext.toList.map(start + _ + end)
    }
    
    pattern.unapplySeq(x) match {
      case Some(y) =>  expandChar(x)
      case None    =>  List()
    }
  }

  def expandAltClass(x: String): List[String] = {
    val pattern = """(.*)\{(.*)\}(.*)""".r

    def expandAlt(x: String): List[String] = {
      val pattern(start, ext, end) = x
      ext.split(',').toList.map(start + _ + end)
    }

    pattern.unapplySeq(x) match {
      case Some(y) =>  expandAlt(x)
      case None    =>  List()
    }
  }
}