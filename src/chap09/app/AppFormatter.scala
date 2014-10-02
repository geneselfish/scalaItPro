package chap09.app

import scala.collection.mutable.ArrayBuffer
import scala.xml.Node
import java.io.FileWriter

object AppFormatter {
  def main(args: Array[String]) {
    val objectName = args(0)
    val outputFileName = args(1)
    val appClass = Class.forName(objectName)
    val app = appClass.newInstance.asInstanceOf[施設利用申請書]
    val out = new FileWriter(outputFileName)
    try {
      val generator = new HtmlGenerator(app)
      generator.toHtml(out)
    } finally {
      out.close()
    }
  }
}