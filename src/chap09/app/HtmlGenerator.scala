package chap09.app

import scala.xml.{XML, Elem, Node}
import java.io.Writer
import java.util.Date
import java.text.SimpleDateFormat

class HtmlGenerator(val app: 施設利用申請書) {
  def toHtml(out: Writer) {
    val html =
<html>
<head>
<meta content="text/html; charset=utf-8" http-equiv="content-type" />
<title>施設利用申請</title>
</head>
<body>
<h1>施設利用申請</h1>

<table class="applicant" border="true">
<thead>
  <tr>
    <th>項目</th>
    <th>値</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>会員番号</td>
    <td>{app.会員番号}</td>
  </tr>
  <tr>
    <td>名前</td>
    <td>{app.名前}</td>
  </tr>
  <tr>
    <td>理由</td>
    <td>
      <ul> {
        for (reason <- app.reasons) yield <li> { reason } </li>
      }
      </ul>
    </td>
  </tr>
</tbody>
</table>

<table class="datasheet" border="true">
<caption>申請内容</caption>
<thead>
<tr>
</tr>
</thead>
<tbody> {
  var counter = 0
  for (candidate <- app.candidates.children) yield {
    <tr>
      <td>申請{counter += 1;counter}</td>
      { make_candidate(candidate) }
    </tr>
  }
}
</tbody>
</table>

</body>
</html>

    XML.write(out, html, "UTF-8", false, null)
  }

  private def make_candidate(candidate: Candidate): Elem = {
    candidate match {
      case set: SetCandidate => make_set_candidate(set)
      case facility: FacilityCandidate => make_facility_candidate(facility)
      case equipment: EquipmentCandidate => make_equipment_candidate(equipment)
      case _ => error("illegal candidate = " + candidate)
    }
  }

  private def make_set_candidate(set: SetCandidate): Elem = {
    <td>
      <table class="datasheet" border="true">
        <tr> {
          for (child <- set.children) yield make_candidate(child)
	}
        </tr>
      </table>
      {
        set.getReason match {
	  case Some(reason: Node) => <table><tr><td>{reason}</td></tr></table>
	  case None => Nil
	}
      }
    </td>
  }

  private def make_facility_candidate(facility: FacilityCandidate): Elem = {
<td>施設：{facility.facility} 
    {make_duration(facility)}{make_reason(facility)}</td>
  }

  private def make_equipment_candidate(equipment: EquipmentCandidate): Elem = {
<td>設備：{equipment.equipment}，個数：{equipment.number} 
    {make_duration(equipment)}{make_reason(equipment)}</td>
  }

  private def make_duration(candidate: Candidate) = {
    "使用日： " + format_date(candidate.effectiveDate) + "，開始時間： " + 
    format_time(candidate.effectiveStartTime) + "，終了時間： " + 
    format_time(candidate.effectiveEndTime) + ")"
  }

  private def make_reason(candidate: Candidate) = {
    candidate.getReason match {
      case Some(reason) => reason
      case None => Nil
    }
  }

  private def format_date(date: Date) = {
    val df = new SimpleDateFormat("yyyy'年'MM'月'dd'日'")
    df.format(date)
  }

  private def format_time(time: Date) = {
    val df = new SimpleDateFormat("HH'時'mm'分'")
    df.format(time)
  }
}