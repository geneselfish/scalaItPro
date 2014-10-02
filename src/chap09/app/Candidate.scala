package chap09.app

import scala.collection.mutable.ArrayBuffer
import scala.xml.Node
import java.util.Date
import 施設区分._
import 設備区分._

/**
 * @author 1134310008768
 *
 */
abstract class Candidate(val date: Date, val startTime: Date, val endTime: Date) {
  var parent: Candidate = _
  val children = new ArrayBuffer[Candidate]
  private var _reason: Node = null

  def reason: Node = {
    if (this._reason == null) <div></div>
    else this._reason
  }

  def reason_=(reason: Node) = {
    this._reason = reason
  }

  def getReason: Option[Node] = {
    if (this._reason != null) Some(this._reason)
    else None
  }

  def this() = this(null, null, null)

  def addChild(child: Candidate): Candidate = {
    child.parent = this
    this.children += child
    child
  }

  def effectiveDate: Date = {
    if (date != null) date
    else if (parent != null) parent.effectiveDate
    else error("no date")
  }

  def effectiveStartTime: Date = {
    if (startTime != null) startTime
    else if (parent != null) parent.effectiveStartTime
    else error("no startTime")
  }

  def effectiveEndTime: Date = {
    if (endTime != null) endTime
    else if (parent != null) parent.effectiveEndTime
    else error("no endTime")
  }

  def 理由は(reason: Node): Candidate = {
    this.reason = reason
    this
  }

}