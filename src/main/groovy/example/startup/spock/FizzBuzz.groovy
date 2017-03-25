package example.startup.spock

class FizzBuzz {
  static say(int i){
    if(i % 15 == 0)
      return "FizzBuzz"
    if(i % 3 == 0)
      return "Fizz"
    if(i % 5 == 0)
      return "Buzz"
    return i.toString()
  }
}
