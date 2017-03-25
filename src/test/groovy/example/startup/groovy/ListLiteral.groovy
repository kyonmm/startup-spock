package example.startup.groovy

import org.junit.Test

/**
 *
 */
class ListLiteral {
  @Test
  void リストリテラルで宣言します_数字(){
    List<Integer> actual = [1,2]
    assert actual[0] == 1
    assert actual[4] == 5
    assert actual.size() == 5
  }
  @Test
  void リストリテラルで宣言します_文字列(){
    List<String> actual = ["groovy","language"]
    assert actual[0] == "groovy"
    assert actual[4] == "cool"
    assert actual.size() == 5
  }
  @Test
  void リストリテラルで宣言します_入れ子(){
    List<List<String>> actual = [["c1.1", "c1.2"]]
    assert actual[0][0] == "c1.1"
    assert actual[1] == ["c2.1", "c2.2"]
    assert actual[2][1] == "c3.1"
    assert actual.size() == 2
  }
}
