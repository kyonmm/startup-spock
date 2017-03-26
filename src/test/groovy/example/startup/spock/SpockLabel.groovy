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

    when:"FizzBuzzに3を渡したとき"
    def result2 = FizzBuzz.say(3)

    then:"Fizzが戻ってくる"
    result2 == "Fizz"
  }

  def "expectはwhenとthenを一度に実行する"(){
    expect:"FizzBuzzに1を渡したときは1が戻ってくる"
    FizzBuzz.say(1) == "1"
    FizzBuzz.say(3) == "Fizz"
  }

  def "whereでパラメタライズドテストができる_expect"(){
    expect:"FizzBuzzにいろんなパターン"
    FizzBuzz.say(i) == expected

    where:
    i | expected
    1 | "1"
    2 | "2"
  }

  def "whereでパラメタライズドテストができる_when_then"(){
    when:"FizzBuzzにいろんなパターン"
    def actual = FizzBuzz.say(i)

    then:"FizzBuzzにいろんなパターン"
    actual == expected

    where:
    i | expected
    1 | "1"
    2 | "2"
  }

  def "whereでパラメタライズドテストができる_Listでもできる"(){
    when:"FizzBuzzにいろんなパターン"
    def actual = FizzBuzz.say(i)

    then:"FizzBuzzにいろんなパターン"
    actual == expected

    where:
    i << [1, 2, 3]
    expected << ["1", "2", "Fizz"]
  }

  def "thrownでキャッチ"(){
    when:
    throw new NullPointerException()

    then:
    thrown(NullPointerException)
  }

  def "引数なしthrown()でキャッチ"(){
    when:
    throw new NullPointerException("しょうさいだよ")

    then:
    NullPointerException ex = thrown()
    ex.message == "しょうさいだよ"
  }

  def "notThrownで例外が投げられていないことを検査できるよ"(){
    when:
    def a = 1

    then:
    notThrown(NullPointerException)
  }
}
