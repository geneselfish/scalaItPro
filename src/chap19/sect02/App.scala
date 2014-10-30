package chap19.sect02

object App {

  def main(args: Array[String]): Unit = {
    (new Printer("abcdefg")).start
    (new Printer("hijkimn")).start
  }

}