package chap09.data

import scala.collection.mutable.ArrayBuffer
import scala.xml.Node
import chap09.app.施設利用申請書
import chap09.app.施設区分._
import chap09.app.設備区分._

case class App20090505() extends 施設利用申請書 {
  //implicit conversionにより自動的に整数値から文字列に変換されてインスタンス変数「会員番号」に格納される
  会員番号 = 123456
  名前 = "Scala太郎"
  理由(<div>Scalaの勉強会を行うため。</div>)
  理由("Liftも少し取り上げるかもしれません。")
  理由(<div><strong>Play2は必ず！！</strong></div>)

  申請 {
    施設(20090601, 1300, 1400, 講堂) 理由は <div>初日は講堂で講演したいから</div>
    同時利用(20090602, 1000, 1200) {
      施設(第1会議室)
      施設(第2会議室) 理由は "第1会議室だけだと足りないから"
      設備(ホワイトボード) 個数は 2 理由は "会議室ごとに利用"
    } 理由は """両方同時に利用希望します。片方だけだと入りきらないので。"""
  }

}