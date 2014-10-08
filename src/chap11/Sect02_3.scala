package chap11

object Sect02_3 {

  def main(args: Array[String]): Unit = {
    //StringクラスにRegexに変換するrメソッドが追加されているので，これを利用するとより
    //簡単にRegexオブジェクトを取得することができます。
    val dt = """(\d\d\d\d)-(\d\d)-(\d\d)""".r
    /*
     * rメソッドを使う場合，Scalaの型推論機能の効果もありscala.util.matching.Regexを
     * importしておく必要はありません。また，わずかですが「Regex」という文字を打ち込
     * む手間も省いています。
     */
    //extractor
    //変数year，month，dateに文字列から抽出した年，月，日を代入(束縛)する
    val dt(year, month, date) = "2009-07-08"
    println(year)//2009
    println(month)//07
    println(date)//08
  }

}