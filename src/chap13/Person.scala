package chap13

class Person(private var personName:String = "") {
  
  def name_=(name: String) {
    this.personName = name
  }

  def name:String = this.personName
}