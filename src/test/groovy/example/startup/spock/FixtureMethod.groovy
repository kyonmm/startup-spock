package example.startup.spock

import spock.lang.Specification

/**
 *
 */
class FixtureMethod extends Specification{

  def setup(){
    println "setup"
  }

  def setupSpec(){
    println "setupSpec"
  }

  def cleanup(){
    println "cleanup"
  }

  def cleanupSpec(){
    println "cleanupSpec"
  }

  def "test1"(){
    expect:
    FizzBuzz.say(1) == "1"
  }

  def "test2"(){
    // TODO これをテストとして動かしてfixtureのprintを確認しよう
  }
}
