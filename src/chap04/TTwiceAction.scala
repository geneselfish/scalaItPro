package chap04

trait TTwiceAction extends TAction {
  
  abstract override  def doAction {
    for(i <- 1 to 2) {
      super.doAction
      println(" ==> No." + i )
    }
  }

}