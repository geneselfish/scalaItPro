package chap07

object Count {

  def main(args: Array[String]): Unit = {
    require(!args.isEmpty/*args.length > 0*/)
    
    val persons = (1 until 5).map(
          args(0) match {
            case "nabe" => new Sekaino(args(0), _)
            case _ => Person(args(0), _)
          }
        )
        
    //val x = this.show _
    //persons.foreach(this.show)
        
    persons.foreach {p =>
      println(p.introduceMySelf)
      println(p.say)
    }
  }
  
  def show(person:Person) :Unit = {
    println(person.introduceMySelf)
    println(person.say)
  }

}