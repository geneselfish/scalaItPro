package chap09.app

import java.util.Date

/**
 * 
 */
class SetCandidate(date: Date, startTime: Date, endTime: Date)
       extends Candidate(date, startTime, endTime) {
  def this() = this(null, null, null)
}