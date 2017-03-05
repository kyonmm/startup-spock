package example.startup

import spock.lang.Specification

class WhenSteppingOut extends Specification {
    def "someLibraryMethod returns true"() {
        given:
        def lib = new SomeLibrary()

        when:
        def result = lib.someLibraryMethod()

        then:
        result == true

        // and:
        // result == false
    }
}
