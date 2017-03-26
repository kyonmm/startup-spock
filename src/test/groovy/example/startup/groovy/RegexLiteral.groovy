package example.startup.groovy

import org.junit.Test

import java.util.regex.Pattern

/**
 *
 */
class RegexLiteral {
  @Test
  void 正規表現比較用の演算子を使います(){
    assert "target-string" ==~ /target.+/
    assert "日本語でOK" ==~ /日本語でOK/

    String s1 = "variable"
    assert "target-variable-string" ==~ /target-${s1}-string/
  }
  @Test
  void 正規表現比較用の演算子を使います_キャプチャ(){
    String target = "-a--b--c--d--e-"
    int counter = 0
    target.eachMatch(/-(.)-/){whole, capture ->
      counter++
      println whole
      println capture
    }
    assert counter == 5
  }
}
