package chap09.app

/**
 * 列挙型の代用。
 */
object 施設区分 extends Enumeration {
  type 施設区分 = Value //typeでEnumeration.Value型に別名を付けておくと、その型名で変数を宣言できるので便利。
  
  val 第1会議室 = Value("第1会議室")
  val 第2会議室 = Value("第2会議室")
  val 第3会議室 = Value("第3会議室")
  val 講堂      = Value("講堂")
}