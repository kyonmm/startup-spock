package example.startup.groovy

import org.junit.Test

/**
 *
 */
class Number {
  @Test
  void 固定回数の繰り返しはtimes(){
    5.times{
      println it
    }
  }
  @Test
  void ある数字の範囲だけ繰り返しはupto(){
    5.upto(10){
      println it
    }

    int start = 1
    int end = 10

    start.upto(end){
      assert 3 < it
      assert it < 7
    }
  }
}
