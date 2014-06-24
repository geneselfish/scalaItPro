package chap04

object Main extends App {

  val t1 = new PianoplayingTeacher
  t1.playPiano
  t1.teach

  val taro = new Person with TPianoPlayer with TTeacher {
    def teach { println("I'm teaching students!!") }
  }
  taro.teach
  taro.playPiano
}