package chap07

object Main8 extends App {

  val list = List(1, 2, 3, 4, 5)
  println(
  list.flatMap(x => x match {
    case 3 => List(List(3.1), List(3.2), List(3.3))
    case _ => List(x * 2)
  })
  )
}