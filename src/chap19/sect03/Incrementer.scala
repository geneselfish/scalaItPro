package chap19.sect03

import scala.actors.Actor

/**
 *
 */
class Incrementer(val counter: Counter) extends Actor {
  def act() {
    counter ! Incr // カウントアップだけして終了
  }
}