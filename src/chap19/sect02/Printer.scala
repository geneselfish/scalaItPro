package chap19.sect02

import scala.actors.Actor

class Printer(val msg : String) extends Actor {
  def act()	 {
     for(i <- 1 to 10)  {
      println(msg)
      Thread.sleep(2)
    }
  }
}