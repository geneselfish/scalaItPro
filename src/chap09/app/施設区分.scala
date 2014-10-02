package chap09.app

/**
 * 
 */
object 施設区分 extends Enumeration {
  type 施設区分 = Value
  val 第1会議室 = Value("第1会議室")
  val 第2会議室 = Value("第2会議室")
  val 第3会議室 = Value("第3会議室")
  val 講堂 = Value("講堂")
}