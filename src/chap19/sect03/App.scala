package chap19.sect03

object App {

  def main(args: Array[String]): Unit = {
    val counter = new Counter // カウンターアクターの作成
    counter.start
    for(i <- 1 to 10 ) {  // それぞれ生成して始動. 10回繰り返す
      (new Incrementer(counter)).start 
      (new Getter(counter)).start
    }
    Thread.sleep(10)
    counter ! Stop // 最後に停止を送って終了
  }

}