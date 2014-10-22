package chap14

object Main01 {
  
  val config = Map("database" -> List(("path",      "/var/app/db"),
                                       ("encoding", "euc-jp" )
                                  ),
                   "urlmapper" -> List(("cgiurl",  "/app"),
                                       ("rewrite", "True")
                                  ),
                   "template" -> List(("path", "/var/app/template"))
               )

  def main(args: Array[String]): Unit = {
    /*
     * Maybeモナド
     * モナドの場合は，「演算をつなぎ合わせる」という発想をします。
     * この場合，「"database"を検索する」演算と「"encording"を検索する」演算をつなぎ合わせることが，
     * Option型を戻す演算（Some/Noneが帰ってくる演算）だと可能になります。
     * 実際のコーディングでは、「flatMap」というメソッドを使って演算をつないでいきます。
     * ここでのflatMapの動きは，congig.get("database") の結果はSome(値)もしくはNoneが帰ってきますが，
     * Noneだったら，次の演算をせずNoneを返却して，Some(値)だったら値に対して，
     * 引数の関数（_.find(x=> …)を適用する動きをします。
     */
    
    println(
      show(config.get("database").flatMap(_.find(_._1 == "encoding")))
    )
    println(
      show(config.get("database").flatMap(_.find(_._1 == "oo")))
    )
    println(
      show(config.get("oo").flatMap(_.find(_._1 == "encoding")))
    )
  }
  
  private def show(x: Option[(String, String)]) = x match {
    case Some(y) => y._2
    case None    => "Nothing!"
  }

}