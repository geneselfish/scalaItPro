package chap04

trait TBeforeAfter extends TAction {
  
  abstract override  def doAction {
    println("/entry before-action") //doActionの前処理
    super.doAction                 // 本来の処理doActionの呼び出し
    println("/exit after-action")   //doActionの後処理
  }

}