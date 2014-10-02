package chap09.app

import java.util.Date
import 設備区分._

class EquipmentCandidate(date: Date, startTime: Date, endTime: Date, val equipment: 設備区分)
       extends Candidate(date, startTime, endTime) {
  var number: Int = 1

  def this(equipment: 設備区分) = this(null, null, null, equipment)

  def 個数は(number: Int): Candidate = {
    this.number = number
    this
  }
}