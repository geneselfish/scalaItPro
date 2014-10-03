package chap09.app

import scala.collection.mutable.ArrayBuffer
import scala.xml.Node
import java.util.Date
import java.text.SimpleDateFormat
import 施設区分._
import 設備区分._

class 施設利用申請書 {
  var 会員番号: String = ""
  var 名前: String = ""
  val reasons = new ArrayBuffer[Node]
  val candidates = new RootCandidate()
  private var current: Candidate = null

  def 理由(reason: Node) {
    reasons += reason
  }

  def 申請(candidate: => Unit) {
    current = candidates
    candidate
    current = null
  }

  def 同時利用(candidate: => Unit): SetCandidate = {
    val child = new SetCandidate()
    current.addChild(child)
    current = child
    candidate
    current = child.parent
    child
  }

  def 同時利用(date: String, startTime: String, endTime: String)
               (candidate: => Unit): SetCandidate = {
    val child = new SetCandidate(to_date(date), to_time(startTime), to_time(endTime))
    current.addChild(child)
    current = child
    candidate
    current = child.parent
    child
  }
  
  def 施設(facility: 施設区分): FacilityCandidate = {
    val child = new FacilityCandidate(facility)
    current.addChild(child)
    child
  }
  
  def 施設(date: String, startTime: String, endTime: String, facility: 施設区分): FacilityCandidate = {
    val child = new FacilityCandidate(to_date(date), to_time(startTime), to_time(endTime), facility)
    current.addChild(child)
    child
  }

  def 設備(equipment: 設備区分): EquipmentCandidate = {
    val child = new EquipmentCandidate(equipment)
    current.addChild(child)
    child
  }
  
  def 設備(date: String, startTime: String, endTime: String, equipment: 設備区分): EquipmentCandidate = {
    val child = new EquipmentCandidate(to_date(date), to_time(startTime), to_time(endTime), equipment)
    current.addChild(child)
    child
  }
  
  private def to_date(string: String): Date = {
    val df = new SimpleDateFormat("yyyyMMdd")
    df.parse(string)
  }

  private def to_time(string: String): Date = {
    val df = new SimpleDateFormat("HHmm")
    df.parse(string)
  }

  /**
   * implicit conversion
   * String型のデータが必要な所にInt型のデータがきたら自動的に呼ばれる関数
   */
  implicit def intToString(value: Int): String = value.toString
  /**
   * scala.xml.Node型のデータが必要な所にString型のデータがきたら自動的に呼ばれる関数
   */
  implicit def stringToNode(value: String): Node = <div>{value}</div>
}