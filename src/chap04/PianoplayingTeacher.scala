package chap04

class PianoplayingTeacher extends Person with TPianoPlayer with TTeacher {
  
  def teach {println("I'm teaching students.")} //操作teachの実装を定義

}