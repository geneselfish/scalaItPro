package chap09.app

/**
 * 
 */
object 設備区分 extends Enumeration {
  type 設備区分 = Value
  val ホワイトボード = Value("ホワイトボード")
  val プロジェクタ = Value("プロジェクタ")
  val 無線LAN = Value("無線LAN")
}