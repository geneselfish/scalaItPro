package chap19.sect03

import scala.actors.Actor

/**
 * カウンター値を内包するアクター
 */
class Counter extends Actor {
  def act()  {
    var count = 0
    while (true) {
      receive {
        case Incr =>  // カウントアップ命令を受け取ったら+1
          count += 1
          println("incremented")
        case Get =>  // 引数のアクターへ現在値を送信
          println("send " + count)
          sender ! count
        case Stop =>  // 終了命令がきたのでアクターを終了
          exit
      }
    }
  }
}