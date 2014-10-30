package chap19.sect04

import scala.actors.Actor._ // actorメソッドとreceiveWithinをインポート
import scala.actors.TIMEOUT

object App {

  def main(args: Array[String]): Unit = {
    val host = new Host("192.168.0.1")
    actor { // actorメソッドでアクター作成
      host ! Echo // pingを送る
      println {
        receiveWithin(1000) { // 1秒以内に応答が欲しい
          case Reply => "alive!"  // pingが通った!
          case TIMEOUT => "no response" // タイムアウト...
        }
      }
    }
  }

}