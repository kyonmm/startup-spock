package example.startup.groovy

import org.junit.Test

/**
 *
 */
class StringLiteral {
  @Test
  void 文字列リテラルで宣言します(){
    String actual = "文字列はなにもしなければJavaといっしょ"
    assert actual.size() == 23
  }

  @Test
  void 文字列リテラルで宣言します_結合(){
    String s1 = "front"
    String s2 = "end"
    String actual = "文字列はなにもしなければJavaといっしょ"
    assert actual.startsWith(s1)
    assert actual.endsWith(s2)
  }

  @Test
  void 文字列リテラルで宣言します_変数埋め込み(){
    String s1 = "target1"
    String s2 = "target2"
    UUID s3 = UUID.randomUUID()
    String actual = "文字列${s1}うめこみ"
    assert actual.contains(s2)
    assert actual.endsWith(s3.toString())
  }

  @Test
  void 文字列リテラルで宣言します_複数行(){
    String actual = """target"""
    assert actual == "target"

    String actual_multiline = """target
2ndline"""
    assert actual_multiline == "target\n2ndline\n3rdline"
  }

  @Test
  void 文字列リテラルで宣言します_複数行_strip(){
    String actual = """target
                       |2ndline
                       |3rdline""".stripMargin("|")
    assert actual == "target\n2ndline\n3rdline"

    String actual_multiline_strip_with_hat = """target
                                               >2ndline""".stripMargin("")
    assert actual_multiline_strip_with_hat == "target\n2ndline\n3rdline"
  }

  @Test
  void 文字列リテラルで宣言します_エスケープ不要の形式(){
    String actual = $/aaa\a/$
    assert actual == "aaa\\a"

    String actual_multiline = $/aaa\a
bbb/$
    assert actual_multiline == "aaa\\a\nbbb"

    String actual_no_escape = $/この文字列を編集して、成功させてね！/$.stripMargin("|")
    assert actual_no_escape == "aaa\\abbb\\ccc\nddd"
  }
}
