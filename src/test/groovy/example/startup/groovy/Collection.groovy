package example.startup.groovy

import org.junit.Test

/**
 *
 */
class Collection {
  @Test
  void Javaのforeachはeach(){
    [1,2,3].each{
      println it
    }
    List<String> actual = ["a", "b", "c"]
    actual.eachWithIndex { String entry, int i ->
      if(i == 0){
        assert entry == "a"
      }
      if(i == 1){
        assert entry == "b"
      }
      if(i == 2){
        assert entry == "c"
      }
    }
    assert actual.size() == 3
  }

  @Test
  void Javaのmapはcollect(){
    [1,2,3].collect{
      it * 2
    }.each{
      println it
    }

    List<String> actual = ["a is groovy", "b is groovy", "c is groovy"]
    actual.collect {
      it + " is groovy"
    }
    assert actual.size() == 3
    assert actual[0] == "a is groovy"
    assert actual[1] == "b is groovy"
    assert actual[2] == "c is groovy"
  }

  @Test
  void every(){
    assert [1,2,3].every{0 < it}

    List<String> actual = ["a12345", "b123456", "c1234567"]
    assert actual.size() == 3
    assert actual.every{5 < it.size()}
  }

  @Test
  void any(){
    assert [1,2,3].any{2 < it}

    List<String> actual = ["a", "1234567890","12345678901"]
    assert actual.size() == 3
    assert actual.any{10 < it.size()}
  }
  @Test
  void unique(){
    assert [1,2,3,3,3,4].unique() == [1,2,3,4]

    List<String> actual = ["a", "a", "a", "b", "c"]
    assert actual.size() == 5
    assert actual.unique().size() == 3
  }

  @Test
  void 文字列結合(){
    assert [1,2,3].join("-") == "1-2-3"
    List<String> actual = ["a", "join", "groovy"]
    assert actual.size() == 3
    assert actual.join("-") == "a-join-groovy"
  }
  @Test
  void JavaのfilterはfindAll(){
    assert [1,2,3].findAll{1 < it} == [2,3]
    List<String> actual = ["a", "b", "x", "x" ,"xy"]
    assert actual.size() == 5
    assert actual.findAll{it.contains("x")}.size() == 3
  }
  @Test
  void find(){
    println ([1,2,3].find{1 < it})
    List<String> actual = ["a", "groovy", "java"]
    assert actual.size() == 3
    assert actual.find{it.contains("y")} == "groovy"
  }
  @Test
  void collectEntryはmap生成(){
    [1,2,3].collectEntries {
      [("k$it".toString()):it]
    }.each{
      println it
    }
    List<String> actual = ["a", "b", "Groovy"]
    assert actual.size() == 3
    assert actual.collectEntries {
      [("key$it".toString()):it]
    }.keyGroovy == "Groovy"
  }
}
