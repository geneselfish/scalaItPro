package chap09.app

import java.util.Date
import 施設区分._

class FacilityCandidate(date: Date, startTime: Date, endTime: Date, val facility: 施設区分)
       extends Candidate(date, startTime, endTime) {
  def this(facility: 施設区分) = this(null, null, null, facility)
}