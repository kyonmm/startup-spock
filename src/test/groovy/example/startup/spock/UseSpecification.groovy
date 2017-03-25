package example.startup.spock

import spock.lang.Specification

/**
 *
 */
class UseSpecification extends Specification{
  def "Spockのテストだよ"(){
    expect:"expectはspockのラベルです"
    assert 1 == 1
  }
}

class SomeSpecification {
  def "このメソッドをテストとして動作するようにしよう"(){
    expect:"expectはspockのラベルです"
    assert 1 == 1
  }
}
