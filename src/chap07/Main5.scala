package chap07

object Main5 extends App {

  val appleList = (0 until 100).reverse.map(x => x match {
    case 1 => x + " apple on the wall."
    case 0 => "no apple on the wall."
    case _ => x + " apples on the wall."
  })
  appleList.foreach(println(_))
}