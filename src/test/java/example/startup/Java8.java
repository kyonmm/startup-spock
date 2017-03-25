package example.startup;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.junit.Test;

public class Java8 {
  @Test
  public void try_with_resource(){
    try(Scanner i = new Scanner(Paths.get("./LICENSE"))){
      while(i.hasNext()){
        System.out.println(i.next());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  @Test
  public void lambda(){
    Predicate<String> hasJava = s -> s.toLowerCase().contains("java");
    assert Stream.of("javajo", "jjug", "kyon_mm").filter(hasJava).count() == 1;
  }

  @Test
  public void method_reference(){
    Stream.of("javajo", "jjug", "kyon_mm").forEach(System.out::println);
  }

  @Test
  public void array_linteral(){
    int[] xs = new int[]{1,2,3};
    assert xs[0] == 1;
  }
}
