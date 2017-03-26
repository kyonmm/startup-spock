package example.startup.groovy

import org.junit.Test

/**
 *
 */
class Keyword {
  @Test
  void 変数宣言の型名はdefでObjectとだいたい一緒になる(){
    String a = "str"
    def b = "str" // IntelliJ だとこれをいいかんじに型推論してくれる
    assert a == b

    int x = 1
    def y = 1
    assert x == y
  }

  @Test
  void メソッド宣言の型名はdefでObjectとだいたい一緒になる(){
    assert 1 == someMethod()
    assert "new-method" == newMethod()
  }

  def someMethod(){// IntelliJ だとこれをいいかんじに型推論してくれる
    return 1
  }

  def newMethod(){
    return "new-method"
  }

  @Test
  void "メソッド名は文字列で宣言できる"(){
    assert "1みたいな数字ではじまっても大丈夫だよ"() == "test"
  }

  def "1みたいな数字ではじまっても大丈夫だよ"(){
    return "test"
  }
}
