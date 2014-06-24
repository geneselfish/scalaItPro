package chap07

case class Person(val name:String, val num:Int) {

  def say(): String = "[" +  this.num + "] "
  
  def introduceMySelf(): String = "わたしの名前は" + this.name
}

class Sekaino(override val name: String, override val num: Int) extends Person(name, num) {
  
  override def say(): String = this.num match {
       case 3 => "[さぁ～ん]"
       case _ => super.say
     }
}