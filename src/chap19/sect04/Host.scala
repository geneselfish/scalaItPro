package chap19.sect04

import scala.actors.Actor

case object Echo
case object Reply

/**
 *
 */
class Host(val ip : String) extends Actor {
  def act() {
    while(true) {
      receive {
        case Echo => // Echo要求が来た。
          Thread.sleep(2000) // 応答に時間がかかっているのをエミュレート
          sender ! Reply // 応答を返す
      }
    }
  }
}