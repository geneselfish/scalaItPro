package chap19.sect03

import scala.actors.Actor

class Getter(val counter: Counter) extends Actor {
  def act() {
    counter ! Get // 現在値を要求して、
    receive { case c => println("got " + c) } // 応答を表示する
  }
}