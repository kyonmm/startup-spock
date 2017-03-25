package example.startup.incompatible.java8

import org.junit.Test

import java.util.function.Predicate
import java.util.stream.Stream

/**
 *
 */
class Lambda {
  @Test
  void use_closure(){
    Predicate<String> hasJava = {s -> s.toLowerCase().contains("java")}
    assert Stream.of("javajo", "jjug", "kyon_mm").filter(hasJava).count() == 1
  }
}
