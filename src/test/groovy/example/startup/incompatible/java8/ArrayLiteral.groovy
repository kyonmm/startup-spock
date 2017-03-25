package example.startup.incompatible.java8

import org.junit.Test

/**
 *
 */
class ArrayLiteral {
  @Test
  void array_linteral(){
    int[] xs = [1,2,3] as int []
    assert xs[0] == 1
  }
}
