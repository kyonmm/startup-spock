package example.startup.spock

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 */
class SpockAnnotation extends Specification{

  @Unroll
  "whereとunrollの併用"(){
    expect:
    FizzBuzz.say(i) == expected

    where:
    i | expected
    1 | "1"
    2 | "2"
    3 | "Fizz"
  }

  @Unroll
  "#i のとき #expectedを戻す_Unrollで文字列埋めこみ"(){
    expect:
    FizzBuzz.say(i) == expected

    where:
    i | expected
    1 | "1"
    2 | "2"
    3 | "Fizz"
    4 | ""
    5 | ""
    15 | ""
  }


  def "should be ignore"(){
    expect:
    assert false, "メソッドに@Ignoreをつけて実行されないようにしましょう(spock.lang.Ignoreを使ってね!)"
  }

  def eachSpecificationDate = Calendar.getInstance()
  def eachFeatureDate = Calendar.getInstance()

  def "test1 eachSpecificationDateに@Sharedをつけると1度だけ初期化される"(){
    when:
    println eachSpecificationDate.timeInMillis
    println eachFeatureDate.timeInMillis
    then:
    eachSpecificationDate <= eachFeatureDate

    where:
    i << [1,2]
  }

}
