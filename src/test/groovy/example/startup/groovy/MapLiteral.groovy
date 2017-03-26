package example.startup.groovy

import org.junit.Test

/**
 *
 */
class MapLiteral {
  @Test
  void マップリテラルで宣言します(){
    Map<String, Integer> actual = ["k1":1, "k2":2, "k3":3]
    assert actual.k1 == 1
    assert actual.k3 == 3
    assert actual.size() == 3
  }
  @Test
  void マップリテラルで宣言します_キーはデフォルトで文字列になる(){
    Map<String, Integer> actual = [auto_string_k1:1, auto_string_k2:2,auto_string_k3:3]
    assert actual.auto_string_k1 == 1
    assert actual.auto_string_k3 == 3
    assert actual.size() == 3
  }
  @Test
  void マップリテラルで宣言します_キーに変数を使う(){
    String k1 = "key1"
    String k2 = "key2"
    String k3 = "key3"
    Map<String, Integer> actual = [(k1):1, (k2):2, (k3):3]
    assert actual.key1 == 1
    assert actual.key3 == 3
    assert actual.size() == 3
  }
  @Test
  void マップリテラルで宣言します_入れ子(){
    Map<String, Map<String, Integer>> actual = [p1:[c1:1, c2:2, c3:3], p2:[c5:5], p3:1]
    assert actual.p1 == [c1:1, c2:2, c3:3]
    assert actual.p1.c3 == 3
    assert actual.p2.c5 == 5
    assert actual.size() == 3
  }
}
