package de.assertagile.workshop.groovy

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

import java.time.LocalDate
import java.util.regex.Pattern

import static groovy.test.GroovyAssert.shouldFail

class PersonServiceTest {

    private static final Person TODD = new Person("Todd Ler", LocalDate.now().minusDays(300))
    private static final Person TINA = new Person("Tina Acher", LocalDate.now().minusYears(18).plusDays(1), "tina.acher@assertagile.de")
    private static final Person BEAR = new Person("Bear Lee Grownup", LocalDate.now().minusYears(18), "bear.lee.grownup@assertagile.de")
    private static final Person ANDREA = new Person("Andrea Aged", LocalDate.now().minusYears(59).plusDays(100))

    @Test
    @DisplayName("getAllPersons returns empty list initially")
    void getAllPersons1() {
        // given
        PersonService service = new PersonService()

        // expect
        assert service.getAllPersons() == Set.of()
    }

    @Test
    @DisplayName("getAllPersons returns all persons added")
    void getAllPersons2() {
        // given
        PersonService service = new PersonService()
        service.addPersons(TODD, TINA, BEAR, ANDREA)

        // expect
        assert service.getAllPersons() == Set.of(TODD, BEAR, ANDREA)
    }

    @Test
    @DisplayName("findPerson returns the named person")
    void findPerson1() {
        // given
        PersonService service = new PersonService()
        service.addPersons(TODD, TINA, BEAR, ANDREA)

        // expect
        assert service.findPerson(TODD.getName()) == Optional.of(TODD)
    }

    @Test
    @DisplayName("findPerson an empty optional if name is unknown")
    void findPerson2() {
        // given
        PersonService service = new PersonService()
        service.addPersons(TODD, TINA, BEAR, ANDREA)

        // expect
        assert service.findPerson("Unknown").isEmpty()
    }

    @Test
    @DisplayName("findPersons returns all persons matching the given pattern")
    void findPersonsPattern1() {
        // given
        PersonService service = new PersonService()
        service.addPersons(TODD, TINA, BEAR, ANDREA)

        // expect
        assert service.findPersons(Pattern.compile(/^T.*$/)) == Set.of(TINA, TODD)
    }

    @Test
    @DisplayName("findPersons returns all persons with the given birthday")
    void findPersonsLocalDate1() {
        // given
        PersonService service = new PersonService()
        service.addPersons(TODD, TINA, BEAR, ANDREA)

        // expect
        assert service.findPersons(ANDREA.getBirthday()) == Set.of(ANDREA)
    }

    @Test
    @DisplayName("findPersons by object throws IllegalArgumentException")
    void findPersonsByObject() {
        // given
        PersonService service = new PersonService()
        service.addPersons(TODD, TINA, BEAR, ANDREA)
        Object regex = Pattern.compile(/^T.*$/)

        // expect
        shouldFail(IllegalArgumentException.class, { -> service.findPersons(regex) })
    }

    @Test
    @DisplayName("findPersons returns fulfilling the given predicate")
    void findPersonsByPredicate() {
        // given
        PersonService service = new PersonService()
        service.addPersons(TODD, TINA, BEAR, ANDREA)

        // expect
        assert service.findPersons({ person -> person.getName().length() > 11 }) == Set.of(BEAR)
    }

    @Test
    @DisplayName("addPerson does not add duplicates")
    void addPerson() {
        // given
        PersonService service = new PersonService()
        service.addPersons(TODD)

        // when
        service.addPersons(new Person(TODD.getName(), TODD.getBirthday()))

        // then
        assert service.getAllPersons() == Set.of(TODD)
    }
}