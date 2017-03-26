package example.startup.spock

import spock.lang.Specification

/**
 *
 */
class SpockLabel extends Specification{
  def "基本となるwhen->thenの流れ"(){
    when:"最初の操作"
    def result1 = 1 + 1

    then:"最初の検証"
    result1 == 2

    when:"2回目の操作"
    def result2 = 2 + 3
    def result3 = [1,2,3].join("-")

    then:"2回目の検証"
    result2 == 5
    result3 == "1-2-3"
  }
  def "FizzBuzzの1と3の場合を動かしてみよう"(){
    when:"FizzBuzzに1を渡したとき"
    def result1 = FizzBuzz.say(1)

    then:"1が戻ってくる"
    result1 == "1"

    assert false, "3のときのテストをwhen,thenで新しく追加してね"
  }

  def "expectはwhenとthenを一度に実行する"(){
    expect:"FizzBuzzに1を渡したときは1が戻ってくる"
    FizzBuzz.say(1) == "1"

    assert false, "3のときのテストをexpectで新しく追加してね"
  }

  def "whereでパラメタライズドテストができる_expect"(){
    expect:"FizzBuzzにいろんなパターン"
    FizzBuzz.say(i) == expected

    where:
    i | expected
    1 | "1"
    2 | "edit me"
  }

  def "whereでパラメタライズドテストができる_when_then"(){
    when:"FizzBuzzにいろんなパターン"
    def actual = FizzBuzz.say(i)

    then:"FizzBuzzにいろんなパターン"
    actual == expected

    where:
    i | expected
    1 | "1"
    2 | "edit me"
  }

  def "whereでパラメタライズドテストができる_Listでもできる"(){
    when:"FizzBuzzにいろんなパターン"
    def actual = FizzBuzz.say(i)

    then:"FizzBuzzにいろんなパターン"
    actual == expected

    where:
    i << [1, 2, 3]
    expected << ["1", "edit me", "edit me"]
  }

  def "thrownでキャッチ"(){
    when:
    throw new NullPointerException()

    then:
    assert false, "thrown(NullPointerException)で例外を補足できるよ"
  }

  def "引数なしthrown()でキャッチ"(){
    when:
    throw new NullPointerException("しょうさいだよ")

    then:
    assert false, "NullPointerException ex = thrown()で投げられた例外を変数に補足できるよ"
  }

  def "notThrownで例外が投げられていないことを検査できるよ"(){
    when:
    throw new NullPointerException("例外をなげないようにしてね")

    then:
    notThrown(NullPointerException)
  }
}
