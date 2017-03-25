package example.startup.incompatible.java8

import org.junit.Test

import java.nio.file.Paths

/**
 *
 */
class TryWithResource {
  @Test
  void use_withCloseable(){
    new Scanner(Paths.get("LICENSE")).withCloseable {
      while(it.hasNext()){
        println it.next()
      }
    }
  }
}
