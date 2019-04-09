package de.assertagile.workshop.groovy

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

import java.time.LocalDate
import java.util.function.Predicate

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
        assert service.allPersons == [] as Set
    }

    @Test
    @DisplayName("getAllPersons returns all persons added")
    void getAllPersons2() {
        // given
        PersonService service = new PersonService()
        service.addPersons(TODD, TINA, BEAR, ANDREA)

        // expect
        assert service.allPersons == [TODD, TINA, BEAR, ANDREA] as Set
    }

    @Test
    @DisplayName("findPerson returns the named person")
    void findPerson1() {
        // given
        PersonService service = new PersonService()
        service.addPersons(TODD, TINA, BEAR, ANDREA)

        // expect
        assert service.findPerson(TODD.name) == Optional.of(TODD)
    }

    @Test
    @DisplayName("findPerson an empty optional if name is unknown")
    void findPerson2() {
        // given
        PersonService service = new PersonService()
        service.addPersons(TODD, TINA, BEAR, ANDREA)

        // expect
        assert service.findPerson("Unknown").empty
    }

    @Test
    @DisplayName("findPersons returns all persons matching the given pattern")
    void findPersonsPattern1() {
        // given
        PersonService service = new PersonService()
        service.addPersons(TODD, TINA, BEAR, ANDREA)

        // expect
        assert service.findPersons(~/^T.*$/) == [TINA, TODD] as Set
    }

    @Test
    @DisplayName("findPersons returns all persons with the given birthday")
    void findPersonsLocalDate1() {
        // given
        PersonService service = new PersonService()
        service.addPersons(TODD, TINA, BEAR, ANDREA)

        // expect
        assert service.findPersons(ANDREA.birthday) == [ANDREA] as Set
    }

    @Test
    @DisplayName("findPersons by object throws IllegalArgumentException")
    void findPersonsByObject() {
        // given
        PersonService service = new PersonService()
        service.addPersons(TODD, TINA, BEAR, ANDREA)

        // expect
        shouldFail IllegalArgumentException, { -> service.findPersons(~/^T.*$/ as Object) }
    }

    @Test
    @DisplayName("findPersons returns fulfilling the given predicate")
    void findPersonsByPredicate() {
        // given
        PersonService service = new PersonService()
        service.addPersons(TODD, TINA, BEAR, ANDREA)

        // expect
        assert service.findPersons({ person -> person.name.length() > 11 } as Predicate) == [BEAR] as Set
    }

    @Test
    @DisplayName("addPerson does not add duplicates")
    void addPerson() {
        // given
        PersonService service = new PersonService()
        service.addPersons(TODD)

        // when
        service.addPersons(new Person(TODD.name, TODD.birthday))

        // then
        assert service.allPersons == [TODD] as Set
    }
}