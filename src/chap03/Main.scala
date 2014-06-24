package chap03

object Main {

  def main(args: Array[String]): Unit = {
    val ichiro = new Person("田中", "一郎");
    ichiro.introduce();
//    println(ichoro.introduce)
    
    ichiro.spouse = new Person("田中", "花子", ichiro)
    ichiro.introduce
    ichiro.spouse.introduce

    println(ichiro)//.toString
    println(ichiro.spouse)//.toString
    println()
    
    val suzuki = new Person("鈴木", "一郎")
    val saku = new Person("谷尾", "桜子")
    println(suzuki)
    println(saku)
    println()
    suzuki <+ saku
//    takuro getMarriedTo yuri
    suzuki.introduce()
    saku.introduce()

    //    takuro.lastName = ""

//    val hanako = new Person("", "花子", ichiro)
//    hanako.introduce
//    println(hanako.introduce)
    
//    ichiro.spouse = hanako
//    ichiro.introduce
    
//    Life.marry(ichiro, ichiro)
  }

}
//http://itpro.nikkeibp.co.jp/article/COLUMN/20080820/313059/?ST=develop&P=4
