package example.startup.incompatible.java8

import org.junit.Test

import java.util.stream.Stream

/**
 *
 */
class MethodReference {
  @Test
  void method_reference(){
    Stream.of("javajo", "jjug", "kyon_mm").forEach{println it};
  }
}
