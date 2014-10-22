package chap13

object Sect4 {
  
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

  def main(args: Array[String]): Unit = {
        
    for (nation <- nationList) {
      println("名前 = %s, 首都 = %s".format(nation.name, nation.capital))
    }
    //Scalaのfor文の真骨頂はfor yield文によるコレクションの生成にあります。以下の例では，
    //クラス国のListである国一覧から，国名と首都の対のTupleのListを生成します。
    val nationCapitalPairs =
      for (nation <- nationList) yield (nation.name, nation.capital)
    println(nationCapitalPairs)//List(('日本,'東京), ('米国,'ワシントン), ('英国,'ロンドン))
    
    //クラスNationのListであるnationListとクラスCityのListであるcityListから，
    //「人口が1千万人を超える都市を持つ国の首都の一覧」を作成する。
    val 大都市首都一覧 = Set.empty ++
      (for (city <- cityList;if city.population > 10000000;
            nation <- nationList;if nation.name == city.countryName)
        yield nation.capital.name)
    //このfor文の実行結果は「東京,東京,ワシントン」と東京が重複するのでSetを用いて重複を取り除いています。
    
    println("大都市首都一覧 = %s".format(大都市首都一覧.mkString(",")))
    
    method01
    
    val p = new Person("xxx")
    println(p.name)
    p.name_=("aaa")
    println(p.name)
  }
  
  /**
   * なお，for文が内部的に行っている処理を明示的に書くと以下のようになります。
   */
  def method01 = {
    val 大都市首都一覧 = Set.empty ++
      cityList.filter(_.population > 10000000)
      .flatMap(city => nationList.filter(city.countryName == _.name).map(_.capital.name))
      
    println("大都市首都一覧 = %s".format(大都市首都一覧.mkString(",")))
  }

}