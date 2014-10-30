package chap19.sect03

abstract class OP // Counterアクターが受け取るメッセージの型
case object Incr extends OP  // カウントアップ操作
case object Get extends OP  // 現在値の取得. 引数のアクターへ応えを返す
case object Stop extends OP // アクターの停止
