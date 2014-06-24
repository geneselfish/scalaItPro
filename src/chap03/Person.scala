package chap03

class Person(
    var lastName:String,
    val firstName:String,
    var spouse:Person = null
    ) {
  
//  def this(lastName:String, firstName:String) {
//    this(lastName, firstName, null)
//  }
  
  def introduce():String = {
    val msg =
    "私の名前は、" + firstName + " " + lastName + "。" +
    (
    if (this.spouse == null)
        ""
    else
      " 相方の名前は、" + this.spouse.firstName + " " + this.spouse.lastName + "。"
    )
    println(msg)
    msg
  }
  
  def getMarriedTo(p:Person):Unit = {
    this.spouse = p
    p.spouse = this
//    p.lastName = this.lastName
  }
  
  def <+(p:Person):Person = {
    this.getMarriedTo(p)
    p.lastName = this.lastName
    this
  }
  
  override def toString() = {
    super.toString +
    " [氏: " + lastName + " 名: " + firstName + " 配偶者: " +
    (
        if (spouse == null)
          "なし"
        else
          " ("+ spouse.lastName + "," + spouse.firstName + ")"
    ) + "]"
  }
}
