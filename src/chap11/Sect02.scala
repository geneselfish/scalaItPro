package chap11

import scala.util.matching.Regex

object Sect02 {

  def main(args: Array[String]): Unit = {
    println(make_date_string_2(2014, 10, 8))//2014-10-8
    
    println(makeClass("Person", "String", "name"))
    /*
     * public Person {
     *   public String name;
     * }
     */
    
    //生文字列リテラル
    val dt = new Regex("""(\d\d\d\d)-(\d\d)-(\d\d)""")
  }
  
  def make_date_string_2(year: Int, month: Int, day: Int): String = {
    //formatメソッド
    "%s-%s-%s".format(year, month, day)
  }
  
  def makeClass(className: String, attrTypeName: String, attrName: String): String = {
    //生文字列リテラル
    """public %s {
  public %s %s;
}
""".format(className, attrTypeName, attrName)
  }

}