package chap13

object Sect4 {

  def main(args: Array[String]): Unit = {
    val nationList = List(
          Nation('日本, '東京), 
          Nation('米国, 'ワシントン), 
          Nation('英国, 'ロンドン)
        )

    val cityList = List(
          City('東京, '日本, 31112000), 
          City('阪神, '日本, 15067000), 
          City('ニューヨーク, '米国, 27860000), 
          City('ワシントン, '米国, 6474000), 
          City('ロンドン, '英国, 9332000), 
          City('マンチェスター, '英国, 3851000)
        )
        
    for (nation <- nationList) {
      println("名前 = %s, 首都 = %s".format(nation.name, nation.capital))
    }
    //Scalaのfor文の真骨頂はfor yield文によるコレクションの生成にあります。以下の例では，
    //クラス国のListである国一覧から，国名と首都の対のTupleのListを生成します。
    val nationCapitalPairs =
      for (nation <- nationList) yield (nation.name, nation.capital)
    println(nationCapitalPairs)//List(('日本,'東京), ('米国,'ワシントン), ('英国,'ロンドン))
    
    val 大都市首都一覧 = Set.empty ++
      (for (city <- cityList;if city.population > 10000000;
            nation <- nationList;if nation.name == city.countryName)
        yield nation.capital.name)
    println("大都市首都一覧 = %s".format(大都市首都一覧.mkString(",")))
  }

}